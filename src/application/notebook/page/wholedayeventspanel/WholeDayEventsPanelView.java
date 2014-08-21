package application.notebook.page.wholedayeventspanel;

import static javax.swing.GroupLayout.DEFAULT_SIZE;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.Group;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.slf4j.Logger;

import application.notebook.panels._abstract.AbstractPanelView;

public class WholeDayEventsPanelView extends AbstractPanelView {
    
    JFrame parrentFrame = null;
    JButton jbutton = null;
    List<JButton> buttons = new ArrayList<JButton>();
    
    public WholeDayEventsPanelView(Logger logger, JFrame parrentFrame, LayoutManager layoutManager) {
    
        super(logger, layoutManager);
        this.parrentFrame = parrentFrame;
        initComponents();
        setPanel();
    }
    
    @Override
    public void modelPropertyChange(PropertyChangeEvent evt) {
    
    }
    
    @Override
    protected void initComponents() {
    
        jbutton = new JButton("CLICK");
        buttons.add(jbutton);
        
        final GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(createHorizontalGroup(layout, buttons));
        layout.setVerticalGroup(createVerticalGroup(layout, buttons));
        
        jbutton.addActionListener(new EventsActionListerner(this));
        
    }
    
    private Group createHorizontalGroup(GroupLayout layout, List<JButton> buttons) {
    
        ParallelGroup parallelGroup = layout.createParallelGroup(Alignment.LEADING);
        SequentialGroup sequentialGroup = layout.createSequentialGroup();
        ParallelGroup parallelGroup2 = layout.createParallelGroup(Alignment.LEADING);
        for (JButton jButton : buttons) {
            parallelGroup2.addComponent(jButton, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE);
            parallelGroup2.addGap(0, 0, 0);
        }
        
        sequentialGroup.addGroup(parallelGroup2);
        parallelGroup.addGroup(sequentialGroup);
        return parallelGroup;
    }
    
    private Group createVerticalGroup(GroupLayout layout, List<JButton> buttons) {
    
        ParallelGroup parallelGroup = layout.createParallelGroup(Alignment.LEADING);
        SequentialGroup sequentialGroup = layout.createSequentialGroup();
        for (JButton jButton : buttons) {
            sequentialGroup.addComponent(jButton, 50, 50, 50);
        }
        
        parallelGroup.addGroup(sequentialGroup);
        return parallelGroup;
    }
    
    @Override
    protected void setPanel() {
    
        setMaximumSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 15, ((int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 4)));
    }
    private final class EventsActionListerner implements ActionListener {
        
        WholeDayEventsPanelView source = null;
        private int clickCount = 0;
        
        public EventsActionListerner(WholeDayEventsPanelView source) {
        
            super();
            this.source = source;
        }
        
        @Override
        public void actionPerformed(ActionEvent arg0) {
        
            GroupLayout layout = new GroupLayout(source);
            source.setLayout(layout);
            
            buttons.add(new JButton("Button:" + clickCount++));
            layout.setHorizontalGroup(createHorizontalGroup(layout, buttons));
            layout.setVerticalGroup(createVerticalGroup(layout, buttons));
            parrentFrame.validate();
        }
        
    }
    
}
