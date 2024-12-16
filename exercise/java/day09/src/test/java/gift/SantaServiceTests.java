package gift;

import org.junit.jupiter.api.Test;

import static gift.Behavior.*;
import static org.assertj.core.api.Assertions.assertThat;

class SantaServiceTests {

    private static final GiftRequest FEASIBLE_GIFT = createGift(true);
    private static final GiftRequest INFEASIBLE_GIFT = createGift(false);

    private final SantaService service = new SantaService();

    @Test
    void niceChildWithFeasibleGift_willReceiveTheirGiftRequest() {
        assertThat(service.isRequestGranted(createChild(NICE, FEASIBLE_GIFT))).isTrue();
    }

    @Test
    void naughtyChild_willNotReceiveTheirGiftRequest() {
        assertThat(service.isRequestGranted(createChild(NAUGHTY, FEASIBLE_GIFT))).isFalse();
    }

    @Test
    void niceChildWithInfeasibleGift_willNotReceiveTheirGiftRequest() {
        assertThat(service.isRequestGranted(createChild(NICE, INFEASIBLE_GIFT))).isFalse();
    }

    private static Child createChild(Behavior behavior, GiftRequest gift) {
        return new Child("Alice", "Thomas", 9, behavior, gift);
    }

    private static GiftRequest createGift(boolean isFeasibleGift) {
        return new GiftRequest("Bicycle", isFeasibleGift, Priority.NICE_TO_HAVE);
    }
}