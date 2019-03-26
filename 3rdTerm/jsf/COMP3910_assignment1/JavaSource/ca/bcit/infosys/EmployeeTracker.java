package ca.bcit.infosys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ca.bcit.infosys.employee.Credentials;
import ca.bcit.infosys.employee.Employee;
import ca.bcit.infosys.employee.EmployeeList;
/**
 * Employee tracker bean used to implement functions that are needed to
 * manipulate employee objects.
 * @author Cameron
 * @version 1.0
 *
 */
@Named
@ApplicationScoped
public class EmployeeTracker implements EmployeeList, Serializable {

    private static AtomicInteger employeeCounter = new AtomicInteger();

    private static final Employee ADMINISTRATOR = new Employee(
            "test", employeeCounter.incrementAndGet(), "test");
    private static final Employee[] INITIAL_EMPLOYEES = {ADMINISTRATOR,
            new Employee("Cam Lay", employeeCounter.incrementAndGet(),
                    "cam.lay"),
            new Employee("Edmund Ham", employeeCounter.incrementAndGet(),
                    "edmund.ham"),
            new Employee("John Smith", employeeCounter.incrementAndGet(),
                    "john.smith"),
            new Employee("Danny Di Iorio", employeeCounter.incrementAndGet(),
                    "danny.di.iorio"),
            new Employee("Tony Pacheco", employeeCounter.incrementAndGet(),
                    "tony.pacheco"),
            new Employee("Bruce Link", employeeCounter.incrementAndGet(),
                    "bruce.link") };
    private static List<Employee> employees =
            new ArrayList<>(Arrays.asList(INITIAL_EMPLOYEES));
    private static Map<String, String> loginCombos;
    static {
        loginCombos = new HashMap<String, String>();
        loginCombos.put("test", "test");
        loginCombos.put("cam.lay", "cam.lay");
        loginCombos.put("edmund.ham", "edmund.ham");
        loginCombos.put("danny.di.iorio", "danny.di.iorio");
        loginCombos.put("john.smith", "john.smith");
        loginCombos.put("tony.pacheco", "tony.pacheco");
        loginCombos.put("bruce.link", "bruce.link");
    }




    @Inject
    private Employee currentEmployee;
    private Employee employeeToBeEdited;
    private Credentials credentialToBeEdited;
    private Employee employeeToBeAdded;
    private Credentials credentialToBeAdded;
    private String addedName;
    private String addedUserName;
    private String addedPassword;
    private String oldPassword;
    private String newPassword;

