/*package com.youku.atm.cacher.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class SSH {
	public static void main(String[] args) throws Exception {
        
		SSH ssh = new SSH("10.10.72.13", 22022, "root", "adtest13");
		//ssh.execCommand("cd /;ls -l> out.txt");
		//ssh.execCommand("cd /opt/ligang;mysql;source atm-schema_2014_06_12.sql");
		//ssh.execCommand("mkdir ligangnew_new");
		ssh.execCommand("service resin restart");
		ssh.closeconn();
	}

	private Connection conn;
	
	@SuppressWarnings("static-access")
	public SSH(String serverip,int port,String username,String pwd) throws Exception {
		conn = new Connection(serverip, port);
		conn.getAvailableServerHostKeyAlgorithms();	
		conn.connect();

		boolean isAuthenticated = conn.authenticateWithPassword(username, pwd);
		
		if (isAuthenticated == false) {
			throw new Exception("Authentication failed.");
		}
	}

	
	public void execCommand(String cmd) throws Exception {
		
		Session session=conn.openSession();
		
		session.execCommand(cmd);
		
		System.out.println("====>>> execCommand :"+cmd);

		
		InputStream stdout = new StreamGobbler(session.getStdout());
		BufferedReader br = new BufferedReader(new InputStreamReader(stdout));

		while (true) {
			String line = br.readLine();
			if (line == null)
				break;
			System.out.println(line);
		}
		
		InputStream stderr = new StreamGobbler(session.getStderr());

		BufferedReader br1 = new BufferedReader(new InputStreamReader(stderr));

		while (true) {
			String line = br1.readLine();
			if (line == null)
				break;
			System.out.println(line);
		}
		
		session.close();
	}
	
	public void SCP_get(String remoteFile,String localDirectory) throws Exception {
        SCPClient scpc=new SCPClient(conn);
        scpc.get(remoteFile, localDirectory);
	}
	
	public void SCP_put(String localFile, String remoteTargetDirectory) throws Exception{
        SCPClient scpc=new SCPClient(conn);
        scpc.put(localFile, remoteTargetDirectory);
	}
	
	public void closeconn() {
		conn.close();
	}
}
*/