package com.jace.chess.local;

import com.jace.chess.local.Pieces.*;

import java.util.ArrayList;

/*This is a local simulated chess just based on the console, just so I can develop a local version first before I make
* the actual version.
* */
public class LocalChess {
    private final Tile[][] chessboard; //the chessboard
    private static final int BOARD_SIZE = 8; //size of chessboard

    private ArrayList<Piece> takenPiecesWhite;
    private ArrayList<Piece> takenPiecesBlack;

    private boolean whiteTurn;

    public LocalChess() {
        chessboard = new Tile[BOARD_SIZE][BOARD_SIZE];
        takenPiecesWhite = new ArrayList<Piece>();
        takenPiecesBlack = new ArrayList<Piece>();
        whiteTurn = true;
        initializeBoard();
        initializeChessPieces();
        printChessBoard();
    }

    //Startup methods

    //initialize the chessboard tiles
    private void initializeBoard() {
        //initialize the chessboard with coordinates, the letter is determined by casting ints to chars corresponding to ascii
        Colour startingRowColour = Colour.WHITE;
        Colour currentTileColour;
        int rowNumber = BOARD_SIZE;
        for (int i = 0; i < chessboard.length; i++) {
            Tile[] row = chessboard[i];

            currentTileColour = startingRowColour;
            int asciiNum = 97; //if you cast as char, this is 'a'
            for (int j = 0; j < row.length; j++) {
                String coordinate = String.format("%c%d", (char) asciiNum, rowNumber);
                chessboard[i][j] = new Tile(currentTileColour, coordinate, this);
                asciiNum++;
                currentTileColour = switchColour(currentTileColour);
            }

            startingRowColour = switchColour(startingRowColour);
            rowNumber--;
        }
    }
        private Colour switchColour(Colour colour) { //helper function to just switch the colour of the tile
            if (colour == Colour.WHITE) {
                return Colour.BLACK;
            }
            return Colour.WHITE;
        }

    //initialize the chessboard pieces
    private void initializeChessPieces(){
        //black back row
        //black front row
        Tile[] backRow = chessboard[0];
        backRow[0].updateOccupyingPiece(new Rook(Colour.BLACK));
        backRow[1].updateOccupyingPiece(new Knight(Colour.BLACK));
        backRow[2].updateOccupyingPiece(new Bishop(Colour.BLACK));
        backRow[3].updateOccupyingPiece(new Queen(Colour.BLACK));
        backRow[4].updateOccupyingPiece(new King(Colour.BLACK));
        backRow[5].updateOccupyingPiece(new Bishop(Colour.BLACK));
        backRow[6].updateOccupyingPiece(new Knight(Colour.BLACK));
        backRow[7].updateOccupyingPiece(new Rook(Colour.BLACK));

        Tile[] secondBackRow = chessboard[1];
        for (Tile tile : secondBackRow) {
            tile.updateOccupyingPiece(new Pawn(Colour.BLACK));
        }

        //middle empty tiles

        //white front row
        Tile[] secondFrontRow = chessboard[6];
        for (Tile tile : secondFrontRow) {
            tile.updateOccupyingPiece(new Pawn(Colour.WHITE));
        }
        //white back row
        Tile[] frontRow = chessboard[7];
        frontRow[0].updateOccupyingPiece(new Rook(Colour.WHITE));
        frontRow[1].updateOccupyingPiece(new Knight(Colour.WHITE));
        frontRow[2].updateOccupyingPiece(new Bishop(Colour.WHITE));
        frontRow[3].updateOccupyingPiece(new Queen(Colour.WHITE));
        frontRow[4].updateOccupyingPiece(new King(Colour.WHITE));
        frontRow[5].updateOccupyingPiece(new Bishop(Colour.WHITE));
        frontRow[6].updateOccupyingPiece(new Knight(Colour.WHITE));
        frontRow[7].updateOccupyingPiece(new Rook(Colour.WHITE));
    }

    //game methods

    //whole game runs within this method.
    public void startGame() {

    }

    //prints the current state of the chessboard
    private void printChessBoard() {
        System.out.println();
        for (Tile[] row : chessboard) {
            for (Tile tile : row) {
                String colourUnicode = tile.getTileColour() == Colour.WHITE ? Tile.WHITE_TILE_COLOUR : Tile.BLACK_TILE_COLOUR;
                String tileRepresentation = String.format(" %s ", returnOccupyingPieceOnTile(tile));
                System.out.print(colourUnicode + tileRepresentation + Tile.COLOUR_UNICODE_RESET);//three char, replace middle with piece when its occupied
            }
            System.out.println();
        }
    }
        private String returnOccupyingPieceOnTile(Tile tile) {
            if (tile.getOccupyingPiece() == null) {
                return " ";
            } else {
                return tile.getOccupyingPiece().getAsciiRepresentation();
            }
        }

    //displays the players dead pieces

    //updated the taken pieces in the game
    public void updateTakenPieces(Piece takenPiece) {}

}
