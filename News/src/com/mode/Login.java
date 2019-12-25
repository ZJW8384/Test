package com.mode;

public class Login {
    private String uid;
    private String pass;
    private String flag;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
    @Override
    public String toString() {
        return "Login{" +
                "uid='" + uid + '\'' +
                ", pass='" + pass + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
