package ProjectPage.Menu;

import ProjectPage.Page;

public class RightMenu extends Menu {
    public RightMenu(Page partOfPage) {
        super(partOfPage);
    }
    public String showInfo() {
        return super.showInfo() + " Right menu is displayed";
    }
}
