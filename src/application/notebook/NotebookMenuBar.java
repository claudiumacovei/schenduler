package application.notebook;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButton;

import org.slf4j.Logger;

public class NotebookMenuBar extends JMenuBar {
    NotebookController controller = null;
    JMenu settingsMenu = new JMenu("Settings");
    ButtonGroup firstDayOfWeekButtonGroup = new ButtonGroup();
    JMenu firstDayOfWeekMenu = new JMenu("First Day Of Week");
    JRadioButton mondayFirstDayOfWeekRadioButton = new JRadioButton("Monday");
    JRadioButton sundayFirstDayOfWeekRadioButton = new JRadioButton("Sunday");
    Logger logger = null;
    
    public NotebookMenuBar(NotebookController controller, Logger logger) {
    
        this.logger = logger;
        this.controller = controller;
        initComponents();
        
    }
    
    protected void initComponents() {
    
        mondayFirstDayOfWeekRadioButton.setSelected(true);
        mondayFirstDayOfWeekRadioButton.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseReleased(MouseEvent arg0) {
            
                controller.getCurrentMonthPanelController().getDayNamePanelController().propertyChange(new PropertyChangeEvent(mondayFirstDayOfWeekRadioButton, "IsMondayFirstDayOfWeek", null, true));
                controller.getCurrentMonthPanelController().getDaysPanelController().propertyChange(new PropertyChangeEvent(mondayFirstDayOfWeekRadioButton, "IsMondayFirstDayOfWeek", null, true));
                
            }
            
            @Override
            public void mousePressed(MouseEvent arg0) {
            
            }
            
            @Override
            public void mouseExited(MouseEvent arg0) {
            
            }
            
            @Override
            public void mouseEntered(MouseEvent arg0) {
            
            }
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
            
            }
        });
        
        sundayFirstDayOfWeekRadioButton.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseReleased(MouseEvent arg0) {
            
                controller.getCurrentMonthPanelController().getDayNamePanelController().propertyChange(new PropertyChangeEvent(sundayFirstDayOfWeekRadioButton, "IsMondayFirstDayOfWeek", null, false));
                controller.getCurrentMonthPanelController().getDaysPanelController().propertyChange(new PropertyChangeEvent(sundayFirstDayOfWeekRadioButton, "IsMondayFirstDayOfWeek", null, false));
            }
            
            @Override
            public void mousePressed(MouseEvent arg0) {
            
            }
            
            @Override
            public void mouseExited(MouseEvent arg0) {
            
            }
            
            @Override
            public void mouseEntered(MouseEvent arg0) {
            
            }
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
            
                // TODO Auto-generated method stub
                
            }
        });
        
        firstDayOfWeekMenu.add(mondayFirstDayOfWeekRadioButton);
        firstDayOfWeekMenu.add(sundayFirstDayOfWeekRadioButton);
        settingsMenu.add(firstDayOfWeekMenu);
        add(settingsMenu);
        
        firstDayOfWeekButtonGroup.add(mondayFirstDayOfWeekRadioButton);
        firstDayOfWeekButtonGroup.add(sundayFirstDayOfWeekRadioButton);
        
    }
}
