package com.dao;

import com.mode.NewsInfo;
import com.utils.DButil;

import java.util.List;

public class OneNew {
   private  String sql="select * from newinfo,news where newinfo.title=news.title and subject=? order by newinfo.id desc limit 0,12";
    public List<NewsInfo> strip(String type) throws Exception {
       Object [] ob={type};
       List<NewsInfo> list= DButil.search(sql,NewsInfo.class,ob);
        return list;
    }
}
