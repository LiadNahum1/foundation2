package ProjectPage.Element;

import ProjectPage.AdvancedPage;
import ProjectPage.Page;

public abstract class Element extends AdvancedPage {

    public Element(Page partOfPage) {
        super(partOfPage);
    }
    public String showInfo() {
        return getPartOfPage().showInfo() + " Adding element ";
    }
}
