package MainProject;

import java.util.LinkedList;
import java.util.List;

public class Offer extends User{
    private String name;
    private String familyName;
    private String email;
    private String phone;
    private List<Integer> projectsCodes; //codes of projects this offer added

    public Offer(String username, String password, String name, String familyName, String email, String phone) {
        super(username, password);
        this.name = name;
        this.familyName = familyName;
        this.email = email;
        this.phone = phone;
        this.projectsCodes = new LinkedList<>();
    }

    public void addProject(int code){
        this.projectsCodes.add(code);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Integer> getProjectsCodes() {
        return projectsCodes;
    }

    public void setProjectsCodes(List<Integer> projectsCodes) {
        this.projectsCodes = projectsCodes;
    }

    /*TODO: assumption username and password are unique*/
    public boolean equals(Object offer){
        if(! (offer instanceof Offer))
            return false;
        else
        {
            if(((Offer) offer).getUsername() == getUsername() & ((Offer) offer).getPassword()== getPassword())
                return true;
            return false;
        }
    }

    public String toString(){
        return "Name: " + this.name + "Family Name: " + this.familyName + " Email: " + this.email + " Phone number: " + this.phone;
    }

    public boolean checkUnmissingData() {
        return checkNotNullOrEmpty(name) &  checkNotNullOrEmpty(familyName) & checkNotNullOrEmpty(email) & checkNotNullOrEmpty(phone);
    }

    private boolean checkNotNullOrEmpty(String field) {
        return field != null & field != "";
    }

}
