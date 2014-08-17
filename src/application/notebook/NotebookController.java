package application.notebook;

import org.slf4j.Logger;

import application.notebook._abstract.AbstractController;
import application.notebook.panels.currentmonthpanel.NotebookCurrentMonthPanelController;

public class NotebookController extends AbstractController {
    
    private NotebookCurrentMonthPanelController currentMonthPanelController = null;
    private NotebookModel model = null;
    private NotebookView view = null;
    
    public NotebookController(Logger logger) {
    
        super(logger);
        this.currentMonthPanelController = new NotebookCurrentMonthPanelController(logger);
        this.currentMonthPanelController.initController();
        this.model = new NotebookModel(logger);
        addModel(model);
        
    }
    
    @Override
    public void initController() {
    
        this.view = new NotebookView(this, getLogger());
        this.view.setVisible(true);
        addView(view);
    }
    
    public NotebookModel getModel() {
    
        return model;
    }
    
    public NotebookCurrentMonthPanelController getCurrentMonthPanelController() {
    
        return currentMonthPanelController;
    }
    
    public void setCurrentMonthPanelController(NotebookCurrentMonthPanelController currentMonthPanelController) {
    
        this.currentMonthPanelController = currentMonthPanelController;
    }
    
}
