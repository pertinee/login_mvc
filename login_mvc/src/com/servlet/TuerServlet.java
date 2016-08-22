package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.factory.DaoFactory;
import com.entity.Tuser;

public class TuerServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		String path = "login.jsp";
		String code = request.getParameter("code");
		String rand = (String)request.getSession().getAttribute("rand");
		if (!rand.equals(code)) {
			request.setAttribute("err", "输入验证码不正确！");
		}else{
			Tuser user = new Tuser();
			user.setUserid(request.getParameter("userid"));
			user.setPassword(request.getParameter("password"));
			try {
				if (DaoFactory.getTuserDaoInstance().findLogin(user)) {
					request.getSession().setAttribute("name", user.getName());
					path = "success.jsp";
				}else{
					request.setAttribute("err", "错误的用户名或密码！");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher(path).forward(request, response);	
	}
}
