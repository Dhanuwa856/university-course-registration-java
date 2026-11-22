// 24IT0469

public class University {
    private Student[] students;
    private int studentCount;
    private Course[] courses;
    private int courseCount;

    public University() {
        students = new Student[100];
        courses = new Course[50];
        studentCount = 0;
        courseCount = 0;
    }

    public boolean addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount++] = student;
            return true;
        }
        return false;
    }

    public boolean addCourse(Course course) {
        if (courseCount < courses.length) {
            courses[courseCount++] = course;
            return true;
        }
        return false;
    }

    private Student findStudent(String id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId().equals(id)) return students[i];
        }
        return null;
    }

    private Course findCourse(String code) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCode().equals(code)) return courses[i];
        }
        return null;
    }
//24IT0510

    public boolean register(String studentId, String courseCode) {
        Student s = findStudent(studentId);
        Course c = findCourse(courseCode);

        if (s == null || c == null) return false;
        if (s.hasCourse(courseCode)) return false;
        if (c.isFull()) return false;
        if ((s.totalCredits() + c.getCredits()) > s.getMaxCredits()) return false;

        if (c.enroll(s)) {
            s.addCourse(c);
            return true;
        }
        return false;
    }

    public boolean drop(String studentId, String courseCode) {
        Student s = findStudent(studentId);
        Course c = findCourse(courseCode);

        if (s != null && c != null && s.hasCourse(courseCode)) {
            c.drop(s);
            s.removeCourse(courseCode);
            return true;
        }
        return false;
    }

    public void showCourseList() {
        System.out.println("\n--- Course List ---");
        if (courseCount == 0) System.out.println("No courses available.");
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i].toString());
        }
    }

    public void printFeeReport() {
        System.out.println("\n--- Student Fee Report ---");
        if (studentCount == 0) System.out.println("No students registered.");
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i].getId() + " - " + students[i].getName() +
                    " [" + students[i].getType() + "]: Rs. " + students[i].calculateFee());
        }
    }
}