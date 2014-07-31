package notebook;

import notebook.abstractc.AbstractModel;

public class NotebookModel extends AbstractModel {
    private NotebookController controller = null;
    private String name = "MainApp";
    private boolean isMondayFirstDayOfWeek = true;
    
    public NotebookModel(NotebookController controller) {
    
        this.controller = controller;
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
                    return "MONDAY";
                case 2:
                    return "TUESDAY";
                case 3:
                    return "WEDNESDAY";
                case 4:
                    return "THURSDAY";
                case 5:
                    return "FRIDAY";
                case 6:
                    return "SATURDAY";
                case 7:
                    return "SUNDAY";
                default:
                    break;
            }
        } else {
            switch (i + 1) {
                case 1:
                    return "SUNDAY";
                case 2:
                    return "MONDAY";
                case 3:
                    return "TUESDAY";
                case 4:
                    return "WEDNESDAY";
                case 5:
                    return "THURSDAY";
                case 6:
                    return "FRIDAY";
                case 7:
                    return "SATURDAY";
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
