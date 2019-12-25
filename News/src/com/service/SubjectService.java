package com.service;

import com.dao.Subjectdao;
import com.mode.Subject;

import java.sql.SQLException;
import java.util.List;

public class SubjectService {
    Subjectdao subj=new Subjectdao();
    public void subAdd(String subject) throws Exception {
        subj.addSub(subject);
    }
    public List<Subject> subSearch() throws Exception {
        List<Subject> list=subj.searchSub();
        return list;
    }
    public void subUP(String subject,int id) throws SQLException {
        subj.upSub(subject,id);
    }
}
