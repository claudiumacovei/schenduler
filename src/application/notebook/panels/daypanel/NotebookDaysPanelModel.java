package application.notebook.panels.daypanel;

import static application.notebook.utils.NotebookDay.FRIDAY;
import static application.notebook.utils.NotebookDay.MONDAY;
import static application.notebook.utils.NotebookDay.SATURDAY;
import static application.notebook.utils.NotebookDay.SUNDAY;
import static application.notebook.utils.NotebookDay.THURSDAY;
import static application.notebook.utils.NotebookDay.TUESDAY;
import static application.notebook.utils.NotebookDay.WEDNESDAY;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;

import application.notebook.panels._abstract.AbstractPanelModel;
import application.notebook.utils.NotebookDay;

public class NotebookDaysPanelModel extends AbstractPanelModel {
    
    public NotebookDaysPanelModel(Logger logger) {
    
        super(logger);
        if (isMondayFirstDayOfWeek() == true) {
            weekDaysMap.put(0, MONDAY);
            weekDaysMap.put(1, TUESDAY);
            weekDaysMap.put(2, WEDNESDAY);
            weekDaysMap.put(3, THURSDAY);
            weekDaysMap.put(4, FRIDAY);
            weekDaysMap.put(5, SATURDAY);
            weekDaysMap.put(6, SUNDAY);
        } else {
            weekDaysMap.put(0, SUNDAY);
            weekDaysMap.put(1, MONDAY);
            weekDaysMap.put(2, TUESDAY);
            weekDaysMap.put(3, WEDNESDAY);
            weekDaysMap.put(4, THURSDAY);
            weekDaysMap.put(5, FRIDAY);
            weekDaysMap.put(6, SATURDAY);
        }
    }
    private static Map<Integer, NotebookDay> weekDaysMap = new HashMap<Integer, NotebookDay>();
    
    @Override
    public void setIsMondayFirstDayOfWeek(Boolean isMondayFirstDayOfWeek) {
    
        if (isMondayFirstDayOfWeek == true) {
            weekDaysMap.put(0, MONDAY);
            weekDaysMap.put(1, TUESDAY);
            weekDaysMap.put(2, WEDNESDAY);
            weekDaysMap.put(3, THURSDAY);
            weekDaysMap.put(4, FRIDAY);
            weekDaysMap.put(5, SATURDAY);
            weekDaysMap.put(6, SUNDAY);
        } else {
            weekDaysMap.put(0, SUNDAY);
            weekDaysMap.put(1, MONDAY);
            weekDaysMap.put(2, TUESDAY);
            weekDaysMap.put(3, WEDNESDAY);
            weekDaysMap.put(4, THURSDAY);
            weekDaysMap.put(5, FRIDAY);
            weekDaysMap.put(6, SATURDAY);
        }
        super.setIsMondayFirstDayOfWeek(isMondayFirstDayOfWeek);
    }
    
    private Integer getDayNumber(int value) {
    
        for (Entry<Integer, NotebookDay> entry : weekDaysMap.entrySet()) {
            if (entry.getValue().getCalendarDay().equals(value))
                return entry.getKey();
        }
        
        return null;
    }
    
    private String getDayNumber(int i, int j) {
    
        Integer dayNumber = getDayNumber(getCalendar().getDayOfWeek());
        
        return String.valueOf(getCalendar().addUnitsToDate(getCalendar().getTime(), Calendar.DAY_OF_YEAR, (7 - dayNumber) + (i - 1) * 7 + j).get(Calendar.DAY_OF_MONTH));
    }
    
    public NotebookDayButton getDayButton(int i, int j) {
    
        return new NotebookDayButton(getCalendar().getTime()).setButtonText(getDayNumber(i, j));
    }
}
