package com.gaocy;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;

public class OrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3958924567119354104L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String pru_type = req.getParameter("pru_type");
		String price = req.getParameter("price");
		String number = req.getParameter("number");
		
		String orderId=generateOrderId(pru_type);

		
		//....接下来是客户的业务逻辑....	
		
		String responseStr = "{\"code\":\"20200\",\"msg\":\"success\"}";
		IOUtils.write(responseStr, response.getOutputStream(), "utf-8");
		
	}

	private String generateOrderId(String pru_type) {
		String orderId = pru_type + UUID.randomUUID().toString();
		return orderId;
	}

}
