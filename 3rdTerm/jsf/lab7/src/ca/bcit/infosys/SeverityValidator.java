package ca.bcit.infosys;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import java.util.Locale;
import java.util.ResourceBundle;

@FacesValidator("SeverityValidator")
public class SeverityValidator implements Validator {
    public void validate(FacesContext context, UIComponent component,
                         Object value) {
        if(value == null) {
            return;
        }
        String status = null;

//        if (value instanceof ProblemReport) {
            status = value.toString();

            if (!(status.equalsIgnoreCase(ProblemReport.Status.MEDIUM.toString()) ||
                    status.equalsIgnoreCase(ProblemReport.Status.HIGH.toString()) ||
                    status.equalsIgnoreCase(ProblemReport.Status.LOW.toString()))) {

                FacesMessage message = new FacesMessage("Security should be one of High, Medium, Low",  null);
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
//        }
    }
}
