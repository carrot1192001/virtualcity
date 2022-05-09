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
//import com.youku.atm.busmodule.MPercent;
//import com.youku.atm.cacher.deliver.PercentLoader;
//import com.youku.atm.om.AdCast;
//
//
//@RunWith(value=Parameterized.class)
//public class PercentLoaderTest {
//	public PercentLoader pld = new PercentLoader();
//	private int castId;
//	private int perct;
//	private AdCast id = new AdCast();
//		
//	@Parameters
//	public static Collection<Integer[]> getTestParameters(){
//		return Arrays.asList(new Integer[][]{
//				{12345,1},
//				{12345,2},
//				{12345,1},
//				{12345,9},
//				{122345,89},
//				{12345,12},
//		});
//	}
//	
//	public PercentLoaderTest(int castId,int perct){
//		this.castId = castId;
//		this.perct = perct;
//	}
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
//		assertEquals("loader_deliver_percent",pld.key());
//	}
//
//	@Test
//	public void testGetDeliverField() {
//		assertEquals("Percent",pld.getDeliverField());
//	}
//	
//	@Test
//	public void testGetDeliverWay() {
//		assertEquals("percent",pld.getDeliverWay());
//	}
//	
////	@Test
////	public void testGetDeliverAlias() {
////		assertEquals("percent",pld.getDeliverAlias());
////	}
//	
//	@Test
//	public void testGetDelieverObject() {
//		try {
//			id.setId(castId);
//			Object mctl = pld.getDelieverObject(id, Integer.toString(perct));
//			MPercent mmctl = (MPercent)mctl;
//			assertEquals(castId,mmctl.getCastId());
//			assertEquals(perct,mmctl.getPercent());
//			System.out.println(castId);
//
//		} catch (TorqueException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//}
