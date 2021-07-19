package lwl.ouc.stream.collectors;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.zone.ZoneRules;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class MapTest8 {
    @Test
    public void putIfAbsent() {
        Map<String, String> map = new HashMap<>();
        map.putIfAbsent("key", "oldValue");
        // 如果key存在，则忽略put操作
        map.putIfAbsent("key", "newValue");
        String value = map.get("key");
        System.out.println(value);
    }

    @Test
    public void forEach() {
        Map<String, String> map = new HashMap<>();
        map.putIfAbsent("key1", "value1");
        map.putIfAbsent("key2", "value1");
        map.putIfAbsent("key3", "value1");

        map.forEach((key, value) -> {
            System.out.println(key + ":" + value);
            if (key.equals("key1")) {
                System.out.println("idea niubi");
            }
        });

        map.forEach((key, value) -> {
            System.out.println(key + ":" + value);
            if (key.equals("key1")) {
                System.out.println("idea niubi");
            }
        });
    }

    @Test
    public void computeIfPresent() {
        Map<String, String> map = new HashMap<>();
        map.putIfAbsent("key1", "value1");
        String oldValue = map.get("key1");
        System.out.println("old value is " + oldValue);

        // 如果存在则计算：先判断key是否存在，如果key存在，将BiFunction计算的结果作为key的新值重新put进去
        map.computeIfPresent("key1", (key, value) -> key + ":" + value);
        String value = map.get("key1");
        System.out.println("new value is " + value);

        // 如果计算的结果为null，相当于从map中移除
        map.computeIfPresent("key1", (k, v) -> null);
        boolean contain = map.containsKey("key1");
        System.out.println(contain);
    }

    @Test
    public void computeIfAbsent() {
        // 如果key不存在则将计算的结果put进去
        Map<String, String> map = new HashMap<>();
        map.computeIfAbsent("key2", v -> "value2");
        boolean contain = map.containsKey("key2");
        System.out.println(contain);
    }

    @Test
    public void remove() {
        // 只有key-value同时满足条件时才会删除
        Map<String, String> map = new HashMap<>();
        map.putIfAbsent("key1", "value1");
        boolean result = map.remove("key1", "value1");
        System.out.println(result);
        map.putIfAbsent("key2", "value2");
        boolean result2 = map.remove("key2", "value1");
        System.out.println(result2);
        System.out.println(map.get("key2"));
    }

    @Test
    public void getOrDefault() {
        // 如果key不存在，则返回默认值
        Map<String, String> map = new HashMap<>();
        String value = map.getOrDefault("key1", "default value");
        System.out.println(value);
    }

    @Test
    public void merge() {
        // 合并：将BiFunction的结果作为key的新值
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");

        map.merge("key1", "newValue222", (value, newValue1) -> value + "+" + newValue1);
        String value = map.get("key1");
        // value1-newValue
        System.out.println(value);
    }

    @Test
    public void clock() {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        Instant instant = clock.instant();
        Date date = Date.from(instant);

        System.out.println(millis);
        System.out.println(date);
    }

    @Test
    public void timezones() {
        // 获取所有可用的时区
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);

        // 获取默认的时区 Asia/Shanghai
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

        // 获取时区规则 ZoneRules[currentStandardOffset=+08:00]
        ZoneRules rules = zoneId.getRules();
        System.out.println(rules);
    }

    @Test
    public void localTime() {
        ZoneId zoneId = ZoneId.systemDefault();
        ZoneId zoneId2 = ZoneId.of("Etc/GMT+8");

        // 获取指定时区的当前时间
        LocalTime now = LocalTime.now(zoneId);
        LocalTime now2 = LocalTime.now(zoneId2);

        // 判断一个本地时间是否在另一个本地时间之前
        boolean isBefore = now.isBefore(now2);

        // 获取两个本地时间小时之差
        long hours = ChronoUnit.HOURS.between(now, now2);
        System.out.println(hours);

        // 获取两个本地时间分钟之差
        long minutes = ChronoUnit.MINUTES.between(now, now2);
        System.out.println(minutes);

        LocalTime localTime = LocalTime.of(23, 59, 59);
        System.out.println(localTime); // 23:59:59

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.GERMAN);
        LocalTime local = LocalTime.parse("13:37", formatter);
        System.out.println(local); // 13:37
    }

    @Test
    public void localDate() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);

        System.out.println(today + "," + tomorrow + "," + yesterday);

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek);

        DateTimeFormatter germanFormatter =
            DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
        LocalDate localDate = LocalDate.parse("24.12.2014", germanFormatter);
        System.out.println(localDate); // 2014-12-24
    }

    @Test
    public void localDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        System.out.println(dayOfWeek);

        Month month = localDateTime.getMonth();
        System.out.println(month);

        long minuteOfDay = localDateTime.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);

        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        System.out.println(date);

        // DateTimeFormatter是不可变的，所以它是线程安全的
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parsed = LocalDateTime.parse("2018-05-07 07:13:00", formatter);
        String string = formatter.format(parsed);
        System.out.println(string);
    }
}
