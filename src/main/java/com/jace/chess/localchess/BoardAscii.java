package com.jace.chess.localchess;

public record BoardAscii() {
    //console background colour
    public static final String WHITE_TILE_COLOUR = "\u001B[47m"; //the tile colour (background colour) to display for white
    public static final String BLACK_TILE_COLOUR = "\u001B[40m"; //the tile colour (background colour) to display for black
    public static final String RESET_BACKGROUND_COLOUR = "\u001B[0m"; //use to reset console background colour after each tile
    //console text colour
    public static final String WHITE_PIECE_COLOUR = "\u001B[31m"; //The text colour for whites pieces
    public static final String BLACK_PIECE_COLOUR = "\u001B[34m"; //The text colour for blacks pieces

    //piece text representation
    public static final String KING = "K";
    public static final String QUEEN = "Q";
    public static final String BISHOP = "B";
    public static final String KNIGHT = "N";
    public static final String ROOK = "R";
    public static final String PAWN = "P";

    //empty tile text representation
    public static final String EMPTY = " ";


    //console letter row
    public static final String LETTER_COLUMN = "   A  B  C  D  E  F  G  H "; //to be displayed as the letter row below board
}
