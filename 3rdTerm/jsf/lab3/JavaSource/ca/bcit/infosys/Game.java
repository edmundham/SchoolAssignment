package ca.bcit.infosys;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@ConversationScoped
public class Game implements Serializable {

    private static final String LOW = "low";
    private static final String HIGH = "high";
    private static final String CORRECT = "correct";
    private static final String NOCHANGE = "noChange";
    private static final Integer MAX = 100;
    private static final Integer MIN = 1;

    private Integer numberOfTries = 0;
    private String userInput;
    private Integer lowerBound = MIN;
    private Integer upperBound = MAX;
    private String errorMessage;
    @Inject @ca.bcit.infosys.Random int randomNumber;
    @Inject Conversation conversation;

    public Integer getNumberOfTries() {
        return numberOfTries;
    }

    public void setNumberOfTries(Integer numberOfTries) {
        this.numberOfTries = numberOfTries;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public Integer getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(Integer lowerBound) {
        this.lowerBound = lowerBound;
    }

    public Integer getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(Integer upperBound) {
        this.upperBound = upperBound;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }

    @PostConstruct
    public void init() {
        if (numberOfTries == 0) {
            conversation.begin();
        }
    }

    @PreDestroy
    public void destroy() {
        conversation.end();
    }

    public String enterUserInput() {
        if (!isInteger(userInput)) {
            userInput = "";
            setErrorMessage("You should enter the number");
            return NOCHANGE;
        }
        if (upperBound < Integer.parseInt(userInput) || lowerBound > Integer.parseInt(userInput)) {
            userInput = "";
            setErrorMessage("You should enter the number in the range");
            return NOCHANGE;
        }

        numberOfTries++;
        if (randomNumber > Integer.parseInt(userInput)) {
            lowerBound = Integer.parseInt(userInput) + 1;
            userInput = "";
            setErrorMessage("");
            return HIGH;
        } else if (randomNumber < Integer.parseInt(userInput)) {
            upperBound = Integer.parseInt(userInput) - 1;
            userInput = "";
            setErrorMessage("");
            return LOW;
        } else {
            return CORRECT;
        }
    }

}
