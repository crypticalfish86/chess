package com.jace.chess.local;

public abstract class Piece implements ChessPieceInterface{



    protected Colour pieceColour;
    protected PieceType pieceType;
    protected String pieceAsciiRep;
    protected Tile occupyingTile;

    public Piece(Colour pieceColour) {
        this.pieceColour = pieceColour;
    }


    public Colour getPieceColour() {
        return this.pieceColour;
    }

    public String getAsciiRepresentation() {
        //send error colour if the ascii representation isn't valid (purple E)
        if (this.pieceAsciiRep.isEmpty()) {
            return "\u001B[35mE";
        }
        return this.pieceAsciiRep;
    }

    public void updateOccupyingTile(Tile newTile) {
        this.occupyingTile = newTile;
    }
}
