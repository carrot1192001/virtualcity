package com.youku.ad.util;

import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;

import com.youku.ad.cast.entity.CampCookie;
import com.youku.ad.cast.entity.CampInfo;
import com.youku.ad.cast.entity.ShowExpireData;
import com.youku.ad.cast.entity.TheaterDefCookie;
import com.youku.ad.cast.entity.TheaterLunboCookie;
import com.youku.ad.cast.entity.VvControlCookie;
import com.youku.ad.cast.manage.CastUtils;
import com.youku.ad.report.util.LogUtil;
import com.youku.ad.tudou.Base64;

/**
 * @author william
 */
public class CookieManager {
	
	private static final Log logger = LogUtil.getLog();
	
	
	private HttpServletRequest request = null;
    private HttpServletResponse response = null;
    private String cookies = null;
    private String history_cookie = null;
    private static final String campKey = "campKey_";
    private static final String numPrex = "campId_";
    

    /**剧场频次和优先级投放 cookie前缀:defId_*/
    private static final String defPrex = "defId_"; 
    
    /**剧场微轮播投放 cookie前缀:lunId_*/
    private static final String lunPrex = "lunId_"; 

    private static final int MAX_AGE = 630720000; //20*365 * 24 * 3600;

	public CookieManager() {
	}
   
    public CookieManager(HttpServletRequest req,HttpServletResponse res){
    	request = req;
    	response = res;
    	cookies = req.getHeader("Cookie");
    }
    
    /**
     * 获取网站用户的uid<p>
     * 网站用户信息存储于名为"yktk"的cookie中，该信息中以"|"分割，第4个是用户信息列。<p>
     * 用户信息列存放格式：uid:uid值,nn:nn值（其中uid是数值型；nn是用户昵称，字符串）<p>
     * @return uid - 如果解析失败，将返回1
     */
    public long getWebSiteUid() {
    	long uid = -1;
    	String cookie = getCookie(Constant.WEBSITE_COOKIE);
    	try {
    		String info = URLDecoder.decode(cookie, "utf-8");
    		String[] infoArray = info.split("\\|");
    		String array = Base64.decode(infoArray[3]);
    		String[] userInfo = array.split(",");
    		String[] keyValue = userInfo[0].split(":");
    		uid = Long.valueOf(keyValue[1]);
    	} catch (Exception e) {
    	}
    	return uid;
    }
    
    /**
     * 取得标识唯一用户的cookie->uc，若没有，创建一个新cookie
     * @return
     */
    public String getUniqCookie()
    {
    	String cookie = getCookie(Constant.COOKIEKEY);
    	if (cookie == null){
    		cookie = createUniqCookie();
    	}
    	return cookie;
    }
    
    /**
     * 取得名为key的cookie值
     * @param key
     * @return
     */
    public String getCookies()
    {
    	return	cookies;
    }
    
    /**
     * 取得所有cookie
     * @return
     */
    public String getCookie(String key){
    	if(cookies == null){
    		return null;
    	}
    	
    	int bIndex;
    	//key在第一个
    	if(cookies.startsWith(key+"=")){
    		bIndex = key.length() +1;
    	}else{
    		//非第一个
    		bIndex = cookies.indexOf("; "+key+"=");
    		if(bIndex ==-1){
    			return null;
    		}else{
    			bIndex = bIndex + key.length() +3;
    		}
    	}
    	
    	int eIndex = cookies.indexOf(";", bIndex);
    	if(eIndex == -1){
    		eIndex = cookies.length();
    	}
    	return	cookies.substring(bIndex, eIndex);
    }
    
