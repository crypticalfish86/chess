package com.jace.chess.local.Pieces;

import com.jace.chess.local.*;

public class Pawn extends Piece {

    private String whiteUnicode = "\u001B[31mP";
    private String blackUnicode = "\u001B[34mP";

    public Pawn(Colour pieceColour) {
        super(pieceColour);
        this.pieceType = PieceType.PAWN;
        this.pieceAsciiRep = this.pieceColour == Colour.WHITE ? whiteUnicode : blackUnicode;
    }

    //move piece
    public void move() {}

    //notify game the enemy king is checked
    public void checkEnemyKing() {}
}
