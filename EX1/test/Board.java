package test;

public class Board {
    private static final int BOARD_SIZE = 15;
    private static Board _mainBoard;
    //private Tile.Bag[] _bags;
    private char[][] _boardGame;

    /////constructor
    public Board(){
        ///init the board game at first.
        this._boardGame=new char[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                this._boardGame[i][j]= 0;
            }
        }
    }


    /////check if the word in the boardGame.
    public boolean boardLegal(Word word){
        if (!word.isVertical())
        {
            ///the word is located Horizontal.
            if (this._boardGame.length-word.getCol() < word.getTile().length){
                return false;
            }
           ///range is good
            int x=0;
            for (int i= word.getRow(); i<word.getTile().length ;i++,x++) {
                if (this._boardGame[word.getRow()][i]!=0 && this._boardGame[word.getRow()][i]!= word.getTile()[x].letter)
                {
                        return  false;
                }
            }
            return true;

        } else if (word.isVertical()) {
            ///the word is located Vertical.
            if(this._boardGame.length-word.getRow() < word.getTile().length){
                return false;
            }
            ///the range is good.
            int x=0;
            for (int i= word.getCol(); i<word.getTile().length && i<this._boardGame.length;i++,x++) {
                if (this._boardGame[i][word.getCol()]!=0 && this._boardGame[i][word.getCol()]!= word.getTile()[x].letter)
                {
                    return  false;
                }
            }
            return true;
        }
        return true;
        ///return this.checkWord(word.getRow(),word.getCol(),word,word.isVertical());.
    }

    private boolean checkWord(int i,int j,Word word,boolean rowOrCol){
        /////if the boolean is true --> run on the row.
        int x=0;
        if (!rowOrCol) {
            ///run on the row.
            for (int k=j; k<this._boardGame.length && x <word.getTile().length; k++,x++){
                if (this._boardGame[i][j]!=word.getTile()[x].letter)
                {
                    return false;
                }
            }
        } else if (rowOrCol) {
            ///run on the col.
            for (int k=i; k<this._boardGame.length && x <word.getTile().length; k++,x++){
                if (this._boardGame[k][j]!=word.getTile()[x].letter)
                {
                    return false;
                }
            }
        }
        return true;
    }
    //  exercise function
    public static Board getBoard() {
        if (_mainBoard == null) {
            // Create a new instance of the Board (calling the private constructor)
            _mainBoard = new Board();
        }
        return _mainBoard;
    }



}
