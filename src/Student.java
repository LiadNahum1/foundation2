public class Student extends User{
    private String id;
    private SignedProject project; // a project this student is signed to
    public Student(String username, String password, String id) {
        super(username, password);
        this.id = id;
        this.project = null;
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
}
