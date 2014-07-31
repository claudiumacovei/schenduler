package notebook.abstractc;

import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPanel extends JPanel {
    
    private final Logger logger = LoggerFactory.getLogger(AbstractPanel.class);
    
    protected abstract void initComponents();
    
    protected abstract void setPanel();
    
    protected Logger getLogger() {
    
        return this.logger;
    }
}
