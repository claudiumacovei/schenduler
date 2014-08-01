package notebook.swing.panels.dayspanel;

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

import notebook.swing.panels.abstractc.AbstractPanelModel;
import notebook.utils.NotebookDay;

import org.slf4j.Logger;

public class NotebookDaysPanelModel extends AbstractPanelModel {
    
    public NotebookDaysPanelModel(Logger logger) {
    
        super(logger);
        // TODO Auto-generated constructor stub
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
    
    public String getDayNumber(int i, int j) {
    
        Integer dayNumber = getDayNumber(getCalendar().getDayOfWeek());
        
        return getCalendar().addDays(Calendar.getInstance().getTime(), (7 - dayNumber) + (i - 1) * 7 + j).toString();
        
    }
}
