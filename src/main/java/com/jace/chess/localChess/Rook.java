package com.jace.chess.localChess;

import java.util.Optional;

public class Rook extends Piece{

    public Rook(Colour colour, int id, Chessboard chessboard, Tile tile) {
        super(colour, PieceType.ROOK, id, chessboard, tile);
    }

    /**
     * Moves rook in all 4 directions a rook should move
     */
    @Override
    public void updatePossibleMoves() {
        this.possibleMoves.clear();

        setMovesUp();
        setMovesLeft();
        setMovesRight();
        setMovesDown();
    }

    /* HELPER: set possible moves for rook upwards */
    private void setMovesUp() {
        Optional<Tile> tileAbove = this.occupyingTile.tileAbove();
        boolean validMovesRemain = tileAbove.isPresent() && checkTile(tileAbove.get());
        //while there are valid moves left upwards, continue adding to possible moves
        while (validMovesRemain) {
            this.possibleMoves.add(tileAbove.get());
            tileAbove = tileAbove.get().tileAbove();
            validMovesRemain = tileAbove.isPresent() && checkTile(tileAbove.get());
        }
    }

    /* HELPER: set possible moves for rook leftwards */
    private void setMovesLeft() {
        Optional<Tile> tileLeft = this.occupyingTile.tileLeft();
        boolean validMovesRemain = tileLeft.isPresent() && checkTile(tileLeft.get());
        //while there are valid moves left in the leftwards direction, continue adding possible moves
        while (validMovesRemain) {
            this.possibleMoves.add(tileLeft.get());
            tileLeft = tileLeft.get().tileLeft();
            validMovesRemain = tileLeft.isPresent() && checkTile(tileLeft.get());
        }
    }

    /* HELPER: set possible moves for rook rightwards*/
    private void setMovesRight() {
        Optional<Tile> tileRight = this.occupyingTile.tileRight();
        boolean validMovesRemain = tileRight.isPresent() && checkTile(tileRight.get());
        //while there are valid moves left in the rightwards direction, continue adding possible moves
        while (validMovesRemain) {
            this.possibleMoves.add(tileRight.get());
            tileRight = tileRight.get().tileRight();
            validMovesRemain = tileRight.isPresent() && checkTile(tileRight.get());
        }
    }

    /* HELPER: set possible moves for rook downwards*/
    private void setMovesDown() {
        Optional<Tile> tileBelow = this.occupyingTile.tileBelow();
        boolean validMovesRemain = tileBelow.isPresent() && checkTile(tileBelow.get());
        //while there are valid moves downwards, continue adding possible moves
        while (validMovesRemain) {
            this.possibleMoves.add(tileBelow.get());
            tileBelow = tileBelow.get().tileBelow();
            validMovesRemain = tileBelow.isPresent() && checkTile(tileBelow.get());
        }
    }

    @Override
    public void uniqueAction() {}; //no unique action

}
