package application.notebook.page._abstract;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.slf4j.Logger;

public abstract class AbstractPageModel {
    
    protected PropertyChangeSupport propertyChangeSupport;
    private Logger logger = null;
    
    public AbstractPageModel(Logger logger) {
    
        super();
        this.logger = logger;
        propertyChangeSupport = new PropertyChangeSupport(this);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
    
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
    
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
    public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
    
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, oldValue);
    }
    
    public Logger getLogger() {
    
        return logger;
    }
    
}
