package ProjectPage.Element;

import ProjectPage.Page;

public class Music extends  Element {
    public Music(Page partOfPage, String nameSong) {
        super(partOfPage, nameSong);
    }
    public String showInfo() {
        return super.showInfo() + "Music " + getElement() + " is played";
    }
}
