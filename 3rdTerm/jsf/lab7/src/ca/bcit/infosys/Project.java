package ca.bcit.infosys;

import java.io.Serializable;

import javax.enterprise.context.Dependent;

@Dependent
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
