package com.youku.atm.easycast;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Constants {
	public static final String BUCKET_SPLIT_DCID  = ":";
    public static final String FORBIDPRE = "0|";
    public static final int TIME = 2;//提前加载未来多少天的广告
    
    public static class TT {
        public static final String CANNOT = "cannot";
        public static HashSet<String> ttSet = new HashSet<String>();
        static {
            ttSet.add("cannot");
            ttSet.add("time");
            ttSet.add("episode");
            ttSet.add("episodes");
        }
        
    }
    
    public static class VC {
    	/** 在线播放缓存视频 */ 
        public static final String OFFLINE_OLD = "1";
        /** 离线播放缓存视频（离线广告） */ 
        public static final String OFFLINE_NEW = "2";
    }
    
    public static class SITE {
        public static final int YOUKU = 1;
        public static final int TUDOU = 2;
        public static final int SHUYU = 11;
        public static final int XIANYU = 12;
        public static final int XIAMI = 13;
        public static final int UCBROWSER = 14;
        public static final int UCTOUTIAO = 15;
        public static final int YYZX = 16; // 应用中心
        public static final int YKLIVE = 17;  //优酷直播
        public static final int WCSHOTV = 18; //世界杯短视频
        public static final Set<Integer> UC  = new HashSet<Integer>();
        public static final String YOUKU_STR = "youku";
        public static final String TUDOU_STR = "tudou";
        public static final Set<Integer> siteSet  = new HashSet<Integer>();
        static {
        	siteSet.add(SITE.YOUKU);
        	siteSet.add(SITE.TUDOU);
        	siteSet.add(SITE.SHUYU);
        	siteSet.add(SITE.XIANYU);
        	siteSet.add(SITE.XIAMI);
        	siteSet.add(SITE.UCBROWSER);
        	siteSet.add(SITE.UCTOUTIAO);
        	siteSet.add(SITE.YYZX);
        	siteSet.add(SITE.YKLIVE);
        	siteSet.add(SITE.WCSHOTV);
        	UC.add(SITE.UCBROWSER);
        	UC.add(SITE.UCTOUTIAO);
        }
    }
    
    public static class PLAYERTYPE {
        public static final String FLASH = "flash"; // falsh播放器
        public static final String H5 = "h5"; // h5播放器
    }
    
    public static class DQ {
        public static final String P_1080 = "1080p";
        public static final String K_4 = "4k";
        public static final String HD3 = "hd3";
        public static final String HD2 = "hd2";
        public static final String _3GPHD = "3gphd";
        public static final String MP4 = "mp4";
        public static final String FLV = "flv";
        public static final String AUTO = "auto";
        public static final String[] array = new String[] {DQ.HD2, DQ.MP4, DQ.FLV};
        public static HashMap<String, Integer> dqIntMap;
        static {
            dqIntMap = new HashMap<String, Integer>();
            dqIntMap.put(HD3, 4);
            dqIntMap.put(HD2, 4);
            dqIntMap.put(MP4, 2);
            dqIntMap.put(FLV, 1);
            dqIntMap.put(_3GPHD, 1);
            dqIntMap.put(AUTO, 1);
        }
    }
    
    public static class RST {
        public static final String FLV = "flv";
        public static final String _3GP = "3gphd";
        public static final String M3U8 = "m3u8";
        public static final String MP4 = "mp4";
        public static Set<String> rstSet = new HashSet<String>();
        static {
            rstSet.add(RST.FLV);
            rstSet.add(RST._3GP);
            rstSet.add(RST.M3U8);
            rstSet.add(RST.MP4);
        }
    }
    
    public static class DQRST {
        public static final String HD2 = "hd2";
        public static final String MP4 = "mp4";
        public static final String FLV = "flv";
        public static final String M3U8_HD2 = "m3u8_hd2";
        public static final String M3U8_HD3 = "m3u8_hd3";
        public static final String M3U8_MP4 = "m3u8_mp4";
        public static final String M3U8 = "m3u8";
        public static final String _3GP = "3gphd";
        public static final String MP4_HD2 = "mp4_hd2";
        public static final String MP4_HD3 = "mp4_hd3";
    }
	public static final Map<String, String> dqRstMap = new HashMap<String, String>();
	static {
		dqRstMap.put(RST.FLV + DQ.HD2, DQRST.HD2);
		dqRstMap.put(RST.FLV + DQ.MP4, DQRST.MP4);
		dqRstMap.put(RST.FLV + DQ.FLV, DQRST.FLV);
		dqRstMap.put(RST.MP4 + DQ.HD2, DQRST.HD2);
		dqRstMap.put(RST.MP4 + DQ.MP4, DQRST.MP4);
		dqRstMap.put(RST.MP4 + DQ.FLV, DQRST.FLV);
		dqRstMap.put(RST.M3U8 + DQ.HD3, DQRST.M3U8_HD3);
		dqRstMap.put(RST.M3U8 + DQ.HD2, DQRST.M3U8_HD2);
		dqRstMap.put(RST.M3U8 + DQ.MP4, DQRST.M3U8_MP4);
		dqRstMap.put(RST.M3U8 + DQ.FLV, DQRST.M3U8);
	}
    
    public static class AW {
        public static final String OFF = "off";
        public static final String A = "a";
        public static final String W = "w";
        public static final String ALL = "all";
    }
    
    public static class BOOLEAN {
        public static final String TRUE = "1";
        public static final String FALSE = "0";
    }
    // interior=站内（优土站内、土豆豆泡）,exterior=站外（优土站外、土豆合作）,adshow=焦点视频播放器，种子视频播放器，不播放其它广告。（优土）,BDskin=合作播放器（优酷）,mdevice=移动客户端播放器（优土）,touch=android设备上浏览器访问使用的播放器（优酷）,xplayer_m3u8=HTML5播放器（优酷）
    public static class WINTYPE {
        public static final String ZN = "interior";
        public static final String ZW = "exterior";
        public static final String ADSHOW = "adshow";
        public static final String BDSKIN = "BDskin";
        public static final String MDEVICE = "mdevice";
        public static final String TOUCH = "touch";
        public static final String HTML5 = "player_h5"; // H5播放器（PC）
        public static final String HTML5_MOBILE = "xplayer_m3u8"; // H5播放器（移动web） 
        /** feed流页面的嵌入式播放器 */
        public static final String INLINE = "inline";
    }
    public static class BT {
        public static final String PAD = "0";
        public static final String PHONE = "1";
        public static final String TV = "2";
        public static final String PC = "3";
        public static HashMap<String, String> btConvertMap = new HashMap<String, String>();
        static {
            btConvertMap = new HashMap<String, String>();
            btConvertMap.put("pad", BT.PAD);
            btConvertMap.put("phone", BT.PHONE);
            btConvertMap.put("tv", BT.TV);
            btConvertMap.put("pc", BT.PC);
        }
        public static Set<String> mobileBtSet = new HashSet<String>();
        static {
        	mobileBtSet.add(BT.PAD);
        	mobileBtSet.add(BT.PHONE);
        	mobileBtSet.add(BT.TV);
        }
    }
    
    public static class ZNW {
        public static final int ZN = 0; // 站内
        public static final int ZW = 1; // 站外
        public static final int TT = 2; // 通投
    }
    
    public static class OS {
        public static final String IOS = "0";
        public static final String ADR = "1";
        public static final String WIN = "2";
        public static final String MAC = "3";
        public static final String LINUX = "4";
        public static final String YUNOS = "6";
		public static final String TIZEN = "7";
        public static final String CYCLONE = "8";
    }
    
    public static class OSSTR {
        public static final String IOS = "ios";
        public static final String ANDROID = "android";
        public static final String YUNOS = "yunos";
    }
    
    public static class PARTERTYPE {
        public static final String COMMON = "0";
        public static final String NO_AD = "1"; // 不投广告的合作方
        public static final String RECORD_LOG = "2"; // 需要记录日志的合作方
    }
    
    
    /**
     * 付费系统-设备map<br>
     */
    public static final Map<String, String> FEE_DEVICE_MAP = new HashMap<String, String>();
    static {
        FEE_DEVICE_MAP.put("0_0_a", "5");
        FEE_DEVICE_MAP.put("0_0_w", "3");
        FEE_DEVICE_MAP.put("0_1_a", "7");
        FEE_DEVICE_MAP.put("0_1_w", "3");
        
        FEE_DEVICE_MAP.put("1_0_a", "4");
        FEE_DEVICE_MAP.put("1_0_w", "3");
        FEE_DEVICE_MAP.put("1_1_a", "6");
        FEE_DEVICE_MAP.put("1_1_w", "3");
        FEE_DEVICE_MAP.put("1_2_a", "10");
        FEE_DEVICE_MAP.put("1_1_w", "3");
        
        FEE_DEVICE_MAP.put("2_0_a", "11");
        FEE_DEVICE_MAP.put("2_0_w", "3");
        FEE_DEVICE_MAP.put("2_1_a", "11");
        FEE_DEVICE_MAP.put("2_1_w", "3");
        FEE_DEVICE_MAP.put("2_2_a", "11");
        FEE_DEVICE_MAP.put("2_2_w", "3");
        FEE_DEVICE_MAP.put("2_3_a", "11");
        FEE_DEVICE_MAP.put("2_3_w", "3");
        
        FEE_DEVICE_MAP.put("3_2_a", "2");
        FEE_DEVICE_MAP.put("3_2_w", "1");
        FEE_DEVICE_MAP.put("3_3_a", "2");
        FEE_DEVICE_MAP.put("3_3_w", "1");
        
        FEE_DEVICE_MAP.put("2_1_a_1", "14");
        FEE_DEVICE_MAP.put("2_1_a_2", "15");
        FEE_DEVICE_MAP.put("2_1_a_3", "16");
        
        FEE_DEVICE_MAP.put("2_6_a", "14");
        FEE_DEVICE_MAP.put("2_6_a_1", "14");
        FEE_DEVICE_MAP.put("2_6_a_2", "15");
        FEE_DEVICE_MAP.put("2_6_a_3", "16");
    }
    
    
    /**
     * 付费系统-私有密钥<br>
     * TEST-123456<br>
     * RELEASE-43d71a39cffd69ebeff4b11a0b52936d
     */
    public static final String NEW_FEE_SYS_SECRET_KEY = "aed39f230160c1b22f864723fde9f287";
    
    /**
     * 新付费系统-公有密钥<br>
     * TEST-B001<br>
     * RELEASE-B005
     */
    public static final String NEW_FEE_SYS_PUB_KEY = "P002";
    
    /**
     * 付费系统-HTTP头信息-HOST<br>
     * TEST-premium.api.youku.com<br>
     * RELEASE-premium.vrfcenter.youku.com
     */
    public static final String FEE_SYS_HTTP_HEAD_HOST = "premium.vrfcenter.youku.com";
    
    /**
     * 付费系统serids<br>
     * TEST-B001<br>
     * RELEASE-B005
     */
    public static final String VIP_SYS_SERIDS = "100000";
    
    public static final int MAX_TWO_MONTH = 5184000;
    
    /**
     * VV推送接口
     */
    public static final String VVURL = "http://statis.api.3g.youku.com/openapi-wireless/statis/vv";
    
    public static final Map<String, String> PID_VV_MAP = new HashMap<String, String>();
    static {
        PID_VV_MAP.put("1_0_0", "88fa5925ec92abae");// YOUKU_IOS_PAD
        PID_VV_MAP.put("1_0_1", "1097200dbf48d21c");// YOUKU_IOS_PHONE
        PID_VV_MAP.put("1_1_0", "1c6b3f062d413119");// YOUKU_ANDROID_PAD
        PID_VV_MAP.put("1_1_1", "6b9545cf4852ef8a");// YOUKU_ANDROID_PHONE
        PID_VV_MAP.put("2_0_0", "b1b2319247053999");// TUDOU_IOS_PAD
        PID_VV_MAP.put("2_0_1", "8decb02bc5ac872a");// TUDOU_IOS_PHONE
        PID_VV_MAP.put("2_1_0", "44675ca55dcfa5ee");// TUDOU_ANDROID_PAD
        PID_VV_MAP.put("2_1_1", "bfc8646ef5b3f864");// TUDOU_ANDROID_PHONE
    }
    
    /**
     * 接口调用状态信息
     */
    public static final class Vip {
        
        /**
         * 付费系统-记录使用日志-成功=1
         */
        public static final int WRITE_LOG_SUCCED = 1;
        /**
         * 付费系统-记录使用日志-参数错误=-100
         */
        public static final int WRITE_LOG_ERR_PARAM = -100;
        /**
         * 付费系统-记录使用日志-签名错误=-101
         */
        public static final int WRITE_LOG_ERR_SIGN = -101;
        /**
         * 付费系统-记录使用日志-写入失败=-202
         */
        public static final int WRITE_LOG_ERR_WRITE_LOG = -202;
        
        /**
         * 付费系统-服务验证-成功=1
         */
        public static final int VALID_VIP_SUCCED = 1;
        /**
         * 付费系统-服务验证-参数错误 =-100
         */
        public static final int VALID_VIP_ERR_PARAM = -100;        
        /**
         * 付费系统-服务验证-签名错误=-101
         */
        public static final int VALID_VIP_ERR_SIGN = -101;
        /**
         * 付费系统-服务验证-IP白名单错误=-101
         */
        public static final int VALID_VIP_ERR_WHITE_LIST = -102;
        /**
         * 付费系统-服务验证-未购买该服务或已过服务期=-203
         */
        public static final int VALID_VIP_ERR_NOTBUY_OR_EXPIRED = -203;
        /**
         * 付费系统-服务验证-超出当日使用次数上限=-204
         */
        public static final int VALID_VIP_ERR_ABOVE_MAX_TOTAL = -204;
        /**
         * 付费系统-服务验证-IP放分享限制不合法=-205
         */
        public static final int VALID_VIP_ERR_IP_LIMIT = -205;
        /**
         * 付费系统-服务验证-会员命中防分享策略 = -2209
         */
        public static final Set<Integer> VALID_VIP_ERR_IP_SHARE_LIMIT_SET = new HashSet<Integer>();
        static {
            VALID_VIP_ERR_IP_SHARE_LIMIT_SET.add(-2002);
            VALID_VIP_ERR_IP_SHARE_LIMIT_SET.add(-2006);
            VALID_VIP_ERR_IP_SHARE_LIMIT_SET.add(-2209);
            VALID_VIP_ERR_IP_SHARE_LIMIT_SET.add(-2210);
            VALID_VIP_ERR_IP_SHARE_LIMIT_SET.add(-2211);
        }
        
        
    }
    
    public static final class VIDEO_GROUP_TYPE {
        /** 入口营销 */
        public static final int ENT = 7;
        /** 1优酷视频id */
        public static final int YKV = 1;
        /** 2优酷播单id */
        public static final int YKD = 2;
        /** 3优酷节目id */
        public static final int YKS = 3;
        /** 土豆视频id */
        public static final int TDV = 4;
        /** 土豆豆单id */
        public static final int TDD = 5;
        /** 土豆节目id */
        public static final int TDS = 6;
    }
    
    public static Set<String> OLD_VERSION = new HashSet<String>();
    static {
        OLD_VERSION.add("ios_pad_app_2.8");
        OLD_VERSION.add("ios_phone_app_3.0.1");
        OLD_VERSION.add("adroid_pad_app_3.1.2");
        OLD_VERSION.add("adroid_pad_app_3.2.1");
        OLD_VERSION.add("adroid_pad_app_3.3");
        OLD_VERSION.add("adroid_phone_app_3.1.2");
        OLD_VERSION.add("adroid_phone_app_3.2.1");
        OLD_VERSION.add("adroid_phone_app_3.3");
    }
    
    public static final class CUF {
    	public static final int BROWSER = 0;
    	public static final int WEBVIEW = 1;
    	public static final int APP_PLAYPAGE = 2;
    	public static final int APP_PROGRAME = 3;
    	public static final int APP_TOPIC = 4;
    	public static final int ALI_SDK = 5;
    	public static final int GAME_SDK = 6;
    	public static final int URI = 8;
        public static final int PPASISTANT_SDK = 9;
        public static final int MAGIC_SCENE = 10;
        public static final int DEEP_LINK = 12;
    }
    
    public static String WEB_URL_YOUKU = "v.youku.com";
    public static String WEB_URL_TUDOU = "www.tudou.com";
    
    public static final String LOCK_KEY_INDEX = "lock_key_index.v6";

    public static final class SynerLockKey {
        public static final String ADTYPE_SYNTASK = "lock_key_adtype_syntask";
        public static final String IDEA_SYNTASK = "lock_key_idea_syntask";
        public static final String PROTECT_SYNTASK = "lock_key_protect_syntask";
        public static final String HOTVIDEO_SYNTASK = "lock_key_hotvideo_syntask";
        public static final String ADLENRANGE_SYNTASK = "lock_key_adlenrange_syntask";
        public static final String OVERFLOWRANGE_SYNTASK = "lock_key_overflowrange_syntask";
        public static final String CHANNEL_SYNTASK = "lock_key_channel_syntask";
        public static final String HCOUNT_SYNTASK = "lock_key_hcount_syntask";
        public static final String HPOSITION_SYNTASK = "lock_key_hposition_syntask";
        public static final String VPOSITION_SYNTASK = "lock_key_vposition_syntask";
        public static final String POSITION_SYNTASK = "lock_key_position_syntask";
        public static final String CASTIDEA_SYNTASK = "lock_key_castidea_syntask";
        public static final String SEED_SYNTASK = "lock_key_seed_syntask";
        public static final String ADCAST_SYNTASK = "lock_key_adcast_syntask";
        public static final String ADPREVIEW_SYNTASK = "lock_key_adpreview_syntask";
        public static final String LIVEPREVIEW_SYNTASK = "lock_key_livepreview_syntask";
        public static final String ADORDER_SYNTASK = "lock_key_adorder_syntask";
        public static final String ADMUTEX_SYNTASK = "lock_key_admutex_syntask";
        public static final String CAMPAIGN_SYNTASK = "lock_key_campaign_syntask";
        public static final String VIDEOGROUP_SYNTASK = "lock_key_videogroup_syntask";
        public static final String PLATFROM_SYNTASK = "lock_key_platform_syntask";
        public static final String COUNTINI_SYNTASK = "lock_key_countini_syntask";
        public static final String AREA_SYNTASK = "lock_key_area_syntask";
        public static final String DEALSET_SYNTASK = "lock_key_dealset_syntask";
        public static final String CID_POSITION_SYNTASK = "lock_key_cidposition_syntask";
        public static final String AD_CAT_CPM_SYNTASK = "lock_key_adcastcpm_syntask";
        public static final String AD_BUCKET_SYNTASK = "lock_key_adbucket_syntask";
        public static final String VIDEO_DOT_SYNTASK = "lock_key_videodot_syntask";
        public static final String MONITOR_PATTERN_SYNTASK = "lock_key_monpattern_syntask";
    }
    
    public static final class RESOURCE_DIRECTION_TYPE {
    	public static final String VIP = "vip";
    	public static final String PAID = "paid";
    	public static final String UA = "ua";
    }
    
    /**
     * 返回给YES系统的保护类型
     */
    public static final class PROTECT_TYPE {
    	/** 保护(只投ATM的广告) */
    	public static final int NORMAL = 1;
    	/** 白名单保护(不投广告不记容量) */
    	public static final int NOAD_WHITELIST = 2;
    	/** 时长规则(不投广告不记容量) */
    	public static final int NOAD_ADLENGTH = 3;
    	/** VIP(不投广告不记容量) */
    	public static final int NOAD_VIP = 4;
    	/** 付费(不投广告不记容量) */
    	public static final int NOAD_PAID = 5;
    	/** 种子视频(不投广告不记容量) */
    	public static final int NOAD_SEED = 6;
    	/** 按UA保护 */
    	public static final int NOAD_UA_PROTECT = 8;
        public static final int NOAD_UA_WEIXIN_PROTECT = 801; // 微信
        public static final int NOAD_UA_WEIBO_PROTECT = 802; // 微博
        public static final int NOAD_UA_BAIDU_PROTECT = 803; // 百度
    	/** 角标广告语场景广告互斥 */
    	public static final int NOAD_SCENE_PROTECT = 10;
    	/** 其它情况(不投广告不记容量) */
    	public static final int NOAD_OTHER = 100;
    	/** 广告预览 */
    	public static final int PREVIEW = 106;
    }
    
    public static final class UA {
        public static final String WEIXIN = "weixin";
        public static final String WEIXINMICRO = "micromessenger";
        public static final String WEIBO = "weibo";
        public static final String BAIDU = "baidu";
    }
    
    public static final String MHTML_CONTENT_SPLIT = "!t\\$p!";
    
    public static final int TYPE_PRIORITY_YES_GD = 3; //保量    ; atm系统中 2：保量， yes系统3：保量
	public static final int TYPE_PRIORITY_ATM_GD = 2; //保量    ; atm系统中 2：保量， yes系统3：保量
	
	/*
	 * keys for center|adserver/config.properties
	 */
	public static final class CONFIG_KEY{
		//定向名称
		public static final String DIRECT_NAME="direct_name";
	}
	
	public static final class PDB_TYPE{
		public static final int NORMAL=0;
		public static final int S2S = 2;
		public static final int C2S = 1;
		
	}
	
	public static final Set<String> NOAD_PARTERNERID_SET = new HashSet<String>();
	static {
//		NOAD_PARTERNERID_SET.add("fcd6f046e6e10f90");
//		NOAD_PARTERNERID_SET.add("5680b390bcf32393");
//		NOAD_PARTERNERID_SET.add("28c7a9f2682a4a14");
//		NOAD_PARTERNERID_SET.add("85991ac55ddc0b1e");
		NOAD_PARTERNERID_SET.add("c16e1569b439bda5");
//		NOAD_PARTERNERID_SET.add("27d679d95cb4383c");
		NOAD_PARTERNERID_SET.add("d3ab2f9c74c261d7");
		NOAD_PARTERNERID_SET.add("144da8204968143f");
		NOAD_PARTERNERID_SET.add("8ea62d4638aed2ad");
		NOAD_PARTERNERID_SET.add("4bd649cd4802caeb");
		NOAD_PARTERNERID_SET.add("5078cfd24350d143");
		NOAD_PARTERNERID_SET.add("07f810702b4d9d5c");
		NOAD_PARTERNERID_SET.add("268259e1eabba568");
		NOAD_PARTERNERID_SET.add("6915440cd54a1128");
		NOAD_PARTERNERID_SET.add("920192b4b0d6e179");
		NOAD_PARTERNERID_SET.add("b50dc7cca930fe80");
	}
	
	public static class RESTRICTION_TYPE {
		public static final String IP = "ip";// 黑名单IP限制
		public static final String IMEI = "imei";// IMEI白名单限制
	}
	
    public static class SynerType {

        public static final String ADORDER = "adorder";
        public static final String ADCAST = "adcast";
        public static final String IDEA = "idea";
        public static final String VIDEOGROUP = "videogroup";
        public static final String CAST_IDEA = "castIdea";

        public static boolean contains(String value) {
            return (ADORDER.equals(value) || ADCAST.equals(value) || IDEA.equals(value)
                    || VIDEOGROUP.equals(value) || CAST_IDEA.equals(value));
        }
    }

	
	public static class ResourceType {
		public static final int DEFAULT = 0;
		public static final int PROTECT = 1;
		public static final int ADLEN = 2;
		public static final int OVERFLOW = 3;
	}
	
    public static class Tair {
        public static final String HA_REDIS_SERVICE = "haRedis";
        public static final String AD_REDUCE_SERVICE = "adreduce";
        public static final String DC_REDIS_SERVICE = "dcRedis";
    }

	public static class UC_SHOW_TYPE {
		public static final String STATIC_IMG = "static_image";
		public static final String DYNAMIC_IMG = "dynamic_image";
	}

    public static class DOT_TYPE {
        public static final int SCENE = 0; // 普通场景
        public static final int SUBTITLE = 4; // 字幕场景（广告逻辑合并到普通场景 type=0中）
        public static final int CUSTOM_FLOAT = 1;
        public static final int MIDDLE = 2;//创意中插和前情提要
        public static final int BILLBOARD = 3;//标版
        public static final int BACK = 5; // 创意后插
    }

    public static class Ccode {
        public static final String YK_SWF = "0401";// 优酷主站swf播放器
        public static final String TD_SWF = "0402";// 土豆swf播放器
        public static final String PHONE_H5 = "0501";// Phone web H5播放器
        public static final String YK_H5 = "0502";// 优酷主站 H5播放器
        public static final String PAD_H5 = "0503";// Pad web H5播放器
        public static final String SELF_H5 = "0504";// 后台管理H5（线上不会有）
        public static final String TD_MOBILE_H5 = "0505";// 土豆 移动 WEB H5播放器
        public static final String TD_PC_H5 = "050F";// 土豆 PC WEB H5播放器
        public static final String OTT_H5 = "0506";// OTT团队
        public static final String OTT2_H5 = "0507";// OTT团队 王利军团队
        public static final String YUN_H5 = "0590";// 视频云H5播放器（站外）
        public static final String ZW_H5 = "0512";// 站外播放器


        public static boolean isSwfCcode(String ccode) {
            if (YK_SWF.equals(ccode) || TD_SWF.equals(ccode)) {
                return true;
            } else {
                return false;
            }
        }

        public static boolean isH5Ccode(String ccode) {
            if (PHONE_H5.equals(ccode) || YK_H5.equals(ccode) || PAD_H5.equals(ccode)
                    || TD_PC_H5.equals(ccode) || TD_MOBILE_H5.equals(ccode) || OTT_H5.equals(ccode)
                    || OTT2_H5.equals(ccode) || YUN_H5.equals(ccode)) {
                return true;
            } else {
                return false;
            }
        }

    }

	
	public static class DMP_TAG_TYPE {
		public static final int NORMAL = 1; // 普通dmp人群
		public static final int CODMP = 2; //codmp人群
	}

	public static class IPTYPE {
		public static final int ALLNOT = 0;
		public static final int YK = 1; // only youku
		public static final int MZ = 2; // only miaozhen
		public static final int YK_MZ = 3;
	}
	public static class MON_ADD_TYPE {
		public static final int DEF = 0;//  不在安全库之列的监测类型或默认
		public static final int MZ = 1; //  miaozhen monitor
	}

	public static class DSP_CODE {  // 和频控参数的st对应
	    public static final String ACCEPT = "10";
	    public static final String REJECT = "25";
    }

    // 阿里TA验证
    public static class AIID {
        public static final int OFF = 0;
        public static final int ON = 1;
    }

    public static class OFFLINE_STATUS {
	    public static final int ALLOWED = 1;
	    public static final int NOT_ALLOWED = 0;
    }
}
