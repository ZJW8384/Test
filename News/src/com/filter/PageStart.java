package com.filter;

import com.dao.Domestic;
import com.dao.LoadNws;
import com.google.gson.Gson;
import com.mode.NewsInfo;
import com.mode.Subject;
import com.service.NewsAService;
import com.service.PageService;
import com.service.SubjectService;;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;

@WebListener
public class PageStart implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        NewsAService nad=new NewsAService();
        PageService pg=new PageService();
        Domestic dom=new Domestic();
        SubjectService subje=new SubjectService();
        HttpSession session=se.getSession();
        Gson gson=new Gson();
        try {
            List<NewsInfo> list=nad.load();
            List<Object> bar=pg.getPages("1");
            List<NewsInfo> nation=dom.nation();
            List<NewsInfo> intern=dom.intern();
            List<NewsInfo> hoblly=dom.hoblly();
            List<NewsInfo> stick=dom.stick();
            List<NewsInfo> slide=dom.slide();
            List<Subject> subjects=subje.subSearch();
            String st=gson.toJson(list);
            session.setAttribute("st",st);
            session.setAttribute("list",list);
            session.setAttribute("subject",subjects);
            session.setAttribute("nation",nation);
            session.setAttribute("hoblly",hoblly);
            session.setAttribute("intern",intern);
            session.setAttribute("stick",stick);
            session.setAttribute("slide",slide);
            session.setAttribute("page",bar.get(0));
            session.setAttribute("count",bar.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
