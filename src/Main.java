import ProjectPage.*;
import ProjectPage.Element.*;
import ProjectPage.Design.*;
import ProjectPage.Menu.*;

public class Main {

    public static void main(String[] args) {
	    ManagementSystem manageSystem = new ManagementSystem();
        System.out.println((new Design1(new Link (new Logo(new BasicPage())))).showInfo());
    }
}
