package com.service;

import com.mode.Page;
import com.utils.DButil;

import java.util.ArrayList;
import java.util.List;


public class PageService {
    public List<Object> getPages(String num) throws Exception {
        int number=1;//默认第一页
        number=Integer.parseInt(num);
        int count= DButil.getCount();//数据总条数
        Page pg=new Page();
        pg.setPagesize(20);//每页显示的条数
        pg.setCount(count);//总条数
        int page=pg.getPage();//总页数
        String sbf=null;
        List<Object> list=new ArrayList<>();
        for(int i=0;i<=page;i++){        //构建导航条
            if(i==count){       //判断是否为当前页
                sbf=String.valueOf(i);
            }else {
                i++;
                sbf=String.valueOf(i);
            }

        }
        list.add(sbf);
        list.add(page);
        return list;
    }
}
