//package com.youku.atm.adserver.service.impl;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.commons.codec.binary.Base64;
//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.lang.math.NumberUtils;
//import org.springframework.stereotype.Component;
//
//import com.alibaba.security.SecurityUtil;
//import com.youku.atm.adserver.service.IParamParser;
//import com.youku.atm.adserver.store.AdBucketStore;
//import com.youku.atm.adserver.store.BaseInfoStore;
//import com.youku.atm.adserver.store.BlackListStore;
//import com.youku.atm.adserver.store.MAdPositionStore;
//import com.youku.atm.adserver.vo.RequestParam;
//import com.youku.atm.common.collector.Ec;
//import com.youku.atm.common.constant.AdCodeConstant;
//import com.youku.atm.common.constant.Constants;
//import com.youku.atm.common.constant.DirectionConstant;
//import com.youku.atm.common.constant.IdeaUrlConstant;
//import com.youku.atm.common.constant.PositionConstants;
//import com.youku.atm.common.constant.RequestParamC;
//import com.youku.atm.common.constant.ScreenSizeConstant;
//import com.youku.atm.common.util.IPUtil;
//import com.youku.atm.common.util.LogUtil;
//import com.youku.atm.common.util.ParamUtil;
//import com.youku.atm.common.util.StringUtil;
//
//
///**
// * 
// * 参数解析
// * 
// * @author hemengxin
// * 
// */
//@Component
//public class ParamParserImpl implements IParamParser {
//    @Override
//    public RequestParam parse(HttpServletRequest request, String requestType) {
//        RequestParam rp = convertRequestParam(request, requestType);
//        return rp;
//    }
//    
//    protected RequestParam convertRequestParam(HttpServletRequest request, String requestType) {
//        RequestParam rp = new RequestParam();
//        rp.setHttpRequest(request);
//        rp.setUserAgent(request.getHeader("User-Agent")==null?"":request.getHeader("User-Agent").toLowerCase());
//        // site相关
//        rp.setSite(getSite(request));
//        
//        rp.setKanDianInfo(ParamUtil.getBoolean(request, "ssp_kanInfo"));
//        rp.setBt(getBt(request, requestType, rp));
//		rp.setIp(getRemoteIp(rp, request));
//		rp.setPs(getPs(request));
//        // p相关
//        rp.setP(ParamUtil.getPositiveInteger(request, "p"));
//        rp.setBids(getBids(request));
//
//        rp.setDomain(getDomain(request, rp.getSite()));
//        rp.setManageType(getManageType(rp,requestType));
//        // cs，ct相关
//        rp.setWinType(ParamUtil.getString(request, "wintype"));
//        // rp.setZw(getZw(rp.getWinType(), rp.getDomain(), request));
//        setCsCt(rp, request);// 老代码这里会根据站外站内去修改cs和ct，而且在定向和日志模块对ct和cs修改的格式不一样，导致要存两份cs和ct，老代码的方式废除
//        
//        rp.setS(getShowId(request));
//        rp.setUploadUserId(ParamUtil.getString(request, "u"));
//        
//        // boolean值
//        rp.setCopyright(getCopyRight(rp)); // 需要根据u，s和ct来生成
//        rp.setIe9(getIe9(rp));
//        rp.setForbidFlag(getFoirbidFlag(request)); // 屏蔽广告的标示
//        rp.setFullScreen(ParamUtil.getBoolean(request, "fu"));
//        rp.setVip(ParamUtil.getBoolean(request, "vip"));
//        rp.setVipR(ParamUtil.getString(request, "vip"));
//        rp.setPaid(ParamUtil.getBoolean(request, "paid"));
//        rp.setTt(getTt(rp, request));
//        
//        rp.setContinuePlay(ParamUtil.getBoolean(request, "ctu"));
//        
//        // 时长
//        rp.setVc(ParamUtil.getString(request, "vc"));
//        rp.setAw(getAw(request, requestType));// 默认值w        
//        rp.setOffLine(getOffLine(rp.getAw(), rp.getVc())); // 只要在vc =2 ，aw=off的时候表示离线
//        rp.setVideoLength(getVl(request, rp));// 离线的时长必须给1200。
//        
//        // String 类型
//        rp.setVs(ParamUtil.getString(request, "vs"));
//        rp.setCallback(ParamUtil.getString(request, "callback"));
//        rp.setD(ParamUtil.getString(request, "d"));
//        rp.setSessionID(ParamUtil.getString(request, "sid"));
//        rp.setTrueVideoId(ParamUtil.getString(request, "td"));
//        rp.setVideoId(ParamUtil.getString(request, "v"));
//        rp.setLid(ParamUtil.getString(request, "lid"));
//        rp.setKeyWords(SecurityUtil.richtext(ParamUtil.getString(request, "k")));
//        rp.setZwCheck(ParamUtil.getString(request, "atm"));
//        rp.setPartnerId(ParamUtil.getString(request, "partnerid"));
//        rp.setAdext(ParamUtil.getString(request, "adext"));
//        // 老代码在这里解析了预览ID的解析，我觉的这部分应该放到相应的预览管道中去，这里保留传入值就行。
//        rp.setGuid(ParamUtil.getString(request, "guid"));
//        rp.setIdfa(ParamUtil.getString(request, "idfa"));
//        rp.setBd(ParamUtil.getString(request, "bd"));
//        rp.setMdl(ParamUtil.getString(request, "mdl"));
//        rp.setOuid(ParamUtil.getString(request, "ouid"));
//        rp.setNet(ParamUtil.getString(request, "net"));
//        rp.setIsp(ParamUtil.getString(request, "isp"));
//        rp.setAvs(ParamUtil.getString(request, "avs"));
//        rp.setSavs(ParamUtil.getString(request, "savs"));
//        rp.setPver(ParamUtil.getString(request, "pver"));
//        rp.setSver(ParamUtil.getString(request, "sver"));
//        rp.setMac(ParamUtil.getString(request, "mac").toUpperCase());
//        rp.setUk(ParamUtil.getString(request, "uk"));// 用来生成websiteUid
//        rp.setPid(ParamUtil.getString(request, "pid"));
//        rp.setIm(ParamUtil.getString(request, "im"));
//        if (BlackListStore.getIMEIData().contains(ParamUtil.getString(request, "im"))) {
//        	rp.setIm("");
//        }
//        rp.setAid(ParamUtil.getString(request, "aid"));
//        rp.setTi(ParamUtil.getString(request, "ti"));
//        rp.setOsv(ParamUtil.getString(request, "osv"));
//        rp.setSc(ParamUtil.getString(request, "sc"));
//        rp.setGd(ParamUtil.getString(request, "gd"));
//        rp.setType(ParamUtil.getString(request,"type"));
//        rp.setShowIds(getShowIds(request));
//        rp.setLot(ParamUtil.getString(request,"lot"));
//        rp.setLat(ParamUtil.getString(request,"lat"));
//        // integer类型
//        rp.setPh(ParamUtil.getPositiveInteger(request, "ph"));
//        rp.setPw(ParamUtil.getPositiveInteger(request, "pw"));
//        this.setDvwDvh(request, rp);
//        rp.setEntry(ParamUtil.getPositiveInteger(request, "ev")); // 入口营销
//        // 特殊处理
//        rp.setDq(getDq(request));
//        
//        rp.setOs(getOs(request));
//        rp.setRst(getRst(request));
//        rp.setRstList(getRstList(rp.getRst(),request));
//        rp.setReferrer(request.getHeader("Referer")==null?"":request.getHeader("Referer"));
//        rp.setAdsid(System.currentTimeMillis() + StringUtil.randomNumber(8)); // 针对广告视频生成一个新的vsid（view-sid），13位时间戳+8位数字随机数，以唯一识别一次视频播放
//        rp.setVert(ParamUtil.getBoolean(request, "isvert"));
//        rp.setRequestId(getRequestId(request, rp));
//        rp.setSs(this.getSs(request, rp));
//        rp.setMoblie(getMoblie(rp, requestType));
//        rp.setIspCode(getIspCode(request,rp));
//        rp.setMyp(ParamUtil.getInteger(request, "myp"));
//        rp.setUtdId(ParamUtil.getString(request,"utdid"));
//        rp.setYid(ParamUtil.getString(request, "yid"));
//        rp.setSex(ParamUtil.getString(request, "sex"));
//        rp.setAge(ParamUtil.getString(request, "ag"));
//        rp.setBox(ParamUtil.getString(request,"box"));
//        rp.setUuid(ParamUtil.getString(request,"uuid"));
//        rp.setVr(ParamUtil.getString(request, "vr"));
//        rp.setFlowmark(ParamUtil.getString(request, "flowmark"));
//        rp.setSr(ParamUtil.getString(request, "sr"));
//        if(PositionConstants.MANAGETYPE.JIAOBIAO.equals(rp.getManageType()) && !StringUtil.isEmptyString(rp.getLid()) && !"0".equals(rp.getLid())){
//			rp.setLivec(true);
//		}
//        
//        rp.setAbt(ParamUtil.getString(request, "abt"));
//        rp.setYtid(ParamUtil.getString(request, "_ytid"));
//        rp.setLogin(ParamUtil.getString(request, "_login"));
//        rp.setSign(ParamUtil.getString(request, "_sign"));
//        rp.setPtoken(ParamUtil.getString(request, "ptoken"));
//        rp.setStoken(ParamUtil.getString(request, "stoken"));
//        rp.setVit(ParamUtil.getString(request, "vit"));
//        rp.setVp(ParamUtil.getString(request, "vp"));
//        rp.setFrameTime((int) ParamUtil.getDouble(request, "ft"));
//		if (PositionConstants.MANAGETYPE.BIANKANBIANMAI.equals(rp.getManageType()) && Constants.OS.IOS.equals(rp.getOs())) {
//			// 兼容ios提前1秒发请求，ft传值不正确
//			rp.setFrameTime(rp.getFrameTime() + 1);
//		}
//        rp.setPreScene(PositionConstants.MANAGETYPE.BIANKANBIANMAI.equals(rp.getManageType()) && rp.getPs() < 0);
//        rp.setAppc(ParamUtil.getString(request, "appc"));
//        rp.setPositionList(getPositionList(request, "ssp_pos"));
//        String resType = MAdPositionStore.getResourceType(rp.getPositionList());
//        rp.setResourceType(resType);       
//        rp.setInfoFlow(rp.isKanDianInfo()||resType.equals(PositionConstants.ResourceType.H_POSITION_TYPE_INFOFLOW));
//        rp.setUnion((!rp.isMoblie() && resType.equals(PositionConstants.ResourceType.H_POSITION_TYPE_PC_FOCUS))
//                || rp.getSite() == Constants.SITE.XIANYU || rp.isInfoFlow());// 闲鱼与信息流都走联盟
//        rp.setMaxAdCount(ParamUtil.getPositiveInteger(request, "ssp_mc"));
//        rp.setMaxAdLength(ParamUtil.getPositiveInteger(request, "ssp_ml"));
//        rp.setUseSspAdLength(ParamUtil.getBoolean(request, "ssp_cl"));
//        rp.setSceneAdConflictTime(ParamUtil.getPositiveInteger(request, "ssp_sct"));
//        rp.setUseSceneConflict(ParamUtil.getBoolean(request, "ssp_exc"));
//        if(PositionConstants.MANAGETYPE.KAIJITU.equals(rp.getManageType()) && rp.getPositionList().size() > 0){
//            rp.setKjtPositionId(rp.getPositionList().get(0));
//        }
//        rp.setNoAd(ParamUtil.getBoolean(request, "ssp_noad"));
//        rp.setNewHtml(ParamUtil.getBoolean(request, "ssp_html"));
//        rp.setCid(ParamUtil.getString(request, "cid"));
//        rp.setTbEagleeyexT(ParamUtil.getPositiveInteger(request, "tb_eagleeyex_t"));
//        rp.setTq(ParamUtil.getString(request, "tq"));
//        rp.setPlayerType(ParamUtil.getString(request, "pltype"));
//        rp.setUseHttps(ParamUtil.getBoolean(request, "use_https"));
//        rp.setAdVids(getAdVidsSet(request, "advids"));
//        rp.setCloseAd(ParamUtil.getBoolean(request, "ssp_close"));
//        rp.setZnw(ParamUtil.getInteger(request, "ssp_traffic"));
//        rp.setZw(Constants.ZNW.ZW == rp.getZnw());
//        rp.setCcode(ParamUtil.getString(request, "ccode"));
//        rp.setSwfRefer(ParamUtil.getString(request, "refer"));
//        // rp.setZw(!isNewZn(rp.getAw(), rp.getCcode(), rp.getSwfRefer(), rp.getReferrer()));
//        // rp.setZw(treatZw(rp, request));
//        rp.setNzn(isNewZn(rp.getAw(), rp.getCcode(), rp.getSwfRefer(), rp.getReferrer()));
//        rp.setOzn(!getZw(rp.getWinType(), rp.getDomain(), request));
//        rp.setAppName(ParamUtil.getString(request, "an"));
//        rp.setYsuid(ParamUtil.getString(request, "ysuid"));
//        rp.setBitRate(ParamUtil.getString(request, "ott_sv_tem"));
//        rp.setVolume(ParamUtil.getString(request, "ott_sv_vol"));
//        rp.setOldBucketPath(ParamUtil.getString(request, "bucket_path"));
//		rp.setBucketPath(setBucketPath(request));
//		rp.setAliaid(ParamUtil.getString(request, "aliaid"));
//		rp.setAidif(ParamUtil.getString(request, "aidif"));
//        rp.setPauseLunBo(ParamUtil.getBoolean(request, "ssp_plb"));
//		rp.setSspMmasdk(ParamUtil.getString(request, "ssp_mmasdk"));
//		rp.setIpType(ParamUtil.getInteger(request, "iptype"));
//		rp.setUseTrace(ParamUtil.getBoolean(request, "use_trace"));
//		rp.setTraceCIds(parseIntegerList(ParamUtil.getString(request, "trace_cids")));
//		rp.setBlacklistAdvertiserIds(parseIntegerList(ParamUtil.getString(request, "blacklist_advertiser")));
//        rp.setBlacklistIndustryIds(parseIntegerList(ParamUtil.getString(request, "blacklist_industry")));
//        return rp;
//    }
//
//    /*
//     * 按各层有预定量比例数据，去掉没有预定量的层，修正path
//     */
//	private String setBucketPath(HttpServletRequest request) {
//		String bucketPath = ParamUtil.getString(request, "bucket_path");
//
//		// 判断是否分桶，并转换为有预定量的分桶路径上
//		if (AdBucketStore.dcIdToPathMap.get(bucketPath) != null && !"".equals(AdBucketStore.dcIdToPathMap.get(bucketPath))) {
//			bucketPath = AdBucketStore.dcIdToPathMap.get(bucketPath);
//		}else{
//			bucketPath = "";
//		}
//		return bucketPath;
//	}
//	
//    private List<String> getPositionList(HttpServletRequest request, String pos) {
//	    List<String> posList = new ArrayList<String>();
//	    String posStr = ParamUtil.getString(request, pos);
//        if (StringUtils.isNotEmpty(posStr)) {
//            String[] poss = StringUtil.split(posStr, ",");
//            for (String p : poss) {
//                if(StringUtils.isNotEmpty(p)){
//                    posList.add(p);
//                }
//            }
//        }
//        return posList;
//    }
//    
//    private Set<String> getAdVidsSet(HttpServletRequest request, String adVids) {
//        Set<String> posList = new HashSet<String>();
//        String adVidStr = ParamUtil.getString(request, adVids);
//        if (StringUtils.isNotEmpty(adVidStr)) {
//            String adVidsStr = "";
//            try {
//                adVidsStr = StringUtil.decodeBase64(adVidStr);
//            } catch (Exception e) {
//                Ec.ADS.log("decodeBase64 adVids error: " + adVidStr, e, Ec.DIM_PARAM_ERROR);
//            }
//            String[] adVidss = StringUtil.split(adVidsStr, ",");
//            for (String adVid : adVidss) {
//                if(StringUtils.isNotEmpty(adVid)){
//                    posList.add(adVid);
//                }
//            }
//        }
//        return posList;
//    }
//    private String getShowId(HttpServletRequest request){
//    	String s = ParamUtil.getString(request, "s");
//    	return "undefined".equals(s) ? "0" : s;
//    }
//    
//    private String getIspCode(HttpServletRequest request, RequestParam rp){
//    	String ispCode = "";
//    	if(rp.getIsp().length()>0){
//			String[] isps = StringUtil.split(rp.getIsp(), "_");
//			if(isps==null){
//				return ispCode;
//			}
//			
//			if(isps.length==2){
//	        	if(StringUtils.isNotEmpty(isps[1])){
//	        		ispCode = DirectionConstant.ISP.ispType.get(isps[1]);
//	        	}
//	        	if(StringUtils.isEmpty(ispCode)){
//	        		ispCode = DirectionConstant.ISP.ispType.get(isps[0]);
//	        	}
//	        }else if(isps.length==1){
//	        	ispCode = DirectionConstant.ISP.ispType.get(isps[0]);
//	        }
//    	}
//    	if(ispCode==null){
//    		ispCode = "";
//    	}
//    	return ispCode;
//    }
//    
//	private String getRequestId(HttpServletRequest request, RequestParam rp) {
//		String requestId = ParamUtil.getString(request, "reqid");
//		if (StringUtils.isEmpty(requestId)) {
//			// 无reqid用UUID代替
//			return LogUtil.getUUID();
//		}
//		return requestId;
//	}
//    
//    public double getSs(HttpServletRequest request,RequestParam rp) {
//        Double reuslt = 0.0;
//        String p = ParamUtil.getString(request, "ss");
//        
//        if(p.length() == 0 && Constants.OS.IOS.equals(rp.getOs())) {
//        	if(Constants.BT.PHONE.equals(rp.getBt())){
//        		reuslt = ScreenSizeConstant.iphoneSizeMap.get(rp.getMdl());
//        	}
//        	//IPAD 默认7.9英寸
//        	if(Constants.BT.PAD.equals(rp.getBt()) && (reuslt==null || reuslt==0)){
//        		reuslt=7.9;
//        	}
//        	reuslt = reuslt == null ? 0 : reuslt;
//        }
//        
//        if (p.length() == 0) {
//            return reuslt;
//        }
//        try {
//            reuslt = Double.parseDouble(p);
//        } catch (Exception e) {
//            Ec.ADS.log("get ss error: " + p, e, Ec.DIM_PARAM_ERROR);
//        }
//        return reuslt;
//    }
//    
//    private Set<String> getShowIds(HttpServletRequest request){
//    	String s =ParamUtil.getString(request, "s");
//    	Set<String> sSet = new HashSet<String>();
//    	if (StringUtils.isNotEmpty(s)) {
//    		String[] ss = StringUtil.split(s,",");
//    		for (int i = 0; i < ss.length; i++) {
//    			String sid = ss[i];
//    			if(StringUtils.isEmpty(sid) || !StringUtil.isPositiveInteger(sid)){
//    				continue;
//    			}
//    			sSet.add(sid);
//			}
//    	}
//    	return sSet;
//    }
//
//	protected String getTt(RequestParam rp, HttpServletRequest request) {
//        String tt = ParamUtil.getString(request, "tt");
//        if (rp.isPaid() && (StringUtils.isEmpty(tt) || !Constants.TT.ttSet.contains(tt))) {
//            tt = Constants.TT.CANNOT;
//        }
//        return tt;
//    }
//
//    //    public boolean treatZw(RequestParam rp, HttpServletRequest request) {
//    //        int p = rp.getP();
//    //        int site = rp.getSite();
//    //        if ((p == PositionConstants.P.QIANTIE || p == PositionConstants.P.MQIANTIE)
//    //                && site == Constants.SITE.YOUKU) {
//    //            return !isNewZn(rp.getAw(), rp.getCcode(), rp.getSwfRefer(), rp.getReferrer());
//    //        } else {
//    //            return getZw(rp.getWinType(), rp.getDomain(), request);
//    //        }
//    //    }
//
//    /**
//     * 新的判断站内请求的方法。 app认为站内；web根据ccode和referer联合判断。ccode值由播放器传给atm
//     * 
//     * @param aw
//     * @param ccode
//     * @param swfRefer
//     * @param referrer
//     * @return
//     */
//    public boolean isNewZn(String aw, String ccode, String swfRefer, String referrer) {
//        if (!Constants.AW.W.equals(aw)) {// app(and off)默认站内
//            if (ccode == null || ccode.length() == 0) {// 取不到ccode默认站外。站内的都带（压流广告应由ups发送）
//                // app默认站内，但再判下referrer(如果不为空）：线上有app，但频道为zw，referrer为http://h5.m.taobao.com/yuntv/edu/cyclone/detail/index.html的情况
//                if (referrer != null && referrer.length() > 0) {
//                    boolean hasZnDomain = ParamUtil.containsDomain(referrer, ".youku.com")
//                            || ParamUtil.containsDomain(referrer, ".tudou.com");
//                    return hasZnDomain;
//                }
//            }
//            return true;
//        }
//        if (Constants.Ccode.YK_SWF.equals(ccode)) {
//            if (swfRefer != null && swfRefer.length() > 0
//                    && (swfRefer.contains("v.youku.com") || swfRefer.contains("v-wb.youku.com"))) {
//                return true;
//            } else {
//                return false;
//            }
//        } else if (Constants.Ccode.TD_SWF.equals(ccode)) {
//            if (swfRefer != null && swfRefer.length() > 0
//                    && (swfRefer.contains("video.tudou.com"))) {
//                return true;
//            } else {
//                return false;
//            }
//        } else if (Constants.Ccode.PHONE_H5.equals(ccode)) {
//            if (referrer != null && referrer.length() > 0 && (referrer.contains("m.youku.com"))) {
//                return true;
//            } else {
//                return false;
//            }
//        } else if (Constants.Ccode.YK_H5.equals(ccode)) {
//            if (referrer != null && referrer.length() > 0
//                    && (referrer.contains("v.youku.com") || referrer.contains("v-wb.youku.com"))) {
//                return true;
//            } else {
//                return false;
//            }
//        } else if (Constants.Ccode.PAD_H5.equals(ccode)) {
//            if (referrer != null && referrer.length() > 0 && (referrer.contains("v.youku.com"))) {
//                return true;
//            } else {
//                return false;
//            }
//        } else if (Constants.Ccode.TD_PC_H5.equals(ccode)) {
//            if (referrer != null && referrer.length() > 0
//                    && (referrer.contains("video.tudou.com"))) {
//                return true;
//            } else {
//                return false;
//            }
//        } else if (Constants.Ccode.TD_MOBILE_H5.equals(ccode)) {
//            if (referrer != null && referrer.length() > 0
//                    && (referrer.contains("video.tudou.com"))) {
//                return true;
//            } else {
//                return false;
//            }
//        }else{
//            return false;
//        }
//    }
//
//    // 老的判断站内外的方式的问题：1.wintype值不准；2.referrer在swf播放器中不准
//    @Deprecated
//    protected boolean getZw(String winType, String domain, HttpServletRequest request) {
//        if (Constants.WINTYPE.ZW.equals(winType) || Constants.WINTYPE.BDSKIN.equals(winType)) {
//            return true;
//        }
//        if (Constants.WINTYPE.HTML5_MOBILE.equals(winType)) {// 默认为站内，可能误判，根据域名大概再过滤一次
//            if (StringUtils.isNotEmpty(domain)) {
//                return !StringUtils.contains(domain, "youku.com");// 根据emb判断。domain来源于emb参数。需要在rp.setDomain后
//            }
//            String refer = request.getHeader("Referer");
//            if (StringUtils.isBlank(refer)) {// refer为空，默认站内
//                return false;
//            }
//            if( !StringUtils.contains(request.getHeader("User-Agent"), "Chrome") ){//只有chrome浏览器按照refer判
//                return false;
//            }
//            return !StringUtils.contains(refer, ".youku.com");
//        }
//        return false;
//    }
//    
//    protected boolean getCopyRight(RequestParam rp) {
//        if (DirectionConstant.CHANNEL.copyrightChannel.contains(rp.getCt()) || !"".equals(rp.getS())) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//    
//    protected boolean getOffLine(String aw, String vc) {
//        if (Constants.AW.OFF.equals(aw) && Constants.VC.OFFLINE_NEW.equals(vc)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//    
//	protected String getAw(HttpServletRequest request, String requestType) {
//		String aw = ParamUtil.getString(request, RequestParamC.AW);
//		if (aw.equals(Constants.AW.A) || aw.equals(Constants.AW.OFF)) {
//			return aw;
//		}
//		return Constants.AW.W;
//	}
//    
//    /**
//     * 特殊处理rst
//     * 
//     * @param request
//     * @return
//     */
//	protected String getRst(HttpServletRequest request) {
//		String rst = ParamUtil.getString(request, "rst").toLowerCase();
//		if (rst.length() == 0) {
//			return "";
//		}
//		rst = SecurityUtil.richtext(rst);
//		for (String r : Constants.RST.rstSet) {
//			if (rst.indexOf(r) > -1) {
//				return r;
//			}
//		}
//		return "";
//	}
//    
//    /**
//     * 特殊处理rst2，仅供页面请求falsh、h5、img
//     * 优先级swf>h5>img
//     * 默认img
//     * @param request
//     * @return
//     */
//	protected List<String> getRstList(String videoRst,HttpServletRequest request) {
//		//容错
//		if(videoRst.length()>0){
//			return null;
//		}
//		List<String> rsts = new ArrayList<String>();
//		String rst = ParamUtil.getString(request, "rst").toLowerCase();
//		if (rst.length() > 0) {
//			rst = SecurityUtil.richtext(rst);
//            if (rst.indexOf(IdeaUrlConstant.RST.ZIP) > -1) {// 自定义浮层sdk端使用zip
//                rsts.add(IdeaUrlConstant.RST.ZIP);
//            }
//			if (rst.indexOf(IdeaUrlConstant.RST.FLASH) > -1) {
//				rsts.add(IdeaUrlConstant.RST.FLASH);
//			}
//			if (rst.indexOf(IdeaUrlConstant.RST.H5) > -1) {
//				rsts.add(IdeaUrlConstant.RST.H5);
//			}
//			if (rst.indexOf(IdeaUrlConstant.RST.IMG) > -1) {
//				rsts.add(IdeaUrlConstant.RST.IMG);
//			}
//			if (rst.indexOf(IdeaUrlConstant.RST.VIDEO) > -1) {//feeds流有同时混传视频与图片的情况
//				rsts.add(IdeaUrlConstant.RST.VIDEO);
//			}
//		}
//		return rsts;
//	}
//    
//    /**
//     * 处理px
//     * 
//     * @param request
//     * @param rp
//     * @return
//     */
//    protected void setDvwDvh(HttpServletRequest request, RequestParam rp) {
//    	rp.setDvw(ParamUtil.getPositiveInteger(request, "dvw"));
//        rp.setDvh(ParamUtil.getPositiveInteger(request, "dvh"));
//        String px = ParamUtil.getString(request, "px");
//        if (StringUtil.isEmptyString(px) || rp.getP() == PositionConstants.P.MKAIJITU) {
//            int width = rp.getDvw();
//            int height = rp.getDvh();
//            if (!(rp.getSite() == Constants.SITE.YOUKU && rp.isInfoFlow()) 
//            		&& rp.getP() != PositionConstants.P.MFOC && Constants.OS.IOS.equals(rp.getOs()) && Constants.BT.PAD.equals(rp.getBt())) {
//                if (height > width) {
//                    int tmp = width;
//                    width = height;
//                    height = tmp;
//                }
//            }
//            if (width != 0 && height != 0) {
//            	rp.setDvw(width);
//        		rp.setDvh(height);
//        		return;
//            }
//        }
//        try {
//        	String[] pxArr = px.split("\\*");
//        	if (pxArr.length < 2) {
//        		pxArr = px.split("%2A");
//        	}
//        	if (pxArr.length == 2) {
//        		rp.setDvw(Integer.parseInt(pxArr[0]));
//        		rp.setDvh(Integer.parseInt(pxArr[1]));
//        	}
//        } catch (Exception e) {
//        	Ec.ADS.log("尺寸参数适配错误，将使用默认尺寸, rp.px=" + px, e, Ec.DIM_PARAM_ERROR);
//        }
//    }
//    
//    /**
//     * 处理os参数
//     * 
//     * @param request
//     * @return
//     */
//    protected String getOs(HttpServletRequest request) {
//        String os = ParamUtil.getString(request, "os").toLowerCase();
//        // 兼容pc端升级前的逻辑，不传os或者传windows都当做是windows;参数包含mac,则为mac;都不是,则维持其默认值不变以便于将来统计实际值
//        if (os.indexOf("win") >= 0 || "".equals(os)) {
//            os = Constants.OS.WIN;
//        } else if (os.indexOf("mac") >= 0) {
//            os = Constants.OS.MAC;
//        } else if (os.indexOf("linux") >= 0) {
//            os = Constants.OS.LINUX;
//        } else if (os.indexOf("android") >= 0) {
//            os = Constants.OS.ADR;
//        } else if (os.indexOf("ios") >= 0) {
//            os = Constants.OS.IOS;
//        } else if (os.indexOf("yunos") >= 0) {
//            os = Constants.OS.YUNOS;
//        } else if (os.indexOf("tizen") >= 0) {
//            os = Constants.OS.TIZEN;
//        } else if (os.indexOf("cyclone") >= 0) {
//            os = Constants.OS.CYCLONE;
//        } 
//        return os;
//    }
//    
//    protected String getBt(HttpServletRequest request, String requestType, RequestParam rp) {
//        String bt = ParamUtil.getString(request, "bt").toLowerCase();
//        if ("".equals(bt)) {// 为空,则为默认的pc（兼容PC现在不传bt的情况）
//            bt = Constants.BT.PC;
//        } else if (Constants.BT.btConvertMap.containsKey(bt)) { // 为pad/phone/tv/pc之一,则直接转;
//            bt = Constants.BT.btConvertMap.get(bt);
//        }
//        //处理html的bt问题,素材选取会用到
//        // 此处仅需区分移动或pc，所以bt记为非pc时，在MIdeaUrl.java中，都会被传成移动
//        if(AdCodeConstant.AdPathType.AD_PATH_HTML.equals(requestType)){
//        	String userAgent = rp.getUserAgent();
//        	boolean beIPad = userAgent.indexOf("ipad") > -1 || userAgent.indexOf("iphone") > -1;
//    		boolean beAndroid = userAgent.indexOf("android") > -1 || userAgent.indexOf("android") > -1;
//    		boolean noFlash = beIPad || beAndroid;
//    		if(noFlash){
//    			 bt = Constants.BT.PAD;
//    		}else {
//    			bt = Constants.BT.PC;
//    		}
//    	}
//        // 如果不在map中又不空,则取原始值不变
//        return bt;
//    }
//    
//    /**
//     * 广告屏蔽表示处理
//     * 
//     * @param request
//     * @return
//     */
//    protected boolean getFoirbidFlag(HttpServletRequest request) {
//        String rt = ParamUtil.getString(request, "rt");
//        if (rt != null && !rt.isEmpty()) {
//            try {
//                byte[] b = Base64.decodeBase64(rt);
//                rt = new String(b);
//                if (!rt.startsWith(Constants.FORBIDPRE)) {
//                    return true;
//                }
//            } catch (Exception e) {
//                Ec.ADS.log("getFoirbidFlag eror: " + rt, e);
//            }
//        }
//        return false;
//    }
//    
//    protected String getDq(HttpServletRequest request) {
//        String dq = ParamUtil.getString(request, "dq").toLowerCase();
//        if (Constants.DQ.P_1080.equals(dq) || Constants.DQ.K_4.equals(dq)) {
//            return Constants.DQ.HD3;
//        }
//        if ("".equals(dq)){
//            dq = Constants.DQ.AUTO;//不传默认为auto
//        }
//        return dq;
//    }
//    
//    protected String getDomain(HttpServletRequest request, int site) {
//        String domain = ParamUtil.getString(request, "emb");
//        if (site == Constants.SITE.TUDOU) {
//            return domain;
//        } else {
//            try {
//                byte[] b = Base64.decodeBase64(domain);
//                String info[] = new String(b).split("\\x02");// 16进制分隔符，Util.split不支持
//                if (info.length > 2) {
//                    domain = info[2];
//                }
//            } catch (Exception e) {
//                Ec.ADS.log("getDomain error: " + domain, e);
//            }
//        }
//        return domain;
//    }
//    
//    protected boolean getIe9(RequestParam rp) {
//        String userAgent = rp.getUserAgent();
//        if (userAgent != null && userAgent.indexOf("msie 9.0") != -1) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//    
//    protected boolean getMoblie(RequestParam rp, String requestType) {
//    	if(AdCodeConstant.AdPathType.AD_PATH_MHTML.equals(requestType) || AdCodeConstant.AdPathType.AD_PATH_MVHTML.equals(requestType)){
//    		return true;
//    	}
//    	//移动web html广告的点击地址是在cpm填写, 无法区分PC还是移动,因此统一作为PC处理,使用客户端的cookie
//    	if(AdCodeConstant.AdPathType.AD_PATH_HTML.equals(requestType)){
//    		return false;
//    	}
//    	return Constants.BT.mobileBtSet.contains(rp.getBt());
//    }
//    
//    /**
//     * cs和ct特殊处理
//     * 
//     * @param rp
//     * @param request
//     */
//    protected void setCsCt(RequestParam rp, HttpServletRequest request) {
//        rp.setCt(SecurityUtil.richtext(ParamUtil.getString(request, "ct")));
//        String subChannel = SecurityUtil.richtext(ParamUtil.getString(request, "cs"));
//        subChannel = getHotCs(subChannel);// 选取二级分类中的某一个
//        // 当二级分类未知的是，根据ct取
//        if ("".equals(subChannel)
//                || (rp.getSite() == Constants.SITE.TUDOU && !BaseInfoStore.tdSubChannel.contains(subChannel))) {
//            String value = DirectionConstant.CHANNEL.unsureSubChannel.get(rp.getCt());
//            if (value != null) {
//                subChannel = value;
//            }
//        }
//        rp.setCs(subChannel);
//    }
//    
//    /**
//     * 获取subChannel中的二级分类
//     *
//     * @return
//     */
//    protected String getHotCs(String subChannel) {
//        String[] csArrays = subChannel.split("\\|");// cs一般都是传三个，用“|”分隔
//        for (String cs : csArrays) {
//            if (BaseInfoStore.hotSubChannel.contains(cs)) {
//                return cs; // 如果有热点二级分类则直接返回热点二级分类
//            }
//        }
//        return csArrays[0]; // 没有热点二级分类的就取数组第一个。
//    }
//    
//    protected String getManageType(RequestParam rp, String requestType) {
//    	if (rp.isUnion()) { // 联盟广告
//    		return PositionConstants.MANAGETYPE.H;
//    	}
//    	if(AdCodeConstant.AdPathType.AD_PATH_HTML.equals(requestType)||AdCodeConstant.AdPathType.AD_PATH_MHTML.equals(requestType)){
//    		return PositionConstants.MANAGETYPE.H; // 页面
//    	}
//    	if(AdCodeConstant.AdPathType.AD_PATH_VHTML.equals(requestType)||AdCodeConstant.AdPathType.AD_PATH_MVHTML.equals(requestType)){
//    		return PositionConstants.MANAGETYPE.BANNER; // 页面
//    	}
//    	String manageType = PositionConstants.posManageTypeMap.get(rp.getP());
//    	if (manageType != null) {
//    		return manageType;
//    	}
//    	return PositionConstants.MANAGETYPE.H;
//    }
//    
//    /**
//     * 获取p值，做一些容错处理
//     * 
//     * @param request
//     * @return
//     */
//    protected Set<String> getBids(HttpServletRequest request) {
//    	Set<String> bidSet = new HashSet<String>();
//    	String p = ParamUtil.getString(request, "p");
//    	if (StringUtils.isNotEmpty(p)) {
//    		String[] bids = StringUtil.split(p,",");
//    		for (int i = 0; i < bids.length; i++) {
//    			String bid = bids[i];
//    			if(StringUtils.isEmpty(bid) || !StringUtils.isNumeric(bid)){
//    				continue;
//    			}
//    			bidSet.add(bid);
//			}
//    	}
//    	return bidSet;
//    }
//    
//    protected int getSite(HttpServletRequest request) {
//        String site = ParamUtil.getString(request, RequestParamC.SITE);
//        if (StringUtils.isEmpty(site) || "null".equals(site)) {
//            return Constants.SITE.YOUKU; // youku vhtml不传site值。
//        }
//        if(Constants.SITE.YOUKU_STR.equals(site)){
//        	return Constants.SITE.YOUKU;
//        } else if (Constants.SITE.TUDOU_STR.equals(site)) {
//        	return Constants.SITE.TUDOU;
//        }
//        int st = Constants.SITE.YOUKU;
//        try {
//        	st = Integer.parseInt(site);
//        } catch (Exception e) {
//        	Ec.ADS.log("get site error: " + site, e, Ec.DIM_PARAM_ERROR);
//        }
//        if (st < 0) {
//        	return Constants.SITE.TUDOU;
//        }
//        return st;
//    }
//    
//    protected String getRemoteIp(RequestParam rp, HttpServletRequest request) {
//    	// 非优酷土豆的请求，优先从参数取ip
//    	String ip = null;
//    	if (rp.isKanDianInfo() || (rp.getSite() != Constants.SITE.YOUKU && rp.getSite() != Constants.SITE.TUDOU || rp.getBt().equals(Constants.BT.TV))) {
//    		ip = ParamUtil.getString(request, RequestParamC.IP);
//    	}
//    	if (StringUtils.isNotEmpty(ip)) {
//    		return ip;
//    	}
//    	return IPUtil.getRemoteIp(request);
//    }
//    
//    private double getVl(HttpServletRequest request, RequestParam rp) {
//    	if (rp.isOffLine()) {
//        	return 1200;
//        }
//        String vl = ParamUtil.getString(request, RequestParamC.VL);
//        double value = 90;
//        if(StringUtils.isEmpty(vl)){
//        	return value;
//        }
//        try {
//            double temp = Double.parseDouble(vl);
//            if (temp > 0) {
//            	return temp;
//            }
//        } catch (Exception e) {
//            Ec.ADS.log("getVl error: " + vl, e, Ec.DIM_PARAM_ERROR);
//        }
//        return value;
//    }
//
//    private int getPs(HttpServletRequest request) {
//        // TODO(zhengyang.lzy): 角标的请求是多值的，但是之前当单个数字处理，会抛异常。暂时先解决异常，之后再改成多值解析。
//        String ps = ParamUtil.getString(request, "ps");
//        String[] vals = StringUtils.split(ps, ",");
//        if (vals.length != 0) {
//            try {
//                return Integer.parseInt(vals[0]);
//            } catch (NumberFormatException e) {
//                Ec.ADS.log(String.format("malformed ps: %s", ps), e);
//                return 0;
//            }
//        }
//        return 0;
//    }
//    
//	protected Set<Integer> parseIntegerList(String data) {
//		Set<Integer> ret = new HashSet<>();
//		if (StringUtils.isEmpty(data)) {
//			return ret;
//		}
//		for (String id : StringUtils.split(data, ",")) {
//			if (NumberUtils.isNumber(id.trim())) {
//				ret.add(Integer.parseInt(id.trim()));
//			}
//		}
//		return ret;
//	}
//    
//}
