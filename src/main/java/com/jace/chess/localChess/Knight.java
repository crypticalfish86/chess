package com.jace.chess.localChess;

public class Knight extends Piece{

    /**
     * Knight piece moves in L-Shapes
     * @param colour Colour of the piece
     * @param id Piece ID (unique per piece-type per colour)
     * @param chessboard The chessboard the piece is on
     * @param tile The tile the piece is starting on
     */
    public Knight(Colour colour, int id, Chessboard chessboard, Tile tile) {
        super(colour, PieceType.KNIGHT, id, chessboard, tile);
    }

    /**
     * Moves Knight in all the L-Shapes it should move
     */
    @Override
    public void updatePossibleMoves() {
        this.possibleMoves.clear();

        setUpLShapes();
        setLeftLShapes();
        setRightLShapes();
        setDownLShapes();
    }

    /* HELPER: set possible moves for upwards L-Shapes*/
    private void setUpLShapes() {

        //if there isn't 2 tiles upwards, then end search for valid moves here
        if (this.occupyingTile.tileAbove().isEmpty() || this.occupyingTile.tileAbove().get().tileAbove().isEmpty()) {
            return;
        }

        Tile up2Tile = this.occupyingTile.tileAbove().get().tileAbove().get();

        if (up2Tile.tileLeft().isPresent() && checkTile(up2Tile.tileLeft().get())) { //add left L-Shape if valid
            possibleMoves.add(up2Tile.tileLeft().get());
        }

        if (up2Tile.tileRight().isPresent() && checkTile(up2Tile.tileRight().get())) { //add right L-Shape if valid
            possibleMoves.add(up2Tile.tileRight().get());
        }
    }

    /* HELPER: set possible moves for left L-Shapes*/
    private void setLeftLShapes() {

        //if there isn't 2 tiles leftwards, then end search for valid moves here
        if (this.occupyingTile.tileLeft().isEmpty() || this.occupyingTile.tileLeft().get().tileLeft().isEmpty()) {
            return;
        }

        Tile left2Tile = this.occupyingTile.tileLeft().get().tileLeft().get();

        if (left2Tile.tileAbove().isPresent() && checkTile(left2Tile.tileAbove().get())) { //add up left L-Shape if valid
            possibleMoves.add(left2Tile.tileAbove().get());
        }

        if (left2Tile.tileBelow().isPresent() && checkTile(left2Tile.tileBelow().get())) { //add down left L-Shape if valid
            possibleMoves.add(left2Tile.tileBelow().get());
        }
    }

    /* HELPER: set possible moves for right L-Shapes*/
    private void setRightLShapes() {

        //if there isn't 2 tiles rightwards, then end search for valid moves here
        if (this.occupyingTile.tileRight().isEmpty() || this.occupyingTile.tileRight().get().tileRight().isEmpty()) {
            return;
        }

        Tile right2Tile = this.occupyingTile.tileRight().get().tileRight().get();

        if (right2Tile.tileAbove().isPresent() && checkTile(right2Tile.tileAbove().get())) {
            possibleMoves.add(right2Tile.tileAbove().get());
        }

        if (right2Tile.tileBelow().isPresent() && checkTile(right2Tile.tileBelow().get())) {
            possibleMoves.add(right2Tile.tileBelow().get());
        }
    }

    /* HELPER: set possible moves for down L-Shapes*/
    private void setDownLShapes() {

        //if there isn't 2 tiles downwards, then end search for valid moves here
        if (this.occupyingTile.tileBelow().isEmpty() || this.occupyingTile.tileBelow().get().tileBelow().isEmpty()) {
            return;
        }

        Tile down2Tile = this.occupyingTile.tileBelow().get().tileBelow().get();

        if (down2Tile.tileLeft().isPresent() && checkTile(down2Tile.tileLeft().get())) {
            possibleMoves.add(down2Tile.tileLeft().get());
        }

        if (down2Tile.tileRight().isPresent() && checkTile(down2Tile.tileRight().get())) {
            possibleMoves.add(down2Tile.tileRight().get());
        }
    }
}
