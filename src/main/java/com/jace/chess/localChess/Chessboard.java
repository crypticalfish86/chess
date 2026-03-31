package com.jace.chess.localChess;

import java.util.ArrayList;

public class Chessboard {
    private final Tile[][] chessboard = new Tile[8][8];
    private final ArrayList<Piece> pieces = new ArrayList<Piece>();
    private Piece whiteKing; //The white king
    private Piece blackKing; //The black king

    /**
     * Returns the pieces on the chessboard
     * @return List of pieces on the chessboard
     */
    public ArrayList<Piece> getPieces() {
        return this.pieces;
    }

    /**
     * Called by the king to signal to the chessboard it's been checkmated, this method should end the game
     * @param checkmatedKing The king that has been checkmated
     */
    public void checkmate(King checkmatedKing) {

    }
}
