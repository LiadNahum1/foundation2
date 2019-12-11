package ProjectPage;

public abstract class AdvancedPage implements Page{
    private Page partOfPage;
    public AdvancedPage(Page partOfPage){
        this.partOfPage = partOfPage;
    }
    public String showInfo() {
        return getPartOfPage().showInfo();
    }

    public Page getPartOfPage() {
        return partOfPage;
    }
}
