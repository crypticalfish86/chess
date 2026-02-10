package com.jace.chess.local.Pieces;

import com.jace.chess.local.*;

public class Knight extends Piece {
    public Knight(Colour pieceColour) {
        super(pieceColour);
        this.pieceType = PieceType.KNIGHT;
        this.pieceAsciiRep = Piece.KNIGHT_ASCII_REP;
    }

    //move piece
    public void move() {}

    //notify game the enemy king is checked
    public void checkEnemyKing() {}
}
