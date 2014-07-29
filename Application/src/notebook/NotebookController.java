package notebook;

import notebookAbstract.AbstractController;

public class NotebookController extends AbstractController {
    
    public NotebookController() {
    
        NotebookModel model = new NotebookModel(this);
        NotebookView view = new NotebookView(this, model);
        view.setVisible(true);
        addModel(model);
        addView(view);
    }
}
