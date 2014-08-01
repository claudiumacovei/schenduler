package notebook.swing.panels.daynamepanel;

import static notebook.utils.NotebookDay.FRIDAY;
import static notebook.utils.NotebookDay.MONDAY;
import static notebook.utils.NotebookDay.SATURDAY;
import static notebook.utils.NotebookDay.SUNDAY;
import static notebook.utils.NotebookDay.THURSDAY;
import static notebook.utils.NotebookDay.TUESDAY;
import static notebook.utils.NotebookDay.WEDNESDAY;

import java.util.HashMap;
import java.util.Map;

import notebook.swing.panels.abstractc.AbstractPanelModel;
import notebook.utils.NotebookDay;

import org.slf4j.Logger;

public class NotebookDayNamePanelModel extends AbstractPanelModel {
    
    public NotebookDayNamePanelModel(Logger logger) {
    
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
    
    public String getDayName(int i) {
    
        if (isMondayFirstDayOfWeek()) {
            return weekDaysMap.get(i).toString();
        } else {
            return weekDaysMap.get((i + 6) % weekDaysMap.size()).toString();
        }
    }
    
}
