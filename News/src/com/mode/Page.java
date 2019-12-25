package com.mode;

public class Page {
    private int pagesize;//每页显示的条数
    private int count;//总条数
    private int page;//总页数



    public int getPagesize() {
        return pagesize;
    }
    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }
    public int getPage() {
        if(count%getPagesize()==0){
            page=count/getPagesize();
        }else {
            page=count/getPagesize()+1;
        }
        return page;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pagesize=" + pagesize +
                ", count=" + count +
                ", page=" + page +
                '}';
    }
}
