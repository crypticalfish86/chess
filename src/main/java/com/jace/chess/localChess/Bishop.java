package com.jace.chess.localChess;

import java.util.Optional;

public class Bishop extends Piece {

    public Bishop(Colour colour, int id, Chessboard chessboard, Tile tile) {
        super(colour, PieceType.BISHOP, id, chessboard, tile);
    }

    /**
     * Moves bishop in all directions a bishop should move
     */
    @Override
    public void updatePossibleMoves() {
        this.possibleMoves.clear();

        setMovesUpLeft();
        setMovesUpRight();
        setMovesDownLeft();
        setMovesDownRight();
    }

    /* HELPER: set possible moves for bishop up-left diagonally*/
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

    /* HELPER: set possible moves for bishop up-right diagonally*/
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

    /* HELPER: set possible moves for bishop down-left*/
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

    /* HELPER: set possible moves for bishop down-right*/
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
}
