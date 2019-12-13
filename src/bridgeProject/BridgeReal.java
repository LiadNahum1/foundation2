package bridgeProject;

import MainProject.ManagementSystem;
import acptTests.auxiliary.DBRegisteredProjectInfo;
import acptTests.auxiliary.DBSuggestedProjectInfo;
public class BridgeReal implements BridgeProject {
    private ManagementSystem m = new ManagementSystem();
    @Override
    public void registerNewTechnicalAdviser(String user, String password) {
        m.registerAsOffer(user,password,"","","","");
    }

    @Override
    public void addNewStudent(String user, String password) {
        m.registerAsStudent(user,password,"");
    }

    @Override
    public int addNewProject(String user, String pass, DBSuggestedProjectInfo suggestedProject) {
        return m.addProject(user,pass,suggestedProject.firstName,suggestedProject.description,suggestedProject.numberOfHours,suggestedProject.organization);
    }

    @Override
    public int registerToProject(String user, String pass, DBRegisteredProjectInfo registeredProject) {
        String answer =  m.registerProject(user,pass,registeredProject.projectId,registeredProject.studentList,registeredProject.academicAdviser);
        if(answer == "")
            return 0;
        else return 1;
    }
}