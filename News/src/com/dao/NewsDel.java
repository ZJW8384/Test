package com.dao;

import com.utils.DButil;

import java.sql.SQLException;

public class NewsDel {
    public void drop(String title) throws SQLException {
        String sql ="delete table newinfo where title=?";
        String sql2="delete table news where title=?";
        DButil.SQLment(sql,title);
        DButil.SQLment(sql2,title);
    }
}
