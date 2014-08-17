package application.notebook.panels._abstract;

import org.slf4j.Logger;

import application.notebook._abstract.AbstractModel;

public class AbstractPanelModel extends AbstractModel {
    
    public AbstractPanelModel(Logger logger) {
    
        super(logger);
    }
    
    @Override
    public void setIsMondayFirstDayOfWeek(Boolean isMondayFirstDayOfWeek) {
    
        super.setIsMondayFirstDayOfWeek(isMondayFirstDayOfWeek);
    }
    
}
