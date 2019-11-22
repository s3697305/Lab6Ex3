package Model;

public class Ex3cards {
    public static int[] allCards = new int[52];
    public static int[] pickedCards = new int[3];

    public static void initCards() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                if (j >= 9) {
                    allCards[i * 13 + j] = 10;
                } else {
                    allCards[i * 13 + j] = j + 1;
                }
            }
        }
    }
    public static void getRandomCards() {
        for (int i = 0; i < 3; i++) {
            pickedCards[i] = getOneRandomCard();
        }

    }
    public static int getOneRandomCard() {
        int randomCardIndex;
        do {
            randomCardIndex = (int)(Math.random() * 52);
        } while (isDuplicateCard(randomCardIndex));
        return randomCardIndex;
    }
    public static boolean isDuplicateCard(int pickedCardIndex) {
        for (int i = 0; i < 3; i++) {
            if (pickedCards[i] == pickedCardIndex) {
                return true;
            }
        }
        return false;
    }
    private static int getCardsSum() {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += allCards[pickedCards[i]];
        }
        return sum;
    }
    private static void printSum() {
        System.out.printf("Sum of 3 cards is %d\n", getCardsSum());
    }
    private static void printCardsName() {
        for (int i = 0; i < 3; i++) {
            String cardRank = getCardRank(pickedCards[i]);
            String cardSuit = getCardSuit(pickedCards[i]);
            System.out.printf("Card number %d (index = %d) is %s of %s\n", i + 1, pickedCards[i], cardRank, cardSuit);
        }
    }
    private static String getCardSuit(int cardIndex) {
        String cardSuit;
        switch (Math.floorDiv(cardIndex, 13)) {
            case 0:
                cardSuit = "clubs";
                break;
            case 1:
                cardSuit = "diamonds";
                break;
            case 2:
                cardSuit = "hearts";
                break;
            case 3:
                cardSuit = "spades";
                break;
            default:
                cardSuit = "error";
                break;
        }
        return cardSuit;
    }
    private static String getCardRank(int cardIndex) {
        String cardRank;
        switch (cardIndex % 13) {
            case 0:
                cardRank = "Ace";
                break;
            case 10:
                cardRank = "Jack";
                break;
            case 11:
                cardRank = "Queen";
                break;
            case 12:
                cardRank = "King";
                break;
            default:
                cardRank = String.format("%d", cardIndex % 13 + 1);
                break;
        }
        return cardRank;
    }
}