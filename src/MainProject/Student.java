package MainProject;

import java.util.HashMap;

public class Student extends User implements Observer{
    private String id;
    private SignedProject project; // a project this student is signed to
    private HashMap<Project, String> informStudentBy; //student who wants to know about project by email or sms
    public Student(String username, String password, String id) {
        super(username, password);
        this.id = id;
        this.project = null;
        this.informStudentBy = new HashMap<>();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public SignedProject getProject() {
        return project;
    }
    public void setProject(SignedProject project) {
        this.project = project;
    }

    public void informStudent(Project project, String by){ //by = "email" or "sms"
        informStudentBy.put(project, by);
        project.attach(this);
    }
    @Override
    public void update(Subject subject) {
        String msgDet = "MainProject.Project has approved and now you can sign to it. The project's details are:\n" +
                ((Project) subject).getDetails();
        String by = informStudentBy.get(subject);
        if(by.equals("email"))
            sendByEmail(msgDet);
        else
            sendBySMS(msgDet);
    }

    private void sendBySMS(String msgDet) {
        System.out.println("This is a message in SMS");
        System.out.println(msgDet);
    }

    private void sendByEmail(String msgDet) {
        System.out.println("This is a message in email");
        System.out.println(msgDet);
    }
}
