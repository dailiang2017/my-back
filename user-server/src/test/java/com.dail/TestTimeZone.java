package com.dail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Auther: dailiang
 * @Date: 2019/1/14 15:32
 * @Description:
 */
public class TestTimeZone {

    public static void main(String[] args) {
        // 查看当前时区
        ZoneId defaultZone = ZoneId.systemDefault();
        System.out.println("查看当前时区：" + defaultZone);
        // 查看美国纽约时间
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime shanghaiTime = LocalDateTime.now(america);
        System.out.println("查看美国纽约时间：" + shanghaiTime);
        // 根据传入时间获取时区
        DateFormat dateFormat = new SimpleDateFormat("Z");
        System.out.println("根据传入时间获取时区：" + dateFormat.format(new Date()));
    }
}
