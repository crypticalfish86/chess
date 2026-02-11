package com.jace.chess.local.Pieces;

import com.jace.chess.local.*;

public class King extends Piece {

    private String whiteUnicode = "\u001B[31mK";
    private String blackUnicode = "\u001B[34mK";

    public King(Colour pieceColour) {
        super(pieceColour);
        this.pieceType = PieceType.KING;
        this.pieceAsciiRep = this.pieceColour == Colour.WHITE ? whiteUnicode : blackUnicode;
    }

    //move piece
    public void move() {}

    //notify game the enemy king is checked
    public void checkEnemyKing() {}
}
