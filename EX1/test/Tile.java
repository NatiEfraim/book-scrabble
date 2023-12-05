package test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Tile {
    public final char letter;
    public final int score;

    // Private constructor for Tile
    private Tile(char letter, int score) {
        this.letter = Character.toUpperCase(letter); // Convert to uppercase
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return letter == tile.letter && score == tile.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(letter, score);
    }

    // Public static inner class Bag
    public static class Bag {
        private static int[] letterQuantity;
        private static Tile[] availableTiles;
        private static Bag _bagBoard=null;
//        // Initialize the availableTiles array with Tile objects for each letter
//        static {
//            for (char ch = 'A'; ch <= 'Z'; ch++) {
//                availableTiles[ch - 'A'] = new Tile(ch, /* Assign score here */);
//            }
//        }
        /////Get bag
        public static Bag getBag(){
             if (_bagBoard ==null){
                 _bagBoard =new Bag();//create a new
             }
             return _bagBoard;
        }

        // Private constructor to prevent instantiation
        private Bag() {
            // Empty private constructor
            this.letterQuantity = new int[26];
            this.availableTiles = new Tile[26];

            this.availableTiles[0] = new Tile('A', 1);
            this.availableTiles[1] = new Tile('B', 3);
            this.availableTiles[2] = new Tile('C', 3);
            this.availableTiles[3] = new Tile('D', 2);
            this.availableTiles[4] = new Tile('E', 1);
            this.availableTiles[5] = new Tile('F', 4);
            this.availableTiles[6] = new Tile('G', 2);
            this.availableTiles[7] = new Tile('H', 4);
            this.availableTiles[8] = new Tile('I', 1);
            this.availableTiles[9] = new Tile('J', 8);
            this.availableTiles[10] = new Tile('K', 5);
            this.availableTiles[11] = new Tile('L', 1);
            this.availableTiles[12] = new Tile('M', 3);
            this.availableTiles[13] = new Tile('N', 1);
            this.availableTiles[14] = new Tile('O', 1);
            this.availableTiles[15] = new Tile('P', 3);
            this.availableTiles[16] = new Tile('Q', 10);
            this.availableTiles[17] = new Tile('R', 1);
            this.availableTiles[18] = new Tile('S', 1);
            this.availableTiles[19] = new Tile('T', 1);
            this.availableTiles[20] = new Tile('U', 1);
            this.availableTiles[21] = new Tile('V', 4);
            this.availableTiles[22] = new Tile('W', 4);
            this.availableTiles[23] = new Tile('X', 8);
            this.availableTiles[24] = new Tile('Y', 4);
            this.availableTiles[25] = new Tile('Z', 10);
            ///////////////////////////
            this.letterQuantity[0] = 9;
            this.letterQuantity[1] = 2;
            this.letterQuantity[2] = 2;
            this.letterQuantity[3] = 4;
            this.letterQuantity[4] = 12;
            this.letterQuantity[5] = 2;
            this.letterQuantity[6] = 3;
            this.letterQuantity[7] = 2;
            this.letterQuantity[8] = 9;
            this.letterQuantity[9] = 1;
            this.letterQuantity[10] = 1;
            this.letterQuantity[11] = 4;
            this.letterQuantity[12] = 2;
            this.letterQuantity[13] = 6;
            this.letterQuantity[14] = 8;
            this.letterQuantity[15] = 2;
            this.letterQuantity[16] = 1;
            this.letterQuantity[17] = 6;
            this.letterQuantity[18] = 4;
            this.letterQuantity[19] = 6;
            this.letterQuantity[20] = 4;
            this.letterQuantity[21] = 2;
            this.letterQuantity[22] = 2;
            this.letterQuantity[23] = 1;
            this.letterQuantity[24] = 2;
            this.letterQuantity[25] = 1;
        }




        // Public static method to create a Tile with a given letter and score
        public static Tile createTile(char letter, int score) {
            letter = Character.toUpperCase(letter); // Convert to uppercase
            int index = letter - 'A';

            if (index < 0 || index >= 26) {
                throw new IllegalArgumentException("Invalid letter: " + letter);
            }

            if (letterQuantity[index] > 0) {
                letterQuantity[index]--;
                return new Tile(letter, score);
            } else {
                throw new IllegalStateException("No more tiles available for letter: " + letter);
            }
        }

        // Public method to get the quantity of available tiles for a specific letter
        public static int getLetterQuantity(char letter) {
            letter = Character.toUpperCase(letter); // Convert to uppercase
            int index = letter - 'A';

            if (index < 0 || index >= 26) {
                throw new IllegalArgumentException("Invalid letter: " + letter);
            }

            return letterQuantity[index];
        }

        public Tile getRand() {
            int count = 0;
            for (int i = 0; i < 26; i++) {
                count += this.letterQuantity[i];
            }
            if (count == 0) {
                return null;
            }
            Random random = new Random();
            int r;
            do {
                r = random.nextInt(26);///get random num
            } while (this.letterQuantity[r] == 0);
            this.letterQuantity[r]--;
            return this.availableTiles[r];
        }

        public Tile getTile(char ch) {
            if (ch > 'Z' || ch < 'A') {
                return null;///invalid char
            }
            int x = (int) ch - 65;
            if (this.letterQuantity[x] == 0) {
                return null;
            }
            this.letterQuantity[x]--;
            return this.availableTiles[x];
        }

        public int size() {
            int sum = 0;
            for (int i = 0; i < 26; i++) {
                sum += this.letterQuantity[i];

            }
            return sum;
        }

        public int[] getQuantities() {
            return Arrays.copyOf(this.letterQuantity,this.letterQuantity.length) ;
        }

        public void put(Tile tile){
            if (this.size()>=98){
                return;
            }
            int pos=tile.letter-65;
            this.letterQuantity[pos]++;///increase.
            return;
        }

    }


}
