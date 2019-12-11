package ProjectPage.Element;

import ProjectPage.Page;

public class Music extends  Element {
    public Music(Page partOfPage) {
        super(partOfPage);
    }
    public String showInfo() {
        return getPartOfPage().showInfo() + " Adding music file ";
    }
}
