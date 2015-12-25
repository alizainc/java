public class Course {
    private String name;
    private int credit;
    private int grade;

    public Course(String n, int c, int g) {
        name = n;
        credit = c;
        grade = g;
    }

    public int getCredits() {
        return credit;
    }

    public int getGrade() {
        return grade;
    }

    public String toString() {
        return name + ": " + grade;
    }

}