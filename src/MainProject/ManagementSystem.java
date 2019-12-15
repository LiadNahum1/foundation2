package MainProject;

import java.util.*;

public class ManagementSystem {
    private List<User> users;
    private List<Project> projects;
    private List<SignedProject> signedProjects;
    public ManagementSystem() {
        users = new LinkedList<>();
        projects = new LinkedList<>();
        signedProjects = new LinkedList<>();

    }

    /*      Logic        */
    //register and add offer to the system
    public void registerAsOffer(String username, String password, String name, String familyName, String email, String phone) {
        this.users.add(new Offer(username, password, name, familyName, email, phone));
    }
    //register and add student to the system
    public void registerAsStudent(String username, String password, String id) {
        this.users.add(new Student(username, password, id));
    }
    //returns code project if succeed or 0 if failed login or failed in adding project
    public int addProject(String username, String password, String firstName, String lastName, String phone, String email, String name, String description, int estimatedNumberOfHours, String organization) {
        User user = login(username, password);
        int code = 0;
        if(user != null & user instanceof Offer ) {
            Offer offer = (Offer) user;
            offer.setName(firstName); offer.setFamilyName(lastName); offer.setPhone(phone); offer.setEmail(email); //set data of offer
            boolean isLegalData =  checkUnmissingData(name, description, (Offer)user);
            Calendar today = Calendar.getInstance();
            if (isLegalData & checkValidityOfName(name, organization, (Offer)user, today) & checkValidityOfHours(estimatedNumberOfHours)) {
                Project newProject = new Project(name, description, estimatedNumberOfHours, (Offer) user , organization, today);
                addToProjectList(newProject);
                code = newProject.getCode();
                ((Offer)user).addProject(code);
            }
        }
        return code;
    }
    private boolean checkUnmissingData(String name, String description, Offer user) {
        if(checkNotNullOrEmpty(name) & checkNotNullOrEmpty(description) & user.checkUnmissingData())
            return true;
        return false;
    }
    private boolean checkNotNullOrEmpty(String field) {
        return field != null & field != "";
    }
    //same offer of organization can't offer projects with same names in the same year
    public boolean checkValidityOfName(String name, String organization, Offer user, Calendar today) {
        for(Project project: this.projects)
        {
            int yearOfSpecificProject = project.getCreationDate().get(Calendar.YEAR);
            int yearOfNewProject = today.get(Calendar.YEAR);
            // same name same year of the same offer or organization
            if(project.getName().equals(name) & yearOfSpecificProject == yearOfNewProject &
                    (project.getOffer().equals(user) | project.getOrganization() == organization)){
                return false;
            }
        }
        return true;
    }
    public boolean checkValidityOfHours(int estimatedNumberOfHours) {
        return estimatedNumberOfHours >= 200 & estimatedNumberOfHours <= 300;
    }


    public void addToProjectList(Project newProject) {
        this.projects.add(newProject);
    }


    public User login(String username, String password) {
        return checkLogin(username, password);
    }
    public User checkLogin(String username, String password) {
        for(User user : this.users){
            if(user.getUsername().equals(username) &  user.getPassword().equals(password))
                return user;
        }
        return null;
    }

    public List<Project> getUnsignedProjects() {
        List<Project> unsignedProjects = new LinkedList<>();
        for(Project project : this.projects)
        {
            if(project.getState() == State.APPROVED & project.getState() != State.IN_PROGRESS)
                unsignedProjects.add(project);
        }
        return unsignedProjects;
    }
    public void presentAllUnsignedProject() {
        List<Project> unsignedProjects = getUnsignedProjects();
        for(int index = 0; index < unsignedProjects.size(); index = index +1){
            System.out.println( (index+1) + ". " + unsignedProjects.get(index).toString());
        }
    }
    public String registerProject(String username, String password, int projectCode, List<String> ids, String nameOfMentor) {
        User user = login(username, password);
        String urlCode = "";
        if(user != null & user instanceof Student ) {
                Project project = getProjectByCode(projectCode);
                if(project != null) {
                      if (checkIfLegalIdsList(ids) & checkIfUnsigned(project) & checkLegalMentor(nameOfMentor)) {
                        SignedProject signed = new SignedProject(ids, project, nameOfMentor);
                        this.signedProjects.add(signed);
                        urlCode = project.getUrl(); //url is defined when project was approved
                        project.setState(State.IN_PROGRESS); //project in progress because signing succeed
                    }
                }
        }
        return urlCode;
    }

    private boolean checkLegalMentor(String nameOfMentor) {
        return nameOfMentor != null & nameOfMentor != "";
    }
    private boolean checkIfUnsigned(Project project) {
        if(project.getState() != State.IN_PROGRESS)
            return true;
        return false;
    }
    public Project getProjectByCode(int projectCode) {
        for(Project project : this.projects){
            if(project.getCode() == projectCode)
                return project;
        }
        return null;
    }
    public boolean checkIfLegalIdsList(List<String> ids) {
        return (ids.size() >= 2 & ids.size() <= 4);
    }

    public void approveProject(int id){
        for(Project project : this.projects) {
            //assume project is in checking before approving
            if (project.getState() == State.IN_CHECKING & project.getCode() == id)
                project.approveProject();
        }
    }

    public void informStudent(Student student, Project project, String by){
        student.informStudent(project, by);
    }
}

