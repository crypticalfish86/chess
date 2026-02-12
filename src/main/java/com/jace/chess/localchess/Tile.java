package com.jace.chess.localchess;

public class Tile {
    private final Colour tileColour;
    private final int yCoord;
    private final char xCoord;

    private Piece heldPiece;

    public Tile(Colour colour, int yCoord, char xCoord) {
        this.tileColour = colour;
        this.yCoord = yCoord;
        this.xCoord = xCoord;
    }


    //getters
    public Colour getTileColour() {
        return this.tileColour;
    }

    public int getYCoord() {
        return this.yCoord;
    }

    public char getXCoord() {
        return this.xCoord;
    }

    public Piece getHeldPiece() {
        return this.heldPiece;
    }

    //setters

    /*updates the held piece and if there was already a piece on the tile, returns it before overwriting.
    * If the current piece is the same colour as the previous piece then throw illegal state exception*/
    public Piece updateHeldPiece(Piece newPiece) throws IllegalStateException {
        Piece oldPiece = this.heldPiece;
        if (oldPiece != null && oldPiece.getColour() == newPiece.getColour()) {
            throw new IllegalStateException("Invalid move: Piece cannot take pieces of the same colour");
        }
        this.heldPiece = newPiece;
        return oldPiece;
    }

    //deletes the piece currently on the chess tile
    public Piece deleteHeldPiece() {
        Piece removedPiece = this.heldPiece;
        this.heldPiece = null;
        return removedPiece;
    }
}
