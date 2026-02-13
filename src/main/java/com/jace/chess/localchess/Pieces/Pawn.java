package com.jace.chess.localchess.Pieces;

import com.jace.chess.localchess.ChessBoard;
import com.jace.chess.localchess.Colour;
import com.jace.chess.localchess.Piece;
import com.jace.chess.localchess.PieceType;

public class Pawn extends Piece {
    public Pawn(Colour colour, PieceType pieceType, ChessBoard chessBoard, int pieceId) {
        super(colour, PieceType.PAWN, chessBoard, pieceId);
    }

    public void move(){};
}
