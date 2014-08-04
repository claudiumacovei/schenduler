package notebook.swing.panels.currentmonthpanel;

import java.beans.PropertyChangeEvent;

import notebook.swing.panels.abstractc.AbstractPanelController;
import notebook.swing.panels.daynamepanel.NotebookDayNamePanelController;
import notebook.swing.panels.dayspanel.NotebookDaysPanelController;
import notebook.swing.panels.weeksnumberpanel.NotebookWeeksNumberPanelController;

import org.slf4j.Logger;

public class NotebookCurrentMonthPanelController extends AbstractPanelController {
    
    private NotebookDayNamePanelController dayNamePanelController = null;
    private NotebookDaysPanelController daysPanelController = null;
    private NotebookWeeksNumberPanelController notebookWeeksNumberPanelController = null;
    
    private NotebookCurrentMonthPanelModel model = null;
    private NotebookCurrentMonthPanelView view = null;
    
    public NotebookCurrentMonthPanelController(Logger logger) {
    
        super(logger);
    }
    
    public NotebookCurrentMonthPanelController initController() {
    
        model = new NotebookCurrentMonthPanelModel(getLogger());
        view = new NotebookCurrentMonthPanelView(this, model, getLogger());
        dayNamePanelController = new NotebookDayNamePanelController(getLogger()).initController();
        daysPanelController = new NotebookDaysPanelController(getLogger()).initController();
        notebookWeeksNumberPanelController = new NotebookWeeksNumberPanelController(getLogger()).initController();
        addModel(model);
        addView(view);
        return this;
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
