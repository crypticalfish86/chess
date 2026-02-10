package com.jace.chess.local.Pieces;

import com.jace.chess.local.*;

public class Rook extends Piece {
    public Rook(Colour pieceColour) {
        super(pieceColour);
        this.pieceType = PieceType.ROOK;
        this.pieceAsciiRep = Piece.ROOK_ASCII_REP;
    }

    //move piece
    public void move() {}

    //notify game the enemy king is checked
    public void checkEnemyKing() {}
}
