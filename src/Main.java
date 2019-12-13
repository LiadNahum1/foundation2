import MainProject.ManagementSystem;
import ProjectPage.*;
import ProjectPage.Element.*;
import ProjectPage.Design.*;

public class Main {

    public static void main(String[] args) {
	    ManagementSystem manageSystem = new ManagementSystem();
        Page page1 = new Design1(new Link ( new AccessProxy(new Logo(new BasicPage(), "logo1") ,true), "link1"));
        Page page2 = new Design1(new Link ( new Logo(new BasicPage(), "logo1"), "link1"));

        System.out.println(page1.showInfo());
        System.out.println( );
        System.out.println(page2.showInfo());
    }
}
