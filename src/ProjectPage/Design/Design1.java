package ProjectPage.Design;

import ProjectPage.Page;

public class Design1 extends  Design {
    public Design1(Page partOfPage) {
        super(partOfPage);
    }
    public String showInfo() {
        return super.showInfo() + " Using design1 ";
    }
}
