package ProjectPage.Menu;
import ProjectPage.Page;

public class TopMenu extends Menu {
    public TopMenu(Page partOfPage) {
        super(partOfPage);
    }
    public String showInfo() {
        return getPartOfPage().showInfo() + " Adding upper menu";
    }
}
