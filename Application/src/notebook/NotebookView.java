package notebook;

import java.beans.PropertyChangeEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import notebookAbstract.AbstractView;

public class NotebookView extends JFrame implements AbstractView {
    private final NotebookController controller;
    private final NotebookModel model;
    private JLabel currentMounthName = new JLabel();
    private JPanel dayNamePannel = new JPanel();
    private JPanel weekNumberPannel = new JPanel();
    
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
