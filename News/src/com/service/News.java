package com.service;

import com.dao.NewSearch;
import com.mode.NewsInfo;

import java.util.List;

public class News {
    public List<NewsInfo> newOne(String title) throws Exception {
        NewSearch ns=new NewSearch();
        List<NewsInfo> lists=ns.search(title);
        return lists;
    }
}
