package application.notebook.panels.currentmonthpanel;

import java.beans.PropertyChangeEvent;

import org.slf4j.Logger;

import application.notebook.panels._abstract.AbstractPanelController;
import application.notebook.panels.daynamepanel.NotebookDayNamePanelController;
import application.notebook.panels.daypanel.NotebookDaysPanelController;
import application.notebook.panels.weeksnumberpanel.NotebookWeeksNumberPanelController;

public class NotebookCurrentMonthPanelController extends AbstractPanelController {
    
    private NotebookDayNamePanelController dayNamePanelController = null;
    private NotebookDaysPanelController daysPanelController = null;
    private NotebookWeeksNumberPanelController weeksNumberPanelController = null;
    
    public NotebookCurrentMonthPanelController(Logger logger) {
    
        super(logger);
        this.dayNamePanelController = new NotebookDayNamePanelController(logger);
        this.dayNamePanelController.initController();
        this.daysPanelController = new NotebookDaysPanelController(logger);
        this.daysPanelController.initController();
        this.weeksNumberPanelController = new NotebookWeeksNumberPanelController(logger);
        this.weeksNumberPanelController.initController();
        addModel(new NotebookCurrentMonthPanelModel(logger));
    }
    
    @Override
    public void initController() {
    
        addView(new NotebookCurrentMonthPanelView(this, getLogger()));
    }
    
    public void setDayNameModelProperty(String propertyName, Object newValue) {
    
        this.dayNamePanelController.propertyChange(new PropertyChangeEvent(this, propertyName, null, newValue));
    }
    
    public void setDaysModelProperty(String propertyName, Object newValue) {
    
        this.daysPanelController.propertyChange(new PropertyChangeEvent(this, propertyName, null, newValue));
    }
    
    public void setWeeksNumberModelProperty(String propertyName, Object newValue) {
    
        this.weeksNumberPanelController.propertyChange(new PropertyChangeEvent(this, propertyName, null, newValue));
        
    }
    
    public NotebookDayNamePanelController getDayNamePanelController() {
    
        return dayNamePanelController;
    }
    
    public NotebookDaysPanelController getDaysPanelController() {
    
        return daysPanelController;
    }
    
    public NotebookWeeksNumberPanelController getNotebookWeeksNumberPanelController() {
    
        return weeksNumberPanelController;
    }
    
    public void setDayNamePanelController(NotebookDayNamePanelController dayNamePanelController) {
    
        this.dayNamePanelController = dayNamePanelController;
    }
    
    public void setDaysPanelController(NotebookDaysPanelController daysPanelController) {
    
        this.daysPanelController = daysPanelController;
    }
    
    public void setNotebookWeeksNumberPanelController(NotebookWeeksNumberPanelController notebookWeeksNumberPanelController) {
    
        this.weeksNumberPanelController = notebookWeeksNumberPanelController;
    }
    
    public NotebookCurrentMonthPanelModel getModel() {
    
        return (NotebookCurrentMonthPanelModel) getRegisteredModel();
    }
    
    public NotebookCurrentMonthPanelView getView() {
    
        return (NotebookCurrentMonthPanelView) getRegisteredView();
    }
}
