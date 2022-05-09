//package com.youku.atm.cacher.test;
//
//import static org.junit.Assert.*;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//import org.apache.torque.TorqueException;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import org.junit.runners.Parameterized.Parameters;
//
//import com.youku.atm.cacher.deliver.LunboLoader;
//import com.youku.atm.om.AdCast;
//
//@RunWith(value=Parameterized.class)
//public class LunboLoaderTest {
//	public LunboLoader lbl = new LunboLoader();
//	
//	private int castId;
//	private int lun;
//	private int totallun;
//	private AdCast id = new AdCast();
//		
//	@Parameters
//	public static Collection<Integer[]> getTestParameters(){
//		return Arrays.asList(new Integer[][]{
//				{12345,1,7},
//				{12345,2,7},
//				{12345,1,8},
//				{12345,9,10},
//				{122345,1,7},
//				{12345,12,7},
//		});
//	}
//	
//	public LunboLoaderTest(int castId,int lun,int totallun){
//		this.castId = castId;
//		this.lun = lun;
//		this.totallun = totallun;
//	}
//
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}
//
//	@Test
//	public void testKey() {
//		assertEquals("loader_deliver_lunbo",lbl.key());
//	}
//
//	@Test
//	public void testGetDeliverField() {
//		assertEquals("Lun",lbl.getDeliverField());
//	}
//
//	@Test
//	public void testGetDeliverWay() {
//		assertEquals("lunbo",lbl.getDeliverWay());
//	}
//	
////	@Test
////	public void testGetDeliverAlias() {
////		assertEquals("lun",lbl.getDeliverAlias());
////	}
//	
//	@Test
//	public void testGetDelieverObject() {
//		String lt = lun + "/" + totallun;
//		
//		System.out.println(lt);
//		try {
//			id.setId(castId);
//	 		Object mctl = lbl.getDelieverObject(id, lt);
//			MCastLunbo mmctl = (MCastLunbo)mctl;
//			assertEquals(castId,mmctl.getCastId());
//			assertEquals(lun,mmctl.getLun());
//			assertEquals(totallun,mmctl.getTotalLun());
//			System.out.println(castId);
//		} catch (TorqueException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}
