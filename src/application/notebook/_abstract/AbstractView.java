package application.notebook._abstract;

import java.beans.PropertyChangeEvent;

import javax.swing.JFrame;

import org.slf4j.Logger;

public abstract class AbstractView extends JFrame {
    private Logger logger = null;
    
    public abstract void modelPropertyChange(final PropertyChangeEvent evt);
    
    protected abstract void initComponents();
    
    protected abstract void setFrame();
    
    public AbstractView(Logger logger) {
    
        this.logger = logger;
    }
    
    protected Logger getLogger() {
    
        return this.logger;
    }
    
}
