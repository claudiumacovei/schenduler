package application.notebook.panels.currentmonthpanel;

import static application.notebook.utils.NotebookConstant.dayNamePannelMinimumHeight;
import static application.notebook.utils.NotebookConstant.weekNumberPannelMinimumWidht;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.SwingConstants.CENTER;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicArrowButton;

import org.slf4j.Logger;

import application.notebook.panels._abstract.AbstractPanelView;

public class NotebookCurrentMonthPanelView extends AbstractPanelView {
    NotebookCurrentMonthPanelController controller = null;
    JLabel currentMonthName = null;
    BasicArrowButton previousMonthButton = null;
    BasicArrowButton nextMonthButton = null;
    
    public NotebookCurrentMonthPanelView(NotebookCurrentMonthPanelController controller, Logger logger) {
    
        super(logger);
        this.controller = controller;
        initComponents();
        setPanel();
    }
    
    @Override
    protected void initComponents() {
    
        currentMonthName = new JLabel();
        currentMonthName.setMinimumSize(new java.awt.Dimension(80, 40));
        currentMonthName.setPreferredSize(new java.awt.Dimension(80, 40));
        currentMonthName.setHorizontalAlignment(CENTER);
        currentMonthName.setText(controller.getModel().getCurrentMonthName() + " " + controller.getModel().getCurrentYear());
        previousMonthButton = new BasicArrowButton(BasicArrowButton.WEST);
        previousMonthButton.setMinimumSize(new java.awt.Dimension(40, 20));
        previousMonthButton.setPreferredSize(new java.awt.Dimension(40, 20));
        previousMonthButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
            
                controller.propertyChange(new PropertyChangeEvent(previousMonthButton, "Date", controller.getModel().getCalendar().getTime(), controller.getModel().getCalendar().addUnitsToDate(controller.getModel().getCalendar().getTime(), Calendar.MONTH, -1).getTime()));
                controller.setWeeksNumberModelProperty("Calendar", controller.getModel().getCalendar());
                controller.setDaysModelProperty("Calendar", controller.getModel().getCalendar());
            }
        });
        nextMonthButton = new BasicArrowButton(BasicArrowButton.EAST);
        nextMonthButton.setMinimumSize(new java.awt.Dimension(40, 20));
        nextMonthButton.setPreferredSize(new java.awt.Dimension(40, 20));
        nextMonthButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
            
                controller.propertyChange(new PropertyChangeEvent(nextMonthButton, "Date", controller.getModel().getCalendar().getTime(), controller.getModel().getCalendar().addUnitsToDate(controller.getModel().getCalendar().getTime(), Calendar.MONTH, 1).getTime()));
                controller.setWeeksNumberModelProperty("Calendar", controller.getModel().getCalendar());
                controller.setDaysModelProperty("Calendar", controller.getModel().getCalendar());
            }
        });
        
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(currentMonthName, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE).addGap(10, 10, 10)).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(previousMonthButton, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE).addGap(4, 4, 4).addComponent(nextMonthButton, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE).addGap(5, 5, 5)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(currentMonthName, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE).addGap(15, 15, 15).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(previousMonthButton, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE).addComponent(nextMonthButton, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)).addGap(15, 15, 15)));
    }
    
    @Override
    protected void setPanel() {
    
        setMinimumSize(new Dimension(weekNumberPannelMinimumWidht, dayNamePannelMinimumHeight));
        setPreferredSize(new Dimension(weekNumberPannelMinimumWidht, dayNamePannelMinimumHeight));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
    }
    
    @Override
    public void modelPropertyChange(PropertyChangeEvent evt) {
    
        currentMonthName.setText(controller.getModel().getCurrentMonthName() + " " + controller.getModel().getCurrentYear());
        
    }
    
}
