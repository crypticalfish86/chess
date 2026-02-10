package com.jace.chess.local.Pieces;

import com.jace.chess.local.*;

public class Pawn extends Piece {
    public Pawn(Colour pieceColour) {
        super(pieceColour);
        this.pieceType = PieceType.PAWN;
        this.pieceAsciiRep = Piece.PAWN_ASCII_REP;
    }

    //move piece
    public void move() {}

    //notify game the enemy king is checked
    public void checkEnemyKing() {}
}
