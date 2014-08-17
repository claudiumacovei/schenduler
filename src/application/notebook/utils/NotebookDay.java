package application.notebook.utils;

import java.util.Calendar;

public enum NotebookDay {
    MONDAY(Calendar.MONDAY, "Monday"), //
    TUESDAY(Calendar.TUESDAY, "Tuesday"), //
    WEDNESDAY(Calendar.WEDNESDAY, "Wednesday"), //
    THURSDAY(Calendar.THURSDAY, "Thursday"), //
    FRIDAY(Calendar.FRIDAY, "Friday"), //
    SATURDAY(Calendar.SATURDAY, "Saturday"), //
    SUNDAY(Calendar.SUNDAY, "Sunday");//
    
    private NotebookDay(Integer calendarDay, String dayName) {
    
        this.calendarDay = calendarDay;
        this.dayName = dayName;
    }
    Integer calendarDay;
    String dayName;
    
    public Integer getCalendarDay() {
    
        return calendarDay;
    }
    
    public String getDayName() {
    
        return dayName;
    }
    
    public void setCalendarDay(Integer calendarDay) {
    
        this.calendarDay = calendarDay;
    }
    
    public void setDayName(String dayName) {
    
        this.dayName = dayName;
    }
    
}
