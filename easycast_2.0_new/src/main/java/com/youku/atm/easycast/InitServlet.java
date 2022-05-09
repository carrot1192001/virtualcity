package com.youku.atm.easycast;

import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.torque.Torque;
import org.apache.torque.TorqueException;

public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 7051292048095757360L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String root = getServletContext().getRealPath("/");
        
        // 初始化Torque
        try {
            Torque.init(root + "WEB-INF/classes/conf/Torque.properties");
        } catch (Exception e) {
        }
        
		// 启动log4j
		try {
			DOMConfigurator.configure(root + "WEB-INF/classes/conf/log4j.xml");
		} catch (Exception e) {
		}
        
		System.out.println("*****************************************************");
        System.out.println("******Atm test started & "+(new Date()).toString()+"******");
        System.out.println("*****************************************************");
    }
	
    @Override
	public void destroy() {
        super.destroy();        
        try {
			Torque.shutdown();
		} catch (TorqueException e) {
			e.printStackTrace();
		}
    }

}
