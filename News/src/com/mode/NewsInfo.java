package com.mode;

public class NewsInfo {
    private int id;
    private String writer;
    private String subject;
    private String title;
    private String slide;
    private String top;
    private String des;
    private String time;
    private String imgPath;
    private String nid;
    private String msg;


    public String getSlide() {
        return slide;
    }

    public void setSlide(String slide) {
        this.slide = slide;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "NewsInfo{" +
                "id=" + id +
                ", writer='" + writer + '\'' +
                ", subject='" + subject + '\'' +
                ", title='" + title + '\'' +
                ", slide='" + slide + '\'' +
                ", top='" + top + '\'' +
                ", des='" + des + '\'' +
                ", time='" + time + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", nid='" + nid + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
