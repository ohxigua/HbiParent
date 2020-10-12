package hbi.core.db.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class test {
    public static void main(String[] args) {
        ArrayList<String> fetureDaysList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            fetureDaysList.add(getFetureDate(getFirstDayOfWeek(2020,31),i));
        }
    }

    /**
     * 得到某年某周的第一天
     * @param year
     * @param week
     * @return
     */
    public static Date getFirstDayOfWeek(int year, int week) {
    Calendar c = Calendar.getInstance();
    c.clear();
    c.setFirstDayOfWeek(Calendar.SATURDAY);
    c.setWeekDate(year,week,Calendar.SATURDAY);
    c.getTime();
    Calendar cal = (GregorianCalendar) c.clone();
    cal.add(Calendar.DATE, 7);
    return cal.getTime();
    }


    /**
     * 获取未来 第 past 天的日期
     * @param past
     * @return
     */
    public static String getFetureDate(Date date, int past) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH,+ past);
        cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(cal.getTime());
        System.out.println(result);
        return result;

    }
}
