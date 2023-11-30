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




    public Tile[] get_tile() {
        return _tile;
    }

    public void set_tile(Tile[] _tile) {
        this._tile = _tile;
    }

    public int get_row() {
        return _row;
    }

    public void set_row(int _row) {
        this._row = _row;
    }

    public int get_col() {
        return _col;
    }

    public void set_col(int _col) {
        this._col = _col;
    }

    public boolean is_vertical() {
        return _vertical;
    }

    public void set_vertical(boolean _vertical) {
        this._vertical = _vertical;
    }
}
