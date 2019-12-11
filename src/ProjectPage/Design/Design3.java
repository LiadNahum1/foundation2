package ProjectPage.Design;

import ProjectPage.Page;

public class Design3 extends Design{
    public Design3(Page partOfPage) {
        super(partOfPage);
    }
    public String showInfo() {
        return getPartOfPage().showInfo() + " Adding design3 ";
    }
}
