package com.example.common.utils.LocalDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2022-06-17 13:02
 **/
public class LocalDateTimeUtils {

  /**
   * Date转换为LocalDateTime
   *
   * @param date 日期
   * @return LocalDateTime
   */
  public static LocalDateTime toLocalDateTime(Date date) {
    return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
  }

  /**
   * LocalDateTime转换为Date
   *
   * @param dateTime 日期时间
   * @return Date
   */
  public static Date toDate(LocalDateTime dateTime) {
    return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
  }

  /**
   * 获取指定格式的指定时间
   *
   * @param dateTime 日期时间
   * @param pattern  指定格式
   * @return 指定格式的日期时间字符串
   */
  public static String formatTime(LocalDateTime dateTime, String pattern) {
    return dateTime.format(DateTimeFormatter.ofPattern(pattern));
  }

  /**
   * 获取指定格式的当前时间
   *
   * @param pattern 指定格式
   * @return 指定格式的当前时间日期字符串
   */
  public static String formatNow(String pattern) {
    return formatTime(LocalDateTime.now(), pattern);
  }

  /**
   * 判断dateTime1是否早于dateTime2
   *
   * @param dateTime1 日期时间1
   * @param dateTime2 日期时间2
   * @return 判断结果
   */
  public static boolean isBefore(LocalDateTime dateTime1, LocalDateTime dateTime2) {
    return dateTime1.isBefore(dateTime2);
  }

  /**
   * 判断dateTime1与dateTime2是否是同一时间
   *
   * @param dateTime1 日期时间1
   * @param dateTime2 日期时间2
   * @return 判断结果
   */
  public static boolean isEqual(LocalDateTime dateTime1, LocalDateTime dateTime2) {
    return dateTime1.isEqual(dateTime2);
  }

  /**
   * 判断dateTime1是否晚于dateTime2
   *
   * @param dateTime1 日期时间1
   * @param dateTime2 日期时间2
   * @return 判断结果
   */
  public static boolean isAfter(LocalDateTime dateTime1, LocalDateTime dateTime2) {
    return dateTime1.isAfter(dateTime2);
  }

  /**
   * 获取指定日期的毫秒
   *
   * @param dateTime 日期时间
   * @return 毫秒
   */
  public static Long getMilliByTime(LocalDateTime dateTime) {
    return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
  }

  /**
   * 获取指定日期的秒
   *
   * @param dateTime 日期时间
   * @return 秒
   */
  public static Long getSecondsByTime(LocalDateTime dateTime) {
    return dateTime.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
  }

  /**
   * 日期加上一个数，根据field不同加不同值
   *
   * @param dateTime 日期时间
   * @param number   数值
   * @param field    单位
   * @return 已添加数值后的日期时间
   */
  public static LocalDateTime plus(LocalDateTime dateTime, long number, ChronoUnit field) {
    return dateTime.plus(number, field);
  }

  /**
   * 日期减去一个数，根据field不同减不同值
   *
   * @param dateTime 日期时间
   * @param number   数值
   * @param field    单位
   * @return 已减少数值后的日期时间
   */
  public static LocalDateTime minus(LocalDateTime dateTime, long number, ChronoUnit field) {
    return dateTime.minus(number, field);
  }

  /**
   * 获取两个日期的差
   *
   * @param startDateTime 开始时间
   * @param endDateTime   结束时间
   * @param field         单位
   * @return 两个日期之间的差值
   */
  public static long between(LocalDateTime startDateTime, LocalDateTime endDateTime, ChronoUnit field) {
    Period period = Period.between(LocalDate.from(startDateTime), LocalDate.from(endDateTime));
    if (field == ChronoUnit.YEARS) return period.getYears();
    if (field == ChronoUnit.MONTHS) return period.getYears() * 12 + period.getMonths();
    return field.between(startDateTime, endDateTime);
  }

  /**
   * 获取某天的开始时间，例如：yyyy,MM,dd 00:00
   *
   * @param dateTime 某天的日期时间
   * @return 某天的开始时间
   */
  public static LocalDateTime getDayStart(LocalDateTime dateTime) {
    return dateTime.withHour(0)
        .withMinute(0)
        .withSecond(0)
        .withNano(0);
  }

  /**
   * 获取某天的结束时间，例如：yyy,MM,dd 23:59:59
   *
   * @param dateTime 某天的日期时间
   * @return 某天的结束时间
   */
  public static LocalDateTime getDayEnd(LocalDateTime dateTime) {
    return dateTime.withHour(23)
        .withMinute(59)
        .withSecond(59);
  }

  public static void main(String[] args) {
    LocalDateTime d1 = LocalDateTime.now();
    LocalDateTime d2 = plus(d1, 1, ChronoUnit.DAYS);
    LocalDateTime d3 = minus(d1, 1, ChronoUnit.DAYS);

    System.out.println(d1);
    System.out.println(d2);
    System.out.println(d3);

    System.out.println(isBefore(d3, d1));
    System.out.println(isEqual(d1, d2));
    System.out.println(isAfter(d2, d1));

    System.out.println(formatTime(d1, "yyyy-MM-dd HH:mm:ss"));
    System.out.println(formatNow("yyyy-MM-dd HH:mm:ss"));

    System.out.println(getDayStart(d1));
    System.out.println(getDayEnd(d1));

    System.out.println(between(d1, d2, ChronoUnit.DAYS));

    System.out.println(getMilliByTime(d1));
    System.out.println(getSecondsByTime(d1));
  }
}
