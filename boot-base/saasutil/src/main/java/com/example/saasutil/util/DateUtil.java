package com.example.saasutil.util;

import com.example.saasutil.enums.DateFinalFormat;
import com.example.saasutil.enums.YesOrNo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.util.StringUtils;

public class DateUtil {

    public static final String DEFAULT_FORMAT = "yyyyMMddHHmmss";
    public static final String SHORT_FORMAT = "yyyyMMdd";
    public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";


    /**
     * 将字符串转化为DATE
     *
     * @param dtFormat 格式yyyy-MM-dd HH:mm:ss 或 yyyy-MM-dd或 yyyy-M-dd或 yyyy-M-d或
     *                 yyyy-MM-d或 yyyy-M-dd
     * @return
     */
    public static Date fmtStrToDate(String dtFormat) {
        if (dtFormat == null) {
            return null;
        }
        try {
            if (dtFormat.length() == 9 || dtFormat.length() == 8) {
                String[] dateStr = dtFormat.split("-");
                dtFormat = dateStr[0] + (dateStr[1].length() == 1 ? "-0" : "-")
                        + dateStr[1] + (dateStr[2].length() == 1 ? "-0" : "-")
                        + dateStr[2];
            }
            if (dtFormat.length() != 10 & dtFormat.length() != 19)
                return null;
            if (dtFormat.length() == 10)
                dtFormat = dtFormat + " 00:00:00";
            SimpleDateFormat dateFormat = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss");
            return dateFormat.parse(dtFormat);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Description:格式化日期,如果格式化失败返回def
     *
     * @param dtFormat
     * @param def
     * @return
     * @since：2008-2-15 下午05:01:37
     */
    public static Date fmtStrToDate(String dtFormat, Date def) {
        Date d = fmtStrToDate(dtFormat);
        if (d == null)
            return def;
        return d;
    }

    /**
     * 返回当日短日期型
     *
     * @return
     * @since：2008-2-15 下午05:03:13
     */
    public static Date getToDay() {
        return toShortDate(new Date());
    }

    /**
     * Description:格式化日期,String字符串转化为Date
     *
     * @param date
     * @param dtFormat 例如:yyyy-MM-dd HH:mm:ss yyyyMMdd
     * @return
     * @since：2007-7-10 上午11:24:00
     */
    public static String fmtDateToStr(Date date, String dtFormat) {
        if (date == null)
            return "";
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(dtFormat);
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Description:按指定格式 格式化日期
     *
     * @param date
     * @param dtFormat
     * @return
     * @since：2007-12-10 上午11:25:07
     */
    public static Date fmtStrToDate(String date, String dtFormat) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(dtFormat);
            return dateFormat.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String fmtDateToYMDHM(Date date) {
        return fmtDateToStr(date, "yyyy-MM-dd HH:mm");
    }

    public static String fmtDateToYMDHMSS(Date date) {
        return fmtDateToStr(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String fmtDateToYMD(Date date) {
        return fmtDateToStr(date, "yyyy-MM-dd");
    }

    public static String fmtDateToYM(Date date) {
        return fmtDateToStr(date, "yyyy-MM");
    }


    public static String fmtDateToMD(Date date) {
        return fmtDateToStr(date, "MM-dd");
    }

    public static String fmtDateToM(Date date) {
        return fmtDateToStr(date, "MM");
    }

    /**
     * Description:只保留日期中的年月日
     *
     * @param date
     * @return
     * @since：2007-12-10 上午11:25:50
     */
    public static Date toShortDate(Date date) {
        String strD = fmtDateToStr(date, "yyyy-MM-dd");
        return fmtStrToDate(strD);
    }

    /**
     * Description:只保留日期中的年月日
     *
     * @param date 格式要求yyyy -MM-dd……………………
     * @return
     * @since：2007-12-10 上午11:26:12
     */
    public static Date toShortDate(String date) {
        if (date != null && date.length() >= 10) {
            return fmtStrToDate(date.substring(0, 10));
        } else
            return fmtStrToDate(date);
    }

    /**
     * 求对日
     *
     * @param countMonth :月份的个数(几个月)
     * @param before     :true 求前countMonth个月的对日:false 求下countMonth个月的对日
     * @return
     */
    public static Date getCounterglow(int countMonth, boolean before) {
        Calendar ca = Calendar.getInstance();
        return getCounterglow(ca.getTime(), before ? -countMonth : countMonth);
    }

    /**
     * Description: 求对日 加月用+ 减月用-
     *
     * @param date
     * @param num
     * @return
     * @since：2007-12-13 下午03:16:47
     */
    public static Date getCounterglow(Date date, int num) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.MONTH, num);
        return ca.getTime();
    }

    /**
     * 获得查询起时间 如：2014-10-22 00:00:00
     *
     * @param date
     * @return
     */
    public static Date getStartDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获得查询止时间 如：2014-10-22 23:59:59
     *
     * @param date
     * @return
     */
    public static Date getEndDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * Description:加一天
     *
     * @param date
     * @return
     * @since：2007-12-13 下午02:57:38
     */
    public static Date addDay(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.add(Calendar.DAY_OF_YEAR, 1);
        return cd.getTime();
    }

    /**
     * Description:判断一个日期是否为工作日(非周六周日)
     *
     * @param date
     * @return
     * @since：2007-12-13 下午03:01:35
     */
    public static boolean isWorkDay(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek != Calendar.SUNDAY || dayOfWeek != Calendar.SATURDAY)
            return false;
        return true;
    }

    /**
     * 获取带星期的日期
     *
     * @param date
     * @return
     */
    public static String getSimpByDate(Date date, String dtFormat) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
        StringBuffer sb = new StringBuffer();
        sb.append(DateUtil.fmtDateToStr(date, dtFormat).trim());
        sb.append(" ");
        switch (dayOfWeek) {
            case Calendar.MONDAY:
                sb.append("星期一");
                break;
            case Calendar.TUESDAY:
                sb.append("星期二");
                break;
            case Calendar.WEDNESDAY:
                sb.append("星期三");
                break;
            case Calendar.THURSDAY:
                sb.append("星期四");
                break;
            case Calendar.FRIDAY:
                sb.append("星期五");
                break;
            case Calendar.SATURDAY:
                sb.append("星期六");
                break;
            case Calendar.SUNDAY:
                sb.append("星期日");
                break;
        }
        String d = sb.toString().trim();
        return d;
    }

    /**
     * Description:取一个月的最后一天
     *
     * @param date1
     * @return
     * @since：2007-12-13 下午03:28:21
     */
    public static Date getLastDayOfMonth(Date date1) {
        Calendar date = Calendar.getInstance();
        date.setTime(date1);
        date.set(Calendar.DAY_OF_MONTH, 1);
        date.add(Calendar.MONTH, 1);
        date.add(Calendar.DAY_OF_YEAR, -1);
        return toShortDate(date.getTime());
    }

    /**
     * 求开始截至日期之间的天数差.
     * 非绝对值
     *
     * @param start 开始日期
     * @param end   截至日期
     * @return 返回相差天数
     * @throws ParseException
     */
    public static int getDaysIntervalWithoutAbs(Date start, Date end) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d1 = sdf.parse(sdf.format(start));
            Date d2 = sdf.parse(sdf.format(end));
            if (d1 == null || d2 == null)
                return 0;
            Date[] d = new Date[2];
            d[0] = d1;
            d[1] = d2;
            Calendar[] cal = new Calendar[2];
            for (int i = 0; i < cal.length; i++) {
                cal[i] = Calendar.getInstance();
                cal[i].setTime(d[i]);
                cal[i].set(Calendar.HOUR_OF_DAY, 0);
                cal[i].set(Calendar.MINUTE, 0);
                cal[i].set(Calendar.SECOND, 0);
            }
            long m = cal[0].getTime().getTime();
            long n = cal[1].getTime().getTime();

            int ret = (int) ((n - m) / 1000 / 3600 / 24);
            return ret;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 求开始截至日期之间的天数差.
     * 绝对值
     *
     * @param start 开始日期
     * @param end   截至日期
     * @return 返回相差天数
     * @throws ParseException
     */
    public static int getDaysInterval(Date start, Date end) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse(sdf.format(start));
        Date d2 = sdf.parse(sdf.format(end));
        if (d1 == null || d2 == null)
            return 0;
        Date[] d = new Date[2];
        d[0] = d1;
        d[1] = d2;
        Calendar[] cal = new Calendar[2];
        for (int i = 0; i < cal.length; i++) {
            cal[i] = Calendar.getInstance();
            cal[i].setTime(d[i]);
            cal[i].set(Calendar.HOUR_OF_DAY, 0);
            cal[i].set(Calendar.MINUTE, 0);
            cal[i].set(Calendar.SECOND, 0);
        }
        long m = cal[0].getTime().getTime();
        long n = cal[1].getTime().getTime();

        int ret = (int) Math.abs((m - n) / 1000 / 3600 / 24);
        return ret;
    }

