package com.controller;


import com.dao.AllNews;
import com.dao.Domestic;
import com.mode.NewsInfo;
import com.mode.Note;
import com.mode.Subject;
import com.service.NewsAService;
import com.service.NoteService;
import com.service.PageService;
import com.service.SubjectService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/newsAdd")
public class NewsAdd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");
       resp.setContentType("text/html;charset=UTF-8");
       boolean isMult= ServletFileUpload.isMultipartContent(req);
        String sub = null;
        String title= null;
        String writer= null;
        String top=null;
        String des= null;
        String msg= null;
        String img=null;
        String slide=null;
        if(isMult){
            FileItemFactory factory= new DiskFileItemFactory();
            ServletFileUpload up=new ServletFileUpload( factory);
            try {
                List<FileItem> items=up.parseRequest(req);
                Iterator<FileItem> it=items.iterator();
                while(it.hasNext()){
                    FileItem f=it.next();
                    String itname=f.getFieldName();
                    if(f.isFormField()){
                        if(itname.equals("subject")){
                            sub=f.getString("UTF-8");
                        }else if(itname.equals("title")){
                            title=f.getString("UTF-8");
                        }else if(itname.equals("top")){
                            top=f.getString("UTF-8");
                        } else if(itname.equals("writer")){
                            writer=f.getString("UTF-8");
                        }else if(itname.equals("des")){
                            des=f.getString("UTF-8");
                        }else if(itname.equals("msg")){
                            String st=f.getString("UTF-8");
                            Pattern p=Pattern.compile("\n");
                            Matcher m = p.matcher(st);
                            msg=m.replaceAll("<p>");
                        }else if(itname.equals("slide")){
                            slide=f.getString("UTF-8");
                        }
                    }else {
                        String filename=f.getName();
                        System.out.println("文件名 "+filename);
                        if(!StringUtils.isEmpty(filename)){
                            String files = this.getClass().getResource("/").getPath();
                            String path=req.getSession().getServletContext().getRealPath("images");
                            img="/images/"+filename;
                            File file=new File(path,filename);
                            f.write(file);
                        }

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        NewsAService nw=new NewsAService();
        try {
            System.out.println(img);
            nw.insertNew(sub,title,slide,top,writer,des,msg,img);
        } catch (Exception e) {
            e.printStackTrace();
        }
        AllNews nad=new AllNews();
        try {
            List<NewsInfo> list=nad.allNews(1);
            req.setAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Domestic dom=new Domestic();
      HttpSession session=req.getSession();
        try {
            List<NewsInfo> intern = dom.intern();
            List<NewsInfo> hoblly=dom.hoblly();
            List<NewsInfo> stick=dom.stick();
            List<NewsInfo> nation=dom.nation();
            List<NewsInfo> slides=dom.slide();
            session.setAttribute("nation",nation);//国内
            session.setAttribute("hoblly",hoblly);//娱乐
            session.setAttribute("intern",intern);//国际
            session.setAttribute("stick",stick);//置顶
            session.setAttribute("slide",slides);//轮播
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SubjectService subje=new SubjectService();
        HttpSession session=req.getSession();
        try {
            List<Subject> subjects=subje.subSearch();
            session.setAttribute("subject",subjects);
            req.getRequestDispatcher("/jsp/newsMager.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
