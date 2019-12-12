package ProjectPage.Element;

import ProjectPage.Page;

public class Link extends Element {
    public Link(Page partOfPage, String link) {
        super(partOfPage, link);
    }
    public String showInfo() {
        return  super.showInfo() + "Link " + getElement() + " is displayed";
    }
}
