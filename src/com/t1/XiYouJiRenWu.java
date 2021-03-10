package com.t1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * name 姓名
 * height 身高
 * weapon 武器
 */
public class XiYouJiRenWu implements Serializable {
    private String name;
    private Double height;
    private String weapon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "XiYouJiRenWu{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weapon='" + weapon + '\'' +
                '}';
    }

    public void printName(List<XiYouJiRenWu> name){
        for (XiYouJiRenWu xiYouJiRenWu : name) {
            System.out.println("姓名："+xiYouJiRenWu.getName());
        }
    }
    public void printWeapon(List<XiYouJiRenWu> weapon){
        for (XiYouJiRenWu xiYouJiRenWu : weapon){
            System.out.println("武器："+xiYouJiRenWu.getWeapon());
        }
    }
    public static void main(String[] args) {
        XiYouJiRenWu zhuBaJie=new XiYouJiRenWu();
        zhuBaJie.setName("猪八戒");
        zhuBaJie.setWeapon("九齿钉耙");
        XiYouJiRenWu sunWuKong=new XiYouJiRenWu();
        sunWuKong.setName("孙悟空");
        sunWuKong.setWeapon("金箍棒");
        List<XiYouJiRenWu> msg=new ArrayList<>();
        msg.add(zhuBaJie);
        msg.add(sunWuKong);
        zhuBaJie.printName(msg);
        sunWuKong.printWeapon(msg);
    }
}