    /**
     * 创建唯一cookie
     * @return
     */
    private String createUniqCookie() {
        // 时间串+随机三个字符
        String cookie = System.currentTimeMillis() + StringUtil.randomString(3);
        Cookie c = new Cookie(Constant.COOKIEKEY, cookie);
        c.setDomain(".youku.com");
        c.setPath("/");
        c.setMaxAge(MAX_AGE);
        response.addCookie(c);
        return cookie;
    }
     
    
    /**
     * 创建广告播放历史记录Cookie
     * @return
     */
    private void createHistoryCookie(String value) {
        // 时间串+随机三个字符
        Cookie c = new Cookie(Constant.COOKIEKEY_HISTORY, value);
        c.setDomain(".atm.youku.com");
        c.setPath("/");
        Date date = new Date(System.currentTimeMillis());
        int age = 24*60*60 - (date.getHours()*60*60 + date.getMinutes()*60 + date.getSeconds());
        c.setMaxAge(age);  //第二天凌晨
        response.addCookie(c);
    }
    
    public boolean hasShow(String campId)
    {
    	if (history_cookie == null){
    		history_cookie = getCookie(Constant.COOKIEKEY_HISTORY);
    	}
    	if (history_cookie == null){
    		return false;
    	}
    	return StringUtil.hasValue(history_cookie,campId,Constant.SEPARATOR_COOKIE_AD);
    }
   
    public void append(String ideaid)
    {
    	if (history_cookie == null)
    		createHistoryCookie(ideaid);
    	else
    		createHistoryCookie(history_cookie+ Constant.SEPARATOR_COOKIE_AD +ideaid);
    }
    
  
	/** 将CampCookie.versionFlag="c"版有效cookie加载到该集合cookieMap中，并删除掉所有c版cookie【暂时没有删除】
     *  
	 * @param  campMap         campain集合【全局变量campMap作为参数: campId-->CampInfo】  
	 * @param  cookieMap       带加载的集合，将有效"c"版campaign投放加载到该集合中，并删除掉所有c版cookie
     */
	private void getCampCookieMap_C(HashMap<Integer,CampInfo> campMap,Map<Integer,CampCookie> cookieMap){
		Cookie[] cookies = request.getCookies();    
		if(cookies!=null)   {   
		    for (int i = 0; i < cookies.length; i++ ){   
		        Cookie c = cookies[i];   
		        if(c.getName().startsWith(numPrex)) {
		        	try {
			        	int campId = Integer.parseInt(c.getName().substring(numPrex.length()));
			        	CampInfo cp = campMap.get(campId);
			        	if(cp != null) {
			        		
				        	String cookieNum = c.getValue();   
				        	//对没过期的c版cookie进行处理
				        	if(CampCookie.isNewVersion(cookieNum)){
				        		if(cp.getEndDate().getTime()>System.currentTimeMillis()) {
				        			
				        			long expireTime = cp.getEndDate().getTime()/100000; //N+投放过期时间
					    			/** c标志的 N+的cookie，则解析value【cookieNum 格式： "c"+总次数_周期:展示次数:周期过期时间_周期:展示次数:周期过期时间】值并返回*/
					    			CampCookie cc = CampCookie.getCampCookie(campId,expireTime,cookieNum); 				        		
					    			if(cc!=null) {
					    				cookieMap.put(campId,cc);   //解析成功的CampCookie 添加到map中			    				
					    			}	
					    			//【暂时注释掉】
				    				//clearCampCookie(cp);  //清空该c标志 的N+的cookie			
				        		}
				    		}
			        	}
		        	}catch(Exception e) {		        		
		        	}
		        }   
		    }
		}		
	}
	
	/** 清空CampCookie.versionFlag="c"版的N+投放cookie
	 * 
	 * @param cp  CampInfo 对象
	 */
	public void clearCampCookie(CampInfo cp) {
		String cookieName = numPrex +cp.getId();
		Cookie cookie=new Cookie(cookieName, "");//new Cookie(cookieName, cc.toString());
		cookie.setDomain(".atm.youku.com");
		cookie.setPath("/");
		//int maxAge = (int)((cp.getEndDate().getTime() - System.currentTimeMillis())/1000);
		int maxAge = 0;
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}

