package beans;

public class Unit {

    private String name;
    private String firstName;
    private Integer ageGroupId;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public Integer getAgeGroupId() {
        return ageGroupId;
    }
    public void setAgeGroupId(Integer ageGroupId) {
        this.ageGroupId = ageGroupId;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", firstName=" + firstName + ", ageGroupId=" + ageGroupId + "]";
    }


}
