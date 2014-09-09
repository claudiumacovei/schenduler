package application.notebook.panels.daypanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.slf4j.Logger;

import application.notebook.page.PageController;

public class DayPanelButtonActionListener implements ActionListener {
    
    Logger logger = null;
    NotebookDayButton sourceButton = null;
    
    public DayPanelButtonActionListener(Logger logger, NotebookDayButton sourceButton) {
    
        super();
        this.logger = logger;
        this.sourceButton = sourceButton;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
    
        new PageController(logger, sourceButton);
    }
    
}
