package com.dao;

import com.mode.Note;
import com.utils.DButil;

import java.sql.SQLException;
import java.util.List;

public class Notedao {
    public List<Note> allNote(String title) throws Exception {
        String sql="select * from note where note.title=? order by id desc";
        Object [] ob={title};
        List<Note> note= DButil.search(sql,Note.class,ob);
        return note;
    }
    public void inote(String title,String uid,String ip,String msg) throws SQLException {
        String sql="insert into note(title,uid,ip,msg) values(?,?,?,?)";
        Object [] ob={title,uid,ip,msg};
        DButil.SQLment(sql,ob);
    }
}
