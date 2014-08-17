package application.notebook.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotebookCalendar {
    static Calendar calendarS = Calendar.getInstance();
    Calendar calendar = Calendar.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(NotebookCalendar.class);
    
    public NotebookCalendar() {
    
    }
    
    public NotebookCalendar(Date time) {
    
        calendar.setTime(time);
    }
    
    public Date getTime() {
    
        return calendar.getTime();
    }
    
    public Integer getFirstWeekOfMonthNumber() {
    
        calendar.set(Calendar.WEEK_OF_MONTH, 1);
        return calendar.get(Calendar.WEEK_OF_YEAR);
        
    }
    
    public Integer getFirstDayOfFirstWeekOfMonth() {
    
        calendar.set(Calendar.WEEK_OF_MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }
    
    public Integer getCurrentWeekNumberInYear() {
    
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }
    
    public void setFirstDayOfWeek(int value) {
    
        calendar.setFirstDayOfWeek(value);
    }
    
    public Integer getDayOfWeek() {
    
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.clear(Calendar.MINUTE);
        calendar.clear(Calendar.SECOND);
        calendar.clear(Calendar.MILLISECOND);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        
        return calendar.get(Calendar.DAY_OF_WEEK);
    }
    
    public Integer getWeekOfMonth() {
    
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }
    
    public static void main(String[] args) throws Exception {
    
        calendarS.set(Calendar.HOUR_OF_DAY, 0);
        calendarS.clear(Calendar.MINUTE);
        calendarS.clear(Calendar.SECOND);
        calendarS.clear(Calendar.MILLISECOND);
        
        //        calendarS.set(Calendar.DAY_OF_MONTH, 1);
        //        logger.info("" + calendarS.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.ALL_STYLES, Locale.ENGLISH));
        //        logger.info("" + calendarS.get(Calendar.WEEK_OF_YEAR));
        //        logger.info("" + calendarS.get(Calendar.WEEK_OF_MONTH));
        //        calendarS.setFirstDayOfWeek(Calendar.MONDAY);
        //        logger.info("" + calendarS.get(Calendar.WEEK_OF_MONTH));
        //        logger.info("" + (calendarS.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY));
        logger.info(calendarS.getDisplayName(Calendar.MONTH, Calendar.ALL_STYLES, Locale.ENGLISH) + "\n" + calendarS.get(Calendar.YEAR));
    }
    
    public Calendar addUnitsToDate(Date time, int unit, int i) {
    
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime(time);
        localCalendar.add(unit, i);
        return localCalendar;
    }
    
    public String getCurrentMonthName() {
    
        return calendar.getDisplayName(Calendar.MONTH, Calendar.ALL_STYLES, Locale.ENGLISH);
    }
    
    public String getCurrentYear() {
    
        return String.valueOf(calendar.get(Calendar.YEAR));
    }
}
