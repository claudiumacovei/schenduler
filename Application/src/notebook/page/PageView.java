package notebook.page;

import java.beans.PropertyChangeEvent;

import notebook.page.abstractc.AbstractPageView;

import org.slf4j.Logger;

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
