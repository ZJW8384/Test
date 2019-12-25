package com.controller;

import com.google.gson.Gson;
import com.mode.Note;
import com.service.NoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/noteCont")
public class NoteCont extends HttpServlet {
    NoteService nots=new NoteService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String title=req.getParameter("title");
        String ip=req.getParameter("ip");
        String uid=req.getParameter("uid");
        String msg=req.getParameter("pinl");
        Gson gson=new Gson();
        PrintWriter out=resp.getWriter();
        try {
            nots.inert(title,uid,ip,msg);
            List<Note> list=nots.allo(title);
            String message=gson.toJson(list);
            out.print(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
