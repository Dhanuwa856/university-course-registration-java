// 24IT0457

public class Course {
    private String code;
    private String title;
    private int credits;
    private int capacity;
    private String lecturer;
    private Student[] enrolled;
    private int enrolledCount;

    public Course(String code, String title, int credits, int capacity, String lecturer) {
        this.code = code;
        this.title = title;
        this.credits = (credits >= 1 && credits <= 6) ? credits : 3; // Credits must be 1-6
        this.capacity = (capacity > 0) ? capacity : 10;
        this.lecturer = lecturer;
        this.enrolled = new Student[this.capacity];
        this.enrolledCount = 0;
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }

    public boolean isFull() {
        return enrolledCount >= capacity;
    }

    public boolean enroll(Student student) {
        if (!isFull()) {
            enrolled[enrolledCount++] = student;
            return true;
        }
        return false;
    }

    public void drop(Student student) {
        for (int i = 0; i < enrolledCount; i++) {
            if (enrolled[i].getId().equals(student.getId())) {
                enrolled[i] = enrolled[enrolledCount - 1];
                enrolled[enrolledCount - 1] = null;
                enrolledCount--;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return code + " - " + title + " (" + credits + " Cr) by " + lecturer + " [" + enrolledCount + "/" + capacity + " Seats]";
    }
}