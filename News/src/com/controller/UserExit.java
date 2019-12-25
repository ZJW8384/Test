package com.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/userExit")
public class UserExit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        session.removeAttribute("flag");
        session.removeAttribute("uid");
        session.removeAttribute("msg");
//        System.out.println("ok");
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
