package ca.bcit.infosys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ca.bcit.infosys.employee.Employee;
import ca.bcit.infosys.timesheet.Timesheet;
import ca.bcit.infosys.timesheet.TimesheetCollection;
import ca.bcit.infosys.timesheet.TimesheetRow;
/**
 * TimesheetTracker bean used to manipulate and interact with timesheet objects.
 * @author Cameron
 * @version 1.0
 *
 */
@Named
@ApplicationScoped
public class TimesheetTracker implements TimesheetCollection, Serializable {

    /** Preferred work hours per week. */
    private static final int HOURS_FOR_WEEK = 40;

    private List<Timesheet> timesheets = new ArrayList<>();
    @Inject private Timesheet currentTimesheet;

    @Override
    public List<Timesheet> getTimesheets() {
        return timesheets;
    }

    @Override
    public List<Timesheet> getTimesheets(Employee e) {
        List<Timesheet> employeeTimesheet = new ArrayList<>();
        for (Timesheet timesheet : timesheets) {
            if (e.getEmpNumber() == timesheet.getEmployee().getEmpNumber()) {
                employeeTimesheet.add(timesheet);
            }
        }
        return employeeTimesheet;
    }

    @Override
    public Timesheet getCurrentTimesheet(Employee e) {
        return currentTimesheet;
    }

    /**
     * Returns the current timesheet.
     * @return currentTimesheet
     */
    public Timesheet getCurrentTimesheet() {
        return currentTimesheet;
    }

    @Override
    public String addTimesheet(Timesheet timesheet) {
        return null;
    }

    /**
     * Adds a timesheet object to the timesheets list.
     * @param timesheet accepts a timesheet object
     * @param employee accepts an employee object
     * @return string for navigation
     */
    public String addTimesheet(Timesheet timesheet, Employee employee) {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = ResourceBundle
                .getBundle("ca.bcit.infosys.messages",
                context.getViewRoot().getLocale());

        if (!validateTimesheet(timesheet)) {
            context.addMessage(
                    null, new FacesMessage(bundle.getString("failed"),
                    bundle.getString("error_message_id_wp")));
            return "fail";
        } else {
            int index = isNewTimesheet(timesheet, employee);
            if (index == -1) {
                timesheet.setEmployee(employee);
                timesheets.add(timesheet);
                currentTimesheet = timesheet;
                context.addMessage(
                        null, new FacesMessage(bundle.getString("successful"),
                        bundle.getString("saved_message_id_wp")));
            } else {
                timesheets.remove(index);
                timesheet.setEmployee(employee);
                timesheets.add(timesheet);
                currentTimesheet = timesheet;
                context.addMessage(
                        null, new FacesMessage(bundle.getString("successful"),
                        bundle.getString("updated_message_id_wp")));
            }
            return null;
        }

    }

    /**
     * Checks to see if the timesheet is new or if it already exists.
     * @param timesheet accepts a timesheet object
     * @param employee accepts an employee object
     * @return returns the index of the timesheet, -1 if none exists
     */
    public int isNewTimesheet(Timesheet timesheet, Employee employee) {
        List<Timesheet> tempTimesheetPerEmployee = getTimesheets(employee);
        int index = 0;
        for (Timesheet tempTimesheet : tempTimesheetPerEmployee) {
            if (timesheet.getWeekNumber() == tempTimesheet.getWeekNumber()) {
                return index;
            }
            index++;
        }
        return -1;
    }

    /**
     * Checks to see if the sheet contains a duplicate id + WP combo.
     * @param timesheet accepts a timesheet object
     * @return return true if the timesheet has a unique id + WP
     */
    public boolean validateTimesheet(Timesheet timesheet) {
        List<TimesheetRow> tempDetail = timesheet.getDetails();
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = ResourceBundle
                .getBundle("ca.bcit.infosys.messages",
                context.getViewRoot().getLocale());

        for (int i = 0; i < tempDetail.size() - 1; i++) {
            if ((tempDetail.get(i).getWorkPackage()
                    + tempDetail.get(i).getProjectID()).equals("0")) {
                return true;
            }
            if (tempDetail.get(i).getSum().intValueExact() > HOURS_FOR_WEEK) {
                context.addMessage(
                        null, new FacesMessage(bundle.getString("warning"),
                        bundle.getString("overtime_warning")));
            }
            for (int j = i + 1; j < tempDetail.size(); j++) {
                if ((tempDetail.get(j).getWorkPackage()
                        + tempDetail.get(j).getProjectID()).equals("0")) {
                    return true;
                }
                if ((tempDetail.get(i).getWorkPackage()
                        + tempDetail.get(i).getProjectID())
                        .equals(tempDetail.get(j).getWorkPackage()
                                + tempDetail.get(j).getProjectID())) {
                    return false;
                }
            }
        }
        return true;
    }

}
