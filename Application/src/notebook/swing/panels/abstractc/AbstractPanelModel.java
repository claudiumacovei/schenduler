package notebook.swing.panels.abstractc;

import notebook.abstractc.AbstractModel;

import org.slf4j.Logger;

public class AbstractPanelModel extends AbstractModel {
    
    public AbstractPanelModel(Logger logger) {
    
        super(logger);
    }
    
    @Override
    public void setIsMondayFirstDayOfWeek(Boolean isMondayFirstDayOfWeek) {
    
        super.setIsMondayFirstDayOfWeek(isMondayFirstDayOfWeek);
    }
    
}
