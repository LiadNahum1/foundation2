package ProjectPage.Element;

import ProjectPage.Page;

public class Link extends Element {
    public Link(Page partOfPage) {
        super(partOfPage);
    }
    public String showInfo() {
        return getPartOfPage().showInfo() + " Adding link ";
    }
}
