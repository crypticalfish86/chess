package com.jace.chess.local.Pieces;

import com.jace.chess.local.*;

public class Queen extends Piece {
    public Queen (Colour pieceColour) {
        super(pieceColour);
        this.pieceType = PieceType.QUEEN;
        this.pieceAsciiRep = Piece.QUEEN_ASCII_REP;
    }

    //move piece
    public void move() {}

    //notify game the enemy king is checked
    public void checkEnemyKing() {}
}
