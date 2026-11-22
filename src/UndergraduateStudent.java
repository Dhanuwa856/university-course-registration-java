
public class UndergraduateStudent extends Student {
    private static final int MAX_CREDITS = 18;
    private static final double FEE_PER_CREDIT = 5000.0;

    public UndergraduateStudent(String id, String name) {
        super(id, name);
    }

    @Override
    public String getType() {
        return "Undergraduate";
    }

    @Override
    public int getMaxCredits() {
        return MAX_CREDITS;
    }

    @Override
    public double calculateFee() {
        return totalCredits() * FEE_PER_CREDIT;
    }
}