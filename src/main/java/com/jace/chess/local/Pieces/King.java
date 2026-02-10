package com.jace.chess.local.Pieces;

import com.jace.chess.local.*;

public class King extends Piece {
    public King(Colour pieceColour) {
        super(pieceColour);
        this.pieceType = PieceType.KING;
        this.pieceAsciiRep = Piece.KING_ASCII_REP;
    }

    //move piece
    public void move() {}

    //notify game the enemy king is checked
    public void checkEnemyKing() {}
}
