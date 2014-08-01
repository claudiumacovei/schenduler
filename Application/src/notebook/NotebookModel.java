package notebook;

import java.util.Calendar;

import notebook.abstractc.AbstractModel;
import notebook.utils.NotebookCalendar;

import org.slf4j.Logger;

public class NotebookModel extends AbstractModel {
    private NotebookController controller = null;
    private String name = "MainApp";
    private NotebookCalendar calendar = new NotebookCalendar();
    
    public NotebookModel(NotebookController controller, Logger logger) {
    
        super(logger);
        this.controller = controller;
        
        if (isMondayFirstDayOfWeek())
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
        else
            calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        
    }
    
    public void setName(String name) {
    
        this.name = name;
    }
    
    public String getName() {
    
        return name;
    }
    
}
