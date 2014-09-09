package application.notebook.page.panels.eventspanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.slf4j.Logger;

public class NotebookEventsPanelButtonActionListener implements ActionListener {
    
    Logger logger = null;
    
    public NotebookEventsPanelButtonActionListener(Logger logger) {
    
        super();
        this.logger = logger;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
    
        logger.warn(arg0.toString());
    }
    
}
