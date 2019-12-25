package com.dao;

import com.mode.NewsInfo;
import com.utils.DButil;

import java.util.List;

public class NewSearch {
    public List<NewsInfo> search(String title) throws Exception {
        String sql="select * from news,newinfo where news.title=newinfo.title and news.title=?";
        List<NewsInfo> news= DButil.search(sql,NewsInfo.class,title);
        return news;
    }
}
