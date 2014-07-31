package notebook.abstractc;

import java.beans.PropertyChangeEvent;

import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractView extends JFrame {
    private final Logger logger = LoggerFactory.getLogger(AbstractView.class);
    
    public abstract void modelPropertyChange(final PropertyChangeEvent evt);
    
    protected Logger getLogger() {
    
        return this.logger;
    }
    
}
