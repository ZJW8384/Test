package com.test;

import com.mode.NewsInfo;
import com.service.NewsAService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PagePreas extends HttpServlet {
    NewsAService ns=new NewsAService();
    Pagebean pgb=new Pagebean();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<NewsInfo> list=ns.fenye();
            pgb.setList(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