	public void clearCookie(String cookieName) {
		Cookie cookie=new Cookie(cookieName, "");
		cookie.setDomain(".atm.youku.com");
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	
	/** 取得N+投放的所有CampCookie对象Map【campId-->CampCookie】
	 * 
	 *  如果cookie中存在合并key，则解析对应的cookieValue值到Map集合中；
	 *  否则解析所有旧的c版本cookie到Map集合，同时清除掉这些cookie。
	 *  
	 * 
	 * @param campMap         campain集合【全局变量campMap作为参数: campId-->CampInfo】
	 * 
	 * @return Map【campId-->CampCookie】，不会返回null
	 */
	public Map<Integer,CampCookie> getCampCookieMap(HashMap<Integer,CampInfo> campMap){
		Map<Integer,CampCookie> cookieMap = null;
		String campValues = getCookie(campKey);  //得到camp投放的cookie【包括所有的N+投放信息】 
		if(campValues!=null && campValues.length()>0) {
			if(campValues.charAt(0) == 'Z') {
				campValues = StringUtil.ungzip(campValues.substring(1,campValues.length()));
			}
			cookieMap = getCampCookieMap(campValues); 
			
		}else {			
			cookieMap = new ConcurrentHashMap<Integer,CampCookie>();//【campId-->CampCookie】
			getCampCookieMap_C(campMap,cookieMap);                  //加载campaign投放的c版cookie
		}
		return cookieMap; 
	}
	/** 将N+投放campKey的 cookieValue值，解析Map【campId-->CampCookie】返回 
	 *  注意：1)过滤掉已经过期的CampCookie；
	 *  
	 * @param campValues   N+投放的cookieValue值，格式如下:
	 *                     1）多个N+用"_"分割
	 *                     2）1个N+的cookieValue格式【campId:总次数:总过期时间:点击次数#周期1:展示次数:周期1过期时间毫秒/100000#周期2:展示次数:周期2过期时间毫秒/100000】
	 *                     
	 * @return Map【campId-->CampCookie】，不会返回null
	 */
	private static Map<Integer,CampCookie> getCampCookieMap(String campValue){		
		Map<Integer,CampCookie> map = new ConcurrentHashMap<Integer,CampCookie>();
		String[] strData = campValue.split("_");   //N+投放数组
		for(String value : strData) {
			try {
				if(value==null || value.length()==0) 
					continue;
				
				String[] strs = value.split("#");  //1个N+投放的周期数组
				if(strs!=null) {						
					String[] tmp = strs[0].split(":");
					int campId  = Integer.parseInt(tmp[0]);    //N+投放Id
					int showTimes = Integer.parseInt(tmp[1]);  //已展示总时间
					long expireTime = Long.parseLong(tmp[2]);  //N+过期时间
					int clicktimes = tmp.length > 3 ? Integer.parseInt(tmp[3]) : 0;
					
					if(expireTime*100000<System.currentTimeMillis()) {//表示该N+投放已经过期，忽略掉
						continue;
					}
					
					
					HashMap<Integer,ShowExpireData> hmShowExpire = new HashMap<Integer,ShowExpireData>();					
					for(int i=1; i<strs.length; i++) {
						String[] items = strs[i].split(":");//N+投放1个周期的各项数据
						if(items.length != 3 ) {
							continue;
						}
						ShowExpireData pd = new ShowExpireData(Integer.parseInt(items[1]),Long.parseLong(items[2]));
						hmShowExpire.put(Integer.parseInt(items[0]),pd);						
					}
					
					
					CampCookie cc = CampCookie.getCampCookie(campId,showTimes, expireTime, hmShowExpire, clicktimes);//构造CampCookie对象
					map.put(campId,cc);
				}
			}catch(Exception e) {				
				e.printStackTrace();
			}
		}
		return map;
	}

	/** 设置N+投放的所有CampCookie对象 写入浏览器
	 * 
	 * @param ccMap Map<Integer,CampCookie>
	 * @return
	 */
	public void setCampCookieMap(Map<Integer,CampCookie> ccMap){
		String value = getCampCookieString(ccMap);
		if(value==null) 
			return;
		String z = StringUtil.gzip(value);
		if(z != null && z.length() > 0) {
			value = "Z"+ z;
		}
		Cookie cookie=new Cookie(campKey, value);
		cookie.setDomain(".atm.youku.com");
		cookie.setPath("/");
		//int maxAge = 365*24*3600;
		cookie.setMaxAge(MAX_AGE);
		response.addCookie(cookie);		
	}
	/** 将N+投放CampCookie的Map【campId-->CampCookie】转化成cookieValue字符串 
	 *  
	 * @param ccMap Map<Integer,CampCookie>
	 * @return cookieValue字符串 
	 *         格式【campId:showtimes:expireTime#period1:showTimes:expireTime#...periodN:showTimes:expireTime_...】
	 */
	private static String getCampCookieString(Map<Integer,CampCookie> ccMap){	
		String cookieValue = null;
		if(ccMap==null || ccMap.size()==0) {
			return cookieValue;
		}

		StringBuffer sb = new StringBuffer();
		Iterator iter = ccMap.entrySet().iterator();
		while (iter.hasNext()) {
			try {
				Map.Entry e = (Map.Entry) iter.next();		
				CampCookie cc = (CampCookie)e.getValue();
				if(cc!=null) {
					if(cc.getShowTimes()>0) {//展示次数大于0
						sb.append(cc.toString()).append("_");
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		cookieValue = sb.toString();
		if(cookieValue.endsWith("_")) {
			cookieValue = cookieValue.substring(0,cookieValue.length()-1);
		}	
		return cookieValue;
	}
	
	
	
	
	/** 根据TheaterDefInfo 取得对应的cookie对象，如果不存在则返回null
	 * 
	 * @param defId  TheaterDefInfo.id
	 * @return
	 */
	public TheaterDefCookie getDefCookie(int defId){
		TheaterDefCookie defCookie = null;
		
		String cookieValue = getCookie(defPrex + defId);
		if(cookieValue != null){
			defCookie = new TheaterDefCookie(defId,cookieValue);
		}
		
		return defCookie;
	}

	/** 写TheaterDefCookie 
	 * 
	 * @param defCookie  TheaterDefCookie
	 */
	public void setDefCookie(TheaterDefCookie defCookie) {
		if(defCookie==null ) {
			return;
		}
		String cookieName = defPrex +defCookie.getDefId();
		StringBuilder sb = new StringBuilder();
		sb.append(defCookie.getCount())
			.append(":").append(defCookie.getLastShowTime()).append(":").append(defCookie.getExpireTime());
		Cookie cookie=new Cookie(cookieName, sb.toString());
		cookie.setDomain(".atm.youku.com");
		cookie.setPath("/");
		int maxAge = (int)((defCookie.getExpireTime() - System.currentTimeMillis())/1000);
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}
	
	
	/** 剧场微轮播投放： 根据TheaterLunboInfo 取得对应的cookie对象，如果不存在则返回null
	 * 
	 * @param theaterId  TheaterLunboInfo.theaterId  剧场id
	 * @param seq        TheaterLunboInfo.seq        广告位id【1第一前贴，2第二前贴】 
	 * @return
	 */
	public TheaterLunboCookie getLunboCookie(int theaterId,int seq){
		TheaterLunboCookie defCookie = null;
		
		String cookieValue = getCookie(lunPrex + theaterId+"_"+seq);
		if(cookieValue != null){
			defCookie = new TheaterLunboCookie(theaterId,seq,cookieValue);
		}		
		return defCookie;
	}

	/** 剧场微轮播投放：写TheaterLunboCookie
	 * 
	 * @param lunboCookie  TheaterLunboCookie
	 */
	public void setLunboCookie(TheaterLunboCookie lunboCookie) {
		if(lunboCookie==null ) {
			return;
		}
		//lunId_theaterId_seq
		String cookieName = lunPrex +lunboCookie.getTheaterId()+"_"+lunboCookie.getSeq();
		StringBuilder sb = new StringBuilder();
		
		sb.append(lunboCookie.getLunCount()).append(":").append(lunboCookie.getLun()).append(":").append(lunboCookie.getIdeaId());
		Cookie cookie=new Cookie(cookieName, sb.toString());
		cookie.setDomain(".atm.youku.com");
		cookie.setPath("/");
		int maxAge = (int)((CastUtils.getNextDateZero(1) - System.currentTimeMillis())/1000);
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}
	
	/**
	 * 设置cookie，在.atm.youku.com域名下，有效期一年
	 * @param key
	 * @param value
	 */
	public void setCookie(String key, String value) {
		if(key == null || value == null){
			return;
		}
		
		Cookie cookie=new Cookie(key, value);
		cookie.setDomain(".atm.youku.com");
		cookie.setPath("/");
		cookie.setMaxAge(MAX_AGE);
		response.addCookie(cookie);		
	}
	
	public void setCookie(String key, String value, int maxAge) {
		if(key == null || value == null){
			return;
		}
		
		Cookie cookie=new Cookie(key, value);
		cookie.setDomain(".atm.youku.com");
		cookie.setPath("/");
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);		
	}

	/**
	 * 获取一次VV控制不投放相同的广告<br>
	 * @param cookie VV不投放相同广告的cookie串(session_expireTime:ideaId1,ideaId2,ideaId3#session_expireTime:ideaId1,ideaId2,ideaId3)
	 * @return vvControlMap(任何情况下返回该对象都不会是NULL)-key：sessionId，value-VvControlCookie
	 */
	public HashMap<String, VvControlCookie> getVvControlCookieMap() {
		HashMap<String, VvControlCookie> vvControlMap = new HashMap<String, VvControlCookie>();
		
		String cookie = getCookie(Constant.VV_CONTROL_COOKIE);
		try {
			String[] vvCookies = cookie.split("#");
			for(int i=0; i<vvCookies.length; i++) {
				String vvCookie = vvCookies[i];
				String sessionId = vvCookie.split("_")[0];
				VvControlCookie vvControlCookie = VvControlCookie.getVvControlCookie(vvCookie);
				if(vvControlCookie == null)
					continue;
				vvControlMap.put(sessionId, vvControlCookie);
			}
		} catch(Exception e) {
		}
		return vvControlMap;
	}
	
	/**
	 * 获取VV一次控制不投放相同的广告cookie<br>
	 * @param vvControlCookieMap 控制信息Map-key:vv的标识ID(sessionId)，value:VvControlCookie对象
	 * @return String-VV一次控制不投放相同的广告cookie信息
	 */
	public String getVvControlCookie(HashMap<String, VvControlCookie> vvControlCookieMap) {
		StringBuilder cookie = new StringBuilder();
		try {
			Iterator<String> iterator = vvControlCookieMap.keySet().iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				VvControlCookie vvControlCookie = vvControlCookieMap.get(key);
				if(vvControlCookie == null)
					continue;
				cookie.append(vvControlCookie.toString()).append("#");
			}
		} catch(Exception e) {
		}
		return cookie.toString();
	}
	
	public void writeAllCookie() {
	}
	/**
	 * 设置移动剧场相关cookie
	 * @param key
	 * @param value
	 * @param maxAge
	 */
	public void setMTheaterCookie(String key,String value,int maxAge) {
	}
	/** 设置VV控制前贴/中插/后贴不播放相同广告信息写入浏览器(cookie有效期1天)
	 * @param vvControlCookieMap vv控制信息(key-sessionId,value-vv控制信息体)
	 */
	public void setVvControlCookie(HashMap<String, VvControlCookie> vvControlCookieMap){
		String value = getVvControlCookie(vvControlCookieMap);
		if(value==null) 
			return;
		Cookie cookie=new Cookie(Constant.VV_CONTROL_COOKIE, value);
		cookie.setDomain(".atm.youku.com");
		cookie.setPath("/");
		cookie.setMaxAge(86400);
		response.addCookie(cookie);		
	}
}
