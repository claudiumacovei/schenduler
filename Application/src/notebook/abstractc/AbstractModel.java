package notebook.abstractc;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractModel {
    protected PropertyChangeSupport propertyChangeSupport;
    private final Logger logger = LoggerFactory.getLogger(AbstractModel.class);
    
    public AbstractModel() {
    
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
