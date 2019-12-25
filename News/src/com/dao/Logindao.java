package com.dao;

import com.mode.Login;
import com.utils.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Logindao {
    Connection con=null;
    PreparedStatement ps=null;
    public List<Login> userLogin(String uid,String pass) throws Exception {
        con= DButil.getConnection();
        List<Login> user=new ArrayList<>();
        String sql="select * from login where uid='"+uid+"' and pwd='"+pass+"'";
        ps=con.prepareStatement(sql);
        ResultSet re=ps.executeQuery();
        while(re.next()){
            Login lg=new Login();
            lg.setFlag(re.getString("flag"));
            lg.setPass(re.getString("pwd"));
            lg.setUid(re.getString("uid"));
            user.add(lg);
        }
        DButil.closeConnection();
        return user;
    }
}
