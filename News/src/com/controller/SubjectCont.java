package com.controller;

import com.google.gson.Gson;
import com.mode.Subject;
import com.service.SubjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/subjectCont")
public class SubjectCont extends HttpServlet {
    SubjectService subct=new SubjectService();
    Gson gson=new Gson();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        HttpSession session=req.getSession();
        PrintWriter out=resp.getWriter();
        String sub=req.getParameter("sub");
        try {
            subct.subAdd(sub);
            List<Subject> subs=subct.subSearch();
            String subject=gson.toJson(subs);
            out.print(subject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session=req.getSession();
        String [] subjects=req.getParameterValues("sub");
        PrintWriter out=resp.getWriter();
        try {
        for(int i=0;i<subjects.length;i++){
                subct.subUP(subjects[i],i+1);
            }
            List<Subject> subject=subct.subSearch();
            session.setAttribute("subject",subject);
//            String sut=gson.toJson(subject);
//            out.print(sut);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/jsp/newsMager.jsp");
    }
}
