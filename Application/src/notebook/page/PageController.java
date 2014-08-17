package notebook.page;

import notebook.page.abstractc.AbstractPageController;
import notebook.swing.panels.dayspanel.NotebookDayButton;

import org.slf4j.Logger;

public class PageController extends AbstractPageController {
    
    private NotebookDayButton dayButton = null;
    
    public PageController(Logger logger, NotebookDayButton dayButton) {
    
        super(logger);
        this.dayButton = dayButton;
    }
    
}
