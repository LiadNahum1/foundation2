package ProjectPage.Element;

import ProjectPage.Page;

public class Logo extends Element {
    public Logo(Page partOfPage) {
        super(partOfPage);
    }

    public String showInfo() {
        return getPartOfPage().showInfo() + " Adding element ";
    }
}
