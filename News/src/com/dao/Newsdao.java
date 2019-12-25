package com.dao;

import com.mode.NewsInfo;
import com.utils.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class Newsdao {
    PreparedStatement ps=null;
    Connection con=null;
    public void addNews(String sub,String title,String slide,String top,String writer,String des,String msg,String img) throws Exception {
        con=DButil.getConnection();
        String sql="insert into newinfo(writer,subject,title,slide,top,des,imgPath) values('"+writer+"','"+sub+"','"+title+"','"+slide+"','"+top+"','"+des+"','"+img+"')";
        String sql2="insert into news(title,msg) values('"+title+"','"+msg+"')";
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        ps=con.prepareStatement(sql2);
        ps.executeUpdate();
    }
    public void upNw(String sub,String title,String top,String writer,String des,String msg,String img) throws Exception {
        String sql="update newinfo set writer=?,subject=?,top=?,des=?,imgpath=? where title=?";
        String sql2="update news set msg=? where title=?";
        DButil.SQLment(sql,writer,sub,top,des,img,title);
        DButil.SQLment(sql2,msg,title);
    }
}

