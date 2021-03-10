package com.t1;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * uid 账号
 * add 存款金额
 * count 账户余额
 * 涉及金钱一律用BigDecimal
 */
public class Account implements Serializable {
    private String uid="000000";
    private double add;
    private double count;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public double getAdd() {
        return add;
    }

    public void setAdd(double add) {
        this.add = add;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count= count;
    }

    @Override
    public String toString() {
        return "Account{" +
                "uid='" + uid + '\'' +
                ", add=" + add +
                ", count=" + count +
                '}';
    }

    public void addMoney(String uid, Double money){
        this.setUid(uid);
        this.setAdd(money);
        this.setCount(this.getAdd());
        System.out.println(this.getUid()+"存款："+money+"元");
    }
    public void getMoney(String uid,Double money){
        this.setUid(uid);
        this.setCount(this.getCount()-money);
        System.out.println(this.getUid()+"取款："+money+"元");
    }
    public void showMoney(String uid){
        System.out.println(this.getUid()+"余额为："+this.getCount()+"元");
    }

    public static void main(String[] args) {
        Account account=new Account();
        account.addMoney("8888",300.0);
        account.getMoney("8888",200.0);
        account.showMoney("8888");
    }
}
