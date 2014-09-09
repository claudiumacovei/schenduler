package application.notebook.page.hoursEventsPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.slf4j.Logger;

public class HoursEventsPanelButtonActionListener implements ActionListener {
    
    Logger logger = null;
    
    public HoursEventsPanelButtonActionListener(Logger logger) {
    
        super();
        this.logger = logger;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
    
        logger.warn(arg0.toString());
    }
    
}
