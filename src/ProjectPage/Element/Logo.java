package ProjectPage.Element;

import ProjectPage.Page;

public class Logo extends Element {
    public Logo(Page partOfPage, String logo) {
        super(partOfPage, logo);
    }

    public String showInfo() {
        return super.showInfo() + "Logo " + getElement() + " is displayed";
    }
}
