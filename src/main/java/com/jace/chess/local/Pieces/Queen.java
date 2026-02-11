package com.jace.chess.local.Pieces;

import com.jace.chess.local.*;

public class Queen extends Piece {

    private String whiteUnicode = "\u001B[31mQ";
    private String blackUnicode = "\u001B[34mQ";

    public Queen (Colour pieceColour) {
        super(pieceColour);
        this.pieceType = PieceType.QUEEN;
        this.pieceAsciiRep = this.pieceColour == Colour.WHITE ? whiteUnicode : blackUnicode;
    }

    //move piece
    public void move() {}

    //notify game the enemy king is checked
    public void checkEnemyKing() {}
}
