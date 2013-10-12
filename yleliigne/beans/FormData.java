package beans;

import java.util.Map;

public class FormData {

    private String name;

    private Map<Integer, String> ageGroups;

    public Map<Integer, String> getAgeGroups() {
        return ageGroups;
    }

    public void setAgeGroups(Map<Integer, String> ageGroups) {
        this.ageGroups = ageGroups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
