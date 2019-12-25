package com.dao;

import com.mode.NewsInfo;
import com.utils.DButil;

import java.util.List;

public class Domestic {
    private String sql="select * from newinfo,news where newinfo.title=news.title and subject=? order by newinfo.id desc limit 0,7";
    private  String sql2="select * from newinfo,news where newinfo.title=news.title and top=? order by newinfo.id desc limit 0,7";
    private String sql3="select * from newinfo,news where newinfo.title=news.title and slide=? order by newinfo.id desc limit 0,3";
    List<NewsInfo> list=null;
    public List<NewsInfo> nation() throws Exception {
        Object [] ob={"国内"};
        list= DButil.search(sql,NewsInfo.class,ob);
        return  list;
    }
    public List<NewsInfo> intern() throws Exception {
        Object[] ob={"国际"};
       list=DButil.search(sql,NewsInfo.class,ob);
        return list;
    }
    public List<NewsInfo>  hoblly() throws Exception {
        Object[] ob={"娱乐"};
        list=DButil.search(sql,NewsInfo.class,ob);
        return list;
    }
    public List<NewsInfo>  stick() throws Exception {
        Object[] ob={"1"};
        list=DButil.search(sql2,NewsInfo.class,ob);
        return  list;
    }
    public List<NewsInfo> slide() throws Exception {
        Object[] ob={"1"};
        list=DButil.search(sql3,NewsInfo.class,ob);
        return list;
    }

}
