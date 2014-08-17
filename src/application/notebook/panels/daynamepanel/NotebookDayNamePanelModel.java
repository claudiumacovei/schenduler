package application.notebook.panels.daynamepanel;

import static application.notebook.utils.NotebookDay.FRIDAY;
import static application.notebook.utils.NotebookDay.MONDAY;
import static application.notebook.utils.NotebookDay.SATURDAY;
import static application.notebook.utils.NotebookDay.SUNDAY;
import static application.notebook.utils.NotebookDay.THURSDAY;
import static application.notebook.utils.NotebookDay.TUESDAY;
import static application.notebook.utils.NotebookDay.WEDNESDAY;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;

import application.notebook.panels._abstract.AbstractPanelModel;
import application.notebook.utils.NotebookDay;

public class NotebookDayNamePanelModel extends AbstractPanelModel {
    
    public NotebookDayNamePanelModel(Logger logger) {
    
        super(logger);
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
    
    @Override
    public void setIsMondayFirstDayOfWeek(Boolean isMondayFirstDayOfWeek) {
    
        super.setIsMondayFirstDayOfWeek(isMondayFirstDayOfWeek);
    }
    
    public String getDayName(int i) {
    
        if (isMondayFirstDayOfWeek()) {
            return weekDaysMap.get(i).toString();
        } else {
            return weekDaysMap.get((i + 6) % weekDaysMap.size()).toString();
        }
    }
    
}
