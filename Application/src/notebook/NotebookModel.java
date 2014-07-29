package notebook;

import notebookAbstract.AbstractModel;

public class NotebookModel extends AbstractModel {
    private NotebookController controller = null;
    private String name = "MainApp";
    
    public NotebookModel(NotebookController controller) {
    
        this.controller = controller;
    }
    
    public void setName(String name) {
    
        this.name = name;
    }
    
    public String getName() {
    
        return name;
    }
}
