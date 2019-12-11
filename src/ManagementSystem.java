import java.util.*;

public class ManagementSystem {
    private List<User> users;
    private List<Project> projects;
    private List<SignedProject> signedProjects;
    private Scanner scanner;
    public ManagementSystem() {
        //read from database or read from file
        initializeData();
    }
    private void initializeData() {
        this.scanner = new Scanner(System.in);
        users = new LinkedList<>();
        projects = new LinkedList<>();
        signedProjects = new LinkedList<>();
        users.add(new Student("stud1", "stud1", "318841285"));
        users.add(new Student("stud2", "stud2", "207912734"));
        Offer offer = new Offer("offer1", "offer1", "offer1", "offer1", "email1", "0526144485");
        users.add(offer);
        projects.add(new Project("project1", "project1", 300, offer, "", Calendar.getInstance() ));
    }

    /*      Logic        */
    //register and add offer to the system
    private void registerAsOffer(String username, String password, String name, String familyName, String email, String phone) {
        this.users.add(new Offer(username, password, name, familyName, email, phone));
    }
    //register and add student to the system
    private void registerAsStudent(String username, String password, String id) {
        this.users.add(new Student(username, password, id));
    }
    //returns code project if succeed or -1 if failed login or failed in adding project
    private int addProject(String username, String password, String name, String description, int estimatedNumberOfHours, String organization) {
        User user = login(username, password);
        int code = -1;
        if(user != null & user instanceof Offer ) {
            Calendar today = Calendar.getInstance();
            if (checkValidityOfName(name, organization, (Offer)user, today) & checkValidityOfHours(estimatedNumberOfHours)) {
                Project newProject = new Project(name, description, estimatedNumberOfHours, (Offer) user , organization, today);
                addToProjectList(newProject);
                code = newProject.getCode();
                ((Offer)user).addProject(code);
            }
        }
        return code;
    }
    private void addToProjectList(Project newProject) {
        this.projects.add(newProject);
    }
    //same offer of organization can't offer projects with same names in the same year
    private boolean checkValidityOfName(String name, String organization, Offer user, Calendar today) {
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
    private boolean checkValidityOfHours(int estimatedNumberOfHours) {
        return estimatedNumberOfHours >= 200 & estimatedNumberOfHours <= 300;
    }

    private User login(String username, String password) {
        return checkLogin(username, password);
    }
    private User checkLogin(String username, String password) {
        for(User user : this.users){
            if(user.getUsername().equals(username) &  user.getPassword().equals(password))
                return user;
        }
        return null;
    }

    private List<Project> getUnsignedProjects() {
        List<Project> unsignedProjects = new LinkedList<>();
        for(Project project : this.projects)
        {
            if(project.getState() == State.APPROVED & project.getState() != State.IN_PROGRESS)
                unsignedProjects.add(project);
        }
        return unsignedProjects;
    }
    private void presentAllUnsignedProject() {
        List<Project> unsignedProjects = getUnsignedProjects();
        for(int index = 0; index < unsignedProjects.size(); index = index +1){
            System.out.println( (index+1) + ". " + unsignedProjects.get(index).toString());
        }
    }
    private int registerProject(String username, String password, int projectCode, List<String> ids, String nameOfMentor) {
        User user = login(username, password);
        int urlCode = -1;
        if(user != null & user instanceof Offer ) {
            List<Student> students = new LinkedList<>();
            students = checkIfLegalIdsList(ids);
            if (students != null) {
                Project project = getProjectByCode(projectCode);
                if(project != null) {
                    SignedProject signed = new SignedProject(students, project, nameOfMentor);
                    this.signedProjects.add(signed);
                    urlCode = signed.getCodeAccess();
                    project.setState(State.IN_PROGRESS); //project in progress because signing succeed
                }
            }
        }
        return urlCode;
    }
    private Project getProjectByCode(int projectCode) {
        for(Project project : this.projects){
            if(project.getCode() == projectCode)
                return project;
        }
        return null;
    }
    private List<Student> checkIfLegalIdsList(List<String> ids) {
        List<Student> students = new LinkedList<>();
        students = getStudents(ids);
        if(students.size() == ids.size() && (ids.size() >= 2 & ids.size() <= 4))
            return students;
        else return null;
    }
    private List<Student> getStudents(List<String> ids) {
        List<Student> students = new LinkedList<>();
        for(User user: this.users){
            if(user instanceof  Student) {
                Student student = (Student) user;
                if (user instanceof Student && (ids.contains(student.getId())))
                    students.add(student);
            }
        }
        return students;
    }


}

