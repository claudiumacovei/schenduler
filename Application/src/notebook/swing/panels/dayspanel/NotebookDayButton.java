package notebook.swing.panels.dayspanel;

import java.util.Date;

import javax.swing.JButton;

public class NotebookDayButton extends JButton {
    
    private Date associatedDate = null;
    private String eventsFilePath = null;
    
    public NotebookDayButton(Date associatedDate) {
    
        super();
        this.associatedDate = associatedDate;
        //TODO: init @eventsFilePath
    }
    
    public NotebookDayButton setButtonText(String text) {
    
        super.setText(text);
        return this;
    }
    
    public NotebookDayButton setDate(Date date) {
    
        this.associatedDate = date;
        return this;
    }
}
