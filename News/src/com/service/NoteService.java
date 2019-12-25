package com.service;

import com.dao.Notedao;
import com.mode.Note;

import java.sql.SQLException;
import java.util.List;

public class NoteService {
    Notedao ne=new Notedao();
    public List<Note> allo(String title) throws Exception {
        List<Note> no=ne.allNote(title);
        return no;
    }
    public void inert(String title,String uid,String ip,String msg) throws SQLException {
        ne.inote(title,uid,ip,msg);
    }
}
