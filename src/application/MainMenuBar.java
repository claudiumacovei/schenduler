package application;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MainMenuBar extends JMenuBar {
    
    public MainMenuBar() {
    
        add(new JMenu("Menu1"));
        add(new JMenu("Menu2"));
    }
}
