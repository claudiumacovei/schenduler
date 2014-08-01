package notebook.swing.panels.currentmonthpanel;

import notebook.abstractc.AbstractModel;

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
}
