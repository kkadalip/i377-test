package model;

import javax.persistence.*;

public class Unit extends AbstractEntity {

    public Unit() {}

    public Unit(String name, String code) {
        this.name = name;
        this.code = code;
    }

    private String name;
    private String code;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

    @Override
    public String toString() {
        return "Unit name: " + name + " Unit code: " + code;
    }
}
