package com.jace.chess.local;

public class Tile {
    private static final String WHITE_TILE_COLOUR = "\u001B[32m"; //green
    private static final String BLACK_TILE_COLOUR = "\u001B[37m"; //white (but it looks like grey)

    private final LocalChess gameSession; //The game session this tile is associated with
    private final Colour tileColour; //The colour of this tile
    private Piece occupyingPiece; //The chess piece occupying this tile

    /*Constructor*/
    Tile(Colour tileColour, LocalChess gameSession) {
        this.tileColour = tileColour;
        this.gameSession = gameSession;
    }



    public Colour getTileColour() {
        return tileColour;
    }

    public Piece getOccupyingPiece() {
        return this.occupyingPiece;
    }

}
