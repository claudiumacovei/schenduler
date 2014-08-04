package notebook.swing.panels.currentmonthpanel;

import java.util.Date;

import notebook.abstractc.AbstractModel;
import notebook.utils.NotebookCalendar;

import org.slf4j.Logger;

public class NotebookCurrentMonthPanelModel extends AbstractModel {
    
    Logger logger = null;
    
    public NotebookCurrentMonthPanelModel(Logger logger) {
    
        super(logger);
    }
    
    public String getCurrentMonthName() {
    
        return getCalendar().getCurrentMonthName();
    }
    
    public String getCurrentYear() {
    
        return getCalendar().getCurrentYear();
    }
    
    public void setDate(Date time) {
    
        NotebookCalendar newCalendar = new NotebookCalendar(time);
        setCalendar(newCalendar);
    }
    
}
