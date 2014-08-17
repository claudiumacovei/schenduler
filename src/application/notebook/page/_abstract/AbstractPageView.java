package application.notebook.page._abstract;

import java.beans.PropertyChangeEvent;

import org.slf4j.Logger;

public abstract class AbstractPageView {
    
    private Logger logger = null;
    
    public AbstractPageView(Logger logger) {
    
        this.logger = logger;
    }
    
    public abstract void modelPropertyChange(final PropertyChangeEvent evt);
    
    protected Logger getLogger() {
    
        return this.logger;
    }
}
