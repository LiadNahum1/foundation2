package ProjectPage.Design;

import ProjectPage.AdvancedPage;
import ProjectPage.Page;

public abstract class Design extends AdvancedPage {
    public Design(Page partOfPage) {
        super(partOfPage);
    }
    public String showInfo() {
        return super.showInfo() + "\nAdding design ";
    }
}
