package MainProject;

public class MessageSystem implements Observer {
    public MessageSystem(){
    }
    @Override
    public void update(Subject subject) {
        System.out.println("A project has approved. The details are: ");
        System.out.println(((Project) subject).getDetailsForAll());
    }
}
