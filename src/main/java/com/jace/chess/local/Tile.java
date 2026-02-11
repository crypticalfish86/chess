package com.jace.chess.local;

public class Tile {
    public static final String WHITE_TILE_COLOUR = "\u001B[32m"; //green
    public static final String BLACK_TILE_COLOUR = "\u001B[37m"; //white (but it looks like grey)
    public static final String COLOUR_UNICODE_RESET = "\u001B[0m";//reset the console text colour to default

    private final LocalChess gameSession; //The game session this tile is associated with
    private final Colour tileColour; //The colour of this tile
    private final String coordinate; //coordinate (always 2 characters e.g. a8)
    private Piece occupyingPiece; //The chess piece occupying this tile

    /*Constructor*/
    Tile(Colour tileColour, String coordinate, LocalChess gameSession) {
        this.tileColour = tileColour;
        this.coordinate = coordinate;
        this.gameSession = gameSession;
    }



    public Colour getTileColour() {
        return tileColour;
    }

    public Piece getOccupyingPiece() {
        return this.occupyingPiece;
    }

}
