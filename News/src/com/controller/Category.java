package com.controller;

import com.google.gson.Gson;
import com.mode.NewsInfo;
import com.service.OneType;
import com.utils.NewsSearch;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/category")
public class Category extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type=req.getParameter("type");
        List<NewsInfo> types;
        System.out.println(type);
        OneType on=new OneType();
        try {
        if(type.equals("science")){
                types=on.clan("科技");
                req.setAttribute("type",types);
                req.getRequestDispatcher("/jsp/science.jsp").forward(req,resp);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String title=req.getParameter("title");
        System.out.println(title);
        String writer=req.getParameter("writer");
        String subject=req.getParameter("subject");
        NewsSearch nsh=new NewsSearch();
        Gson gson=new Gson();
        PrintWriter out=resp.getWriter();
        try {
            List<NewsInfo> list=nsh.search(title,writer,subject);
            String str=gson.toJson(list);
            out.print(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
