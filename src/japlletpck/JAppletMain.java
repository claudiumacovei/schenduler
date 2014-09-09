package japlletpck;

import javax.swing.JApplet;

import application.MainFrame;

public class JAppletMain extends JApplet {
    
    @Override
    public void init() {
    
        super.init();
        new MainFrame().setVisible(true);
    }
    
}
