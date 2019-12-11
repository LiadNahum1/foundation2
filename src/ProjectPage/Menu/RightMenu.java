package ProjectPage.Menu;

import ProjectPage.Page;

public class RightMenu extends Menu {
    public RightMenu(Page partOfPage) {
        super(partOfPage);
    }
    public String showInfo() {
        return getPartOfPage().showInfo() + " Adding right menu";
    }
}
