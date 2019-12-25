package com.dao;

import com.mode.Subject;
import com.utils.DButil;

import java.sql.SQLException;
import java.util.List;

public class Subjectdao {

    public void addSub(String subject) throws Exception {
        String sql="insert into subject(subject) values(?)";
        Object [] obj={subject};
       DButil.SQLment(sql,obj);
    }
    public List<Subject> searchSub() throws Exception {
        String sql="select * from subject";
        List<Subject> list= DButil.search(sql,Subject.class,null);
        return list;
    }
    public void upSub(String subject,int id) throws SQLException {
        String sql="update subject set subject=? where id=?";
        DButil.SQLment(sql,subject,id);
    }
}
