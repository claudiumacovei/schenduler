package notebook.abstractc;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.slf4j.Logger;

public abstract class AbstractModel {
    protected PropertyChangeSupport propertyChangeSupport;
    private Logger logger = null;
    
    public AbstractModel(Logger logger) {
    
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
    
    protected Logger getLogger() {
    
        return this.logger;
    }
}
