
public class PostgraduateStudent extends Student {
    private static final int MAX_CREDITS = 12;
    private static final double FEE_PER_CREDIT = 8000.0;
    private static final double RESEARCH_FEE = 10000.0;

    public PostgraduateStudent(String id, String name) {
        super(id, name);
    }

    @Override
    public String getType() {
        return "Postgraduate";
    }

    @Override
    public int getMaxCredits() {
        return MAX_CREDITS;
    }

    @Override
    public double calculateFee() {
        return (totalCredits() * FEE_PER_CREDIT) + RESEARCH_FEE;
    }
}