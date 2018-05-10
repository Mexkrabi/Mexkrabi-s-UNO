import java.util.Random; //check the Link for more info about Random int -> https://www.mkyong.com/java/java-generate-random-integers-in-a-range/

public class Game {

    public Card[] allCards = new Card[108];
    public Card[] deck = new  Card[108];

    public Game() {

/**
 * card order/ids:
 *      0-9: red_1 0-9
 *      10-19: yellow_1 0-9
 *      20-29: green_1 0-9
 *      30-39: blue_1 0-9
 *
 *      40-48: red_2 1-9
 *      49-57: yellow_2 1-9
 *      58-66: green_2 1-9
 *      67-75: blue_2 1-9
 *
 *      76-77: red skip
 *      78-79: yellow skip
 *      80-81: green skip
 *      82-83: blue skip
 *
 *      84-85: red reverse
 *      86-87: yellow reverse
 *      88-89: green reverse
 *      90-91: blue reverse
 *
 *      92-93: red +2
 *      94-95: yellow +2
 *      96-97: green +2
 *      98-99: blue +2
 *
 *      100-103: black choose
 *      104-107: black +4
 */

        int id = 0;
//normal cards +0
        int val = 0;
        while (0 <= id && id <= 9) {
            allCards[id] = new Card(id, "red", val, false);
            val++;
            id++;
        }
        val = 0;
        while (10 <= id && id <= 19) {
            allCards[id] = new Card(id, "yellow", val, false);
            val++;
            id++;
        }
        val = 0;
        while (20 <= id && id <= 29) {
            allCards[id] = new Card(id, "green", val, false);
            val++;
            id++;
        }
        val = 0;
        while (30 <= id && id <= 39) {
            allCards[id] = new Card(id, "blue", val, false);
            val++;
            id++;
        }

//normal cards -0
        val = 1;
        while (40 <= id && id <= 48) {
            allCards[id] = new Card(id, "red", val, false);
            val++;
            id++;
        }
        val = 1;
        while (49 <= id && id <= 57) {
            allCards[id] = new Card(id, "yellow", val, false);
            val++;
            id++;
        }
        val = 1;
        while (58 <= id && id <= 66) {
            allCards[id] = new Card(id, "green", val, false);
            val++;
            id++;
        }
        val = 1;
        while (67 <= id && id <= 75) {
            allCards[id] = new Card(id, "blue", val, false);
            val++;
            id++;
        }

//skip cards
        val = 10;
        while (76 <= id && id <= 77) {
            allCards[id] = new Card(id, "red", val, true);
            id++;
        }
        while (78 <= id && id <= 79) {
            allCards[id] = new Card(id, "yellow", val, true);
            id++;
        }
        while (80 <= id && id <= 81) {
            allCards[id] = new Card(id, "green", val, true);
            id++;
        }
        while (82 <= id && id <= 83) {
            allCards[id] = new Card(id, "blue", val, true);
            id++;
        }

//reverse cards
        val = 11;
        while (84 <= id && id <= 85) {
            allCards[id] = new Card(id, "red", val, true);
            id++;
        }
        while (86 <= id && id <= 87) {
            allCards[id] = new Card(id, "yellow", val, true);
            id++;
        }
        while (88 <= id && id <= 89) {
            allCards[id] = new Card(id, "green", val, true);
            id++;
        }
        while (90 <= id && id <= 91) {
            allCards[id] = new Card(id, "blue", val, true);
            id++;
        }

//+2 cards
        val = 12;
        while (92 <= id && id <= 93) {
            allCards[id] = new Card(id, "red", val, true);
            id++;
        }
        while (94 <= id && id <= 95) {
            allCards[id] = new Card(id, "yellow", val, true);
            id++;
        }
        while (96 <= id && id <= 97) {
            allCards[id] = new Card(id, "green", val, true);
            id++;
        }
        while (98 <= id && id <= 99) {
            allCards[id] = new Card(id, "blue", val, true);
            id++;
        }

//black cards

//choose cards
        val = 13;
        while (100 <= id && id <= 103) {
            allCards[id] = new Card(id, "black", val, true);
            id++;
        }

//+4 cards
        val = 14;
        while (104 <= id && id <= 107) {
            allCards[id] = new Card(id, "black", val, true);
            id++;
        }

        //create and mix deck
        int counter = 0;
        while (deck.length < 108) {
            int randomNumber = getRandomNumberInRange(0, 108);
            if(allCards[randomNumber].isMixedIntoDeck() == false) {
                deck[counter] = allCards[randomNumber];
                allCards[randomNumber].setMixedIntoDeck(true);
            }
        }
        System.out.println("Deck order:");
        for (int i = 0; deck.length > i; i++) {
            System.out.println(deck[i]);
        }

        //create players
        Player p1 = new Player("Player 1", 1, 7);
        Player p2 = new Player("Player 2", 2, 7);
        Player p3 = new Player("Player 3", 3, 7);
        Player p4 = new Player("Player 4", 4, 7);
    }

    //gets random number
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
