package preparation;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static preparation.Gift.RECOMMENDED_AGE;

class SantaWorkshopServiceTest {
    private SantaWorkshopService service;
    private Faker faker;

    @BeforeEach
    void setUp() {
        service = new SantaWorkshopService();
        faker = new Faker();
    }

    @Test
    void prepareGiftWithValidToyShouldInstantiateIt() {
        var gift = prepareGift(validWeight());

        assertThat(gift).isNotNull();
    }

    @Test
    void retrieveAttributeOnGift() {
        var gift = prepareGift(validWeight());
        gift.addAttribute(RECOMMENDED_AGE, "3");

        assertThat(gift.getRecommendedAge())
                .isEqualTo(3);
    }

    @Test
    void failsForATooHeavyGift() {
        double tooHeavyWeight = faker.number().randomDouble(2, 6, Integer.MAX_VALUE);
        assertThatThrownBy(() -> prepareGift(tooHeavyWeight))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Gift is too heavy for Santa's sleigh");
    }

    private double validWeight() {
        return faker.number().randomDouble(2, 0, 5);
    }

    private Gift prepareGift(double weight) {
        var giftName = faker.commerce().productName();
        var color = faker.color().name();
        var material = faker.options().option("Cotton", "Metal", "Plastic", "Liquid");
        return service.prepareGift(giftName, weight, color, material);
    }
}
