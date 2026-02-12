package com.jace.chess.localchess;

//placeholder for now until rest of board is set up, will eventually be abstract
public class Piece {
    private Colour pieceColour;
    private PieceType pieceType;

    public Piece(Colour colour, PieceType pieceType) {
        this.pieceColour = colour;
        this.pieceType = pieceType;
    }

    public Colour getColour() {
        return pieceColour;
    }
    public PieceType getPieceType() {
        return this.pieceType;
    }
}

