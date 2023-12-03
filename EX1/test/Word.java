package test;


import java.util.Arrays;
import java.util.Objects;

public class Word {

	///data member
    private Tile[] _tile;
    private int _row;
    private int _col;
    private boolean _vertical;

    public Word(Tile[] tile, int row, int col, boolean vertical) {
        this._tile = tile;
        this._row = row;
        this._col = col;
        this._vertical = vertical;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return _row == word._row && _col == word._col && _vertical == word._vertical && Arrays.equals(_tile, word._tile);
    }




    public Tile[] getTile() {
        return this._tile;
    }

    public void setTile(Tile[] _tile) {
        this._tile = _tile;
    }

    public int getRow() {
        return this._row;
    }

    public void setRow(int row) {
        this._row = row;
    }

    public int getCol() {
        return this._col;
    }

    public void setCol(int col) {
        this._col = col;
    }

    public boolean isVertical() {
        return this._vertical;
    }

    public void setVertical(boolean vertical) {
        this._vertical = vertical;
    }
}
