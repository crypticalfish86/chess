package com.jace.chess.localchess;

//The pieces on the chessboard (extended by individual piece types)
public abstract class Piece implements PieceFunctionality{
    protected Colour pieceColour;
    protected PieceType pieceType;
    protected int pieceId; //to be incremented in subclasses to refer to specific pieces of the same type
    protected ChessBoard chessBoard; //The chessboard this piece is on

    public Piece(Colour colour, PieceType pieceType, ChessBoard chessBoard, int pieceId) {
        this.pieceColour = colour;
        this.pieceType = pieceType;
        this.chessBoard = chessBoard;
        this.pieceId = pieceId;
    }

    public Colour getColour() {
        return pieceColour;
    }

    public PieceType getPieceType() {
        return this.pieceType;
    }

    /*will return the piece id (unique to each type of piece per player,
    not every piece in set, search per player per type of piece to find each unique piece)*/
    public int getPieceId() {
        return this.pieceId;
    }
}

