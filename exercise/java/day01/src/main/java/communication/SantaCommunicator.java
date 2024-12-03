package communication;

public class SantaCommunicator {
    private final int numberOfDaysToRest;
    private final int numberOfDayBeforeChristmas;

    private SantaCommunicator(int numberOfDaysToRest, int numberOfDayBeforeChristmas) {
        this.numberOfDaysToRest = numberOfDaysToRest;
        this.numberOfDayBeforeChristmas = numberOfDayBeforeChristmas;
    }

    public String composeMessage(ReindeerInfo reindeerInfo) {
        var daysBeforeReturn = daysBeforeReturn(reindeerInfo.numbersOfDaysForComingBack(), this.numberOfDayBeforeChristmas);

        return "Dear " + reindeerInfo.name() + ", please return from " + reindeerInfo.currentLocation() +
               " in " + daysBeforeReturn + " day(s) to be ready and rest before Christmas.";
    }

    public boolean isOverdue(ReindeerInfo reindeerInfo, Logger logger) {
        if (daysBeforeReturn(reindeerInfo.numbersOfDaysForComingBack(), this.numberOfDayBeforeChristmas) <= 0) {
            logger.log("Overdue for " + reindeerInfo.name() + " located " + reindeerInfo.currentLocation() + ".");
            return true;
        }
        return false;
    }

    private int daysBeforeReturn(int numbersOfDaysForComingBack, int numberOfDaysBeforeChristmas) {
        return numberOfDaysBeforeChristmas - numbersOfDaysForComingBack - numberOfDaysToRest;
    }

    public static class Builder {
        private int numberOfDaysToRest;
        private int numberOfDayBeforeChristmas;

        public SantaCommunicator build() {
            return new SantaCommunicator(numberOfDaysToRest, numberOfDayBeforeChristmas);
        }

        public Builder daysToRest(int numberOfDaysToRest) {
            this.numberOfDaysToRest = numberOfDaysToRest;
            return this;
        }

        public Builder daysBeforeChristmas(int numberOfDayBeforeChristmas) {
            this.numberOfDayBeforeChristmas = numberOfDayBeforeChristmas;
            return this;
        }
    }
}