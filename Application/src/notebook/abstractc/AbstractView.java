package notebook.abstractc;

import java.beans.PropertyChangeEvent;

public interface AbstractView {
    public void modelPropertyChange(final PropertyChangeEvent evt);
    
}