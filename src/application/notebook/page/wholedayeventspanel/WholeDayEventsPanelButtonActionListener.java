package application.notebook.page.wholedayeventspanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.slf4j.Logger;

public class WholeDayEventsPanelButtonActionListener implements ActionListener {
    
    Logger logger = null;
    
    public WholeDayEventsPanelButtonActionListener(Logger logger) {
    
        super();
        this.logger = logger;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
    
        logger.warn(arg0.toString());
    }
    
}
