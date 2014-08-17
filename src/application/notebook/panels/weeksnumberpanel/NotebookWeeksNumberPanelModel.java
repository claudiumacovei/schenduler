package application.notebook.panels.weeksnumberpanel;

import org.slf4j.Logger;

import application.notebook.panels._abstract.AbstractPanelModel;

public class NotebookWeeksNumberPanelModel extends AbstractPanelModel {
    
    public NotebookWeeksNumberPanelModel(Logger logger) {
    
        super(logger);
    }
    
    public String getWeekNumber(int i) {
    
        return (getCalendar().getCurrentWeekNumberInYear() + i) + "";
    }
    
}
