package kz.kaznitu.lessons.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Workers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String last_name;
    private String first_name;
    private String job;

    public Workers() {
    }

    public Workers(String last_name, String first_name, String job) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.job = job;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
