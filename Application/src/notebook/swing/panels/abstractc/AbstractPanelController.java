package notebook.swing.panels.abstractc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;

import notebook.abstractc.AbstractModel;

import org.slf4j.Logger;

public class AbstractPanelController implements PropertyChangeListener {
    
    private AbstractPanelView registeredView = null;
    private AbstractModel registeredModel = null;
    private Logger logger = null;
    
    public AbstractPanelController(Logger logger) {
    
        this.logger = logger;
    }
    
    public void addModel(AbstractModel model) {
    
        registeredModel = model;
        model.addPropertyChangeListener(this);
    }
    
    public void removeModel() {
    
        registeredModel = null;
    }
    
    public void addView(AbstractPanelView view) {
    
        registeredView = view;
    }
    
    public void removeView() {
    
        registeredView = null;
    }
    
    //  Use this to observe property changes from registered models
    //  and propagate them on to all the views.
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    
        if (evt.getPropertyName() != null && evt.getNewValue() != null) {
            setModelProperty(evt.getPropertyName(), evt.getNewValue());
        }
        registeredView.modelPropertyChange(evt);
    }
    
    /**
     * This is a convenience method that subclasses can call upon
     * to fire property changes back to the models. This method
     * uses reflection to inspect each of the model classes
     * to determine whether it is the owner of the property
     * in question. If it isn't, a NoSuchMethodException is thrown,
     * which the method ignores.
     *
     * @param propertyName = The name of the property.
     * @param newValue = An object that represents the new value
     * of the property.
     */
    public void setModelProperty(String propertyName, Object newValue) {
    
        try {
            
            Method method = registeredModel.getClass().getMethod("set" + propertyName, new Class[] { newValue.getClass() });
            
            method.invoke(registeredModel, newValue);
            
        } catch (Exception ex) {
            getLogger().error(ex.getMessage(), ex);
        }
    }
    
    protected Logger getLogger() {
    
        return this.logger;
    }
    
}
