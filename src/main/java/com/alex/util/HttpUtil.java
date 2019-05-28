package com.alex.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alex.util.common.CommonUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * HTTP请求处理工具类
 * 
 * @author heshaojian
 *
*/
@Slf4j
public class HttpUtil {

	/** 
	 * 获取用户真实IP地址
	 * 
	 * @param request 
	 * @return 
	 */
	public final static String getIpAddress(HttpServletRequest request) { 
		String ip = request.getHeader("x-forwarded-for"); 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			ip = request.getHeader("Proxy-Client-IP"); 
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			ip = request.getHeader("WL-Proxy-Client-IP"); 
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			ip = request.getHeader("HTTP_CLIENT_IP"); 
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			ip = request.getRemoteAddr(); 
		} 
		return ip; 
	}

	/** 
	 * 获取请求地址
	 * 
	 * @param request 
	 * @return 
	 */
	public final static String getRequestUrl(HttpServletRequest request) {
		StringBuffer sb = new StringBuffer();
		 
		sb.append("http://");
		sb.append(request.getServerName());//服务器地址  
		sb.append(":");
		sb.append(request.getServerPort());//端口号  
		sb.append(request.getContextPath());//项目名称  
		sb.append(request.getRequestURI());//请求地址; 
		
		return sb.toString();
	}
	
	/**
	 * 获得请求内容
	 * 
	 * @param servletRequest
	 * @return
	 * @throws Exception
	 */
	public final static String getRequestContent(HttpServletRequest servletRequest) throws Exception{
		StringBuffer data = new StringBuffer() ;
		InputStream is = servletRequest.getInputStream(); 
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String lineContent = null; 
		while((lineContent=br.readLine())!=null){
			data.append(lineContent) ; 
		}
		return data.toString();
	}
	
	/**
	 * 判断是否是JSON格式的数据
	 * 
	 * @param servletRequest
	 * @return
	 * @throws Exception
	 */
	public final static boolean isJsonContent(HttpServletRequest servletRequest) throws Exception{
		String contentType = servletRequest.getHeader("Content-Type");
		if(CommonUtil.isEmpty(contentType)){
			contentType = servletRequest.getContentType();
		}		  
		log.info("判断是否是JSON格式的数据："+contentType);
		return isJsonContentType(contentType);
	} 
	
	/**
	 * 判断是否是XML格式的数据
	 * 
	 * @param servletRequest
	 * @return
	 * @throws Exception
	 */
	public final static boolean isXmlContent(HttpServletRequest servletRequest) throws Exception{
		String contentType = servletRequest.getHeader("Content-Type");
		if(CommonUtil.isEmpty(contentType)){
			contentType = servletRequest.getContentType();
		}
		log.info("判断是否是XML格式的数据："+contentType);
		return isXmlContentType(contentType);
	}
	
	public final static boolean isJsonContentType(String contentType){
		if(CommonUtil.isNotEmpty(contentType) && contentType.indexOf("application/json")!=-1){
			return true;
		}
		return false;
	}


	public final static boolean isXmlContentType(String contentType){
		if(contentType.indexOf("application/xml")!=-1||contentType.indexOf("text/xml")!=-1){
			return true;
		}
		return false;
	}

	public static String sendGet(String reqURL)  {
		String result="";
		CloseableHttpClient client = HttpClients.createDefault();
		try {
			//发送get请求
			HttpGet request = new HttpGet(reqURL);
			HttpResponse response = client.execute(request);
			/**请求发送成功，并得到响应**/
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				/**读取服务器返回过来的json字符串数据**/
				result = EntityUtils.toString(response.getEntity());
			}else{
				throw new HttpResponseException(response.getStatusLine().getStatusCode(), "http请求失败");
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url 请求URL
	 * @param params 请求参数
	 * @param contentType 请求类型
	 * @param charSet 字符集
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws HttpException 
	 * 
	 * @author huangyubing
	 * @date 2018-05-17 10:47
	 *
	*/
	public static String sendPost(String url, String params, String contentType, String charSet) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpPost httpPost = new HttpPost(url);// 创建httpPost	 
		httpPost.setHeader("Accept", contentType);   
		httpPost.setHeader("Content-Type", contentType);  
		
		StringEntity entity = new StringEntity(params, charSet);  
		httpPost.setEntity(entity);
		
		CloseableHttpResponse response = null;  
		String returnStr = null;
		try {  
			response = httpClient.execute(httpPost);  
			StatusLine status = response.getStatusLine();  
			int state = status.getStatusCode();  
			
			HttpEntity responseEntity = response.getEntity();  
			returnStr = EntityUtils.toString(responseEntity,charSet);  
			if (state != HttpStatus.SC_OK) {  
				throw new HttpResponseException(state, "http请求失败:"+returnStr+":status code is:"+state);
			}
		} finally {  
			if (response != null) {  
				try {  
					response.close();  
				} catch (IOException e) {  
					e.printStackTrace();  
				}  
			}  
			try {  
				httpClient.close();  
			} catch (IOException e) {  
				e.printStackTrace();  
			}  
		}  
		return returnStr;  
	}
	
	/**
	 * 以UTF-8字符集向指定 URL 发送POST方法的请求
	 * 
	 * @param url 请求URL
	 * @param params 请求参数
	 * @param contentType 请求类型
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws HttpException 
	 * 
	 * @author huangyubing
	 * @date 2018-05-17 10:47
	 *
	*/
	public static String sendPost(String url, String params, String contentType) throws Exception{
		return sendPost(url, params, contentType, "UTF-8");
	}
	
	
	public static String sendPostForm(String url, HashMap<String, String> params, String charSet) throws Exception{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpPost httpPost = new HttpPost(url);// 创建httpPost	 
		httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");  
		
		List<NameValuePair>list = new ArrayList<NameValuePair>();  
		for (Map.Entry<String, String> entry : params.entrySet()) {  
		    list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));  
		}  
		httpPost.setEntity(new UrlEncodedFormEntity(list,charSet));
		
		CloseableHttpResponse response = null;  
		String returnStr = null;
		try {  
			response = httpClient.execute(httpPost);  
			StatusLine status = response.getStatusLine();  
			int state = status.getStatusCode();  

			HttpEntity responseEntity = response.getEntity();  
			returnStr = EntityUtils.toString(responseEntity,charSet);  
			
			if (state != HttpStatus.SC_OK) {  
				throw new HttpResponseException(state, "http请求失败:"+returnStr);
			}
		} finally {  
			if (response != null) {  
				try {  
					response.close();  
				} catch (IOException e) {  
					e.printStackTrace();  
				}  
			}  
			try {  
				httpClient.close();  
			} catch (IOException e) {  
				e.printStackTrace();  
			}  
		}  
		return returnStr; 
	}


	public static HttpSendResult sendPostFormWithCode(String url, HashMap<String, String> params, String charSet) throws Exception{
		HttpSendResult httpSendResult = new HttpSendResult();

		CloseableHttpClient httpClient = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost(url);// 创建httpPost
		httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");

		List<NameValuePair>list = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		httpPost.setEntity(new UrlEncodedFormEntity(list,charSet));

		CloseableHttpResponse response = null;
		String returnStr = null;
		try {
			response = httpClient.execute(httpPost);
			StatusLine status = response.getStatusLine();
			int state = status.getStatusCode();
			HttpEntity responseEntity = response.getEntity();
			returnStr = EntityUtils.toString(responseEntity,charSet);
			httpSendResult.setHttpCode(state);
			httpSendResult.setHttpReturnStr(returnStr);
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return httpSendResult;
	}
	
	public static String sendPostForm(String url, HashMap<String, String> params) throws Exception{
		return sendPostForm(url, params, "UTF-8");
	}
	
	public static String sendPostMultiForm(String url, HashMap<String, String> params, HashMap<String, File> fileList) throws Exception{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpPost httpPost = new HttpPost(url);// 创建httpPost	
		
		ContentType strContent=ContentType.create("text/plain",Charset.forName("UTF-8"));
		
		MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
		if(params!=null && params.size()>0) {
			for (Map.Entry<String, String> entry : params.entrySet()) {
				entityBuilder.addTextBody(entry.getKey(), entry.getValue(), strContent);
			}
		}else{
			log.warn("params is empty");
		}
		if(fileList!=null && fileList.size()>0) {
			for (Map.Entry<String, File> entry : fileList.entrySet()) {
				log.info(String.format("file key is %s,file length is %s", entry.getKey(), entry.getValue().length()));
				entityBuilder.addBinaryBody(entry.getKey(), entry.getValue());
			}
		}else{
			log.warn("fileList is empty");
		}
		
		httpPost.setEntity(entityBuilder.build());
		
		CloseableHttpResponse response = null;  
		String returnStr = null;
		try {  
			response = httpClient.execute(httpPost);  
			StatusLine status = response.getStatusLine();  
			int state = status.getStatusCode();  

			HttpEntity responseEntity = response.getEntity();  
			returnStr = EntityUtils.toString(responseEntity,"UTF-8");  
			
			if (state != HttpStatus.SC_OK) {  
				throw new HttpResponseException(state, "http请求失败");
			}
		} finally {  
			if (response != null) {  
				try {  
					response.close();  
				} catch (IOException e) {  
					e.printStackTrace();  
				}  
			}  
			try {  
				httpClient.close();  
			} catch (IOException e) {  
				e.printStackTrace();  
			}  
		}  
		return returnStr; 
	}
	
	public static InputStream getInputStream(String url) throws Exception{
		
		HttpClient httpClient = new HttpClient();  
        GetMethod getMethod = new GetMethod(url);  
		httpClient.executeMethod(getMethod);  
        InputStream ins =getMethod.getResponseBodyAsStream();
        
        return ins;
	}
	
	/**
	 * 获取链接的后缀名
	 * 
	 * @param url
	 * @return
	 * 
	 * @author huangyubing
	 * @date 2018-07-02 09:48
	 *
	 */
	public static String getUrlSuffix(String url) {
    	
    	if(CommonUtil.isEmpty(url)){
    		return null;
    	}
    	Pattern pattern = Pattern.compile("\\S*[?]\\S*");
        Matcher matcher = pattern.matcher(url);
 
        String[] spUrl = url.toString().split("/");
        int len = spUrl.length;
        String endUrl = spUrl[len - 1];
 
        if(matcher.find()) {
            String[] spEndUrl = endUrl.split("\\?");
            if(spEndUrl[0].split("\\.").length>1){
            	return spEndUrl[0].split("\\.")[1];
            }else{
            	return null;
            }
        }
        if(endUrl.split("\\.").length>1){
        	return endUrl.split("\\.")[1];
        }else{
        	return null;
        }
    }
}
