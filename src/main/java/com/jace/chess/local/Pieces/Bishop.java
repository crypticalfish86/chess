package com.jace.chess.local.Pieces;

import com.jace.chess.local.*;

public class Bishop extends Piece {

    public Bishop(Colour pieceColour) {
        super(pieceColour);
        this.pieceType = PieceType.BISHOP;
        this.pieceAsciiRep = Piece.BISHOP_ASCII_REP;
    }

    //move piece
    public void move() {}

    //notify game the enemy king is checked
    public void checkEnemyKing() {}
}
