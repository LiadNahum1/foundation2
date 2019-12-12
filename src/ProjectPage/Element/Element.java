package ProjectPage.Element;

import ProjectPage.AdvancedPage;
import ProjectPage.Page;

public abstract class Element extends AdvancedPage {
    private String element;
    public Element(Page partOfPage, String element) {
        super(partOfPage);
        this.element = element;
    }
    public String showInfo() {
        return getPartOfPage().showInfo() + "\nAdding element ";
    }

    public String getElement() {
        return element;
    }
}
