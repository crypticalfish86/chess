package com.jace.chess.local;

import java.util.ArrayList;

/*This is a local simulated chess just based on the console, just so I can develop a local version first before I make
* the actual version.
* */
public class LocalChess {
    private final Tile[][] chessboard; //the chessboard
    private static final int BOARD_SIZE = 8; //size of chessboard

    private ArrayList<Piece> takenPiecesWhite;
    private ArrayList<Piece> takenPiecesBlack;

    LocalChess() {
        chessboard = new Tile[BOARD_SIZE][BOARD_SIZE];
        takenPiecesWhite = new ArrayList<Piece>();
        takenPiecesBlack = new ArrayList<Piece>();
        initializeBoard();
    }

    //Startup methods

    //initialize the chessboard tiles
    private void initializeBoard() {}

    //initialize the chessboard pieces
    private void initializeChessPieces(){}

    //game methods

    //updated the taken pieces in the game
    public void updateTakenPieces(Piece takenPiece) {}

}