    /**
     * Function to add new users and create credentials for them.
     */
    public void addNewAction() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (this.addedName != null
                && this.addedUserName != null
                && this.addedPassword != null) {

            employeeToBeAdded = new Employee(this.addedName,
                    employeeCounter.incrementAndGet(),
                    this.addedUserName);
            employees.add(employeeToBeAdded);
            loginCombos.put(this.addedUserName, this.addedPassword);
            context.addMessage(null,
                    new FacesMessage("Successful", "User has been added"));
        } else {
        context.addMessage(null,
                new FacesMessage("Fail", "Must fill in all fields"));
        }
        this.addedName = null;
        this.addedUserName = null;
        this.addedPassword = null;
    }


    @Override
    public List<Employee> getEmployees() {
        if (currentEmployee.getEmpNumber() == ADMINISTRATOR.getEmpNumber()) {
            return employees;
        } else {
            return null;
        }
    }

    @Override
    public Employee getEmployee(String name) {
        for (Employee employee : employees) {
            if (name.equals(employee.getUserName())) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public Map<String, String> getLoginCombos() {
        if (currentEmployee.getEmpNumber() == ADMINISTRATOR.getEmpNumber()) {
            return loginCombos;
        } else {
            return null;
        }
    }

    @Override
    public Employee getCurrentEmployee() {
        return currentEmployee;
    }

    @Override
    public Employee getAdministrator() {
        return ADMINISTRATOR;
    }

    /**
     * Helper function to check if the user is an admin.
     * @param userName accepts a string input
     * @return true if user is an administrator
     */
    public boolean isAdmin(String userName) {
        return userName.equals(ADMINISTRATOR.getUserName());
    }

    @Override
    public boolean verifyUser(Credentials credential) {
        try {
            boolean isVerified = loginCombos.get(
                    credential.getUserName()).equals(credential.getPassword());
            currentEmployee = this.getEmployee(credential.getUserName());
            return isVerified;
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public String logout(Employee employee) {
        if (currentEmployee.getUserName().equals(employee.getUserName())) {
            return "logoutSuccess";
        } else {
            return "logoutFail";
        }
    }

    @Override
    public void deleteEmployee(Employee userToDelete) {
        if (currentEmployee.getEmpNumber() == ADMINISTRATOR.getEmpNumber()) {
            int i = 0;
            while (i < employees.size()) {
                if (employees.get(i).getUserName()
                        .equals(userToDelete.getUserName())) {
                    break;
                }
                i++;
            }
            employees.remove(i);
        }

    }

    @Override
    public void addEmployee(Employee newEmployee) {

        employees.add(newEmployee);
    }

    /**
     * Increments the employee counter and returns it.
     * @return incremented employee number
     */
    public Integer getAutoEmployeeNumber() {
        return employeeCounter.incrementAndGet();
    }

    /**
     * Checks to see if an employee is editable for the current user.
     * @param employee accepts an employee object
     * @return true if the employee is editable
     */
    public boolean isEditable(Employee employee) {
        if (employee.getEmpNumber() == currentEmployee.getEmpNumber()
                || isAdmin(currentEmployee.getUserName())) {
            setEmployeeToBeEdited(employee);
            setCredentialToBeEdited(new Credentials(employee.getUserName(),
                    loginCombos.get(employee.getUserName())));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the employee to be edited.
     * @return employee to be edited
     */
    public Employee getEmployeeToBeEdited() {
        return employeeToBeEdited;
    }

    /**
     * Sets the employee to be edited.
     * @param employeeToBeEdited accepts an employee object
     */
    public void setEmployeeToBeEdited(Employee employeeToBeEdited) {
        this.employeeToBeEdited = employeeToBeEdited;
    }

    /**
     * Gets the credentials to be edited.
     * @return Credentials object to be edited
     */
    public Credentials getCredentialToBeEdited() {
        return credentialToBeEdited;
    }

    /**
     * Sets the credentials that are to be edited.
     * @param credentialToBeEdited accepts a Credentials Object
     */
    public void setCredentialToBeEdited(Credentials credentialToBeEdited) {
        this.credentialToBeEdited = credentialToBeEdited;
    }

    /**
     * Updates employee password.
     */
    public void updateEmployeePassword() {
        loginCombos.put(employeeToBeEdited.getUserName(),
                credentialToBeEdited.getPassword());
    }

    /**
     * Gets employee to be added.
     * @return the employeeToBeAdded
     */
    public Employee getEmployeeToBeAdded() {
        return employeeToBeAdded;
    }

    /**
     * Sets employee to be added.
     * @param employeeToBeAdded the employeeToBeAdded to set
     */
    public void setEmployeeToBeAdded(Employee employeeToBeAdded) {
        this.employeeToBeAdded = employeeToBeAdded;
    }

    /**
     * Gets credentials to be added.
     * @return the credentialToBeAdded
     */
    public Credentials getCredentialToBeAdded() {
        return credentialToBeAdded;
    }

    /**
     * Sets credentials to be added.
     * @param credentialToBeAdded the credentialToBeAdded to set
     */
    public void setCredentialToBeAdded(Credentials credentialToBeAdded) {
        this.credentialToBeAdded = credentialToBeAdded;
    }

    /**
     * Gets the name to be added.
     * @return the addedName
     */
    public String getAddedName() {
        return addedName;
    }


    /**
     * Sets the name to be added.
     * @param addedName the addedName to set
     */
    public void setAddedName(String addedName) {
        this.addedName = addedName;
    }


    /**
     * Gets the username to be added.
     * @return the addedUserName
     */
    public String getAddedUserName() {
        return addedUserName;
    }


    /**
     * Sets the username to be added.
     * @param addedUserName the addedUserName to set
     */
    public void setAddedUserName(String addedUserName) {
        this.addedUserName = addedUserName;
    }


    /**
     * Gets the password to be added.
     * @return the addedPassword
     */
    public String getAddedPassword() {
        return addedPassword;
    }


    /**
     * Sets the password to be added.
     * @param addedPassword the addedPassword to set
     */
    public void setAddedPassword(String addedPassword) {
        this.addedPassword = addedPassword;
    }


    /**
     * Variable to hold input for old password.
     * @return the oldPassword
     */
    public String getOldPassword() {
        return oldPassword;
    }


    /**
     * Sets the variable that holds user entered old password.
     * @param oldPassword the oldPassword to set
     */
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }


    /**
     * Variable to get the user input for new password.
     * @return the newPassword
     */
    public String getNewPassword() {
        return newPassword;
    }


    /**
     * Variable to set the new password through user input.
     * @param newPassword the newPassword to set
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * Updates the employee's password.
     * @param oldPword accepts a string
     * @param newPword accepts a string
     * @return string for navigation
     */
    public String updateEmployee(String oldPword, String newPword) {
        FacesContext context = FacesContext.getCurrentInstance();


        if ((oldPword.compareTo(loginCombos
                .get(currentEmployee.getUserName()))) != 0) {
            context.addMessage(null, new FacesMessage("Fail",
                    "Incorrect old password"));
            return null;
        } else if ((oldPword.compareTo(newPword)) == 0) {
            context.addMessage(null, new FacesMessage("Fail",
                    "Password must be different"));
            return null;
        }
        context.addMessage(null, new FacesMessage("Successful",
                "Your password has been changed"));
        loginCombos.put(currentEmployee.getUserName(), newPword);

        return null;
    }
}
