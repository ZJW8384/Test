package com.controller;

import com.service.LoginService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/index")
public class UserLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String uid=req.getParameter("uid");
        String pwd=req.getParameter("pwd");
        String id=null;
        LoginService login=new LoginService();
        HttpSession session=req.getSession();
        PrintWriter out=resp.getWriter();
        try {
            List<String> lg=login.isLogin(uid,pwd);
            String flag=lg.get(0);
            id=lg.get(1);
            out.print(id);
            session.setAttribute("flag",flag);
            session.setAttribute("uid",uid);
//            resp.sendRedirect("index.jsp");
        } catch (Exception e) {
            out.print(id);
            req.setAttribute("msg","用户名或密码错误！");
            req.getRequestDispatcher("/jsp/login.jsp").forward(req,resp);
           e.printStackTrace();
        }
    }
}
