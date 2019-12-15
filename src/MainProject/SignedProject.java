package MainProject;

import java.util.List;

public class SignedProject {
    private List<String> participants;
    private Project project;
    private String mentor;

    public SignedProject(List<String> participants, Project project, String mentor) {
        this.participants = participants;
        this.project = project;
        this.mentor = mentor;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
