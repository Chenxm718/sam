package com.sam.utils.date;


import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.*;
/**
 * Created by ChenXinmin on 2017/1/9.
 */
public class DateUtils {
    private DateUtils() {
    }

    /**
     * yyyy-MM-dd 转localDate
     *
     * @param dateStr
     * @return
     */
    public static LocalDate dateStr2LocalDate(String dateStr) {
        return LocalDate.parse(dateStr);
    }

    /**
     * localDate转yyyy-MM-dd字符串
     *
     * @param date
     * @return
     */
    public static String localDate2Str(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     * localDate转指定格式的字符串
     *
     * @param date
     * 时间
     * @param date
     * 格式
     * @return
     */
    public static String localDate2Str(LocalDate date,String format) {
        return date.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * LocalDateTime 转str
     * @param localDateTime
     * @return
     */
    public static String localDateTime2Str(LocalDateTime localDateTime){
        return localDateTime2Str(localDateTime,"yyyy-MM-dd HH:mm:ss");
    }

    /**
     * LocalDateTime 转str
     * @param localDateTime
     * 时间
     * @param pattern
     * pattern
     * @return
     */
    public static String localDateTime2Str(LocalDateTime localDateTime,String pattern){
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }
    /**
     * yyyy-MM-dd HH:mm:ss 转localDate
     *
     * @param dateTimeStr
     * @return
     */
    public static LocalDate dateTimeStr2LocalDate(String dateTimeStr) {
        return LocalDate.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * yyyy-MM-dd HH:mm:ss 转localDateTime
     *
     * @param dateTimeStr
     * @return
     */
    public static LocalDateTime dateTimeStr2LocalDateTime(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * yyyy-MM-dd 转localDateTime
     *
     * @param dateStr
     * @return
     */
    public static LocalDateTime dateStr2LocalDateTime(String dateStr) {
        LocalDate date = dateStr2LocalDate(dateStr);
        return LocalDateTime.of(date, LocalTime.of(0, 0, 0));
    }

    /**
     * yyyy-MM-dd 转localDateTime
     *
     * @param dateStr
     * @return
     */
    public static LocalDateTime dateStr2StartLocalDateTime(String dateStr) {
        LocalDate date = dateStr2LocalDate(dateStr);
        return LocalDateTime.of(date, LocalTime.of(0, 0, 0));
    }

    /**
     * yyyy-MM-dd 转localDateTime
     *
     * @param dateStr
     * @return
     */
    public static LocalDateTime dateStr2EndLocalDateTime(String dateStr) {
        LocalDate date = dateStr2LocalDate(dateStr);
        return LocalDateTime.of(date, LocalTime.of(23, 59, 59));
    }

    /**
     * 日期转数字 yyyyMMddHH
     *
     * @param dateTime
     * @return
     */
    public static Integer dateTime2Number(LocalDateTime dateTime) {
        return Integer.valueOf(dateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHH")));
    }

    /**
     * 日期转数字 yyyyMMdd
     *
     * @param date
     * @return
     */
    public static Integer date2Number(LocalDate date) {
        return Integer.valueOf(date.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    }

    /**
     * 日期转 yyyyMM
     *
     * @param date
     * @return
     */
    public static Integer date2MonthNumber(LocalDate date) {
        return Integer.valueOf(date.format(DateTimeFormatter.ofPattern("yyyyMM")));
    }

    /**
     * 数字转日期字符串
     *
     * @param number
     * @return
     */
    public static String number2LocalDateStr(Integer number) {
        return LocalDate.parse("" + number, DateTimeFormatter.ofPattern("yyyyMMdd")).toString();
    }

    /**
     * 月份数字转日期字符串
     *
     * @param number
     * @return
     */
    public static String numberMonth2DateStr(Integer number) {
        int year = number / 100;
        int month = number - number / 100 * 100;
        return year + "-" + (month < 10 ? "0" + month : month);
    }

    /**
     * 获得日期所在第几周，指定周一到周日为一周
     *
     * @param date
     * @return
     */
    public static int getWeek(LocalDate date) {
        return date.get(WeekFields.of(DayOfWeek.MONDAY, 1).weekOfYear());
    }

    /**
     * 根据日期获取周的起止日期
     *
     * @param date
     * @return
     */
    public static LocalDate[] getWeekDays(LocalDate date) {
        return getWeekDays(getYearWeek(date));
    }

    /**
     * 获得日期所在年周，指定周一到周日为一周
     *
     * @param date
     * @return
     */
    public static int getYearWeek(LocalDate date) {
        int week = date.get(WeekFields.of(DayOfWeek.MONDAY, 1).weekOfYear());
        Integer year = date.getYear();
        String yearWeek = week < 10 ? year + "0" + week : year + "" + week;
        return Integer.parseInt(yearWeek);
    }

    /**
     * 根据年周获取起止时间
     *
     * @param yearWeek
     * @return
     */
    public static LocalDate[] getWeekDays(Integer yearWeek) {
        LocalDate startDay;
        LocalDate endDay;
        int year = yearWeek / 100;
        int weekNo = yearWeek - year * 100;
        LocalDate date = getFirstDayOfWeek(year, weekNo);
        // 第一周
        if (1 == weekNo) {// 1月1日到周日
            startDay = date.withDayOfYear(1);
            int weekDay = startDay.getDayOfWeek().getValue();
            endDay = date.plusDays(7l - weekDay);
        } else if (53 == weekNo) {// 53周可能为跨年周
            if (12 == date.plusDays(6).getMonthValue()) {// 如果是一整周，周一到周日
                startDay = date;
                endDay = date.plusDays(6);
            } else {// 拆开跨年周，周一到年尾
                endDay = date.plusMonths(1).withDayOfMonth(1).minusDays(1);
                int weekDay = endDay.getDayOfWeek().getValue();
                startDay = endDay.minusDays(weekDay).plusDays(1);
            }
        } else {
            startDay = date;
            endDay = date.plusDays(6);
        }
        return new LocalDate[] { startDay, endDay };
    }

    /**
     * 获取某年的第几周的开始日期
     *
     * @param year
     * @param week
     * @return
     */
    private static LocalDate getFirstDayOfWeek(int year, int week) {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, 1);
        if (week == 1) {
            return LocalDate.of(year, Month.JANUARY, 1);
        }
        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, (week - 1) * 7);
        Date d = getFirstDayOfWeek(cal.getTime());
        return dateStr2LocalDate(new SimpleDateFormat("yyyy-MM-dd").format(d));
    }

    /**
     * 获取当前时间所在周的开始日期
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        return c.getTime();
    }

    /**
     * 获取两个时间内的所有小时
     *
     * @param sDate
     * @param eDate
     * @return
     */
    public static List<Integer> hoursBetween(LocalDateTime sDate, LocalDateTime eDate) {
        List<Integer> list = new ArrayList<>();
        while (sDate.isBefore(eDate) || sDate.equals(eDate)) {
            String hour = sDate.getHour() < 10 ? "0" + sDate.getHour() : String.valueOf(sDate.getHour());
            String day = sDate.getDayOfMonth() < 10 ? "0" + sDate.getDayOfMonth()
                    : String.valueOf(sDate.getDayOfMonth());
            String month = sDate.getMonthValue() < 10 ? "0" + sDate.getMonthValue()
                    : String.valueOf(sDate.getMonthValue());
            list.add(Integer.parseInt(sDate.getYear() + month + day + hour));
            sDate = sDate.plusHours(1);
        }
        return list;
    }

    /**
     * 获取两个时间之间所有日期
     *
     * @param sdate
     * @param edate
     * @return
     */
    public static List<Integer> daysBetween(String sdate, String edate) {
        LocalDate sd = dateStr2LocalDate(sdate);
        LocalDate ed = dateStr2LocalDate(edate);
        return daysBetween(sd, ed);
    }

    /**
     * 获取两个时间之间所有日期
     *
     * @param sdate
     * @param edate
     * @return
     */
    public static List<Integer> daysBetween(LocalDate sdate, LocalDate edate) {
        List<Integer> list = new ArrayList<>();
        while (sdate.isBefore(edate) || sdate.equals(edate)) {
            String day = sdate.getDayOfMonth() < 10 ? "0" + sdate.getDayOfMonth()
                    : String.valueOf(sdate.getDayOfMonth());
            String month = sdate.getMonthValue() < 10 ? "0" + sdate.getMonthValue()
                    : String.valueOf(sdate.getMonthValue());
            list.add(Integer.parseInt(sdate.getYear() + month + day));
            sdate = sdate.plusDays(1);
        }
        return list;
    }

    /**
     * 获取两个日期之间周数
     *
     * @param sdate
     * @param edate
     * @return
     */
    public static List<Integer> weeksBetween(String sdate, String edate) {
        return weeksBetween(dateStr2LocalDate(sdate), dateStr2LocalDate(edate));
    }

    /**
     * 获取两个日期之间周数
     *
     * @param sdate
     * @param edate
     * @return
     */
    public static List<Integer> weeksBetween(LocalDate sdate, LocalDate edate) {
        List<Integer> list = new ArrayList<>();
        Integer startYearWeek = getYearWeek(sdate);
        Integer endYearWeek = getYearWeek(edate);
        for (int i = startYearWeek; i <= endYearWeek; i++) {
            list.add(i);
            int week = i - i / 100 * 100;
            if (week == 53) {
                i = i / 100 * 100 + 100;
            }
        }
        return list;
    }

    /**
     * 获取两个日期之间月数
     *
     * @param sdate
     * @param edate
     * @return
     */
    public static List<Integer> monthsBetween(String sdate, String edate) {
        return monthsBetween(dateStr2LocalDate(sdate), dateStr2LocalDate(edate));
    }

    /**
     * 获取两个日期之间月数
     *
     * @param sdate
     * @param edate
     * @return
     */
    public static List<Integer> monthsBetween(LocalDate sdate, LocalDate edate) {
        List<Integer> list = new ArrayList<>();
        Integer startMonth = date2MonthNumber(sdate);
        Integer endMonth = date2MonthNumber(edate);
        for (int i = startMonth; i <= endMonth; i++) {
            list.add(i);
            int month = i - i / 100 * 100;
            if (month == 12) {
                i = i / 100 * 100 + 100;
            }
        }
        return list;
    }

    /**
     * 获取两个日期之间年数
     *
     * @param sdate
     * @param edate
     * @return
     */
    public static List<Integer> yearsBetween(LocalDate sdate, LocalDate edate) {
        return yearsBetween(sdate.getYear(), edate.getYear());
    }

    /**
     * 获取两个日期之间年数
     *
     * @param syear
     * @param eyear
     * @return
     */
    public static List<Integer> yearsBetween(Integer syear, Integer eyear) {
        List<Integer> list = new ArrayList<>();
        for (int i = syear; i <= eyear; i++) {
            list.add(i);
        }
        return list;
    }

    /**
     * 获取两个日期之间年数
     *
     * @param sdate
     * @param edate
     * @return
     */
    public static List<Integer> yearsBetween(String sdate, String edate) {
        Integer startYear = dateStr2LocalDate(sdate).getYear();
        Integer endYear = dateStr2LocalDate(edate).getYear();
        return yearsBetween(startYear, endYear);
    }

    /**
     * 数字日期转换成字符串yyyy-MM-dd 20160101->2016-01-01
     *
     * @param number
     *            数字型的日期
     * @return20160101
     */
    public static String numberDate2DateStr(Integer number) {
        int year = number / 10000;
        int month = (number - (number / 10000 * 10000)) / 100;
        int day = (number - (number / 10000 * 10000)) - month * 100;
        return year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day);
    }

    /**
     * 结束时间比开始时间多多少毫秒
     * @param startTime
     * @param endTime
     * @return
     */
    public static long betweenMillis(LocalDateTime startTime,LocalDateTime endTime){
        Duration duration = Duration.between(startTime,endTime);
        return duration.toMillis();
    }

    /**
     * 秒时间戳转时间
     * @param timestamp
     * @return
     */
    public static LocalDateTime timestampSecondToLocalDateTime(long timestamp){
        Instant instant = Instant.ofEpochSecond(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }
    /**
     * 毫秒时间戳转时间
     * @param timestamp
     * @return
     */
    public static LocalDateTime timestampMilliToLocalDateTime(long timestamp){
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

}
