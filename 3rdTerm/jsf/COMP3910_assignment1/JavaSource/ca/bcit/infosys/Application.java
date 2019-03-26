package ca.bcit.infosys;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ca.bcit.infosys.employee.Credentials;
import ca.bcit.infosys.employee.Employee;
/**
 * Application bean which contains helper functions to login and edit passwords.
 * @author Cameron
 * @version 1.0
 *
 */
@Named("timesheetApplication")
@RequestScoped
public class Application {

    @Inject private EmployeeTracker employeeTracker;

    /**
     * Login function which will check that a user is an admin and
     * see if the login is successful.
     * @param userName accepts a string
     * @param password accepts a string
     * @return string based on if login is a success or failure
     */
    public String login(String userName, String password) {
        FacesContext context = FacesContext.getCurrentInstance();
        if (employeeTracker.verifyUser(new Credentials(userName, password))) {
            if (employeeTracker.isAdmin(userName)) {
                return "admin";
            }
            return "success";
        } else {
            context.addMessage(null, new FacesMessage("Fail",
                    "Incorrect username or password"));
            return null;
        }
    }

    /**
     * Function used to indicate if a password was successfully changed.
     * @param employee accepts an Employee object
     * @return string on whether the edit succeeded or failed.
     */
    public String editPasswordButton(Employee employee) {
        if (employeeTracker.isEditable(employee)) {
            return "edit";
        } else {
            return "fail";
        }
    }

    /**
     * Returns a string describing who changed the password.
     * @return string depending if it was a user or admin that changed password
     */
    public String editOneUserPassword() {
        employeeTracker.updateEmployeePassword();
        return employeeTracker.isAdmin(employeeTracker
                .getAdministrator()
                .getUserName()) ? "adminSuccess" : "userSuccess";
    }

    /**
     * Formats the date into a dd/MM/yyyy format.
     * @param date accepts a date object
     * @return formatted date
     */
    public String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }
}
