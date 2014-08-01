package notebook.swing.panels.abstractc;

import java.beans.PropertyChangeEvent;

import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPanelView extends JPanel {
    
    private final Logger logger = LoggerFactory.getLogger(AbstractPanelView.class);
    
    public abstract void modelPropertyChange(final PropertyChangeEvent evt);
    
    protected abstract void initComponents();
    
    protected abstract void setPanel();
    
    protected Logger getLogger() {
    
        return this.logger;
    }
}
