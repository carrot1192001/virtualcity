package com.youku.atm.cacher.test;

import java.lang.reflect.Field;

public class TestPrivate2
{
//    public static void main(String[] args) throws Exception
//    {
//        PrivateClass2 p = new TestAbs();
//        
//        Class<?> classType = p.getClass();
//        
//        Field field = classType.getDeclaredField("name");
//
//        field.setAccessible(true); // 抑制Java对修饰符的检查
//        
//        System.out.println(field.get("name"));
//        
//
//        
//    }
    	
        public static void main(String[] args) throws Exception
        {
            PrivateClass2 p = new TestAbs();
            
     //       Class<?> classType = p.getClass();
            
            Field field = PrivateClass2.class.getDeclaredField("name");

            field.setAccessible(true); // 抑制Java对修饰符的检查
            
            Object test = field.get(p);
            
            System.out.println(test.toString());
            

            
        }

}
