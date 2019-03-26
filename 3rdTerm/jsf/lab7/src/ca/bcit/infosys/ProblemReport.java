package ca.bcit.infosys;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class ProblemReport implements Serializable {

    @Inject private Project project;
    @Inject
    Conversation conversation;

    private static boolean isNewRequest = true;

    private static final long serialVersionUID = 1L;
    private Integer number;
    private Date date = new Date();
    private String originator;
    private String modules;
    private String description;
    private String solution;
    private String priority;
    private String security;
    private Date assignedDate = new Date();
    private Date fixedDate = new Date();
    private boolean scope;

    private Status priorityStatus;
    private Status securityStatus;

    public String getDocumentTitle() {
        FacesContext context = FacesContext.getCurrentInstance();
        Application app = context.getApplication();
        ResourceBundle backendText = app.getResourceBundle(context, "msgs");
        String documentTitle;
        if (scope) {
            documentTitle = backendText.getString("checkedDocumentTitle");
        } else {
            documentTitle = backendText.getString("documentTitle");
        }
        return documentTitle;
    }

    @PostConstruct
    public void init() {
        conversation.begin();
    }

    @PreDestroy
    public void destroy() {
        conversation.end();
    }

    public void setPriorityStatus(Status priorityStatus) {
        this.priorityStatus = priorityStatus;
    }

    public Status getPriorityStatus() {
        return priorityStatus;
    }

    public Status getSecurityStatus() {
        return securityStatus;
    }

    public void setSecurityStatus(Status securityStatus) {
        this.securityStatus = securityStatus;
    }

    public boolean isScope() {
        return scope;
    }

    public void setScope(boolean scope) {
        this.scope = scope;
    }

    public enum Status {
        LOW, MEDIUM, HIGH, CRITICAL;
        public String toString() {
            return name().charAt(0) + name().substring(1).toLowerCase();
        }
    }

    public Map<String, Status> getStatusType() {
        Map<String, Status> map = new LinkedHashMap<>();
        for (Status status : Status.values()) {
            map.put(status.toString(), status);
        }
        return map;
    }

    public Map<String, Status> getSecurityLevel() {
        Map<String, Status> map = new LinkedHashMap<>();
        for (Status status : Status.values()) {
            if (status != Status.CRITICAL) {
                map.put(status.toString(), status);
            }
        }
        return map;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = modules;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public Date getFixedDate() {
        return fixedDate;
    }

    public void setFixedDate(Date fixedDate) {
        this.fixedDate = fixedDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String submit() {
        return "success";
    }

    public String edit() {
        return "edit";
    }

    public String newProblem() {
        return "newProblem";
    }

}
