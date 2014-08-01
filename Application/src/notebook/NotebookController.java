package notebook;

import notebook.abstractc.AbstractController;

import org.slf4j.Logger;

public class NotebookController extends AbstractController {
    
    public NotebookController(Logger logger) {
    
        super(logger);
        NotebookModel model = new NotebookModel(logger);
        NotebookView view = new NotebookView(this, model, logger);
        view.setVisible(true);
        addModel(model);
        addView(view);
    }
}
