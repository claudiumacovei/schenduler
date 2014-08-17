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
    
    public Date getAssociatedDate() {
    
        return associatedDate;
    }
    
    public String getEventsFilePath() {
    
        return eventsFilePath;
    }
    
    public void setAssociatedDate(Date associatedDate) {
    
        this.associatedDate = associatedDate;
    }
    
    public void setEventsFilePath(String eventsFilePath) {
    
        this.eventsFilePath = eventsFilePath;
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
