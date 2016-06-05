package com.gdglapaz.io.legotbbtiot.model;

/**
 * Created by andresvasquez on 4/6/16.
 */
public class Developer {

    /* Developers who contributed in the project */

    public long id;
    public String name;
    public String email;
    public String organitation;

    public Developer(long id, String name, String email, String organitation) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.organitation = organitation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganitation() {
        return organitation;
    }

    public void setOrganitation(String organitation) {
        this.organitation = organitation;
    }
}
