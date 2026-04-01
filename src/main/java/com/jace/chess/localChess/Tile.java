package com.jace.chess.localChess;

import java.util.Optional;

/*Tiles are to be part of a 2D doubly linked matrix (WARNING, TILE LOCATIONS ARE UNREMOVABLE ONCE GENERATED TO PREVENT ERRORS)*/
public class Tile {
    private Tile up; //The tile above this one
    private Tile left; //The tile to the left of this one
    private Tile right; //The tile to the right of this one
    private Tile down; //The tile below this one

    private Chessboard chessboard; //The chessboard the tile is a part of
    private final Colour tileColour; //Tile colour (to be used for GUI)
    private Piece occupyingPiece; //The piece currently occupying this tile
    private final String coordinate; //The coordinate marker of the tile in the chessboard

    /**
     * Constructor for the Tile class
     * @param colour The colour of the tile
     */
    public Tile(Colour colour, Chessboard chessboard, String coordinate) {
        this.tileColour = colour;
        this.chessboard = chessboard;
        this.coordinate = coordinate;
    }

    //getters

    /**
     * returns the colour of the tile
     * @return The colour of the tile
     */
    public Colour getTileColour() {
        return this.tileColour;
    }

    /**
     * returns the piece occupying the tile (or an empty optional if no piece is present)
     * @return An optional containing piece currently occupying the tile
     */
    public Optional<Piece> getPiece() {
        if (this.occupyingPiece == null) {
            return Optional.empty();
        } else {
            return Optional.of(this.occupyingPiece);
        }
    }

    /**
     * Returns the tile directly above this one (or an empty optional if no tile is above it)
     * @return An optional containing the tile directly above this one
     */
    public Optional<Tile> tileAbove() {
        if (this.up == null) {
            return Optional.empty();
        } else {
            return Optional.of(this.up);
        }
    }

    /**
     * Returns the tile to the left of this one (or an empty optional if no tile is to the left)
     * @return An optional containing the tile directly to the left of this one
     */
    public Optional<Tile> tileLeft() {
        if (this.left == null) {
            return Optional.empty();
        } else {
            return Optional.of(this.left);
        }
    }

    /**
     * Returns the tile to the right of this one (or an empty optional if no tile is to the right)
     * @return An optional containing the tile directly to the right of this one
     */
    public Optional<Tile> tileRight() {
        if (this.right == null) {
            return Optional.empty();
        } else {
            return Optional.of(this.right);
        }
    }

    /**
     * Returns the tile directly below this one (or an empty optional if no tile is below it)
     * @return An optional containing the tile directly below this one
     */
    public Optional<Tile> tileBelow() {
        if (this.down == null) {
            return Optional.empty();
        } else {
            return Optional.of(this.down);
        }
    }

    //setters

    /**
     * Removes the piece from the square, setting it to null and returns the moving piece,
     * to be used when moving a piece to another part of the board (not to take it off the board).
     * To be invoked when moving a piece off of a tile.
     * @return The piece moved from the tile
     */
    public Piece removePieceFromTile() throws NullPointerException {
        if (this.occupyingPiece == null) {
            throw new NullPointerException("Error: You've tried to remove a piece from an empty tile");
        }
        Piece movingPiece = this.occupyingPiece;
        this.occupyingPiece = null;
        return movingPiece;
    }

    /**
     * Updates the occupying piece to an incoming piece from another tile, removing the current piece occupying the tile
     * and removing it from the board entirely
     * @param incomingPiece The incoming piece which will now occupy the tile
     * @return An optional containing the piece that was taken by the incoming piece
     * @throws IllegalArgumentException Thrown if a player tries to take one of their own pieces
     */
    public Optional<Piece> updatePiece(Piece incomingPiece) throws IllegalArgumentException {
        if (this.occupyingPiece == null || this.occupyingPiece.getColour() != incomingPiece.getColour()) { //checks validity of move
            Piece oldPiece = this.occupyingPiece;
            this.occupyingPiece = incomingPiece;
            incomingPiece.updateOccupyingTile(this);

            if (oldPiece == null) {//If there's an old piece to deal with, remove it from the board
                return Optional.empty();
            } else {
                oldPiece.removeFromBoard();
                return Optional.of(oldPiece);
            }
        } else { //if move was invalid throw an error
            String errorMessage =
                    String.format(
                            "Error: %s is same colour as %s", incomingPiece.toString(), this.occupyingPiece.toString()
                    );
            throw new IllegalArgumentException(errorMessage);
        }
    }

    /**
     * Connects this tile to the tile that's directly above it (CAN ONLY BE SET ONCE)
     * @param aboveTile The tile directly above this one
     * @throws IllegalStateException
     * Thrown if there's already another tile connected above (need to regenerate whole board)
     */
    public void setAboveTile(Tile aboveTile) throws IllegalStateException {
        if (this.up == null) {
            this.up = aboveTile;
        } else {
            String errorMessage =
                    String.format("Error: %s is already connected above to %s", this.toString(), this.up);
            throw new IllegalStateException(errorMessage);
        }
    }

    /**
     * Connects this tile to the tile that's directly to the left (CAN ONLY BE SET ONCE)
     * @param leftTile The tile directly to the left of this one
     * @throws IllegalStateException
     * Thrown if there's already another tile connected to the left (need to regenerate whole board)
     */
    public void setLeftTile(Tile leftTile) throws IllegalStateException {
        if (this.left == null) {
            this.left = leftTile;
        } else {
            String errorMessage =
                    String.format("Error: %s is already connected to left tile %s", this.toString(), this.left);
            throw new IllegalStateException(errorMessage);
        }
    }

    /**
     * Connects this tile to the tile that's directly to the right (CAN ONLY BE SET ONCE)
     * @param rightTile The tile directly to the right of this one
     * @throws IllegalStateException
     * Thrown if there's already another tile to the right (need to regenerate whole board)
     */
    public void setRightTile(Tile rightTile) throws IllegalStateException {
        if (this.right == null) {
            this.right = rightTile;
        } else {
            String errorMessage =
                    String.format("Error: %s is already connected to right tile %s", this.toString(), this.right);
            throw new IllegalStateException(errorMessage);
        }
    }

    /**
     * Connects this tile to the tile that's directly below it (CAN ONLY BE SET ONCE)
     * @param belowTile The tile directly below this one
     * @throws IllegalStateException
     * Thrown if there's already another tile below it (need to regenerate whole board)
     */
    public void setBelowTile(Tile belowTile) throws IllegalStateException {
        if (this.down == null) {
            this.down = belowTile;
        } else {
            String errorMessage =
                    String.format("Error: %s is already connected below to %s", this.toString(), this.down);
            throw new IllegalStateException(errorMessage);
        }
    }
    //other methods

    /**
     * Overridden toString for Tile, now returns the coordinate position of the tile e.g. "E4"
     * @return Two character string detailing the coordinate on the chessboard
     */
    @Override
    public String toString() {
        return this.coordinate;
    }
}
