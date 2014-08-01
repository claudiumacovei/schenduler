package notebook.swing.panels.currentmonthpanel;

import notebook.abstractc.AbstractModel;

import org.slf4j.Logger;

public class NotebookCurrentMonthPanelModel extends AbstractModel {
    
    private NotebookCurrentMonthPanelController controller = null;
    Logger logger = null;
    
    public NotebookCurrentMonthPanelModel(NotebookCurrentMonthPanelController controller, Logger logger) {
    
        super(logger);
        this.controller = controller;
    }
    
    public String getCurrentMonthName() {
    
        // TODO Auto-generated method stub
        return null;
    }
    
    public String getCurrentYear() {
    
        // TODO Auto-generated method stub
        return null;
    }
}
