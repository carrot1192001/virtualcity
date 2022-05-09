package com.youku.atm.easycast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @author fangweng
 * @email fangweng@taobao.com
 * @date 2011-5-9
 *
 */
public class MockedHttpServletRequest implements HttpServletRequest {
	String contentType;
	String characterEncoding;
	String method;
	Map<String,String> params = new HashMap<String,String>();
	Map<String,Object> attr = new HashMap<String,Object>();


	public void setMethod(String method) {
		this.method = method;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getAuthType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getContextPath() {
		// TODO Auto-generated method stub
		return null;
	}

	public Cookie[] getCookies() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getDateHeader(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getHeader(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Enumeration getHeaderNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public Enumeration getHeaders(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getIntHeader(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getMethod() {
		// TODO Auto-generated method stub
		return method;
	}

	public String getPathInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPathTranslated() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getQueryString() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRemoteUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRequestURI() {
		// TODO Auto-generated method stub
		return null;
	}

	public StringBuffer getRequestURL() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRequestedSessionId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletPath() {
		// TODO Auto-generated method stub
		return null;
	}

	public HttpSession getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	public HttpSession getSession(boolean create) {
		// TODO Auto-generated method stub
		return null;
	}

	public Principal getUserPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isRequestedSessionIdFromCookie() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isRequestedSessionIdFromURL() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isRequestedSessionIdFromUrl() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isRequestedSessionIdValid() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isUserInRole(String role) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getAttribute(String name) {
		// TODO Auto-generated method stub
		return attr.get(name);
	}

	public Enumeration getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCharacterEncoding() {
		return characterEncoding;
	}

	public int getContentLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getContentType() {
		
		return this.contentType;
	}

	public ServletInputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLocalAddr() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLocalName() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getLocalPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	public Enumeration getLocales() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getParameter(String name) {
		// TODO Auto-generated method stub
		return params.get(name);
	}
	
	public void setParameter(String name,String value)
	{
		params.put(name, value);
	}

	public Map getParameterMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public Enumeration getParameterNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getParameterValues(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getProtocol() {
		// TODO Auto-generated method stub
		return null;
	}

	public BufferedReader getReader() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRealPath(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRemoteAddr() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRemoteHost() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getRemotePort() {
		// TODO Auto-generated method stub
		return 0;
	}

	public RequestDispatcher getRequestDispatcher(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getScheme() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServerName() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getServerPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isSecure() {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeAttribute(String name) {
		attr.remove(name);
		
	}

	public void setAttribute(String name, Object o) {
		attr.put(name, o);
		
	}

	public void setCharacterEncoding(String env)
			throws UnsupportedEncodingException {
		this.characterEncoding = env;
		
	}

}
