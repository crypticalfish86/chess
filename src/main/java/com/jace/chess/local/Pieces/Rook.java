package com.jace.chess.local.Pieces;

import com.jace.chess.local.*;

public class Rook extends Piece {

    private String whiteUnicode = "\u001B[31mR";
    private String blackUnicode = "\u001B[34mR";

    public Rook(Colour pieceColour) {
        super(pieceColour);
        this.pieceType = PieceType.ROOK;
        this.pieceAsciiRep = this.pieceColour == Colour.WHITE ? whiteUnicode : blackUnicode;
    }

    //move piece
    public void move() {}

    //notify game the enemy king is checked
    public void checkEnemyKing() {}
}
