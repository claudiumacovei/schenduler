package notebook;

import java.beans.PropertyChangeEvent;

import javax.swing.JFrame;

import notebookAbstract.AbstractView;

public class NotebookView extends JFrame implements AbstractView {
    private final NotebookController controller;
    private final NotebookModel model;
    
    /**
     * Creates new form NotebookView
     * @param controller
     */
    public NotebookView(NotebookController controller, NotebookModel model) {
    
        this.controller = controller;
        this.model = model;
        initComponents();
    }
    
    private void initComponents() {
    
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void modelPropertyChange(PropertyChangeEvent evt) {
    
        // TODO Auto-generated method stub
        
    }
    
}
