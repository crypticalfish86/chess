package com.jace.chess.localChess;

import java.util.Optional;

public class Pawn extends Piece {

    /**
     * Pawn moves only up (or diagonally when there's enemy piece)
     * @param colour Colour of the piece
     * @param id Piece ID (unique per piece-type per colour)
     * @param chessboard The chessboard the piece is on
     * @param tile The tile the piece is starting on
     */
    public Pawn(Colour colour, int id, Chessboard chessboard, Tile tile) {
        super(colour, PieceType.PAWN, id, chessboard, tile);
    }

    /**
     * Pawn moves up (or diagonally when there's enemy piece)
     */
    @Override
    public void updatePossibleMoves() {
        this.possibleMoves.clear();

        Optional<Tile> up = this.occupyingTile.tileAbove();

        if (up.isEmpty()) { //if there are no more tiles up then end search here
            return;
        }

        if (up.get().getPiece().isEmpty()) { //if the tile directly above pawn is empty then it's a valid move
            this.possibleMoves.add(up.get());
        }

        //if an enemy piece is in top left tile, then it's a valid move
        if (up.get().tileLeft().isPresent()) {
            if (up.get().tileLeft().get().getPiece().isPresent()) {
                if (up.get().tileLeft().get().getPiece().get().getColour() != this.getColour()) {
                    this.possibleMoves.add(up.get().tileLeft().get());
                }
            }
        }

        //if an enemy piece is in top right tile, then it's a valid move
        if (up.get().tileRight().isPresent()) {
            if (up.get().tileRight().get().getPiece().isPresent()) {
                if (up.get().tileRight().get().getPiece().get().getColour() != this.getColour()) {
                    this.possibleMoves.add(up.get().tileRight().get());
                }
            }
        }
    }


    public void transformPiece(PieceType transformationChoice) throws IllegalArgumentException {

        //ensure the pawn can only transform into valid pieces
        if (transformationChoice.equals(PieceType.KING) || transformationChoice.equals(PieceType.PAWN)) {
            String errorMessage = "Error: invalid transformation option";
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
