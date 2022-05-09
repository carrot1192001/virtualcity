///**
// * 
// */
//package com.youku.atm.cacher.test;
//
//import static org.junit.Assert.*;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import org.junit.runners.Parameterized.Parameters;
//
///**
// * @author jeff-mbp
// *
// */
//@RunWith(value=Parameterized.class)
//public class LunboCookieTest {
//	private Integer ct;
//	private Integer adPos;
//	private Integer lun;
//	private Long expireTime;
//	@Parameters
//	public static Collection<Integer[]> getTestPara(){
//		return Arrays.asList(new Integer[][]{
//				{21,1,1,1231434121},
//				{22,2,2,1231434122},
//				{23,3,3,1231434123},
//				{24,4,4,1231434124}
//		});
//	}
//	
//	public LunboCookieTest(int ct, int adPos, int lun, long expireTime){
//		this.ct = ct;
//		this.adPos =adPos;
//		this.lun = lun;
//		this.expireTime = expireTime;
//	}
//	
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@After
//	public void tearDown() throws Exception {
//	}
//
//	/**
//	 * Test method for {@link com.youku.atm.caster.deliver.obj.LunboCookie#toCookieKeyString()}.
//	 */
//	@Test
//	public void testToCookieKeyString() {
//		LunboCookie lc = new LunboCookie(ct, adPos, lun, expireTime);
//		System.out.println(lc.toCookieKeyString());
//		assertEquals(ct+"_"+adPos,lc.toCookieKeyString());
//	}
//
//	/**
//	 * Test method for {@link com.youku.atm.caster.deliver.obj.LunboCookie#toCookieValueString()}.
//	 */
//	@Test
//	public void testToCookieValueString() {
//		LunboCookie lc = new LunboCookie(ct, adPos, lun, expireTime);
//		System.out.println(lc.toCookieValueString());
//		assertEquals(lun.toString(),lc.toCookieValueString());
//	}
//
//}
