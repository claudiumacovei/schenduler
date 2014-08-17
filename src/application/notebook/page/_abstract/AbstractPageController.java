package application.notebook.page._abstract;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.slf4j.Logger;

public class AbstractPageController implements PropertyChangeListener {
    
    private ArrayList<AbstractPageView> registeredViews;
    private ArrayList<AbstractPageModel> registeredModels;
    private Logger logger = null;
    
    public AbstractPageController(Logger logger) {
    
        this.logger = logger;
        registeredViews = new ArrayList<AbstractPageView>();
        registeredModels = new ArrayList<AbstractPageModel>();
    }
    
    public void addModel(AbstractPageModel model) {
    
        registeredModels.add(model);
        model.addPropertyChangeListener(this);
    }
    
    public void removeModel(AbstractPageModel model) {
    
        registeredModels.remove(model);
        model.removePropertyChangeListener(this);
    }
    
    public void addView(AbstractPageView view) {
    
        registeredViews.add(view);
    }
    
    public void removeView(AbstractPageView view) {
    
        registeredViews.remove(view);
    }
    
    //  Use this to observe property changes from registered models
    //  and propagate them on to all the views.
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    
        setModelProperty(evt.getPropertyName(), evt.getNewValue());
        for (AbstractPageView view : registeredViews) {
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
    
        for (AbstractPageModel model : registeredModels) {
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
