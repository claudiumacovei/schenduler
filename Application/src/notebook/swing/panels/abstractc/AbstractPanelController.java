package notebook.swing.panels.abstractc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

import notebook.abstractc.AbstractModel;

import org.slf4j.Logger;

public class AbstractPanelController implements PropertyChangeListener {
    
    private ArrayList<AbstractPanelView> registeredViews;
    private ArrayList<AbstractModel> registeredModels;
    private Logger logger = null;
    
    public AbstractPanelController(Logger logger) {
    
        this.logger = logger;
        registeredViews = new ArrayList<AbstractPanelView>();
        registeredModels = new ArrayList<AbstractModel>();
    }
    
    public void addModel(AbstractModel model) {
    
        registeredModels.add(model);
        model.addPropertyChangeListener(this);
    }
    
    public void removeModel(AbstractModel model) {
    
        registeredModels.remove(model);
        model.removePropertyChangeListener(this);
    }
    
    public void addView(AbstractPanelView view) {
    
        registeredViews.add(view);
    }
    
    public void removeView(AbstractPanelView view) {
    
        registeredViews.remove(view);
    }
    
    //  Use this to observe property changes from registered models
    //  and propagate them on to all the views.
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    
        setModelProperty(evt.getPropertyName(), evt.getNewValue());
        for (AbstractPanelView view : registeredViews) {
            view.modelPropertyChange(evt);
        }
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
    
        for (AbstractModel model : registeredModels) {
            try {
                
                Method method = model.getClass().getMethod("set" + propertyName, new Class[] { newValue.getClass() });
                
                method.invoke(model, newValue);
                
            } catch (Exception ex) {
                System.out.println("Exception catched: " + ex.getMessage());
            }
        }
    }
    
    protected Logger getLogger() {
    
        return this.logger;
    }
    
}
