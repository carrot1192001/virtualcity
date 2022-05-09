//package com.youku.atm.cacher.test;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
//
//
//public class DetailTable {
//	private Logger logger = Logger.getLogger(this.getClass().getName());
//	private String androidSdkPath;
//	private String screenshotsDir="/sdcard/gary";
//	private ArrayList<String> List = new ArrayList<String>();	//存储图片名称信息
//	private ArrayList<String> photoInfo = new ArrayList<String>();//存储断言信息
//
//	public DetailTable() {
//		try {
//			androidSdkPath=TmpConf.getAndroidSdkPath();
//			PropertyConfigurator.configure("./conf/log4j.properties");
//			screenshotsDir=TmpConf.getScreenshotsDir();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	/**
//	 * 生成单个用例的详细报告
//	 * @param caseName
//	 * @param caseNameCN
//	 * @param jnuitLog
//	 * @param CaseInfoTemplate
//	 * @param ReportPath
//	 * @param ImageInfoTemplate
//	 * @param LogInfoTemplate
//	 * @throws IOException
//	 */
//	
//	public void detailTableContent(String caseName, String caseNameCN,String jnuitLog, String CaseInfoTemplate, String ReportPath, String ImageInfoTemplate, String LogInfoTemplate) throws IOException {
//		//读取模板
//		Files files = new Files();
//		String ReportContent=files.readfile(new File(CaseInfoTemplate));
//		File reportFile=new File(ReportPath + File.separator+caseName + "/" + caseName + ".html");
//		//替换关键信息	
//		ReportContent = ReportContent.replace("$CaseName", caseName);
//		ReportContent=ReportContent.replace("$CaseDescription", caseNameCN);
//		
//		
//		//重新写单个用例报告
//		FileOutputStream fw=new FileOutputStream(reportFile);
//		PrintWriter bw=new PrintWriter(fw);
//		bw.write(ReportContent);
//
//		
//		
//		for (int i = 0; i < List.size(); i++) {
//		String ImageInfoContent = files.readfile(new File(ImageInfoTemplate));	
//		if (photoInfo.size()>0) {//如果有图片说明信息
//			ImageInfoContent = ImageInfoContent.replace("$ImageInfo", "Assertion:"+new String(photoInfo.get(i).getBytes("utf-8")));
//		}
//		ImageInfoContent = ImageInfoContent.replace("$ImagePath","screenshots/" + List.get(i));
//        
//		bw.write(ImageInfoContent);
//		}
//		
//        Files file=new Files();
//        String junitLogContent = file.readfile(new File(jnuitLog));
//        
//		if (junitLogContent != null) {
//
//			junitLogContent = junitLogContent.replaceAll("<", "&lt;");
//
//			junitLogContent = junitLogContent.replaceAll(">", "&gt;");
//
//			junitLogContent = junitLogContent.replaceAll("\r\n", " <br>");
//			
//			String LogInfoContent=files.readfile(new File(LogInfoTemplate));
//
//			LogInfoContent=LogInfoContent.replace("$JnuitLog", new String(junitLogContent.getBytes("utf-8")));
//			
//			bw.write(LogInfoContent);
//		
//			
//		} 
//		bw.close();
//		fw.close();
//		
//	}
//	
///**
// * 获取图片名称信息与图片检查点信息
// * @param caseName
// * @param ReportPath
// */
//
//	public void getImageNamesFromPC(String caseName, String ReportPath) {
//
//		//从PC端获取图片名称信息
//		File f = new File(ReportPath +File.separator+ caseName + "/screenshots");
//		if (f.exists()) {
//			File[] fs = f.listFiles();
//			for (int i = 0; i < fs.length; i++) {
//				if ((!fs[i].isDirectory())&&((fs[i].getName()).contains(".jpg"))) {
//					List.add(fs[i].getName());
//				
//				}
//				else{
//					System.out.println("is a directory,not be added into List");
//				}
//			}
//		} else {
//			System.out.println("pullScreenshotsToPC is failed!!");
//		}
//		
//		
//		
//		//获取检查点信息暂时存储，用于在报告中显示
//		Files file = new Files();
//		File checkTextInfo=new File(ReportPath +File.separator+ caseName + "/screenshots"+"/caseCheckInfo.txt");
//		if (checkTextInfo.exists()) {
//			try {
//				String photoInfoText = file.readfile(checkTextInfo);
//				String[] photoInfoList = photoInfoText.split("\n");
//				for (int i = 0; i < photoInfoList.length; i++) {
//					photoInfo.add(photoInfoList[i]);
//				}
//				
//				
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}else {
//			logger.debug("screenShot failed!!");
//		}
//		
//		
//		
//	}
//	
//	/**
//	 * 将手机上得图片信息pull到手机上
//	 * @param caseName
//	 * @param ReportPath
//	 * @throws Exception
//	 */
//	
//	public void pullScreenshotsToPC(String caseName, String ReportPath) throws Exception {
//
//		Files files = new Files();
//		
//		CMD cmd = new CMD();
//		
//
//		File f = new File(ReportPath +File.separator+ caseName + "/screenshots");
//		if (f.exists()) {
//		//	files.deletefile(ReportPath +File.separator+caseName + "/screenshots");
//			f.mkdirs();
//		} else {
//			// create file
//			f.mkdirs();
//		}
//		exec(androidSdkPath+"/platform-tools/adb pull " +screenshotsDir+ " "+ReportPath+File.separator
//				+ caseName + "/screenshots");
//		exec(androidSdkPath+"/platform-tools/adb shell rm -r "+screenshotsDir);
//
//	}
//	
//	/**
//	 * 清除SD卡上测试生成的临时文件
//	 */
//	public void clearSDcardTmpFile(){
//		exec(androidSdkPath+"/platform-tools/adb shell rm -r "+screenshotsDir);
//	}
//	
//	private void exec(String command) {
//		Process proc;
//		try {
//			proc = Runtime.getRuntime().exec(command);
//			 // any error message?
//	        StreamGobbler errorGobbler = new
//	            StreamGobbler(proc.getErrorStream(), "ERROR");            
//	        
//	        // any output?
//	        StreamGobbler outputGobbler = new
//	            StreamGobbler(proc.getInputStream(), "OUTPUT");
//	        // kick them off
//	        errorGobbler.start();
//	        outputGobbler.start();
//	        int exitVal;  
//	        exitVal = proc.waitFor();
//	        logger.debug("ExitValue: " + exitVal);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//         catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//       
//		
//	}
//	public static void main(String[] args) throws Exception {
//		DetailTable test=new DetailTable();
////		test.detailTableContent(caseName, jnuitLog, CaseInfoTemplate, ReportPath, ImageInfoTemplate, LogInfoTemplate)
//	//	test.pullScreenshotsToPC("TestCase.Test1", "D:/auto_release/0913/E2EAutomatedTestFramework_1.0b/E2EAutomatedTestFramework_1.0b/FitNesseRoot/files/logs/");
//		test.getImageNamesFromPC("TestButtonUi.Test1", "D:/auto_release/0913/E2EAutomatedTestFramework_1.0b/E2EAutomatedTestFramework_1.0b/FitNesseRoot/files/logs/");
//		test.detailTableContent("TestButtonUi.Test1","测试用例",
//				"D:/auto_release/0913/E2EAutomatedTestFramework_1.0b/E2EAutomatedTestFramework_1.0b/FitNesseRoot/files/logs/JunitLog.txt", 
//				"D:/auto_release/0913/E2EAutomatedTestFramework_1.0b/E2EAutomatedTestFramework_1.0b/template/CaseInfo.html.template", 
//				"D:/auto_release/0913/E2EAutomatedTestFramework_1.0b/E2EAutomatedTestFramework_1.0b/FitNesseRoot/files/logs/", 
//				"D:/auto_release/0913/E2EAutomatedTestFramework_1.0b/E2EAutomatedTestFramework_1.0b/template/ImageInfo.html.template", 
//				"D:/auto_release/0913/E2EAutomatedTestFramework_1.0b/E2EAutomatedTestFramework_1.0b/template/LogInfo.html.template");
//		
//	
//	}
//	
//
//
//}
//
//
//class StreamGobbler extends Thread
//{
//    InputStream is;
//    String type;
//    
//    StreamGobbler(InputStream is, String type)
//    {
//        this.is = is;
//        this.type = type;
//    }
//    
//    public void run()
//    {
//        try
//        {
//            InputStreamReader isr = new InputStreamReader(is);
//            BufferedReader br = new BufferedReader(isr);
//            String line=null;
//            while ( (line = br.readLine()) != null)
//                System.out.println(type + ">" + line);    
//            } catch (IOException ioe)
//              {
//                ioe.printStackTrace();  
//              }
//    }
//}
