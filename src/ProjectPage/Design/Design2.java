package ProjectPage.Design;

import ProjectPage.Page;

public class Design2 extends Design {
    public Design2(Page partOfPage) {
        super(partOfPage);
    }
    public String showInfo() {
        return getPartOfPage().showInfo() + " Adding design2 ";
    }
}