    /**
     * 求开始截至日期之间的天数差.按每月30天计算,注：2月份按28天(平年),29天(润年)
     *
     * @param d1 开始日期
     * @param d2 截至日期
     * @return 返回相差天数
     * @throws ParseException
     */
    public static int getDaysIntervalWithThirty(Date d1, Date d2) throws ParseException {
        // int year = Integer.parseInt(fmtDateToStr(d2,"yyyy"));
        int mounthD1 = Integer.parseInt(fmtDateToM(d1));
        int mounthD2 = Integer.parseInt(fmtDateToM(d2));
        int days = getDaysInterval(d1, d2);

        if ((mounthD2 == 1 || mounthD2 == 3 || mounthD2 == 5 || mounthD2 == 7
                || mounthD2 == 8 || mounthD2 == 10 || mounthD2 == 12)
                && mounthD1 != mounthD2) {
            days = days - 1;
        }
        return days;
    }

    public static String getDayOfWeek(Date date) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        return "周" + toChNumber(cl.get(Calendar.DAY_OF_WEEK) - 1);
    }

    /**
     * 将数字转为中文。 "0123456789"->"〇一二三四五六七八九"
     *
     * @param num 长度为1,'0'-'9'的字符串
     * @return
     */
    private static String toChNumber(int num) {
        final String str = "〇一二三四五六七八九";
        return str.substring(num, num + 1);
    }

    /**
     * Description:指定日期加或减days天
     *
     * @param date1 日期
     * @param days  天数
     * @return
     * @since：2007-12-17 下午03:47:12
     */
    public static Date addDay(Date date1, int days) {
        Calendar date = Calendar.getInstance();
        date.setTime(date1);
        date.add(Calendar.DAY_OF_YEAR, days);
        return date.getTime();
    }

    /**
     * Description:指定日期加或减hours小时
     *
     * @param date  日期
     * @param hours 小时数
     * @return
     */
    public static Date addHour(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    /**
     * Description:指定日期加或减分钟
     *
     * @param date1 日期
     * @param mins  秒数
     * @return
     * @since：2007-12-17 下午03:47:12
     */
    public static Date addMins(Date date1, int mins) {
        Calendar date = Calendar.getInstance();
        date.setTime(date1);
        date.add(Calendar.MINUTE, mins);
        return date.getTime();
    }

    /**
     * Description:指定日期加或减months月
     *
     * @param date1
     * @param months
     * @return
     * @since：2008-3-5 下午05:17:26
     */
    public static Date addMonth(Date date1, int months) {
        Calendar date = Calendar.getInstance();
        date.setTime(date1);
        date.add(Calendar.MONTH, months);
        return date.getTime();
    }

    /**
     * Description:指定日期加或减years年
     *
     * @param date1
     * @param years
     * @return
     */
    public static Date addYear(Date date1, int years) {
        Calendar date = Calendar.getInstance();
        date.setTime(date1);
        date.add(Calendar.YEAR, years);
        return date.getTime();
    }

    /**
     * 指定期间的开始日期
     *
     * @param date 指定日期
     * @param type 期间类型
     * @param diff 与指定日期的范围
     * @return
     */
    public static Date getPeriodStart(Calendar date, int type, int diff) {
        date.add(type, diff * (-1));
        return date.getTime();
    }

    /**
     * 指定期间的开始日期
     *
     * @param date 指定日期
     * @param type 期间类型
     * @param diff 与指定日期的范围
     * @return
     */
    public static Date getPeriodStart(Date date, int type, int diff) {
        return getPeriodStart(dateToCalendar(date), type, diff);
    }

    /**
     * 指定期间的结束日期
     *
     * @param date 指定日期
     * @param type 期间类型
     * @param diff 与指定日期的范围
     * @return
     */
    public static Date getPeriodEnd(Calendar date, int type, int diff) {
        date.add(type, diff);
        return date.getTime();
    }

    /**
     * 指定期间的结束日期
     *
     * @param date 指定日期
     * @param type 期间类型
     * @param diff 与指定日期的范围
     * @return
     */
    public static Date getPeriodEnd(Date date, int type, int diff) {
        return getPeriodEnd(dateToCalendar(date), type, diff);
    }

    /**
     * 指定日期所在星期的第一天
     *
     * @param date
     * @return
     */
    public static Date getWeekStart(Date date) {
        Calendar cdate = dateToCalendar(date);
        cdate.set(Calendar.DAY_OF_WEEK, 2);
        return cdate.getTime();
    }

    /**
     * 将java.util.Date类型转换成java.util.Calendar类型
     *
     * @param date
     * @return
     */
    public static Calendar dateToCalendar(Date date) {
        Calendar cdate = Calendar.getInstance();
        cdate.setTime(date);
        return cdate;
    }

    /**
     * 指定日期所在月的第一天
     *
     * @param date
     * @return
     */
    public static Date getMonthStart(Date date) {
        Calendar cdate = dateToCalendar(date);
        cdate.set(Calendar.DAY_OF_MONTH, 1);
        return toShortDate(cdate.getTime());
    }

    /**
     * 指定日期所在上月的第一天
     *
     * @param date
     * @return
     */
    public static Date getLastMonthStart(Date date) {
        Calendar cdate = dateToCalendar(date);
        cdate.set(Calendar.DAY_OF_MONTH, 1);
        cdate.add(Calendar.MONTH, -1);
        return toShortDate(cdate.getTime());
    }

    /**
     * 指定日期所在旬的第一天
     *
     * @param date
     * @return
     */
    public static Date getTenDaysStart(Date date) {
        Calendar cdate = dateToCalendar(date);
        int day = cdate.get(Calendar.DAY_OF_MONTH) / 10 * 10 + 1;
        if (cdate.get(Calendar.DAY_OF_MONTH) % 10 == 0 || day == 31)
            day = day - 10;
        cdate.set(Calendar.DAY_OF_MONTH, day);
        return cdate.getTime();
    }

    /**
     * 指定日期所在旬的最后一天
     *
     * @param date
     * @return
     */
    public static Date getTenDaysEnd(Date date) {
        Calendar cdate = dateToCalendar(date);
        if (cdate.get(Calendar.DAY_OF_MONTH) / 10 == 2
                && cdate.get(Calendar.DAY_OF_MONTH) != 20)
            return getLastDayOfMonth(date);
        else
            return addDay(getTenDaysStart(addDay(date, 10)), -1);
    }

    /**
     * 指定日期所在年的第一天
     *
     * @param date
     * @return
     */
    public static Date getYearStart(Date date) {
        Calendar cdate = dateToCalendar(date);
        cdate.set(Calendar.DAY_OF_YEAR, 1);
        return cdate.getTime();
    }

    /**
     * 所在年最后一天
     * @param date
     * @return
     */
    public static Date getYearEnd(Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
        cal.set(Calendar.DAY_OF_YEAR, last);
        return cal.getTime();
    }


    /**
     * 指定日期所在季度的第一天
     *
     * @param date
     * @return
     */
    public static Date getQuarterStart(Date date) {
        Calendar cdate = dateToCalendar(date);
        int month = (cdate.get(Calendar.MONTH) / 3) * 3;
        cdate.set(Calendar.MONTH, month);
        return getMonthStart(cdate.getTime());
    }

    /**
     * 指定日期返回带中文的字符串（目前为年月日类型，之后补充）
     *
     * @param date
     * @param format
     * @return
     */
    public static String dateToStringByChinese(String format, Date date) {
        String dateString = fmtDateToStr(date, format);
        String[] dateStringArray = dateString.split("-");
        if ("yyyy-MM-dd".equals(format)) {
            dateString = dateStringArray[0] + "年" + dateStringArray[1] + "月"
                    + dateStringArray[2] + "日";
        } else if ("yyyy-MM".equals(format)) {
            dateString = dateStringArray[0] + "年" + dateStringArray[1] + "月";
        }
        return dateString;
    }

    public static Date getLastDayOfYear(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        String years = dateFormat.format(date);
        years += "-12-31";
        Date returnDate = fmtStrToDate(years);
        return toShortDate(returnDate);
    }

    /**
     * 计算两个日期之间相差的月数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getMonths(Date date1, Date date2) {
        int iMonth = 0;
        int flag = 0;
        try {
            Calendar objCalendarDate1 = Calendar.getInstance();
            objCalendarDate1.setTime(date1);

            Calendar objCalendarDate2 = Calendar.getInstance();
            objCalendarDate2.setTime(date2);

            if (objCalendarDate2.equals(objCalendarDate1))
                return 0;
            if (objCalendarDate1.after(objCalendarDate2)) {
                Calendar temp = objCalendarDate1;
                objCalendarDate1 = objCalendarDate2;
                objCalendarDate2 = temp;
            }
            if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1.get(Calendar.DAY_OF_MONTH))
                flag = 1;

            if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1.get(Calendar.YEAR))
                iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1.get(Calendar.YEAR)) * 12 + objCalendarDate2.get(Calendar.MONTH) - flag) - objCalendarDate1.get(Calendar.MONTH);
            else
                iMonth = objCalendarDate2.get(Calendar.MONTH) - objCalendarDate1.get(Calendar.MONTH) - flag;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iMonth;
    }

    /**
     * 指定日期上一个旬的第一天
     */
    public static Date getLastTenStartDate(Date date) {
        Date returnDate = DateUtil.toShortDate(date);
        returnDate = DateUtil.getTenDaysStart(date);
        returnDate = DateUtil.addDay(returnDate, -1);
        returnDate = DateUtil.getTenDaysStart(returnDate);
        return DateUtil.toShortDate(returnDate);
    }

    /**
     * 指定日期上一个旬的最后一天
     */
    public static Date getLastTenEndDate(Date date) {
        Date returnDate = DateUtil.toShortDate(date);
        returnDate = DateUtil.getTenDaysStart(date);
        returnDate = DateUtil.addDay(returnDate, -1);
        return DateUtil.toShortDate(returnDate);
    }

    /**
     * 指定日期上个月第一天
     */
    public static Date getLastMonthStartDate(Date date) {
        Date returnDate = DateUtil.toShortDate(date);
        returnDate = DateUtil.getLastMonthStart(date);
        return DateUtil.toShortDate(returnDate);
    }

    /**
     * 指定日期上个月最后一天
     */
    public static Date getLastMonthEndDate(Date date) {
        Date returnDate = DateUtil.toShortDate(date);
        returnDate = DateUtil.getMonthStart(date);
        returnDate = DateUtil.addDay(returnDate, -1);
        return DateUtil.toShortDate(returnDate);
    }

    public static String getLongStrFromDate(Date date) {
        if (date == null) {
            return null;
        }
        long timeLong = date.getTime();
        return String.valueOf(timeLong);
    }

    /**
     * 文章和系统记录查询使用的日期格式转换 统一查询时间段的起始为00:00:00
     *
     * @param dtFormat
     * @return
     */
    public static Date fmtStrToDateForBegin(String dtFormat) {
        if (dtFormat == null) {
            return null;
        }
        try {
            if (dtFormat.length() == 9 || dtFormat.length() == 8) {
                String[] dateStr = dtFormat.split("-");
                dtFormat = dateStr[0] + (dateStr[1].length() == 1 ? "-0" : "-")
                        + dateStr[1] + (dateStr[2].length() == 1 ? "-0" : "-")
                        + dateStr[2];
            }
            if (dtFormat.length() != 10 & dtFormat.length() != 19)
                return null;
            if (dtFormat.length() == 10)
                dtFormat = dtFormat + " 00:00:00";
            SimpleDateFormat dateFormat = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss");
            return dateFormat.parse(dtFormat);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 文章和系统记录查询使用的日期格式转换 统一查询时间段的结束为23:59:59
     *
     * @param dtFormat
     * @return
     */
    public static Date fmtStrToDateForEnd(String dtFormat) {
        if (dtFormat == null) {
            return null;
        }
        try {
            if (dtFormat.length() == 9 || dtFormat.length() == 8) {
                String[] dateStr = dtFormat.split("-");
                dtFormat = dateStr[0] + (dateStr[1].length() == 1 ? "-0" : "-")
                        + dateStr[1] + (dateStr[2].length() == 1 ? "-0" : "-")
                        + dateStr[2];
            }
            if (dtFormat.length() != 10 & dtFormat.length() != 19) {
                return null;
            }
            if (dtFormat.length() == 10) {
                dtFormat = dtFormat + " 23:59:59";
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss");
            return dateFormat.parse(dtFormat);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            smdate = sdf.parse(sdf.format(smdate));
            bdate = sdf.parse(sdf.format(bdate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(smdate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(bdate);
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);
            return Integer.parseInt(String.valueOf(between_days));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 计算传入日期和当前时间的差值 返回单位 秒S
     *
     * @param smdate
     * @return 秒
     */
    public static long daysTurnSecond(Date smdate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date bdate = new Date();
        long time3;
        try {
            smdate = sdf.parse(sdf.format(smdate));
            bdate = sdf.parse(sdf.format(bdate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(smdate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(bdate);
            long time2 = cal.getTimeInMillis();
            time3 = (time1 - time2) / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
        return time3;
    }

    /**
     * 转化锁定日期 例：60 --> 2个月
     *
     * @param days 天数
     * @return
     */
    public static String convertPeriod(int days) {
        if (days <= 30) {
            return days + "天";
        }
        if (days < 365) {
            int i = days % 30;
            if (i == 0) {
                return (days / 30) + "个月";
            } else {
                return (days / 30) + "个月零" + i + "天";
            }
        }
        int j = days % 365;
        if (j == 0) {
            return ((days / 365) * 12) + "个月";
        }
        int k = j % 30;
        if (k == 0) {
            return ((days / 365) * 12 + j / 30) + "个月";
        }
        return ((days / 365) * 12 + j / 30) + "个月零" + k + "天";

    }

    /**
     * 获取前月的第一天开始时间 例如  2015-10-01 00:00:00
     *
     * @return
     */
    public static Date getStartMonth() {
        Calendar cale = null;
        // 获取前月的第一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        cale.set(Calendar.HOUR_OF_DAY, 0);
        cale.set(Calendar.MINUTE, 0);
        cale.set(Calendar.SECOND, 0);
        cale.set(Calendar.MILLISECOND, 0);
        return cale.getTime();
    }

    /**
     * 获取前月的最后一天结束时间 例如  2015-10-31 23:59:59
     *
     * @return
     */
    public static Date getEndMonth() {
        Calendar cale = null;
        // 获取前月的最后一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        cale.set(Calendar.HOUR_OF_DAY, 23);
        cale.set(Calendar.MINUTE, 59);
        cale.set(Calendar.SECOND, 59);
        cale.set(Calendar.MILLISECOND, 999);
        return cale.getTime();
    }

    /**
     * 根据日期字符串进行美化
     *
     * @param date 日期字符串，格式：yyyyMMdd 或 yyyyMMddHHmmss
     * @param flag 转换样式，0代表转换成yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss
     *             1代表转换成yyyy年MM月dd日 或 yyyy年MM月dd日 HH时mm分ss秒
     * @return
     */
    public static String getConvertStr(String date, String flag) {
        String time = null;
        StringBuffer sb = new StringBuffer();
        if (StringUtils.hasText(date) && StringUtils.hasText(flag)) {
            date = date.trim();
            if (date.length() == 8) {
                /**    传过来的日期格式为yyyyMMdd*/
                if ("0".equals(flag)) {
                    /**    需要生成的格式为：yyyy-MM-dd*/
                    sb.append(date.substring(0, 4)).append("-").append(date.substring(4, 6)).append("-").append(date.substring(date.length() - 2, date.length()));
                    time = sb.toString();
                } else if ("1".equals(flag)) {
                    /**    需要生成的格式为：yyyy年MM月dd日*/
                    sb.append(date.substring(0, 4)).append("年").append(date.substring(4, 6)).append("月").append(date.substring(date.length() - 2, date.length())).append("日");
                    time = sb.toString();
                }
                return time;
            } else if (date.length() == 14) {
                /**    传过来的日期格式为yyyyMMddHHmmss*/
                if ("0".equals(flag)) {
                    /**    需要生成的格式为：yyyy-MM-dd HH:mm:ss*/
                    sb.append(date.substring(0, 4)).append("-").append(date.substring(4, 6)).append("-").append(date.substring(6, 8)).append(" ").append(date.substring(8, 10)).append(":").append(date.substring(10, 12)).append(":").append(date.substring(12, 14));
                    time = sb.toString();

                } else if ("1".equals(flag)) {
                    /**    需要生成的格式为：yyyy年MM月dd日 HH时mm分ss秒*/
                    sb.append(date.substring(0, 4)).append("年").append(date.substring(4, 6)).append("月").append(date.substring(6, 8)).append("日 ").append(date.substring(8, 10)).append("时").append(date.substring(10, 12)).append("分").append(date.substring(12, 14)).append("秒");
                    time = sb.toString();
                }
                return time;
            } else {
                return null;
            }
        }
        return null;
    }

    /**
     * @param date1 早期日期
     * @param date2 晚期日期
     * @return
     */
    public static int getDateBetweenHours(Date date1, Date date2) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;

        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = date2.getTime() - date1.getTime();
        // 计算差多少天
        //long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        //long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;

        return (int) hour;
    }

    /**
     * @param date1 早期日期
     * @param date2 晚期日期
     * @return
     */
    public static int getDateBetweenMint(Date date1, Date date2) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;

        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = date2.getTime() - date1.getTime();
        // 计算差多少天
        //long day = diff / nd;
        // 计算差多少小时
        //long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;

        return (int) min;
    }

    /**
     * @param date1 早期日期
     * @param date2 晚期日期
     * @return
     */
    public static int getDateBetweenSec(Date date1, Date date2) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;

         long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = date2.getTime() - date1.getTime();
        // 计算差多少天
        //long day = diff / nd;
        // 计算差多少小时
        //long hour = diff % nd / nh;
        // 计算差多少分钟
//        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
         long sec = diff % nd % nh % nm / ns;

        return (int) sec;
    }

    /**
     * 计算月份差
     *
     * @param firstDate
     * @param secDate
     * @return
     */
    public static int monthBetween(Date firstDate, Date secDate) {
        SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM");
        String firstStr = smt.format(firstDate);
        String secStr = smt.format(secDate);

        Integer fYear = Integer.valueOf(firstStr.split("-")[0]);
        Integer fMonth = Integer.valueOf(firstStr.split("-")[1]);
        Integer sYear = Integer.valueOf(secStr.split("-")[0]);
        Integer sMonth = Integer.valueOf(secStr.split("-")[1]);

        return (fYear - sYear) * 12 + (fMonth - sMonth);
    }


    public static Date getBeginDateStr(String dateStr) {
        Date date = DateUtil.fmtStrToDate(dateStr, "yyyy-MM-dd");
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);
        return now.getTime();
    }

    public static Date getEndDateStr(String dateStr) {
        Date date = DateUtil.fmtStrToDate(dateStr, "yyyy-MM-dd");
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.HOUR_OF_DAY, 23);
        now.set(Calendar.MINUTE, 59);
        now.set(Calendar.SECOND, 59);
        now.set(Calendar.MILLISECOND, 999);
        return now.getTime();
    }

    public static String getStartDateByMounth(){
        return fmtDateToYMDHM(getStartMonth());
    }

    public static String getEndDateByMounth(){
        return fmtDateToYMDHM(getEndMonth());
    }

    public static String getStartMounth(Date date){
        return fmtDateToYMDHM(getStartDate(getMonthStart(date)));
    }

    public static String getEndMounth(Date date){
        return fmtDateToYMDHM(getEndDate(getLastDayOfMonth(date)));
    }

    public static String getStartYear(Date date){
        return fmtDateToYMDHM(getStartDate(getYearStart(date)));
    }

    public static String getEndYear(Date date){
        return fmtDateToYMDHM(getEndDate(getYearEnd(date)));
    }

    public static Date getDateByOpertion(String type, Integer year, Integer month) {
        Calendar cal = Calendar.getInstance();
        if (StringUtils.hasText(type) && YesOrNo.YES.getValue().equals(type)) {
            //如果月份为空展示全年数据
            cal.set(Calendar.YEAR, year);
            if (month != null) {
                cal.set(Calendar.MONTH, month - 1);
            }
        } else {
            //如果月份为空查询当前月
            if (month != null) {
                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, month - 1);
            }
        }
        return cal.getTime();
    }


    /**
     * 新规则
     * @param date1
     * @param days
     * @return
     */
    public static Date addDays(Date date1, int days) {
        Calendar date = Calendar.getInstance();
        date.setTime(date1);
        date.add(Calendar.DAY_OF_YEAR, days-1);
        return date.getTime();
    }

    public static String fmtDateToYMDHMS(Date date) {
        return fmtDateToStr(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String fmtDateToUnsigned(Date date) {
        return fmtDateToStr(date, "yyyyMMddHHmmss");
    }

    /**
     * 是否无符号时间字符串
     * @return
     */
    public static boolean isUnsignedDate(String dateStr) {
        return dateStr.length() == 8 || dateStr.length() == 14;
    }

    public static String diyFormat(String dateStr) {
        if (isUnsignedDate(dateStr)) {
            return getConvertStr(dateStr, "0");
        } else {
            Date TenderDate = DateUtil.fmtStrToDate(dateStr);
            return DateUtil.fmtDateToStr(TenderDate,
                DateFinalFormat.YYYY_MM_dd_HH_mm_ss.getCode());
        }
    }

    /**
    * @Description: 返回当前时间 str
    * @Param: []
    * @return:
    * @Author: hushenggui
    * @Date: 2021-09-09
    */
    public static String nowDayStr(String pattern){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return now.format(dateTimeFormatter);
    }


    /**
     * 转换为中文的起止日期
     * @param start
     * @param end
     * @return
     */
    public static String convertStartAndEndZhData(String start, String end) {
        String startDate = DateUtil.getConvertStr(start, "1");
        String endDate = DateUtil.getConvertStr(end, "1");
        return startDate + "至" + endDate;
    }


    public static void main(String[] args) {
        String dateStr = "2019-05-22 14:28:30";
//        String dateStr = "20190522142830";
        System.out.println(diyFormat(dateStr));
    }
}
