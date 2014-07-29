package notebookAbstract;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class AbstractModel {
    protected PropertyChangeSupport propertyChangeSupport;
    
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
}
