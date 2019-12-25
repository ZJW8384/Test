package com.service;

import com.dao.Logindao;
import com.mode.Login;

import java.util.ArrayList;
import java.util.List;

public class LoginService {
    public List<String> isLogin(String id,String pass) throws Exception {
        Logindao lg=new Logindao();
        List<Login> user=lg.userLogin(id,pass);
        String uid=user.get(0).getUid();
        String pwd=user.get(0).getPass();
        String flag=user.get(0).getFlag();
        List<String> us=new ArrayList<>();
        us.add(flag);
        us.add(uid);
        us.add(pwd);
        return us;
    }
}
