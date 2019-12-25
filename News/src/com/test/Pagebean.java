package com.test;

import com.mode.NewsInfo;

import java.util.ArrayList;
import java.util.List;

public class Pagebean {
    private int currentPage;//当前哪一页
    private int totalPage; //一共多少页
    private int totalCount;//一共多少条记录
    private List<NewsInfo> list=new ArrayList<>();

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<NewsInfo> getList() {
        return list;
    }

    public void setList(List<NewsInfo> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Pagebean{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", list=" + list +
                '}';
    }
}
