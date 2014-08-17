package application.notebook.page;

import org.slf4j.Logger;

import application.notebook.page._abstract.AbstractPageController;
import application.notebook.panels.daypanel.NotebookDayButton;

public class PageController extends AbstractPageController {
    
    private NotebookDayButton dayButton = null;
    
    public PageController(Logger logger, NotebookDayButton dayButton) {
    
        super(logger);
        this.dayButton = dayButton;
    }
    
}
