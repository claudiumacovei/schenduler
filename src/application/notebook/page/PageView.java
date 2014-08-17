package application.notebook.page;

import java.beans.PropertyChangeEvent;

import org.slf4j.Logger;

import application.notebook.page._abstract.AbstractPageView;

public class PageView extends AbstractPageView {
    
    private PageController controller = null;
    private PageModel model = null;
    
    public PageView(Logger logger) {
    
        super(logger);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void modelPropertyChange(PropertyChangeEvent evt) {
    
        // TODO Auto-generated method stub
        
    }
    
}
