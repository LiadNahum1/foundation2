import java.util.List;

public class SignedProject {
    public static int generateCode = 0; // static field
    private List<Student> participants;
    private Project project;
    private String mentor;
    private int codeAccess;

    public SignedProject(List<Student> participants, Project project, String mentor) {
        this.participants = participants;
        this.project = project;
        this.mentor = mentor;
        generateCode = generateCode + 1;
        this.codeAccess = generateCode;
    }

    public List<Student> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Student> participants) {
        this.participants = participants;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getCodeAccess() {
        return codeAccess;
    }

}
