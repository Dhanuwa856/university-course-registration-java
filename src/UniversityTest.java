
// 24IT0514
public class UniversityTest {

    public static void check(String name, boolean condition) {
        if (condition) {
            System.out.println("PASS: " + name);
        } else {
            System.out.println("FAIL: " + name);
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Starting University System Tests ---");
        University uni = new University();

        UndergraduateStudent ug1 = new UndergraduateStudent("U001", "Nimal");
        PostgraduateStudent pg1 = new PostgraduateStudent("P001", "Kamal");

        Course c1 = new Course("IT1001", "Programming", 4, 2, "Dr. Silva");
        Course c2 = new Course("IT1002", "Database", 4, 1, "Dr. Perera");
        Course c3 = new Course("IT1003", "Networks", 5, 2, "Mr. Fernando");
        Course c4 = new Course("IT1004", "AI", 6, 2, "Dr. Bandara");
        Course c5 = new Course("IT1005", "Maths", 4, 2, "Mrs. Kumari");

        uni.addStudent(ug1); uni.addStudent(pg1);
        uni.addCourse(c1); uni.addCourse(c2); uni.addCourse(c3); uni.addCourse(c4); uni.addCourse(c5);

        // Inherited overrides check
        check("UG Max Credits is 18", ug1.getMaxCredits() == 18);
        check("PG Max Credits is 12", pg1.getMaxCredits() == 12);

        // Registration Checks
        check("Normal course registration successful", uni.register("U001", "IT1001") && ug1.totalCredits() == 4);
        check("Duplicate registration rejected", !uni.register("U001", "IT1001"));

        // Capacity Checks
        UndergraduateStudent ug2 = new UndergraduateStudent("U002", "Sunil");
        uni.addStudent(ug2);
        uni.register("U001", "IT1002"); // Course capacity 1 filled
        check("Registration rejected when course is full", !uni.register("U002", "IT1002"));

        // Drop Checks
        uni.drop("U001", "IT1002");
        check("Dropping a course frees a place", uni.register("U002", "IT1002"));

        // Edge Cases: Limits
        uni.register("U001", "IT1003"); // Total credits = 9
        uni.register("U001", "IT1004"); // Total credits = 15
        check("UG credit limit (18) enforced properly", !uni.register("U001", "IT1005")); // 15 + 4 = 19

        uni.register("P001", "IT1004"); // Total = 6
        uni.register("P001", "IT1003"); // Total = 11
        check("PG credit limit (12) enforced properly", !uni.register("P001", "IT1005")); // 11 + 4 = 15

        // Fee Calculations via Polymorphism
        check("UG calculateFee is correct (15 * 5000)", ug1.calculateFee() == 75000.0);
        check("PG calculateFee is correct (11 * 8000 + 10000)", pg1.calculateFee() == 98000.0);

        PostgraduateStudent pg2 = new PostgraduateStudent("P002", "Ruwan");
        check("PG fee with 0 credits is exactly the research fee", pg2.calculateFee() == 10000.0);

        System.out.println("--- Tests Completed ---");
    }
}