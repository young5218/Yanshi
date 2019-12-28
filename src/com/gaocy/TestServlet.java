package com.gaocy;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class TestServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 374149504530167899L;
	
	public static final String TARGET_URL="http://localhost:8081/TestWeb/alertmsg";
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		URL url = new URL(TARGET_URL);
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setDoOutput(true);// 允许写出
		urlConnection.setDoInput(true);// 允许读入
		urlConnection.setUseCaches(false);// 不使用缓存
		urlConnection.setRequestMethod("POST");
		// 设置请求需要返回的数据类型和字符集类型
		urlConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
		urlConnection.setRequestProperty("Connection", "close");
		// 设置超时
		urlConnection.setConnectTimeout(5000);
		urlConnection.setReadTimeout(5000);
		
		urlConnection.getOutputStream().flush();
		urlConnection.getOutputStream().close();
		// 获取返回结果
		InputStream inputStream = urlConnection.getInputStream();
		String bodyInfo = IOUtils.toString(inputStream, "utf-8");
		// 关闭资源
		inputStream.close();
		urlConnection.disconnect();
		
		IOUtils.write(bodyInfo, resp.getOutputStream(), "utf-8");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

}
