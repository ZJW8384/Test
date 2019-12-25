package com.service;

import com.dao.LoadNws;
import com.dao.Newsdao;
import com.mode.NewsInfo;

import java.util.List;

public class NewsAService {
    public void insertNew(String sub,String title,String slide,String top,String writer,String des,String msg,String img) throws Exception {
        Newsdao nd=new Newsdao();
        nd.addNews(sub,title,slide,top,writer,des,msg,img);
    }
    public List<NewsInfo> load() throws Exception {
        LoadNws ld=new LoadNws();
        List<NewsInfo> list=ld.startNews();
        return list;
    }
    public List<NewsInfo> fenye() throws Exception {
        LoadNws ld=new LoadNws();
        List<NewsInfo> list=ld.pageNew();
        return  list;
    }
        public void upnews(String sub,String title,String top,String writer,String des,String msg,String img) throws Exception {
            Newsdao newsdao=new Newsdao();
            newsdao.upNw( sub, title, top, writer, des, msg, img);
        }

}
