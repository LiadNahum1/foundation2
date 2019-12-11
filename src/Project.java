import java.util.Calendar;
import java.util.Date;

public class Project {
    public static int generateCode = 0; // static field
    private String name;
    private String description;
    private int numberOfEstimatedHours;
    private Offer offer;
    private String organization;
    private int code;
    private State state;
    private Calendar creationDate;

    public Project(String name, String description, int numberOfEstimatedHours, Offer offer, String organization, Calendar today) {
        this.name = name;
        this.description = description;
        this.numberOfEstimatedHours = numberOfEstimatedHours;
        this.offer = offer;
        this.organization = organization;
        generateCode = generateCode + 1;
        this.code = generateCode;
        this.state = State.IN_CHECKING;
        this.creationDate = today;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfEstimatedHours() {
        return numberOfEstimatedHours;
    }

    public void setNumberOfEstimatedHours(int numberOfEstimatedHours) {
        this.numberOfEstimatedHours = numberOfEstimatedHours;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }
    public String toString(){
        return "Name: " + this.name + "\nDescription: " + this.description + "\nOffer: " + offer.toString() +
                "\nOrganization: " + this.organization +"\nCode: " + this.code + "\nState: " + this.state + "\nCreation Date: " + this.creationDate.getTime().toString();
    }
}
