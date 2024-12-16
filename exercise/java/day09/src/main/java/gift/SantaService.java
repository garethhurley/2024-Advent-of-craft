package gift;

public class SantaService {
    public boolean isRequestGranted(Child child) {
        return child.getBehavior() == Behavior.NICE && child.getGiftRequest().isFeasible();
    }
}