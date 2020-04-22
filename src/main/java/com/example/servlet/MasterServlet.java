package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controller.RequestHelper;

public class MasterServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		RequestHelper.process(req, res);
		
		System.out.println("Hello");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		
		System.out.println("Hello1");
		
		String targetURL = RequestHelper.process(req, res);
		
		System.out.println("Hello2");
		System.out.println(targetURL);
		req.getRequestDispatcher(targetURL).forward(req, res);
		//chose to respond with a forward for every POST request
	}

}
