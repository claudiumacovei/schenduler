package notebook;

import java.util.Calendar;

import notebook.abstractc.AbstractModel;
import notebook.utils.NotebookCalendar;

import org.slf4j.Logger;

public class NotebookModel extends AbstractModel {
    private String title = "MainApp";
    private NotebookCalendar calendar = new NotebookCalendar();
    
    public NotebookModel(Logger logger) {
    
        super(logger);
        
        if (isMondayFirstDayOfWeek())
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
        else
            calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        
    }
    
    public void setIsMondayFirstDayOfWeek(Boolean isMondayFirstDayOfWeek) {
    
        super.setIsMondayFirstDayOfWeek(isMondayFirstDayOfWeek);
    }
    
    public String getTitle() {
    
        return title;
    }
    
    public void setTitle(String title) {
    
        this.title = title;
    }
    
}
