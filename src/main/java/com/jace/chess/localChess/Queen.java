package com.jace.chess.localChess;

import java.util.Optional;

public class Queen extends Piece {

    public Queen(Colour colour, int id, Chessboard chessboard, Tile tile) {
        super(colour, PieceType.QUEEN, id, chessboard, tile);
    }

    /**
     * Moves the queen in all the directions a queen moves
     */
    @Override
    public void updatePossibleMoves() {
        this.possibleMoves.clear();

        //method would be so big and so unautomatable, so it's been split up into 8 separate but similar helpers
        setMovesUp();
        setMovesLeft();
        setMovesRight();
        setMovesDown();
        setMovesUpLeft();
        setMovesUpRight();
        setMovesDownLeft();
        setMovesDownRight();

    }

    /* HELPER: set possible moves for queen upwards */
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

    /* HELPER: set possible moves for queen leftwards */
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

    /* HELPER: set possible moves for queen rightwards*/
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

    /* HELPER: set possible moves for queen downwards*/
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

    /* HELPER: set possible moves for queen up-left diagonally*/
    private void setMovesUpLeft() {
        Optional<Tile> up = this.occupyingTile.tileAbove();
        if (up.isEmpty()) { //if there are no tiles up, then there are no tiles diagonally, end search here
            return;
        }
        Optional<Tile> upLeft = up.get().tileLeft();
        boolean validMovesRemain = upLeft.isPresent() && checkTile(upLeft.get());
        //while there are valid moves diagonally up-left, continue adding possible moves
        while (validMovesRemain) {
            this.possibleMoves.add(upLeft.get());
            up = upLeft.get().tileAbove();
            if (up.isEmpty()) { //if there's no longer tiles upwards then there's no more moves left, end search here
                break;
            }
            upLeft = up.get().tileLeft();
            validMovesRemain = upLeft.isPresent() && checkTile(upLeft.get());
        }
    }

    /* HELPER: set possible moves for queen up-right diagonally*/
    private void setMovesUpRight() {
        Optional<Tile> up = this.occupyingTile.tileAbove();
        if (up.isEmpty()) { //if there are no tiles up, then there are no tiles diagonally, end search here
            return;
        }
        Optional<Tile> upRight = up.get().tileRight();
        boolean validMovesRemain = upRight.isPresent() && checkTile(upRight.get());
        //while there are valid moves diagonally up-right, continue adding possible moves
        while (validMovesRemain) {
            this.possibleMoves.add(upRight.get());
            up = upRight.get().tileAbove();
            if (up.isEmpty()) { //if there's no longer tiles upwards then there's no more moves right, end search here
                break;
            }
            upRight = up.get().tileRight();
            validMovesRemain = upRight.isPresent() && checkTile(upRight.get());
        }
    }

    /* HELPER: set possible moves for queen down-left*/
    private void setMovesDownLeft() {
        Optional<Tile> down = this.occupyingTile.tileBelow();
        if (down.isEmpty()) { //if there are no tiles down, then there are no tiles diagonally, end search here
            return;
        }
        Optional<Tile> downLeft = down.get().tileLeft();
        boolean validMovesRemain = downLeft.isPresent() && checkTile(downLeft.get());
        //while there are valid moves diagnoally down-left, continue adding possible moves
        while (validMovesRemain) {
            this.possibleMoves.add(downLeft.get());
            down = downLeft.get().tileBelow();
            if (down.isEmpty()) { //if there are no longer tiles downwards then there's no more moves left, end search
                break;
            }
            downLeft = down.get().tileLeft();
            validMovesRemain = downLeft.isPresent() && checkTile(downLeft.get());
        }
    }

    /* HELPER: set possible moves for queen down-right*/
    private void setMovesDownRight() {
        Optional<Tile> down = this.occupyingTile.tileBelow();
        if (down.isEmpty()) { //if there are no tiles down, then there are no tiles diagonally, end search here
            return;
        }
        Optional<Tile> downRight = down.get().tileRight();
        boolean validMovesRemain = downRight.isPresent() && checkTile(downRight.get());
        while (validMovesRemain) {
            this.possibleMoves.add(downRight.get());
            down = downRight.get().tileBelow();
            if (down.isEmpty()) { //if there are no longer tiles downwards then there's no more moves left, end search
                break;
            }
            downRight = down.get().tileRight();
            validMovesRemain = downRight.isPresent() && checkTile(downRight.get());
        }
    }

    @Override
    public void uniqueAction() {}; //no unique action
}
