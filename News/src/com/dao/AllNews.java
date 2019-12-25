package com.dao;

import com.mode.NewsInfo;
import com.mode.Page;
import com.utils.DButil;

import java.util.ArrayList;
import java.util.List;

public class AllNews {
    public List<NewsInfo> allNews( int page) throws Exception {
        Page pg=new Page();
        List<NewsInfo> news=new ArrayList<>();
        pg.setPagesize(21);
        Object[] pram={(page-1)*pg.getPagesize(),pg.getPagesize()};
        String sql="select * from  news,newinfo where newinfo.title=news.title order by newinfo.id desc limit ?,? ";
        news= DButil.search(sql,NewsInfo.class,pram);
        return news;
    }
}
