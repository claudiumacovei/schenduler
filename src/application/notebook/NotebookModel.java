package application.notebook;

import java.util.Calendar;

import org.slf4j.Logger;

import application.notebook._abstract.AbstractModel;
import application.notebook.utils.NotebookCalendar;

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
    
    @Override
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
