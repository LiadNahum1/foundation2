import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Project implements Subject{
    public static int generateCode = 0; // static field
    private String name;
    private String description;
    private int numberOfEstimatedHours;
    private Offer offer;
    private String organization;
    private int code;
    private State state;
    private Calendar creationDate;
    private List<Observer> observers;
    private String url; //url to the page that describes it in the system

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
        this.observers = new LinkedList<>();
        this.url = "";
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

    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

    public String toString(){
        String str =  "Name: " + this.name + "\nDescription: " + this.description + "\nOffer: " + offer.toString() +
                "\nOrganization: " + this.organization +"\nCode: " + this.code + "\nState: " + this.state + "\nCreation Date: " + this.creationDate.getTime().toString();
        if(this.url == "")
            str += "\nURL: None";
        else
            str += "\nURL: " + this.url;
        return str;
    }

    public String getDetails(){
        return "Name: " + this.name + "\nDescription: " + this.description + "\nOffer: " + offer.toString()
                + "\nURL: " + this.url;
    }

    public void approveProject(){
        setState(State.APPROVED);
        setUrl("www.website." + getName() + "_" + getCode());
        notifyObservers();

    }
    @Override
    public void attach(Observer observer) {
        if(!observers.contains(observer))
            observers.add(observer);
    }
    @Override
    public void detach(Observer observer) {
        observers.remove(observer);

    }
    @Override
    public void notifyObservers() {
        for(Observer o : observers)
            o.update(this);
    }
}
