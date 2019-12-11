package ProjectPage.Design;

import ProjectPage.Page;

public class Design4 extends Design {
    public Design4(Page partOfPage) {
        super(partOfPage);
    }
    public String showInfo() {
        return getPartOfPage().showInfo() + " Adding design4 ";
    }
}
