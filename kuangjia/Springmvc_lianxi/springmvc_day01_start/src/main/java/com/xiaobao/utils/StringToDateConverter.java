package com.xiaobao.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        if (source == null){
            throw new RuntimeException ("请您传入数据");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat ( "yyyy-mm-dd" );
        Date date = null;
        try {
            date = simpleDateFormat.parse ( source );
        } catch (ParseException e) {
            e.printStackTrace ();
        }
        return date;
    }
}
