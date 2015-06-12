package com.caishi.capricorn.common.login.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

public class RequestUtil {
	private RequestUtil(){
		
	}
	
	private static class RequestUtilHodler{
		public final static RequestUtil instance = new RequestUtil();
	}
	
	public static RequestUtil getInstance(){
		return RequestUtilHodler.instance;
	}
	
	/**
	 * POST��ʽ�������
	 * @param sendUrl ���������ַ
	 * @param sendParam ����
	 * @param backEncodType ������Ϣ����
	 * @return ���󷵻���Ϣ
	 * @throws IOException 
	 */
	public String doHttpPostRequest(String sendUrl, String sendParam,String backEncodType){
		StringBuffer resultStringBuffer = new StringBuffer();
		BufferedWriter bufferedWriter = null;
		try{
			if (backEncodType == null || backEncodType.equals("")) {
				backEncodType = "UTF-8";
			}
			URL url = new URL(sendUrl);
			HttpURLConnection URLConn = (HttpURLConnection)url.openConnection();
			URLConn.setDoOutput(true);
			URLConn.setDoInput(true);
			((HttpURLConnection) URLConn).setRequestMethod("POST");
			URLConn.setUseCaches(false);
			URLConn.setAllowUserInteraction(true);
			HttpURLConnection.setFollowRedirects(true);
			URLConn.setInstanceFollowRedirects(true);
			URLConn.setRequestProperty("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
			URLConn.setRequestProperty("Content-Length", String.valueOf(sendParam.getBytes().length));
			DataOutputStream dos = new DataOutputStream(URLConn.getOutputStream());
			dos.writeBytes(sendParam);
			BufferedReader rd = new BufferedReader(new InputStreamReader(URLConn.getInputStream(), backEncodType));
			String line;
			while ((line = rd.readLine()) != null) {
				resultStringBuffer.append(line).append("\r\n");
			}
			rd.close();
		}catch(Exception ex){
			resultStringBuffer.append("���ʷ�������з����쳣��").append(ex.getMessage());
			try {
				throw ex;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}finally{
			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				bufferedWriter = null;
			}
		}
		return resultStringBuffer.toString();
	}
	
	/**
	 * GET��ʽ�������
	 * @param sendUrl ���������ַ
	 * @param backEncodType ������Ϣ����
	 * @return ���󷵻���Ϣ
	 */
	public String doHttpGetRequest(String sendUrl, String backEncodType){
		StringBuffer resultStringBuffer = new StringBuffer();
		BufferedReader in = null;
		try {
			if (backEncodType == null || backEncodType.equals("")) {
				backEncodType = "UTF-8";
			}
			URL url = new URL(sendUrl);
			HttpURLConnection URLConn = (HttpURLConnection)url.openConnection();
			URLConn.setDoInput(true);
			URLConn.setDoOutput(true);
			URLConn.connect();
			URLConn.getOutputStream().flush();
			in = new BufferedReader(new InputStreamReader(URLConn.getInputStream(), backEncodType));
			String line;
			while ((line = in.readLine()) != null) {
				resultStringBuffer.append(line).append("\r\n");
			}
		} catch (IOException ex) {
			resultStringBuffer.append("���ʷ�������з����쳣��").append(ex.getMessage());
			try {
				throw ex;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (java.io.IOException ex) {
					ex.printStackTrace();
				}
				in = null;
			}
		}
		return resultStringBuffer.toString();
	}
	
	/**
	 * Https Get ����
	 * @param requestUrl ���ʵ�ַ��ȫ·����
	 * @param charsetName �ַ�����,Ĭ��ΪUTF-8
	 * @return ��Ӧ��Ϣ
	 * @throws Exception
	 */
	public String doHttpsGetRequest(String requestUrl,String charsetName) throws Exception{
		charsetName = charsetName!=null?charsetName:"UTF-8";
		URL url = new URL(requestUrl);
		HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charsetName);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		StringBuilder message = new StringBuilder();
		String inputStr;
		while((inputStr=bufferedReader.readLine())!=null){
			message.append(inputStr);
		}
		return message.toString();
	}
	
	/**
	 * ��ȡHttps����ƾ֤��Ϣ
	 * @param requestUrl ���ʵ�ַ��ȫ·����
	 * @return ƾ֤��Ϣ
	 * @throws IOException
	 */
	public Certificate[] getHttpsCertificate(String requestUrl) throws IOException{
		URL url = new URL(requestUrl);
		HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
		return getHttpsCertificate(connection);
	}
	
	/**
	 * ��ȡHttps����ƾ֤��Ϣ
	 * @param connection �������Ӷ���
	 * @return ƾ֤��Ϣ
	 * @throws SSLPeerUnverifiedException
	 */
	public Certificate[] getHttpsCertificate(HttpsURLConnection connection) throws SSLPeerUnverifiedException{
		return connection.getServerCertificates();
	}
}
