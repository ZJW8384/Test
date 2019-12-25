package com.dao;

import com.utils.DButil;

public class UpNews {
    public void upNw(String id,String sub,String title,String top,String writer,String des,String msg,String img) throws Exception {
        String sql="update newinfo set writer=?,subject=?,top=?,des=?,imgpath=? where title=?";
        String sql2="update news set mag=? where title=?";
        DButil.SQLment(sql,writer,sub,top,des,img,title);
        DButil.SQLment(sql2,msg,title);
    }
}
