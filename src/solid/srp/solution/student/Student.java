package solid.srp.solution.student;

import java.util.Date;

public class Student {

    private String id;
    private String name;
    private String address;

    public void save() {
        new StudentRepository().save(this);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
