package com.gaocy;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3958924567119354104L;

	// admin/123456
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String responseStr;
		if("admin".equals(username)) {
			if("123456".equals(password)) {
				responseStr = "{\"code\":\"10200\",\"msg\":\"login success\"}";
			}else {
				responseStr = "{\"code\":\"10300\",\"msg\":\"password error\"}";
			}
		}else {
			responseStr = "{\"code\":\"10400\",\"msg\":\"user not exist\"}";
		}
		
		IOUtils.write(responseStr, response.getOutputStream(), "utf-8");
	}

}
