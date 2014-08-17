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
    private NotebookWeeksNumberPanelController notebookWeeksNumberPanelController = null;
    
    private NotebookCurrentMonthPanelModel model = null;
    private NotebookCurrentMonthPanelView view = null;
    
    public NotebookCurrentMonthPanelController(Logger logger) {
    
        super(logger);
    }
    
    @Override
    public void initController() {
    
        model = new NotebookCurrentMonthPanelModel(getLogger());
        view = new NotebookCurrentMonthPanelView(this, model, getLogger());
        dayNamePanelController = new NotebookDayNamePanelController(getLogger());
        daysPanelController = new NotebookDaysPanelController(getLogger());
        notebookWeeksNumberPanelController = new NotebookWeeksNumberPanelController(getLogger());
        addModel(model);
        addView(view);
    }
    
    public void setDayNameModelProperty(String propertyName, Object newValue) {
    
        this.dayNamePanelController.propertyChange(new PropertyChangeEvent(this, propertyName, null, newValue));
    }
    
    public void setDaysModelProperty(String propertyName, Object newValue) {
    
        this.daysPanelController.propertyChange(new PropertyChangeEvent(this, propertyName, null, newValue));
    }
    
    public void setWeeksNumberModelProperty(String propertyName, Object newValue) {
    
        this.notebookWeeksNumberPanelController.propertyChange(new PropertyChangeEvent(this, propertyName, null, newValue));
        
    }
    
    public NotebookDayNamePanelController getDayNamePanelController() {
    
        return dayNamePanelController;
    }
    
    public NotebookDaysPanelController getDaysPanelController() {
    
        return daysPanelController;
    }
    
    public NotebookWeeksNumberPanelController getNotebookWeeksNumberPanelController() {
    
        return notebookWeeksNumberPanelController;
    }
    
    public void setDayNamePanelController(NotebookDayNamePanelController dayNamePanelController) {
    
        this.dayNamePanelController = dayNamePanelController;
    }
    
    public void setDaysPanelController(NotebookDaysPanelController daysPanelController) {
    
        this.daysPanelController = daysPanelController;
    }
    
    public void setNotebookWeeksNumberPanelController(NotebookWeeksNumberPanelController notebookWeeksNumberPanelController) {
    
        this.notebookWeeksNumberPanelController = notebookWeeksNumberPanelController;
    }
    
    public NotebookCurrentMonthPanelModel getModel() {
    
        return model;
    }
    
    public NotebookCurrentMonthPanelView getView() {
    
        return view;
    }
    
    public void setModel(NotebookCurrentMonthPanelModel model) {
    
        this.model = model;
    }
    
    public void setView(NotebookCurrentMonthPanelView view) {
    
        this.view = view;
    }
    
}
