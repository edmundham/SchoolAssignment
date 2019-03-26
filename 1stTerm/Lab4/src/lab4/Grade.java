package lab4;

public class Grade {

    public static void main(String[] args) {
        
        Student student1 = new Student("Mary");
        Student student2 = new Student("Mike");
        
        student1.inputGrades();
        
        System.out.println(student1.getName() + "'s average score is: " +
                           student1.getAverage());

        System.out.println();
        System.out.println();
        System.out.println();
        
        student2.inputGrades();
        
        System.out.println(student2.getName() + "'s average score is: " +
                student2.getAverage());
    }
}
