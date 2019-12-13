package ProjectPage.Menu;

import ProjectPage.AdvancedPage;
import ProjectPage.Page;

public abstract class Menu extends AdvancedPage {
    public Menu(Page partOfPage) {
        super(partOfPage);
    }

    public String showInfo() {
        return super.showInfo() + "\nAdding menu ";
    }
}
