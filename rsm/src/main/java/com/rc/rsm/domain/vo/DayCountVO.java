package com.rc.rsm.domain.vo;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DayCountVO {
    private String day;
    private Integer count;

    // 正确的 setter 方法
    public void setDay(String dayStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            formatter.parse(dayStr); // 解析日期字符串，如果解析成功则说明格式正确
            this.day = dayStr; // 直接赋值字符串
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // 其他 getter 和 setter 方法
    public String getDay() {
        return day;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }
}
