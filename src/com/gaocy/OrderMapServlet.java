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
import com.impl.OrderHandler;

public class OrderMapServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3958924567119354104L;

	// admin/123456
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String pru_type = req.getParameter("pru_type");
		String price = req.getParameter("price");
		String number = req.getParameter("number");
		
		String orderId=pru_type + UUID.randomUUID().toString();

		Map<String,String> map = new HashMap<String,String>(); 
		map.put("pru_type", pru_type);
		map.put("price", price);
		map.put("number", number);
		map.put("orderId", orderId);
		
		
		//....接下来是客户的业务逻辑....	
		
		//{pru_type:1,price:10000,number:99,orderId:1a288947d-e01d-4b6d-9c61-b66a5cabcd31}
		OrderHandler.handleOrder(map);
		
		
		String responseStr = "{\"code\":\"20200\",\"msg\":\"success\"}";
		IOUtils.write(responseStr, response.getOutputStream(), "utf-8");
		
	}
}
