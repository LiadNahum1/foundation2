package ProjectPage;

public class AccessProxy implements Page {
    private Page page;
    private boolean isBlocked;
    public AccessProxy(Page page, boolean isBlocked){
        this.page = page;
        this.isBlocked = isBlocked;
    }

    public String showInfo(){
        String info ;
        if(isBlocked) {
            info = "Access for " + page.getClass().getSimpleName() + " is blocked !\n";
            if(page instanceof AdvancedPage )
                info += ((AdvancedPage) page).getPartOfPage().showInfo();
        }
        else
            info = page.showInfo();
        return info;
    }
}
