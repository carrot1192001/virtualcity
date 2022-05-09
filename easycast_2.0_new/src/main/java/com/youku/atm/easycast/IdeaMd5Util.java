package com.youku.atm.easycast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 图片相关工具
 * 
 * @author subin
 * @date 2017年1月17日
 */
public class IdeaMd5Util {
	/** 
     * 从网络Url中下载文件 
     * @param urlStr 
     * @param fileName 
     * @param savePath 
     * @throws IOException 
     */  
    public static String  getUrlFileMd5(String urlStr,String fileName,String savePath) throws IOException{  
        URL url = new URL(urlStr);    
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();    
                //设置超时间为3秒  
        conn.setConnectTimeout(3*1000);  
        //防止屏蔽程序抓取而返回403错误  
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");  
  
        //得到输入流  
        InputStream inputStream = conn.getInputStream();    

        //获取自己数组  
        byte[] getData = readInputStream(inputStream);      
  
        //文件保存位置  
        File saveDir = new File(savePath);  
        if(!saveDir.exists()){  
            saveDir.mkdir();  
        }  
        
        File file = new File(saveDir+File.separator+fileName);
        FileOutputStream fos = new FileOutputStream(file);       
        fos.write(getData);   
        if(fos != null){  
            fos.close();    
        }  
        if(inputStream!=null){  
            inputStream.close();  
        } 

        String value = "";
        FileInputStream fin = new FileInputStream(file); 
        try{
            value =  FileMD5Util.getMD5(file);
        }catch(Exception e){
//            Ec.COMMON.log(" MD5Util.getMD5 error!", e);
        }
        if(fin != null){
        	fin.close();
        }
        conn.disconnect();
        file.delete();
        return value;
    }  
  
  
    /** 
     * 从输入流中获取字节数组 
     * @param inputStream 
     * @return 
     * @throws IOException 
     */  
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {    
        byte[] buffer = new byte[1024];    
        int len = 0;    
        ByteArrayOutputStream bos = new ByteArrayOutputStream();    
        while((len = inputStream.read(buffer)) != -1) {    
            bos.write(buffer, 0, len);    
        }    
        bos.close();    
        return bos.toByteArray();    
    }    
  
    public static void main(String[] args) {  
        try{  
        	System.out.println(getUrlFileMd5("http://r1.ykimg.com/material/0A03/A1/201806/0615/3003495/1529052431757/0D0100005B237D1E9472061828524B32.jpg",  
                    "video111","d:/workspace/"));  
        	//http://vali.cp31.ott.cibntv.net/youku/6976C52086A3C717E5F09540D/0300080100584130F5C1F6003E880345222DCF-4683-B493-A42B-8977BCEA426B.mp4?sid=052902870426012603343_00_Aaaa0b5b2b52468f674fe70a5a665151f&sign=0c6a480e378eeddfadf64e948c69e646&ctype=50&hd=1",
        }catch (Exception e) {  
            e.printStackTrace();
        }  
        
//        System.out.println(MD5Util.getMD5(new File("D:/619357104.mp4")));
    }  

}
