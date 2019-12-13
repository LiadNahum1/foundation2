import java.util.List;

public class SignedProject {
    private List<Student> participants;
    private Project project;
    private String mentor;

    public SignedProject(List<Student> participants, Project project, String mentor) {
        this.participants = participants;
        this.project = project;
        this.mentor = mentor;
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

}
