package q3;

import java.text.DecimalFormat;

/**
 * <p>This is a class that contains information of Students.
 * Student class is invoked in TestStudent.java file.</p>
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 * 
 */
public class Student {
    
    /**
     * <p>DecimalFormat object used for average scores.</p>
     */
    private static DecimalFormat fmt = new DecimalFormat("0.##");
    
    /**
     * <p>The number of tests, which is used in Average() method.</p>
     */
    private final int numTest = 3;
    
    /**
     * <p>Score of the first test.</p>
     */
    private double score1;
    
    /**
     * <p>Score of the second test.</p>
     */
    private double score2;
    
    /**
     * <p>Score of the third test.</p>
     */
    private double score3;
    
    /**
     * <p>Average of 3 test score, but it is possible to
     * have only one or two test scores.</p>
     */
    private double average;
    
    /**
     * <p>Student's first name.</p>
     */
    private String firstName;
    
    /**
     * <p>Student's last name.</p>
     */
    private String lastName;
    
    /**
     * <p>Student's home address. For the convenience, the program
     * automatically set the address.</p>
     */
    private Address home = new Address();
    
    /**
     * <p>Student's school address. For the convenience, the program
     * automatically set the address.</p>
     */
    private Address school = new Address();
    
    
    /**
     * <p>Constructor that has student's name, home address, school address,
     * and first, second, and third test scores.</p>
     * 
     * @param firstName is used for declaring student's first name
     * @param lastName is used for declaring student's last name
     */
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        home.setHomeStreetAddress();
        home.setHomeState();
        home.setHomeCity();
        home.setHomeZipCode();
        school.setSchoolStreetAddress();
        school.setSchoolState();
        school.setSchoolCity();
        school.setSchoolZipCode();
    }
    
    /**
     * <p>Zero-parameter constructor that has been initialized
     * first, second, and third test scores as zero.</p>
     */
    public Student() {
        score1 = 0;
        score2 = 0;
        score3 = 0;
    }
    
    /**
     * <p>Setter that reads test number and test score to
     * initialize student's test score.</p>
     * 
     * @param testNumber is used for reading which test number.
     * @param testScore is used for initializing test score.
     */
    public void setTestScore(int testNumber, double testScore) {
        if (!(testNumber == 1 || testNumber == 2 
                || testNumber == numTest)) {
            throw new IllegalArgumentException("You must enter 1, 2, or"
                    + " 3 for the testNumber.");
        }
        if (testNumber == 1) {
            score1 = testScore;
        }   else if (testNumber == 2) {
            score2 = testScore;
        }   else if (testNumber == numTest) {
            score3 = testScore;
        }
    }
    
    /**
     * <p>Getter that reads which test number and return
     * the relevant test score. It returns score3 if testNumber isn't 2 and 3
     * since instruction in TestStudent.java restrict test number as 1 to 3.</p>
     * 
     * @param testNumber is used for reading which test number.
     * @return score1, score2, or score3 depends on the parameter.
     */
    public double getTestScore(int testNumber) {
        if (!(testNumber == 1 || testNumber == 2 
                || testNumber == numTest)) {
            throw new IllegalArgumentException("You must enter 1, 2, or"
                    + " 3 for the testNumber.");
        }
        
        if (testNumber == 1) {
            return score1;
        } else if (testNumber == 2) {
            return score2;
        } else {
            return score3;
        }
    }
    
    /**
     * <p>Getter that has no parameter, but automatically
     * calculate the average of score1, score2, and score3.</p>
     * 
     * @return average of score1, score2, and score3
     */
    public double average() {
        if (score1 == 0 && score2 == 0
                && score3 == 0) {
            throw new IllegalArgumentException("You must not enter "
                    + "all test score to 0.");
        }
        average = (score1 + score2 + score3) / numTest;
        return average;
    }
    
    /**
     * <p>toString methods that print well-organized message.</p>
     * 
     * @return Name of the students, first, second, third test scores,
     *  and average of the student.
     */
    public String toString() {
        return "=======================================\n"
                + "Name: " + firstName + " " + lastName
                + "\nHome address: " + home + "\nSchool address: " + school
                + "\n1st test: " + score1 + "\n2nd test: "
                + score2 + "\n3rd test: " + score3 + "\nAverage: " 
                + fmt.format(average);
    }
    
    

}
