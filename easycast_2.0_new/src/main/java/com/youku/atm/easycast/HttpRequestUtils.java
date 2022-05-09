package com.youku.atm.easycast;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * http���ʷ���ʵ��
 * 
 * @author Gary Lee
 * @date: 2019-06-04
 */
public class HttpRequestUtils {
	private static Logger logger = LoggerFactory.getLogger(HttpRequestUtils.class); // ��־��¼
	
	/**
	 * GET�ύ
	 * 
	 * @return
	 */
	public static String doGet(String url) {
		String strResult = "";
		// 1. ����һ��Ĭ�ϵ�clientʵ��
		CloseableHttpClient client = HttpClients.createDefault();
		try {
			// 2. ����һ��httpget����
			HttpGet httpGet = new HttpGet(url);
			System.out.println("executing GET request " + httpGet.getURI());

			// 3. ִ��GET���󲢻�ȡ��Ӧ����
			CloseableHttpResponse resp = client.execute(httpGet);
			try {
				// 6. ��ӡ��Ӧ���Ⱥ���Ӧ����
				if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					// 4. ��ȡ��Ӧ��
					HttpEntity entity = resp.getEntity();
					System.out.println("Response content length = " + entity.getContentLength());
					System.out.println("------");
					strResult = EntityUtils.toString(resp.getEntity());
				}
			} finally {
				// ��������ɹ����Ҫ�ر�resp
				resp.close();
			}
		} catch (ClientProtocolException e) {
			logger.error("get����ʧ��:", e);
			// e.printStackTrace();
		} catch (ParseException e) {
			logger.error("get�����������:", e);
			// e.printStackTrace();
		} catch (IOException e) {
			logger.error("get����IO����:", e);
			// e.printStackTrace();
		} finally {
			// 8. ����Ҫ�ر����ӣ��ͷ���Դ
			try {
				client.close();
			} catch (Exception e) {
				logger.error("get������Ϲر����ӳ���:", e);
				// e.printStackTrace();
			}
		}
		return strResult;
	}

	/**
	 * ��ͨPOST�ύ
	 * 
	 * @param url
	 * @param map
	 * @return
	 */
	public static String doPost(String url, Map<String, Object> map) {
		String strResult = "";
		// 1. ��ȡĬ�ϵ�clientʵ��
		CloseableHttpClient client = HttpClients.createDefault();
		// 2. ����httppostʵ��
		HttpPost httpPost = new HttpPost(url);
		// 3. �����������У���ֵ���б�
		List<NameValuePair> paramPairs = new ArrayList<NameValuePair>();
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			Object val = map.get(key);
			paramPairs.add(new BasicNameValuePair(key, val.toString()));
		}
		UrlEncodedFormEntity entity;
		try {
			// 4. ���������õ�entity������
			entity = new UrlEncodedFormEntity(paramPairs, "UTF-8");
			// 5. ��entity�������õ�httppost������
			httpPost.setEntity(entity);
			// 6. �������󲢻�ȥ��Ӧ
			CloseableHttpResponse resp = client.execute(httpPost);
			try {
				// 7. ��ȡ��Ӧentity
				HttpEntity respEntity = resp.getEntity();
				strResult = EntityUtils.toString(respEntity, "UTF-8");
			} finally {
				// 9. �ر���Ӧ����
				resp.close();
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 10. �ر����ӣ��ͷ���Դ
			try {
				client.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return strResult;
	}

	/**
	 * json������ʽPOST�ύ
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doPost(String url, JSONObject params) {
		String strResult = "";
		// 1. ��ȡĬ�ϵ�clientʵ��
		CloseableHttpClient client = HttpClients.createDefault();
		// 2. ����httppostʵ��
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("Content-Type", "application/json;charset=utf-8"); // �������ͷ
		httpPost.setHeader("Cookies","GEEKPLUSSESSIONID=98353367-bb29-48f0-bcc2-50cfaf237259");
		try {
			httpPost.setEntity(new StringEntity(params.toJSONString(), "utf-8"));
			CloseableHttpResponse resp = client.execute(httpPost);
			try {
				// 7. ��ȡ��Ӧentity
				HttpEntity respEntity = resp.getEntity();
				strResult = EntityUtils.toString(respEntity, "UTF-8");
				System.out.println("resp is : " + resp);
			} finally {
				resp.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				client.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return strResult;
	}
	
	/**
	 * json������ʽPOST�ύ
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doPost1(String url, JSONObject params, String cookies) {
		String strResult = "";
		// 1. ��ȡĬ�ϵ�clientʵ��
		CloseableHttpClient client = HttpClients.createDefault();
		// 2. ����httppostʵ��
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("Content-Type", "application/json;charset=utf-8"); // �������ͷ
		httpPost.addHeader("Cookie","GEEKPLUSSESSIONID=" + cookies);
		try {
			httpPost.setEntity(new StringEntity(params.toJSONString(), "utf-8"));
			CloseableHttpResponse resp = client.execute(httpPost);
			try {
				
				if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					// 4. ��ȡ��Ӧ��
					HttpEntity entity = resp.getEntity();
					System.out.println("Response content length = " + entity.getContentLength());
					System.out.println("resp.getStatusLine().getStatusCode() is :" + resp.getStatusLine().getStatusCode());
					// 7. ��ȡ��Ӧentity
					HttpEntity respEntity = resp.getEntity();
					strResult = EntityUtils.toString(respEntity, "UTF-8");
				}			

			} finally {
				resp.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				client.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return strResult;
	}
	
	public static void main(String[] args) {
		
		JSONObject params = new JSONObject();
		params.put("binCode", "A000001" + "F1A");
		params.put("chooseStrategy", 1);
		params.put("configType", 0);
		params.put("count", 0);
		params.put("extraParam", "testArkRpc");
		params.put("shelfSide", "F");
		params.put("shelfType", 0);
		
		
		params.put("shelfCode", "A000002");
		params.put("workflowCode", "Test_presstest2");
		
		
		params.put("workflowWorkId", 0);

		String res = HttpRequestUtils.doPost("http://172.16.3.48:8089/ark-web/api/test/workflowStart", params);
		System.out.println("result is :" + res);				
		
	}
	
}
