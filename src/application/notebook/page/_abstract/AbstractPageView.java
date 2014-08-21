package application.notebook.page._abstract;

import java.beans.PropertyChangeEvent;

import org.slf4j.Logger;

import application.notebook._abstract.AbstractView;

public abstract class AbstractPageView extends AbstractView {
    
    private Logger logger = null;
    
    public AbstractPageView(Logger logger) {
    
        super(logger);
    }
    
    @Override
    public abstract void modelPropertyChange(final PropertyChangeEvent evt);
    
    @Override
    protected Logger getLogger() {
    
        return this.logger;
    }
}
