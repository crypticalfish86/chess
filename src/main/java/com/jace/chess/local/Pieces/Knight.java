package com.jace.chess.local.Pieces;

import com.jace.chess.local.*;

public class Knight extends Piece {

    private String whiteUnicode = "\u001B[31mN";
    private String blackUnicode = "\u001B[34mN";

    public Knight(Colour pieceColour) {
        super(pieceColour);
        this.pieceType = PieceType.KNIGHT;
        this.pieceAsciiRep = this.pieceColour == Colour.WHITE ? whiteUnicode : blackUnicode;
    }

    //move piece
    public void move() {}

    //notify game the enemy king is checked
    public void checkEnemyKing() {}
}
