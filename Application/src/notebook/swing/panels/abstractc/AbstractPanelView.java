package notebook.swing.panels.abstractc;

import java.beans.PropertyChangeEvent;

import javax.swing.JPanel;

import org.slf4j.Logger;

public abstract class AbstractPanelView extends JPanel {
    
    private Logger logger = null;
    
    public AbstractPanelView(Logger logger) {
    
        super();
        this.logger = logger;
    }
    
    public abstract void modelPropertyChange(final PropertyChangeEvent evt);
    
    protected abstract void initComponents();
    
    protected abstract void setPanel();
    
    protected Logger getLogger() {
    
        return this.logger;
    }
}
