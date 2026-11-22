
public abstract class Student extends Person implements Payable {
    private Course[] registeredCourses;
    private int courseCount;
    private static final int MAX_COURSES = 10;

    public Student(String id, String name) {
        super(id, name);
        this.registeredCourses = new Course[MAX_COURSES];
        this.courseCount = 0;
    }

    public boolean addCourse(Course course) {
        if (courseCount < MAX_COURSES) {
            registeredCourses[courseCount++] = course;
            return true;
        }
        return false;
    }

    public void removeCourse(String courseCode) {
        for (int i = 0; i < courseCount; i++) {
            if (registeredCourses[i].getCode().equals(courseCode)) {
                registeredCourses[i] = registeredCourses[courseCount - 1];
                registeredCourses[courseCount - 1] = null;
                courseCount--;
                break;
            }
        }
    }

    public boolean hasCourse(String courseCode) {
        for (int i = 0; i < courseCount; i++) {
            if (registeredCourses[i].getCode().equals(courseCode)) {
                return true;
            }
        }
        return false;
    }

    public int totalCredits() {
        int total = 0;
        for (int i = 0; i < courseCount; i++) {
            total += registeredCourses[i].getCredits();
        }
        return total;
    }

    public abstract int getMaxCredits();
}