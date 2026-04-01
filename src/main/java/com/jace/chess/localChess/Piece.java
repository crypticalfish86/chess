package com.jace.chess.localChess;

import java.util.ArrayList;
import java.util.Optional;

public abstract class Piece {

    private final Colour pieceColour; //The colour of the piece
    protected final ArrayList<Tile> possibleMoves; //List of possible tiles this piece can move to
    private final PieceType pieceType; //The type of piece
    protected final Chessboard chessboard; //The chessboard the piece is on
    protected Tile occupyingTile; //The tile the piece currently occupies
    private final int pieceID; //The id of the piece (unique to each piece type per colour)
    private boolean alive;

    /**
     * Super constructor for all chess pieces (to be accessed only through children)
     * @param colour The colour of the chess piece
     * @param pieceType The type of chess piece it is (e.g. KING)
     * @param id unique id (per piecetype per colour) of piece
     * @param chessboard the chessboard the piece is attached to
     * @param tile the tile the piece begins on
     */
    protected Piece(Colour colour, PieceType pieceType, int id, Chessboard chessboard, Tile tile) {
        this.pieceColour = colour;
        this.possibleMoves = new ArrayList<Tile>();
        this.pieceType = pieceType;
        this.pieceID = id;
        this.chessboard = chessboard;
        this.alive = true;
        this.updateOccupyingTile(tile);
    }

    //getters

    /**
     * Returns the colour of the piece
     * @return The colour of the piece
     */
    public Colour getColour() {
        return this.pieceColour;
    }

    /**
     * Returns the piece type of the piece
     * @return The piece type of the piece
     */
    public PieceType getPieceType() {
        return this.pieceType;
    }

    /**
     * Returns the id number of the piece
     * @return The id number of the piece
     */
    public int getPieceID() {
        return pieceID;
    }

    /**
     * gets the tile the piece currently occupies
     * @return The piece the tile currently occupies
     */
    public Tile getOccupyingTile() {
        return this.occupyingTile;
    }

    /**
     * Returns a list of all possible moves the piece can take
     * @return The list of all possible moves
     */
    public ArrayList<Tile> getAllPossibleMoves() {
        return this.possibleMoves;
    }

    /**
     * Simple method that returns the living status of the piece
     * @return the living status of the piece
     */
    public boolean getAliveStatus() {
        return this.alive;
    }
    //setters

    /**
     * Updates the tile the piece occupies
     * @param newTile The new tile the piece is occupying
     */
    public void updateOccupyingTile(Tile newTile) {
        this.occupyingTile = newTile;
    }

    /**
     * Abstract method which fills the possible moves list (to be recalculated for every piece at start of a turn)
     * (each type of piece will have their own moves so must remain abstract)
     */
    public abstract void updatePossibleMoves();

    //other methods

    /**
     * Method will move piece to new tile
     * @param tileToMoveTo The tile you want the piece to move to
     * @return An optional containing the enemy piece taken (if there is one)
     * @throws IllegalArgumentException Thrown if not in the possible moves list of the piece
     */
    public Optional<Piece> movePiece(Tile tileToMoveTo) throws IllegalArgumentException{
        if (possibleMoves.contains(tileToMoveTo)) {
            this.occupyingTile.removePieceFromTile();
            this.occupyingTile = tileToMoveTo;
            return tileToMoveTo.updatePiece(this);
        } else {
            String errorMessage = String.format("Error: not a valid move for %s", this.toString());
            throw new IllegalArgumentException(errorMessage);
        }
    }


    /**
     * Does cleanup operations necessary to remove piece from board (METHOD MIGHT EXPAND AS YOU DEVELOP PROGRAM)
     */
    public void removeFromBoard() {
        possibleMoves.clear();
        if (this.occupyingTile != null) {
            this.occupyingTile.removePieceFromTile();
            this.occupyingTile = null;
        }
        this.alive = false;
    }

    //helper method for children to check if tiles are going to be valid (to use when adding possible moves)
    protected boolean checkTile(Tile tile) {
        Optional<Piece> occupyingPiece = tile.getPiece();
        return occupyingPiece.isEmpty() || occupyingPiece.get().getColour() != this.getColour();
    }

    /**
     * Returns a string representation of the piece (e.g. WHITE_KING_1)
     * @return The string representation of the piece
     */
    @Override
    public String toString() {
        String colour = this.pieceColour == Colour.WHITE ? "WHITE_" : "BLACK_";
        String pieceType;

        switch (this.pieceType) {
            case KING -> pieceType = "KING";
            case QUEEN -> pieceType = "QUEEN";
            case BISHOP -> pieceType = "BISHOP";
            case KNIGHT -> pieceType = "KNIGHT";
            case ROOK -> pieceType = "ROOK";
            case PAWN -> pieceType = "PAWN";
            default -> pieceType = "UNKNOWN";
        }

        return String.format("%s%s_%d", colour, pieceType, this.pieceID);
    }
}
