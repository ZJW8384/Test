package com.dao;

import com.mode.NewsInfo;
import com.utils.DButil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LoadNws {
    public List<NewsInfo> startNews() throws Exception {
        List<NewsInfo> list=new ArrayList<>();
        String sql="select * from  news,newinfo where newinfo.title=news.title order by newinfo.id desc limit 0,21";
        list= DButil.search(sql,NewsInfo.class,null);
        return list;
    }
    public List<NewsInfo> topNews() throws Exception {
        String sql="select * from news,newinfo where news.title=newinfo.title and top=1 order by news.id desc limit 0,2";
        List<NewsInfo> list=DButil.search(sql,NewsInfo.class,null);
        return list;
    }
    public List<NewsInfo> pageNew() throws Exception {
        String sql="select * from  news,newinfo where newinfo.title=news.title order by newinfo.id desc";
        List<NewsInfo> list=DButil.search(sql,NewsInfo.class,null);
        return list;
    }
}
