package notebook;

import static notebook.utils.NotebookDay.FRIDAY;
import static notebook.utils.NotebookDay.MONDAY;
import static notebook.utils.NotebookDay.SATURDAY;
import static notebook.utils.NotebookDay.SUNDAY;
import static notebook.utils.NotebookDay.THURSDAY;
import static notebook.utils.NotebookDay.TUESDAY;
import static notebook.utils.NotebookDay.WEDNESDAY;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import notebook.abstractc.AbstractModel;
import notebook.swing.NotebookCurrentMonthPanel;
import notebook.swing.NotebookDaysNamePanel;
import notebook.swing.NotebookDaysPanel;
import notebook.swing.NotebookWeeksNumberPanel;
import notebook.utils.NotebookCalendar;
import notebook.utils.NotebookDay;

public class NotebookModel extends AbstractModel {
    private NotebookController controller = null;
    private String name = "MainApp";
    private boolean isMondayFirstDayOfWeek = true;
    private NotebookDaysNamePanel notebookDaysNamePanel = null;
    private NotebookDaysPanel notebookDaysPannel = null;
    private NotebookWeeksNumberPanel notebookWeeksNumberPannel = null;
    private NotebookCurrentMonthPanel notebookCurrentMonthPanel = null;
    private NotebookCalendar calendar = new NotebookCalendar();
    
    public NotebookModel(NotebookController controller) {
    
        this.controller = controller;
        notebookDaysNamePanel = new NotebookDaysNamePanel(this);
        notebookDaysPannel = new NotebookDaysPanel(this);
        notebookWeeksNumberPannel = new NotebookWeeksNumberPanel(this);
        notebookCurrentMonthPanel = new NotebookCurrentMonthPanel(this);
        if (isMondayFirstDayOfWeek)
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
        else
            calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        
    }
    
    public NotebookDaysPanel getNotebookDaysPannel() {
    
        return notebookDaysPannel;
    }
    
    public NotebookWeeksNumberPanel getNotebookWeeksNumberPannel() {
    
        return notebookWeeksNumberPannel;
    }
    
    public void setNotebookDaysPannel(NotebookDaysPanel notebookDaysPannel) {
    
        this.notebookDaysPannel = notebookDaysPannel;
    }
    
    public void setNotebookWeeksNumberPannel(NotebookWeeksNumberPanel notebookWeeksNumberPannel) {
    
        this.notebookWeeksNumberPannel = notebookWeeksNumberPannel;
    }
    
    public NotebookDaysNamePanel getNotebookDaysNamePanel() {
    
        return notebookDaysNamePanel;
    }
    
    public void setNotebookDaysNamePanel(NotebookDaysNamePanel notebookDaysNamePanel) {
    
        this.notebookDaysNamePanel = notebookDaysNamePanel;
    }
    
    public void setName(String name) {
    
        this.name = name;
    }
    
    public String getName() {
    
        return name;
    }
    
    private static Map<Integer, NotebookDay> weekDaysMap = new HashMap<Integer, NotebookDay>();
    static {
        weekDaysMap.put(0, MONDAY);
        weekDaysMap.put(1, TUESDAY);
        weekDaysMap.put(2, WEDNESDAY);
        weekDaysMap.put(3, THURSDAY);
        weekDaysMap.put(4, FRIDAY);
        weekDaysMap.put(5, SATURDAY);
        weekDaysMap.put(6, SUNDAY);
    }
    
    public Integer getDayNumber(int value) {
    
        for (Entry<Integer, NotebookDay> entry : weekDaysMap.entrySet()) {
            if (entry.getValue().getCalendarDay().equals(value))
                return entry.getKey();
        }
        
        return null;
    }
    
    public String getDayName(int i) {
    
        if (isMondayFirstDayOfWeek) {
            return weekDaysMap.get(i).toString();
        } else {
            return weekDaysMap.get((i + 6) % weekDaysMap.size()).toString();
        }
    }
    
    public String getWeekNumber(int i) {
    
        return (this.calendar.getCurrentWeekNumberInYear() + i) + "";
    }
    
    public String getDayNumber(int i, int j) {
    
        Integer dayNumber = getDayNumber(calendar.getDayOfWeek());
        
        return calendar.addDays(Calendar.getInstance().getTime(), (7 - dayNumber) + (i - 1) * 7 + j).toString();
        
    }
    
    public NotebookCurrentMonthPanel getNotebookCurrentMonthPanel() {
    
        return this.notebookCurrentMonthPanel;
    }
    
    public String getCurrentMonthName() {
    
        return calendar.getCurrentMonthName();
    }
    
    public String getCurrentYear() {
    
        return calendar.getCurrentYear();
    }
}
