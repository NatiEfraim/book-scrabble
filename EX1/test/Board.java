package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private static final int BOARD_SIZE = 15;
    private static Board _mainBoard;
    //private Tile.Bag[] _bags;
    private final Tile[][] _boardGame;

    /////constructor
    private Board(){
        ///init the board game at first.
        this._boardGame=new Tile[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                this._boardGame[i][j]= null;
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
            if (this.isInitBoardGame() && word.getRow()==8) {
                ////this is the first word in the game
                for (int i = 0; i < word.getTile().length; i++) {
                    if ( i+word.getCol()==8) {
                        return true;
                    }
                }
            }
            int x=0;
            boolean adjust=false;

            for (int i = 0; i < word.getTile().length; i++) {
                /////if the new word will be in some word
                if (word.getTile()[i].letter=='_' && this._boardGame[word.getRow()][i+word.getCol()]!=null) {
                    adjust=true;
                }
                /////if the new word will be in edge word
                if ( (this._boardGame[word.getRow()+1][word.getCol()+i]!=null) ||(this._boardGame[word.getRow()-1][word.getCol()+i]!=null)) {
                    adjust=true;
                }
            }

            for (int i= 0; i<word.getTile().length && i<this._boardGame.length;i++,x++) {
                if (this._boardGame[word.getRow()][word.getCol()+i]!=null && word.getTile()[i].letter!='_')
                {
                    /////////The location is not allowed
                    return  false;
                }
            }
            return adjust;

        } else if (word.isVertical()) {
            ///the word is located Vertical.

            if(this._boardGame.length-word.getRow() < word.getTile().length){
                return false;
            }
            ///the range is good.
            if (this.isInitBoardGame() && word.getCol()==8) {
                ////this is the first word in the game
                for (int i = 0; i < word.getTile().length; i++) {
                    if ( i+word.getRow()==8) {
                        return true;
                    }
                }
            }

            int x=0;
            boolean adjust=false;

            for (int i = 0; i < word.getTile().length; i++) {
                /////if the new word will be in some word
                if (word.getTile()[i].letter=='_' && this._boardGame[i+word.getRow()][word.getCol()]!=null) {
                    adjust=true;
                }
                /////if the new word will be in edge word
                if ( (this._boardGame[i+word.getRow()][word.getCol()+1]!=null) ||(this._boardGame[i+word.getRow()][word.getCol()-1]!=null)) {
                        adjust=true;
                }
            }

            for (int i= 0; i<word.getTile().length && i<this._boardGame.length;i++,x++) {
                if (this._boardGame[word.getRow()+i][word.getCol()]!=null && word.getTile()[i].letter!='_')
                {
                    /////////The location is not allowed
                    return  false;
                }
            }
            return adjust;
        }
    }

    private boolean checkWord(int i,int j,Word word,boolean rowOrCol){
        /////if the boolean is true --> run on the row.
        int x=0;
        if (!rowOrCol) {
            ///run on the row.
            for (int k=j; k<this._boardGame.length && x <word.getTile().length; k++,x++){
                if (this._boardGame[i][j].letter!=word.getTile()[x].letter)
                {
                    return false;
                }
            }
        } else if (rowOrCol) {
            ///run on the col.
            for (int k=i; k<this._boardGame.length && x <word.getTile().length; k++,x++){
                if (this._boardGame[k][j].letter!=word.getTile()[x].letter)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public Tile[][] getTiles()
    {
        return Arrays.copyOf(this._boardGame,this._boardGame.length);
    }

    public boolean dictionaryLegal(Word word){
        return true;
    }
    public ArrayList<Word> getWord(){
        ArrayList<Word> words=new ArrayList<>();

        return words;
    }
    public int tryPlaceWord(Word word){
        int score=0;
        if (this.boardLegal(word) && this.dictionaryLegal(word)){
            ///the word is good
            if (!word.isVertical()){
                ////the word is horizontal
                for (int i = 0; i < word.getTile().length; i++) {
                    ///assignment each crocheter
                    this._boardGame[word.getRow()][i+word.getCol()]=word.getTile()[i].letter;

                }

                return getScore(word);
            } else if (word.isVertical()) {
                ////the word is Vertical
                for (int i = 0; i < word.getTile().length; i++) {
                    ///assignment each crocheter
                    this._boardGame[i+word.getRow()][word.getCol()]=word.getTile()[i].letter;

                }
                return getScore(word);

            }

        }
        return 0;
    }
    private boolean isInitBoardGame()
    {
        for (int i = 0; i < this._boardGame.length; i++) {
            for (int j = 0; j < this._boardGame.length; j++) {
                if (this._boardGame[i][j] != null) {
                    /////board is not empty
                    return false;
                }
            }
        }
        return true;
    }
    ////need to implement
    public int getScore(Word word){
        return 0;
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
