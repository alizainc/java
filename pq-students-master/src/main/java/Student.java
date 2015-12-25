public class Student {
    private String sName;
    private Course[] courses;

    public Student(String s, Course[] c) {
        sName = s;
        courses = c;
    }

    public int getCredits() {
        int sum = 0;
        for (Course p: courses) {
            sum = sum + p.getCredits();
        }
        return sum;
    }

    public String toString() {
        String str = sName + " is taking " + courses.length + " courses:";
        for (Course t: courses) {
            str = str + String.format("%n%s", t.toString());
        }
        return str;
    }

    public double getGPA() {
        double gpa = 0;
        for (Course d: courses) {
            if (d.getGrade() == 4) {
                gpa = gpa + d.getCredits() * 4;
            }
            if (d.getGrade() == 3) {
                gpa = gpa + d.getCredits() * 3;
            }
            if (d.getGrade() == 2) {
                gpa = gpa + d.getCredits() * 2;
            }
            if (d.getGrade() == 1) {
                gpa = gpa + d.getCredits() * 1;
            }
            if (d.getGrade() == 0) {
                gpa = gpa + d.getCredits() * 0;
            }
        }
        gpa = gpa / getCredits();
        return gpa;
    }
}