package com.jace.chess.local.Pieces;

import com.jace.chess.local.*;

public class Bishop extends Piece {

    private String whiteUnicode = "\u001B[31mB";
    private String blackUnicode = "\u001B[34mB";

    public Bishop(Colour pieceColour) {
        super(pieceColour);
        this.pieceType = PieceType.BISHOP;
        this.pieceAsciiRep = this.pieceColour == Colour.WHITE ? whiteUnicode : blackUnicode;
    }

    //move piece
    public void move() {}

    //notify game the enemy king is checked
    public void checkEnemyKing() {}
}
