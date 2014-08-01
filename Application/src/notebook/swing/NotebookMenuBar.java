package notebook.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import notebook.NotebookController;

public class NotebookMenuBar extends JMenuBar {
    NotebookController controller = null;
    JMenu settingsMenu = new JMenu("Settings");
    ButtonGroup firstDayOfWeekButtonGroup = new ButtonGroup();
    JMenu firstDayOfWeekMenu = new JMenu("First Day Of Week");
    JRadioButton mondayFirstDayOfWeekRadioButton = new JRadioButton("Monday");
    JRadioButton sundayFirstDayOfWeekRadioButton = new JRadioButton("Sunday");
    
    public NotebookMenuBar(NotebookController controller) {
    
        this.controller = controller;
        initComponents();
        
    }
    
    protected void initComponents() {
    
        mondayFirstDayOfWeekRadioButton.setSelected(true);
        mondayFirstDayOfWeekRadioButton.addChangeListener(new ChangeListener() {
            
            @Override
            public void stateChanged(ChangeEvent e) {
            
            }
        });
        sundayFirstDayOfWeekRadioButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            
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
