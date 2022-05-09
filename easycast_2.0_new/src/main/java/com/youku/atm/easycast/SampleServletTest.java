package com.youku.atm.easycast;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SampleServletTest {
	
	private MockCheckUser mcu = new MockCheckUser();
	
    private LoginServlet servlet = new LoginServlet(mcu);  
    
    private MockedHttpServletRequest mockRequest = new MockedHttpServletRequest();  
  
    private MockedHttpServletResponse mockRespones = new MockedHttpServletResponse(new StringWriter());
    
    public void testServletTest() throws ServletException, IOException{
    	
    	mockRequest.setParameter("username", "Gary");
    	
    	mockRequest.setParameter("password", "88481013");
    	
    	mockRespones.setContentType("text/html");
    	
    	mockRespones.setCharacterEncoding("GB18030");
    	
    	servlet.doPost(mockRequest, mockRespones);
    	
    	System.out.println(mockRequest.getParameter("username"));
    	
    	System.out.println(mockRespones.getStringWriter());
    }
    
    public static void main(String[] args) throws ServletException, IOException {
		
    	SampleServletTest test = new SampleServletTest();
    	test.testServletTest();
	}

}
