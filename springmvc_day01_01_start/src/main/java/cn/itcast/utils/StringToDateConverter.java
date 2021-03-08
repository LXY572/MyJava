package cn.itcast.utils;


import org.springframework.core.convert.converter.Converter;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 把字符串转化成日期
 */
public class StringToDateConverter implements Converter<String,Date>{

    /**
     *String source 传入进来的字符串
     * @param source
     * @return
     */
    @Override
    public Date convert(String source) {
        //判断
        if(source == null){
            //若为空，则返回
            throw new RuntimeException("请传入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //把字符串转换成日期
            return df.parse(source);
        } catch (ParseException e) {
            //若报错，则返回
            throw new RuntimeException("请传入数据");
        }
    }
}

