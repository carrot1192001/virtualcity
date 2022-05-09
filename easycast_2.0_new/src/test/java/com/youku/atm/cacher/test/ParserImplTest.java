//package com.youku.atm.cacher.test;
//
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//import javax.servlet.http.HttpServletRequest;
//
//import mockit.Deencapsulation;
//import mockit.Mocked;
//import mockit.NonStrictExpectations;
//
//import org.apache.commons.codec.binary.Base64;
//import org.junit.Test;
//
//import com.youku.atm.adserver.service.impl.ParamParserImpl;
//import com.youku.atm.adserver.store.BaseInfoStore;
//import com.youku.atm.adserver.vo.RequestParam;
//import com.youku.atm.common.constant.Constants;
//import com.youku.atm.common.constant.DirectionConstant;
//import com.youku.atm.common.constant.PositionConstants;
//
///**
// * 参数解析单元测试
// * 
// * @author hemengxin
// * 
// */
//public class ParserImplTest {
//    ParamParserImpl paramParserImpl = new ParamParserImpl();
//    @Mocked
//    HttpServletRequest request;
//    
//    
//    
//    /**
//     * case1,2,3: 如果X-Forwarded-For中为null或者为""或者为unknown，则返回getRemoteAddr（）
//     */
//    @Test
//    public void testGetRemoteIpCase1() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getHeader("X-Forwarded-For");
//                result = "";
//                request.getRemoteAddr();
//                result = "ip";
//            }
//        };
//        String result = Deencapsulation.invoke(paramParserImpl, "getRemoteIp", request);
//        assertEquals("ip", result);
//    }
//    
//    @Test
//    public void testGetRemoteIpCase2() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getHeader("X-Forwarded-For");
//                result = null;
//                request.getRemoteAddr();
//                result = "ip";
//            }
//        };
//        String result = Deencapsulation.invoke(paramParserImpl, "getRemoteIp", request);
//        assertEquals("ip", result);
//    }
//    
//    @Test
//    public void testGetRemoteIpCase3() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getHeader("X-Forwarded-For");
//                result = "unknown";
//                request.getRemoteAddr();
//                result = "ip";
//            }
//        };
//        String result = Deencapsulation.invoke(paramParserImpl, "getRemoteIp", request);
//        assertEquals("ip", result);
//    }
//    
//    /**
//     * case4: 如果X-Forwarded-For中的值没有意义，getRemoteAddr（）为null，则返回“”
//     * 
//     * @throws Exception
//     */
//    @Test
//    public void testGetRemoteIpCase4() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getHeader("X-Forwarded-For");
//                result = "";
//                request.getRemoteAddr();
//                result = null;
//            }
//        };
//        String result = Deencapsulation.invoke(paramParserImpl, "getRemoteIp", request);
//        assertEquals("", result);
//    }
//    
//    /**
//     * case5: 如果X-Forwarded-For中的值合法，取split之后的第一个字不为空串且不为“unknown”的符串
//     * 
//     * @throws Exception
//     */
//    @Test
//    public void testGetRemoteIpCase5() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getHeader("X-Forwarded-For");
//                result = "111,222,333";
//            }
//        };
//        String result = Deencapsulation.invoke(paramParserImpl, "getRemoteIp", request);
//        assertEquals("111", result);
//    }
//    
//    /**
//     * case6: 如果X-Forwarded-For中的值合法，取split之后的第一个字不为空串且不为“unknown”的符串，
//     * 
//     * @throws Exception
//     */
//    @Test
//    public void testGetRemoteIpCase6() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getHeader("X-Forwarded-For");
//                result = "unknown,222,333";
//            }
//        };
//        String result = Deencapsulation.invoke(paramParserImpl, "getRemoteIp", request);
//        assertEquals("222", result);
//    }
//    
//    
//    /**
//     * case1: 当site传“1”或者不传的时候认为是优酷1
//     */
//    @Test
//    public void testGetSiteCase1() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("site");
//                result = "1";
//            }
//        };
//        int result = Deencapsulation.invoke(paramParserImpl, "getSite", request);
//        assertEquals(1, result);
//    }
//    
//    /**
//     * case2: site传“”，应该也表示优酷。
//     */
//    @Test
//    public void testGetSiteCase2() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("site");
//                result = "";
//            }
//        };
//        int result = Deencapsulation.invoke(paramParserImpl, "getSite", request);
//        assertEquals(1, result);
//    }
//    
//    /**
//     * case3: site不传，返回1，表示优酷
//     */
//    @Test
//    public void testGetSiteCase3() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("site");
//                result = null;
//            }
//        };
//        int result = Deencapsulation.invoke(paramParserImpl, "getSite", request);
//        assertEquals(1, result);
//    }
//    
//    /**
//     * case4: 当site传“1”或者不传的时候认为是优酷1，否则全部都是土豆，赋值为2；
//     */
//    @Test
//    public void testGetSiteCase4() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("site");
//                result = "-1";
//            }
//        };
//        int result = Deencapsulation.invoke(paramParserImpl, "getSite", request);
//        assertEquals(2, result);
//    }
//    
//    /**
//     * case5: 当site传“1”或者不传的时候认为是优酷1，否则全部都是土豆，赋值为2；
//     */
//    @Test
//    public void testGetSiteCase5() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("site");
//                result = "sdfsd";
//            }
//        };
//        int result = Deencapsulation.invoke(paramParserImpl, "getSite", request);
//        assertEquals(2, result);
//    }
//    
//    /**
//     * case1: p的合法值应该是数字；
//     */
//    @Test
//    public void testGetPCase1() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("p");
//                result = "2";
//            }
//        };
//        int result = Deencapsulation.invoke(paramParserImpl, "getP", request);
//        assertEquals(2, result);
//    }
//    
//    /**
//     * case2: p的合法值应该是正整数
//     */
//    @Test
//    public void testGetPCase2() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("p");
//                result = "-2";
//            }
//        };
//        int result = Deencapsulation.invoke(paramParserImpl, "getP", request);
//        assertEquals(0, result);
//        
//        new NonStrictExpectations() {
//            {
//                request.getParameter("p");
//                result = "dfasdf";
//            }
//        };
//        result = Deencapsulation.invoke(paramParserImpl, "getP", request);
//        assertEquals(0, result);
//        
//        new NonStrictExpectations() {
//            {
//                request.getParameter("p");
//                result = "";
//            }
//        };
//        result = Deencapsulation.invoke(paramParserImpl, "getP", request);
//        assertEquals(0, result);
//        
//        
//        new NonStrictExpectations() {
//            {
//                request.getParameter("p");
//                result = null;
//            }
//        };
//        result = Deencapsulation.invoke(paramParserImpl, "getP", request);
//        assertEquals(0, result);
//    }
//    
//    
//    
//    /**
//     * case1: 根据p生manageType,注意除了p=1-13,当p为其他值的时候，表示页面广告blockId，manageType为h。
//     */
//    @Test
//    public void testGetManageType5Case1() throws Exception {
//        String result = Deencapsulation.invoke(paramParserImpl, "getManageType", 1);
//        assertEquals("f", result);
//        result = Deencapsulation.invoke(paramParserImpl, "getManageType", 2);
//        assertEquals("b", result);
//        result = Deencapsulation.invoke(paramParserImpl, "getManageType", 3);
//        assertEquals("o", result);
//        result = Deencapsulation.invoke(paramParserImpl, "getManageType", 4);
//        assertEquals("p", result);
//        result = Deencapsulation.invoke(paramParserImpl, "getManageType", 5);
//        assertEquals("c", result);
//        result = Deencapsulation.invoke(paramParserImpl, "getManageType", 6);
//        assertEquals("v", result);
//        result = Deencapsulation.invoke(paramParserImpl, "getManageType", 7);
//        assertEquals("f", result);
//        result = Deencapsulation.invoke(paramParserImpl, "getManageType", 8);
//        assertEquals("o", result);
//        result = Deencapsulation.invoke(paramParserImpl, "getManageType", 9);
//        assertEquals("b", result);
//        result = Deencapsulation.invoke(paramParserImpl, "getManageType", 10);
//        assertEquals("p", result);
//        result = Deencapsulation.invoke(paramParserImpl, "getManageType", 11);
//        assertEquals("c", result);
//        result = Deencapsulation.invoke(paramParserImpl, "getManageType", 12);
//        assertEquals("i", result);
//        result = Deencapsulation.invoke(paramParserImpl, "getManageType", 13);
//        assertEquals("i", result);
//        result = Deencapsulation.invoke(paramParserImpl, "getManageType", 14);
//        assertEquals("h", result);
//        result = Deencapsulation.invoke(paramParserImpl, "getManageType", 15);
//        assertEquals("h", result);
//        result = Deencapsulation.invoke(paramParserImpl, "getManageType", 100);
//        assertEquals("h", result);
//    }
//    
//    /**
//     * case: 获取数组中的热点城市,如果有就返回，没有返回数组第一个元素
//     */
//    @Test
//    public void testGetHotCsCase() throws Exception {
//        BaseInfoStore.hotSubChannel.add("1");
//        String result = Deencapsulation.invoke(paramParserImpl, "getHotCs", "1|2|3");
//        assertEquals("1", result);
//        result = Deencapsulation.invoke(paramParserImpl, "getHotCs", "3|2|4");
//        assertEquals("3", result);
//        result = Deencapsulation.invoke(paramParserImpl, "getHotCs", "");
//        assertEquals("", result);
//        BaseInfoStore.hotSubChannel.clear();
//    }
//    
//    
//    
//    /**
//     * case1: 设置一级分类和二级分类,如果是优酷的，只要二级分类不是”“，那么直接复制到rp中
//     */
//    @Test
//    public void testSetCsCtCase1() throws Exception {
//        BaseInfoStore.tdSubChannel.add("a");
//        BaseInfoStore.tdSubChannel.add("b");
//        new NonStrictExpectations() {
//            {
//                request.getParameter("ct");
//                result = "a";
//                request.getParameter("cs");
//                result = "c";
//            }
//        };
//        RequestParam rp = new RequestParam();
//        rp.setSite(Constants.SITE.YOUKU);
//        Deencapsulation.invoke(paramParserImpl, "setCsCt", rp, request);
//        assertEquals("a", rp.getCt());
//        assertEquals("c", rp.getCs());
//        BaseInfoStore.tdSubChannel.clear();
//    }
//    
//    
//    /**
//     * case2: 如果是土豆的，二级分类能识别，将参数中的值直接赋值到rp中
//     */
//    @Test
//    public void testSetCsCtCase2() throws Exception {
//        BaseInfoStore.tdSubChannel.add("a");
//        BaseInfoStore.tdSubChannel.add("b");
//        new NonStrictExpectations() {
//            {
//                request.getParameter("ct");
//                result = "30";
//                request.getParameter("cs");
//                result = "b";
//            }
//        };
//        RequestParam rp = new RequestParam();
//        rp.setSite(Constants.SITE.TUDOU);
//        Deencapsulation.invoke(paramParserImpl, "setCsCt", rp, request);
//        assertEquals("30", rp.getCt());
//        assertEquals("b", rp.getCs());
//        BaseInfoStore.tdSubChannel.clear();
//    }
//    
//    /**
//     * case3: 设置一级分类和二级分类,如果是土豆的，二级分类不能识别，则去分类映射map（unsureSubChannel）中去查找二级分类
//     */
//    @Test
//    public void testSetCsCtCase3() throws Exception {
//        BaseInfoStore.tdSubChannel.add("a");
//        BaseInfoStore.tdSubChannel.add("b");
//        new NonStrictExpectations() {
//            {
//                request.getParameter("ct");
//                result = "30";
//                request.getParameter("cs");
//                result = "c";
//            }
//        };
//        RequestParam rp = new RequestParam();
//        rp.setSite(Constants.SITE.TUDOU);
//        Deencapsulation.invoke(paramParserImpl, "setCsCt", rp, request);
//        assertEquals("30", rp.getCt());
//        assertEquals("110309999", rp.getCs());
//        BaseInfoStore.tdSubChannel.clear();
//    }
//    
//    /**
//     * case4:如果是二级分类是”“,不论是优酷还是土豆，则去分类映射map（unsureSubChannel）中去查找二级分类。
//     */
//    @Test
//    public void testSetCsCtCase4() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("ct");
//                result = "a";
//                request.getParameter("cs");
//                result = "";
//            }
//        };
//        RequestParam rp = new RequestParam();
//        rp.setSite(Constants.SITE.YOUKU);
//        Deencapsulation.invoke(paramParserImpl, "setCsCt", rp, request);
//        assertEquals("a", rp.getCt());
//        assertEquals("1000", rp.getCs());
//    }
//    
//    /**
//     * case1:根据p值判断是否是移动，只有当p值为7,8,9,10,11,12的时候才是移动
//     */
//    @Test
//    public void testGetMoblieCase1() throws Exception {
//        boolean result = Deencapsulation.invoke(paramParserImpl, "getMoblie", 7);
//        assertTrue(result);
//        result = Deencapsulation.invoke(paramParserImpl, "getMoblie", 8);
//        assertTrue(result);
//        result = Deencapsulation.invoke(paramParserImpl, "getMoblie", 9);
//        assertTrue(result);
//        result = Deencapsulation.invoke(paramParserImpl, "getMoblie", 10);
//        assertTrue(result);
//        result = Deencapsulation.invoke(paramParserImpl, "getMoblie", 11);
//        assertTrue(result);
//        result = Deencapsulation.invoke(paramParserImpl, "getMoblie", 12);
//        assertTrue(result);
//        result = Deencapsulation.invoke(paramParserImpl, "getMoblie", 5);
//        assertFalse(result);
//        result = Deencapsulation.invoke(paramParserImpl, "getMoblie", 16);
//        assertFalse(result);
//    }
//    
//    /**
//     * case1:判断是否是ie9
//     */
//    @Test
//    public void testGetIe9Case1() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getHeader("User-Agent");
//                result = "msie 9.0";
//            }
//        };
//        boolean reuslt = Deencapsulation.invoke(paramParserImpl, "getIe9", request);
//        assertTrue(reuslt);
//        new NonStrictExpectations() {
//            {
//                request.getHeader("User-Agent");
//                result = "msdfds";
//            }
//        };
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getIe9", request);
//        assertFalse(reuslt);
//        new NonStrictExpectations() {
//            {
//                request.getHeader("User-Agent");
//                result = "";
//            }
//        };
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getIe9", request);
//        assertFalse(reuslt);
//        new NonStrictExpectations() {
//            {
//                request.getHeader("User-Agent");
//                result = null;
//            }
//        };
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getIe9", request);
//        assertFalse(reuslt);
//    }
//    
//    
//    /**
//     * case1:必须是土豆的并且prd参数中存在"tvb"的才是prd
//     */
//    @Test
//    public void testGetPrdCase1() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("prd");
//                result = "tvb";
//            }
//        };
//        boolean reuslt = Deencapsulation.invoke(paramParserImpl, "getPrd", request, Constants.SITE.TUDOU);
//        assertTrue(reuslt);
//    }
//    
//    
//    /**
//     * case2:必须是土豆的并且prd参数中存在"tvb"的才是prd,否则为false
//     */
//    @Test
//    public void testGetPrdCase2() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("prd");
//                result = "tvb";
//            }
//        };
//        boolean reuslt = Deencapsulation.invoke(paramParserImpl, "getPrd", request, Constants.SITE.YOUKU);
//        assertFalse(reuslt);
//        
//        new NonStrictExpectations() {
//            {
//                request.getParameter("prd");
//                result = "tttt";
//            }
//        };
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getPrd", request, Constants.SITE.TUDOU);
//        assertFalse(reuslt);
//    }
//    
//    /**
//     * case1:正常赋值
//     */
//    @Test
//    public void testGetDqCase1() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("dq");
//                result = "abc";
//            }
//        };
//        String reuslt = Deencapsulation.invoke(paramParserImpl, "getDq", request);
//        assertEquals("abc", reuslt);
//    }
//    
//    /**
//     * case2:如果是1080p或者4k，转换成hd2
//     */
//    @Test
//    public void testGetDqCase2() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("dq");
//                result = "1080p";
//            }
//        };
//        String reuslt = Deencapsulation.invoke(paramParserImpl, "getDq", request);
//        //assertEquals(DirectionConstant.DQ.HD2, reuslt);
//        
//        new NonStrictExpectations() {
//            {
//                request.getParameter("dq");
//                result = "4k";
//            }
//        };
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getDq", request);
//        //assertEquals(DirectionConstant.DQ.HD2, reuslt);
//    }
//    
//    
//    
//    /**
//     * case1:正常赋值
//     */
//    @Test
//    public void testGetBtCase1() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("bt");
//                result = "abc";
//            }
//        };
//        String reuslt = Deencapsulation.invoke(paramParserImpl, "getBt", request);
//        assertEquals("abc", reuslt);
//    }
//    
//    
//    /**
//     * case2:如果没有，默认为是pc
//     */
//    @Test
//    public void testGetBtCase2() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("bt");
//                result = null;
//            }
//        };
//        String reuslt = Deencapsulation.invoke(paramParserImpl, "getBt", request);
//        assertEquals(Constants.BT.PC, reuslt);
//        
//        new NonStrictExpectations() {
//            {
//                request.getParameter("bt");
//                result = "";
//            }
//        };
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getBt", request);
//        assertEquals(Constants.BT.PC, reuslt);
//    }
//    
//    /**
//     * case3:如果是pad，phone，tv，pc需要转换成相对应的数字代码
//     */
//    @Test
//    public void testGetBtCase3() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("bt");
//                result = "pad";
//            }
//        };
//        String reuslt = Deencapsulation.invoke(paramParserImpl, "getBt", request);
//        assertEquals(Constants.BT.PAD, reuslt);
//        
//        new NonStrictExpectations() {
//            {
//                request.getParameter("bt");
//                result = "phone";
//            }
//        };
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getBt", request);
//        assertEquals(Constants.BT.PHONE, reuslt);
//        
//        new NonStrictExpectations() {
//            {
//                request.getParameter("bt");
//                result = "tv";
//            }
//        };
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getBt", request);
//        assertEquals(Constants.BT.TV, reuslt);
//        new NonStrictExpectations() {
//            {
//                request.getParameter("bt");
//                result = "pc";
//            }
//        };
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getBt", request);
//        assertEquals(Constants.BT.PC, reuslt);
//    }
//    
//    /**
//     * case1:正常赋值
//     */
//    @Test
//    public void testGetOsCase1() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("os");
//                result = "abc";
//            }
//        };
//        String reuslt = Deencapsulation.invoke(paramParserImpl, "getOs", request);
//        assertEquals("abc", reuslt);
//    }
//    
//    /**
//     * case2:如果是windows，mac，linux，android，ios，则要转换成相对应的数字代码
//     */
//    @Test
//    public void testGetOsCase2() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("os");
//                result = "windows";
//            }
//        };
//        String reuslt = Deencapsulation.invoke(paramParserImpl, "getOs", request);
//        assertEquals(Constants.OS.WIN, reuslt);
//        
//        new NonStrictExpectations() {
//            {
//                request.getParameter("os");
//                result = "mac";
//            }
//        };
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getOs", request);
//        assertEquals(Constants.OS.MAC, reuslt);
//        
//        new NonStrictExpectations() {
//            {
//                request.getParameter("os");
//                result = "linux";
//            }
//        };
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getOs", request);
//        assertEquals(Constants.OS.LINUX, reuslt);
//        
//        new NonStrictExpectations() {
//            {
//                request.getParameter("os");
//                result = "android";
//            }
//        };
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getOs", request);
//        assertEquals(Constants.OS.ADR, reuslt);
//        
//        new NonStrictExpectations() {
//            {
//                request.getParameter("os");
//                result = "ios";
//            }
//        };
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getOs", request);
//        assertEquals(Constants.OS.IOS, reuslt);
//    }
//    
//    /**
//     * case3:如果是null或者“”，默认为win
//     */
//    @Test
//    public void testGetOsCase3() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("os");
//                result = "";
//            }
//        };
//        String reuslt = Deencapsulation.invoke(paramParserImpl, "getOs", request);
//        assertEquals(Constants.OS.WIN, reuslt);
//        
//        new NonStrictExpectations() {
//            {
//                request.getParameter("os");
//                result = null;
//            }
//        };
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getOs", request);
//        assertEquals(Constants.OS.WIN, reuslt);
//    }
//    
//    /**
//     * case1:如果是flv,3gphd,m3u8直接赋值
//     */
//    @Test
//    public void testGetRstCase1() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("rst");
//                result = "flv";
//            }
//        };
//        String reuslt = Deencapsulation.invoke(paramParserImpl, "getRst", request);
//        assertEquals(Constants.RST.FLV, reuslt);
//        
//        new NonStrictExpectations() {
//            {
//                request.getParameter("rst");
//                result = "3gphd";
//            }
//        };
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getRst", request);
//        assertEquals(Constants.RST._3GP, reuslt);
//        
//        new NonStrictExpectations() {
//            {
//                request.getParameter("rst");
//                result = "m3u8";
//            }
//        };
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getRst", request);
//        assertEquals(Constants.RST.M3U8, reuslt);
//        
//    }
//    
//    /**
//     * case2:如果不是flv,3gphd,m3u8，赋值为""
//     */
//    @Test
//    public void testGetRstCase2() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("rst");
//                result = "";
//            }
//        };
//        String reuslt = Deencapsulation.invoke(paramParserImpl, "getRst", request);
//        assertEquals("", reuslt);
//        
//        new NonStrictExpectations() {
//            {
//                request.getParameter("rst");
//                result = null;
//            }
//        };
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getRst", request);
//        assertEquals("", reuslt);
//    }
//    
//    /**
//     * case1:aw,默认值为w。
//     */
//    @Test
//    public void testGetAwCase1() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("aw");
//                result = "";
//            }
//        };
//        String reuslt = Deencapsulation.invoke(paramParserImpl, "getAw", request);
//        assertEquals("w", reuslt);
//        
//        new NonStrictExpectations() {
//            {
//                request.getParameter("aw");
//                result = null;
//            }
//        };
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getAw", request);
//        assertEquals("w", reuslt);
//    }
//    
//    /**
//     * case2:aw,正常赋值
//     */
//    @Test
//    public void testGetAwCase2() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("aw");
//                result = "a";
//            }
//        };
//        String reuslt = Deencapsulation.invoke(paramParserImpl, "getAw", request);
//        assertEquals("a", reuslt);
//    }
//    
//    /**
//     * case1:off,正常赋值
//     */
//    @Test
//    public void testGetOffCase1() throws Exception {
//        boolean reuslt = Deencapsulation.invoke(paramParserImpl, "getOffLine", "off", "2");
//        assertTrue(reuslt);
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getOffLine", "a", "0");
//        assertFalse(reuslt);
//    }
//    
//    /**
//     * case1:如果s不为空串，有版权
//     */
//    @Test
//    public void testGetCopyRightCase1() throws Exception {
//        RequestParam rp = new RequestParam();
//        rp.setS("121");
//        boolean reuslt = Deencapsulation.invoke(paramParserImpl, "getCopyRight", rp);
//        rp.setS("");
//        assertTrue(reuslt);
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getCopyRight", rp);
//        assertFalse(reuslt);
//    }
//    
//    /**
//     * case2:如果ct属于有版权的一级分类，有版权
//     */
//    @Test
//    public void testGetCopyRightCase2() throws Exception {
//        RequestParam rp = new RequestParam();
//        rp.setS("");
//        
//        rp.setCt("a");
//        boolean reuslt = Deencapsulation.invoke(paramParserImpl, "getCopyRight", rp);
//        assertTrue(reuslt);
//        
//        rp.setCt("afdsfds");
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getCopyRight", rp);
//        assertFalse(reuslt);
//    }
//    
//    
//    /**
//     * case1：如果不是移动开机图，直接赋值
//     */
//    @Test
//    public void testGetPxCase1() throws Exception {
//        RequestParam rp = new RequestParam();
//        rp.setP(PositionConstants.P.QIANTIE);
//        new NonStrictExpectations() {
//            {
//                request.getParameter("px");
//                result = "aaaa";
//            }
//        };
//        String reuslt = Deencapsulation.invoke(paramParserImpl, "getPx", request, rp);
//        assertEquals("aaaa", reuslt);
//    }
//    
//    /**
//     * case2：如果是移动开机图,,px由dvw*dvh组成
//     * 
//     */
//    @Test
//    public void testGetPxCase2() throws Exception {
//        RequestParam rp = new RequestParam();
//        rp.setP(PositionConstants.P.MKAIJITU);
//        new NonStrictExpectations() {
//            {
//                request.getParameter("px");
//                result = "aaaa";
//            }
//        };
//        rp.setDvw(2);
//        rp.setDvh(1);
//        String reuslt = Deencapsulation.invoke(paramParserImpl, "getPx", request, rp);
//        assertEquals("2*1", reuslt);
//    }
//    
//    /**
//     * case3：如果是移动开机图,ios&&pad&&dvw<dvh,则dvw和dvh互换,px=dvw*dvh
//     * 
//     */
//    @Test
//    public void testGetPxCase3() throws Exception {
//        RequestParam rp = new RequestParam();
//        rp.setP(PositionConstants.P.MKAIJITU);
//        new NonStrictExpectations() {
//            {
//                request.getParameter("px");
//                result = "aaaa";
//            }
//        };
//        rp.setDvw(1);
//        rp.setDvh(2);
//        rp.setOs(Constants.OS.IOS);
//        rp.setBt(Constants.BT.PAD);
//        String reuslt = Deencapsulation.invoke(paramParserImpl, "getPx", request, rp);
//        assertEquals("2*1", reuslt);
//        rp.setDvw(2);
//        rp.setDvh(1);
//        reuslt = Deencapsulation.invoke(paramParserImpl, "getPx", request, rp);
//        assertEquals("2*1", reuslt);
//    }
//    
//    /**
//     * case4：如果是移动开机图,直接由px = dvw*dvh
//     * 
//     */
//    @Test
//    public void testGetPxCase4() throws Exception {
//        RequestParam rp = new RequestParam();
//        rp.setP(PositionConstants.P.MKAIJITU);
//        new NonStrictExpectations() {
//            {
//                request.getParameter("px");
//                result = "aaaa";
//            }
//        };
//        rp.setDvw(1);
//        rp.setDvh(2);
//        rp.setOs(Constants.OS.IOS);
//        String reuslt = Deencapsulation.invoke(paramParserImpl, "getPx", request, rp);
//        assertEquals("1*2", reuslt);
//    }
//    
//    /**
//     * case1：rt取出，解码，返回为true
//     * 
//     */
//    @Test
//    public void testGetFoirbidFlagCase1() throws Exception {
//        final String rt = Base64.encodeBase64String("1|hmx".getBytes());
//        new NonStrictExpectations() {
//            {
//                request.getParameter("rt");
//                result = rt;
//            }
//        };
//        boolean reuslt = Deencapsulation.invoke(paramParserImpl, "getFoirbidFlag", request);
//        assertTrue(reuslt);
//    }
//    
//    /**
//     * case2：rt取出，解码，返回为true
//     * 
//     */
//    @Test
//    public void testGetFoirbidFlagCase2() throws Exception {
//        final String rt = Base64.encodeBase64String("0|dfdsf".getBytes());
//        new NonStrictExpectations() {
//            {
//                request.getParameter("rt");
//                result = rt;
//            }
//        };
//        boolean reuslt = Deencapsulation.invoke(paramParserImpl, "getFoirbidFlag", request);
//        assertFalse(reuslt);
//    }
//    
//    /**
//     * case1：domain,如果是土豆直接赋值
//     * 
//     */
//    @Test
//    public void testGetDomainCase2() throws Exception {
//        new NonStrictExpectations() {
//            {
//                request.getParameter("emb");
//                result = "abc";
//            }
//        };
//        String reuslt = Deencapsulation.invoke(paramParserImpl, "getDomain", request, 2);
//        assertEquals("abc", reuslt);
//    }
//}
