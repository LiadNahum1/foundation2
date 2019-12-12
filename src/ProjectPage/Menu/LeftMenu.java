package ProjectPage.Menu;

import ProjectPage.Page;

public class LeftMenu extends Menu {
    public LeftMenu(Page partOfPage) {
        super(partOfPage);
    }
    public String showInfo() {
        return  super.showInfo() + " Left menu is displayed";
    }
}
