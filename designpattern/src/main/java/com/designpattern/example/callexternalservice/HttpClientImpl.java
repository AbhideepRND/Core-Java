package com.designpattern.example.callexternalservice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpClientImpl {

	public static void main(String[] args) throws ClientProtocolException, IOException {
	/*	HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://www.baidu.com");
        String xml = "<xml>xxxx</xml>";
        HttpEntity entity = new ByteArrayEntity(xml.getBytes("UTF-8"));
        post.setEntity(entity);
        HttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity());*/
		
		BufferedReader br = new BufferedReader(new FileReader("d:/service.txt"));
		String sCurrentLine;
		StringBuffer stringbuffer = new StringBuffer(); 
		while ((sCurrentLine = br.readLine()) != null) {
			stringbuffer.append(sCurrentLine);
		}
		
		String xml = stringbuffer.toString();
		System.out.println(xml);
		HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://ws.cdyne.com/emailverify/Emailvernotestemail.asmx");
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/soap");
        //post.setHeader(HttpHeaders.ACCEPT_CHARSET, "utf-8");
        post.addHeader("Accept" , "text/xml");
        post.addHeader("SOAPAction","http://ws.cdyne.com/VerifyEmail");
        
        StringEntity stringentity=new StringEntity(xml,"UTF-8");
        stringentity.setChunked(true);
        post.setEntity(stringentity);

        HttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
	}
}
