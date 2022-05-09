package com.youku.atm.easycast;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import java.io.IOException;
 
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
 
/*
  @author: Liu Yuanyuan
  purpose: test connecting remote computer and execute linux command
*/
 
public class TestRemoteConnect {
 
    public static void main(String[] args) {
 
        String hostname = "172.16.3.48";
        int port = 400011;
        String username = "root";
        String password = "root";
        //指明连接主机的IP地址  
        Connection conn = new Connection(hostname, port);
        Session ssh = null;
        try {
            //连接到主机  
            conn.connect();
            //使用用户名和密码校验  
            boolean isconn = conn.authenticateWithPassword(username, password);
            if (!isconn) 
            {
                System.out.println("用户名称或者是密码不正确");
            } 
            else 
            {
                System.out.println("已经连接OK");
                ssh = conn.openSession(); 
                String JAVA_HOME="export JAVA_HOME=/usr/local/geekplus/java/jdk1.8.0_111";
                //ssh.execCommand(JAVA_HOME+ ";" + "/usr/local/geekplus/script_tools/tomcat_manager.py restart tomcat-ark");
                ssh.execCommand(JAVA_HOME+ ";" + "sudo java -jar /opt/resin-4.0.36/lib/resin.jar restart");
                //ssh.execCommand("cd /root; ./resin_restart");  
                //只允许使用一行命令，即ssh对象只能使用一次execCommand这个方法，
                //多次使用则会出现异常       
                //使用多个命令用分号隔开  
                //ssh.execCommand("cd /root; sh hello.sh"); 
                 
                //将Terminal屏幕上的文字全部打印出来                  
                InputStream is = new StreamGobbler(ssh.getStdout());
                BufferedReader brs = new BufferedReader(new InputStreamReader(is));
                while (true) 
                {
                    String line = brs.readLine();
                    if (line == null) 
                    {
                        break;
                    }
                    System.out.println(line);
                }
            }            
 
        } catch (IOException e) 
        {
            e.printStackTrace();
        } finally 
        {
            //连接的Session和Connection对象都需要关闭  
            ssh.close();
            conn.close();
        }
 
    }
 
}
