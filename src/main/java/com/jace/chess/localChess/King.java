package com.jace.chess.localChess;

import java.util.ArrayList;
import java.util.Optional;

public class King extends Piece{

    private boolean isChecked;

    /**
     * Constructor for king chess piece
     * @param colour The colour of the king
     * @param tile The tile the king occupies
     */
    public King(Colour colour, Chessboard chessboard, Tile tile) {
        super(colour, PieceType.KING, chessboard);
        this.updateOccupyingTile(tile);
        isChecked = false;
    }

    //getters

    /**
     * Returns a boolean that says whether the king is currently in check
     * @return boolean of whether the king is currently in check
     */
    public boolean isChecked() {
        return this.isChecked;
    }

    /**
     * Move the king in the 8 cardinal directions (also checks for checkmate of the king)
     */
    @Override
    public void updatePossibleMoves() {

        //check if left tile is a valid move for king
        Optional<Tile> leftTile = this.occupyingTile.tileLeft();
        if (leftTile.isPresent() && checkTile(leftTile.get())) {
            this.possibleMoves.add(leftTile.get());
        }

        //check if right tile is a valid move for king
        Optional<Tile> rightTile = this.occupyingTile.tileRight();
        if (rightTile.isPresent() && checkTile(rightTile.get())) {
            this.possibleMoves.add(rightTile.get());
        }

        //check the 3 tiles above and below and add valid ones to possible moves
        checkTileTriplet(this.occupyingTile.tileAbove());
        checkTileTriplet(this.occupyingTile.tileBelow());

        isChecked = checkForCheck(this.occupyingTile);
        //if no possible moves were found for the king, and the king is also in check then it's checkmate
        if (isChecked && this.possibleMoves.isEmpty()) {
            this.chessboard.checkmate(this);
        }
    }

    //Helper method which adds the valid moves of a triplet of tiles (meant for above and below tiles)
    private void checkTileTriplet(Optional<Tile> tileOptional) {
        if (tileOptional.isEmpty()) {
            return;
        } else {

            Tile centreTile = tileOptional.get();

            if (checkTile(centreTile)) {
                this.possibleMoves.add(centreTile);
            }

            Optional<Tile> leftTile = centreTile.tileLeft();
            if (leftTile.isPresent() && checkTile(leftTile.get())) {
                this.possibleMoves.add(leftTile.get());
            }

            Optional<Tile> rightTile = centreTile.tileRight();
            if (rightTile.isPresent() && checkTile(rightTile.get())) {
                this.possibleMoves.add(rightTile.get());
            }
        }
    }

    //helper method to check the tiles are valid possible moves (if tile is empty or there is an opposing piece) + no check
    private boolean checkTile(Tile tile) {
        Optional<Piece> occupyingPiece = tile.getPiece();
        return (occupyingPiece.isEmpty() || occupyingPiece.get().getColour() != this.getColour()) && checkForCheck(tile);
    }

    //helper method which checks the pieces on the chessboard to see if any pieces have this king currently in check
    private boolean checkForCheck(Tile tile) {
        ArrayList<Piece> allPieces = this.chessboard.getPieces();
        for (Piece piece : allPieces) {
            if (piece != this && piece.getAllPossibleMoves().contains(tile)) {
                return true;
            }
        }
        return false;
    }
}
