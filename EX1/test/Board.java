package test;

public class Board {
    private static final int BOARD_SIZE = 15;
    private static Board _mainBoard;
    public static Board getBoard() {
        // Check if the board is not initialized
        if (_mainBoard == null) {
            // Create a new instance of the Board (calling the private constructor)
            new Board();
        }
        return _mainBoard;
    }



}
