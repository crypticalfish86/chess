package com.jace.chess.localchess.Pieces;

import com.jace.chess.localchess.ChessBoard;
import com.jace.chess.localchess.Colour;
import com.jace.chess.localchess.Piece;
import com.jace.chess.localchess.PieceType;

public class King extends Piece {
    public King(Colour colour, PieceType pieceType, ChessBoard chessBoard, int pieceId) {
        super(colour, PieceType.KING, chessBoard, pieceId);
    }

    public void move(){};
}
