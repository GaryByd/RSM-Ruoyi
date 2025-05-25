package com.rc.rsm.domain.vo;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Data
public class DateCountVO {
    private String date;
    private Integer count;

    // 正确的 setter 方法
    public void setDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        try {
            formatter.parse(dateStr); // 解析日期字符串，如果解析成功则说明格式正确
            this.date = dateStr; // 直接赋值字符串
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // 其他 getter 和 setter 方法
    public String getDate() {
        return date;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }
}
