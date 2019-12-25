package com.utils;

import com.mode.NewsInfo;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewsSearch {
    public List<NewsInfo> search(String title,String writer,String subject) throws Exception {
        List<Object> lists=new ArrayList<>();
        String sql="select * from newinfo where 1=1";
        if(!StringUtils.isEmpty(title)){
            sql=sql+" and title like ?";
            lists.add("%" + title + "%");
        }else if(!StringUtils.isEmpty(writer)){
            sql=sql+" and writer like ?";
            lists.add("%"+writer+"%");
        }else if(!StringUtils.isEmpty(subject)){
            sql=sql+" and subject like ?";
            lists.add("%"+subject+"%");
        }
        List<NewsInfo> list=new ArrayList<>();
        try {
            Connection con= DButil.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            for(int i=0;i<lists.size();i++){//根据参数的长度逐个取出，再加入到sql语句
                ps.setObject(i+1,lists.get(i));//注意 i+1
            }
            ResultSet re = ps.executeQuery();
            while (re.next()){
               NewsInfo news=new NewsInfo();
               news.setTime(re.getString("time"));
               news.setTitle(re.getString("title"));;
               list.add(news);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    private static <T> T[] concatAll(T[] first, T[]... rest) {
        int totalLength = first.length;
        for (T[] array : rest) {
            totalLength += array.length;
        }
        T[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (T[] array : rest) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }
}
