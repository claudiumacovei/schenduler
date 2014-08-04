package notebook.abstractc;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import notebook.utils.NotebookCalendar;

import org.slf4j.Logger;

public abstract class AbstractModel {
    private boolean isMondayFirstDayOfWeek = true;
    private NotebookCalendar calendar = new NotebookCalendar();
    protected PropertyChangeSupport propertyChangeSupport;
    private Logger logger = null;
    
    public AbstractModel(Logger logger) {
    
        this.logger = logger;
        propertyChangeSupport = new PropertyChangeSupport(this);
    }
    
    public NotebookCalendar getCalendar() {
    
        return calendar;
    }
    
    public void setCalendar(NotebookCalendar calendar) {
    
        this.calendar = calendar;
    }
    
    public boolean isMondayFirstDayOfWeek() {
    
        return isMondayFirstDayOfWeek;
    }
    
    public void setIsMondayFirstDayOfWeek(Boolean isMondayFirstDayOfWeek) {
    
        this.isMondayFirstDayOfWeek = isMondayFirstDayOfWeek;
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
