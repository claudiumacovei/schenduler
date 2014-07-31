package notebook;

import static notebook.utils.NotebookDay.FRIDAY;
import static notebook.utils.NotebookDay.MONDAY;
import static notebook.utils.NotebookDay.SATURDAY;
import static notebook.utils.NotebookDay.SUNDAY;
import static notebook.utils.NotebookDay.THURSDAY;
import static notebook.utils.NotebookDay.TUESDAY;
import static notebook.utils.NotebookDay.WEDNESDAY;
import notebook.abstractc.AbstractModel;
import notebook.swing.NotebookDaysNamePanel;
import notebook.swing.NotebookDaysPannel;
import notebook.swing.NotebookWeeksNumberPannel;
import notebook.utils.NotebookCalendar;

public class NotebookModel extends AbstractModel {
    private NotebookController controller = null;
    private String name = "MainApp";
    private boolean isMondayFirstDayOfWeek = true;
    private NotebookDaysNamePanel notebookDaysNamePanel = null;
    private NotebookDaysPannel notebookDaysPannel = null;
    private NotebookWeeksNumberPannel notebookWeeksNumberPannel = null;
    private NotebookCalendar calendar = new NotebookCalendar();
    
    public NotebookModel(NotebookController controller) {
    
        this.controller = controller;
        notebookDaysNamePanel = new NotebookDaysNamePanel(this);
        notebookDaysPannel = new NotebookDaysPannel(this);
        notebookWeeksNumberPannel = new NotebookWeeksNumberPannel(this);
    }
    
    public NotebookDaysPannel getNotebookDaysPannel() {
    
        return notebookDaysPannel;
    }
    
    public NotebookWeeksNumberPannel getNotebookWeeksNumberPannel() {
    
        return notebookWeeksNumberPannel;
    }
    
    public void setNotebookDaysPannel(NotebookDaysPannel notebookDaysPannel) {
    
        this.notebookDaysPannel = notebookDaysPannel;
    }
    
    public void setNotebookWeeksNumberPannel(NotebookWeeksNumberPannel notebookWeeksNumberPannel) {
    
        this.notebookWeeksNumberPannel = notebookWeeksNumberPannel;
    }
    
    public NotebookDaysNamePanel getNotebookDaysNamePanel() {
    
        return notebookDaysNamePanel;
    }
    
    public void setNotebookDaysNamePanel(NotebookDaysNamePanel notebookDaysNamePanel) {
    
        this.notebookDaysNamePanel = notebookDaysNamePanel;
    }
    
    public void setName(String name) {
    
        this.name = name;
    }
    
    public String getName() {
    
        return name;
    }
    
    public String getDayName(int i) {
    
        if (isMondayFirstDayOfWeek) {
            switch (i + 1) {
                case 1:
                    return MONDAY.getDayName();
                case 2:
                    return TUESDAY.getDayName();
                case 3:
                    return WEDNESDAY.getDayName();
                case 4:
                    return THURSDAY.getDayName();
                case 5:
                    return FRIDAY.getDayName();
                case 6:
                    return SATURDAY.getDayName();
                case 7:
                    return SUNDAY.getDayName();
                default:
                    break;
            }
        } else {
            switch (i + 1) {
                case 1:
                    return SUNDAY.getDayName();
                case 2:
                    return MONDAY.getDayName();
                case 3:
                    return TUESDAY.getDayName();
                case 4:
                    return WEDNESDAY.getDayName();
                case 5:
                    return THURSDAY.getDayName();
                case 6:
                    return FRIDAY.getDayName();
                case 7:
                    return SATURDAY.getDayName();
                default:
                    break;
            }
        }
        
        return "undefined";
    }
    
    public String getWeekNumber(int i) {
    
        return (new Integer(i)).toString();
    }
    
    public String getDayNumber(int i, int j) {
    
        return (new Integer(i)).toString() + " / " + (new Integer(j)).toString();
    }
}
