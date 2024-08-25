package HangmanGameOOP;

public enum Gallows {
    ZERO(" +---+\n" +
                " |   |\n" +
                "     |\n" +
                "     |\n" +
                "     |\n" +
                "     |\n" +
                "========''']"),
    ONE( " +---+\n" +
                " |   |\n" +
                " 0   |\n" +
                "     |\n" +
                "     |\n" +
                "     |\n" +
                "========''']"),
    TWO( " +---+\n" +
                " |   |\n" +
                " 0   |\n" +
                " |   |\n" +
                "     |\n" +
                "     |\n" +
                "========''']"),
    THREE(" +---+\n" +
                 " |   |\n" +
                 " 0   |\n" +
                 "/|   |\n" +
                 "     |\n" +
                 "     |\n" +
                 "========''']"),
    FOR(  " +---+\n" +
                 " |   |\n" +
                 " 0   |\n" +
                 "/|\\  |\n" +
                 "     |\n" +
                 "     |\n" +
                 "========''']"),
    FIVE(" +---+\n" +
                " |   |\n" +
                " 0   |\n" +
                "/|\\  |\n" +
                "/    |\n" +
                "     |\n" +
                "========''']"),
    SIX(  " +---+\n" +
                " |   |\n" +
                " 0   |\n" +
                "/|\\  |\n" +
                "/ \\  |\n" +
                "     |\n" +
                "========''']");

    private String image;

    Gallows(String image) {
        this.image = image;
    }

    public static void showGallows(int value) {
        switch (value) {
            case 0:
                System.out.println(ZERO);
                break;
            case 1:
                System.out.println(ONE);
                break;
            case 2:
                System.out.println(TWO);
                break;
            case 3:
                System.out.println(THREE);
                break;
            case 4:
                System.out.println(FOR);
                break;
            case 5:
                System.out.println(FIVE);
                break;
            case 6:
                System.out.println(SIX);
                break;
        }
    }

    public String toString() {
        return image;
    }
}