package kz.kaznitu.lessons.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String department_name;
    private String nachalnik;

    public Departments() {
    }

    public Departments(String department_name, String nachalnik) {
        this.department_name = department_name;
        this.nachalnik = nachalnik;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getNachalnik() {
        return nachalnik;
    }

    public void setNachalnik(String nachalnik) {
        this.nachalnik = nachalnik;
    }
}
