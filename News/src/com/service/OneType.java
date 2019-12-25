package com.service;

import com.dao.OneNew;
import com.mode.NewsInfo;
import org.junit.Test;

import java.util.List;

public class OneType {
    public List<NewsInfo> clan(String types) throws Exception {
        OneNew on=new OneNew();
        List<NewsInfo> list=on.strip(types);
        return list;
    }
//    @Test
//    public void es() throws Exception {
//        OneType on=new OneType();
//        List<NewsInfo> ls=on.clan("科技");
//        ls.forEach(a-> System.out.println(a));
//    }
}
