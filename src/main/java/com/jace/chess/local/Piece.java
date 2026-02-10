package com.jace.chess.local;

public abstract class Piece implements ChessPieceInterface{

    protected static final String WHITE_PIECE_COLOUR = "\u001B[31m"; //red
    protected static final String BLACK_PIECE_COLOUR = "\u001B[30m"; //blue

    protected static final String KING_ASCII_REP = "K";
    protected static final String QUEEN_ASCII_REP = "Q";
    protected static final String BISHOP_ASCII_REP = "B";
    protected static final String KNIGHT_ASCII_REP = "N";
    protected static final String ROOK_ASCII_REP = "R";
    protected static final String PAWN_ASCII_REP = "P";


    protected Colour pieceColour;
    protected PieceType pieceType;
    protected String colourAsciiRep;
    protected String pieceAsciiRep;
    protected Tile occupyingTile;

    public Piece(Colour pieceColour) {
        this.pieceColour = pieceColour;

        if (this.pieceColour == Colour.WHITE) {
            this.colourAsciiRep = Piece.WHITE_PIECE_COLOUR;
        } else {
            this.colourAsciiRep = Piece.BLACK_PIECE_COLOUR;
        }
    }


    public Colour getPieceColour() {
        return this.pieceColour;
    }

    public String getAsciiRepresentation() {
        //send error colour if the ascii representation isn't valid (purple E)
        if (this.pieceAsciiRep.isEmpty() || this.colourAsciiRep.isEmpty()) {
            return "\u001B[35mE";
        }
        return this.colourAsciiRep + this.pieceAsciiRep;
    }
}
