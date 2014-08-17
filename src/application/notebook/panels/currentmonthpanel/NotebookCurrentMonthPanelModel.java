package application.notebook.panels.currentmonthpanel;

import java.util.Date;

import org.slf4j.Logger;

import application.notebook._abstract.AbstractModel;
import application.notebook.utils.NotebookCalendar;

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
