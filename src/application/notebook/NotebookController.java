package application.notebook;

import org.slf4j.Logger;

import application.notebook._abstract.AbstractController;
import application.notebook.panels.currentmonthpanel.NotebookCurrentMonthPanelController;

public class NotebookController extends AbstractController {
    
    private NotebookCurrentMonthPanelController currentMonthPanelController = null;
    
    public NotebookController(Logger logger) {
    
        super(logger);
        this.currentMonthPanelController = new NotebookCurrentMonthPanelController(logger);
        this.currentMonthPanelController.initController();
        addModel(new NotebookModel(logger));
        
    }
    
    @Override
    public void initController() {
    
        addView(new NotebookView(this, getLogger()));
    }
    
    public NotebookCurrentMonthPanelController getCurrentMonthPanelController() {
    
        return currentMonthPanelController;
    }
    
    public void setCurrentMonthPanelController(NotebookCurrentMonthPanelController currentMonthPanelController) {
    
        this.currentMonthPanelController = currentMonthPanelController;
    }
    
}
