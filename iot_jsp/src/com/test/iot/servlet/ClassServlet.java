package com.test.iot.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.iot.service.ClassService;
import com.test.iot.service.impl.ClassServiceImpl;

public class ClassServlet extends HttpServlet{
	
	ClassService cs = new ClassServiceImpl();
	public String getCommand(String uri) {
		
		int idx = uri.lastIndexOf("/");
		if(idx!=-1) {
			return uri.substring(idx+1);
		}
		return "";
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	
	public void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String uri = req.getRequestURI();
		String url = req.getRequestURL().toString();
		String cmd = getCommand(uri);
		if(cmd.equals("list")) {
			req.setAttribute("list", cs.getClassList());
		}
		
		
		uri = "/WEB-INF/view"+uri+".jsp";
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, resp);
		
		
	}
	
}
