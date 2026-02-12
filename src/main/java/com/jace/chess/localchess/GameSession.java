package com.jace.chess.localchess;

import java.util.ArrayList;

public class GameSession {

    private final Tile[][] chessboard = new Tile[8][8]; //The chessboard (always 8x8 grid)
    private final ArrayList<Piece> deadPiecesWhite = new ArrayList<Piece>(); //the pieces of white captured by black
    private final ArrayList<Piece> deadPiecesBlack = new ArrayList<Piece>(); //the pieces of black captured by white
    private boolean isWhiteTurn; //if true it is whites turn, if false it's blacks turn


    public GameSession() {
        this.isWhiteTurn = true;
        initializeChessboard();
        setUpPieces();
    }

    /*setup methods (methods in the constructor that set up the chessboard)*/

    //initialize tiles in the chessboard array (for xcoords use casted chars)
    private void initializeChessboard() {
        Colour startingColour = Colour.BLACK;
        Colour currentColour;

        for (int y = chessboard.length - 1; y >= 0; y--) {
            currentColour = startingColour;

            for (int x = (int) 'A'; x <= (int) 'H'; x++) {
                chessboard[y][x - 65] = new Tile(currentColour, y, (char) x);
                currentColour = switchColour(currentColour);
            }

            startingColour = switchColour(startingColour);
        }
    }
        //method to switch colour
        private Colour switchColour(Colour colour) {
            if (colour == Colour.WHITE) {
                return Colour.BLACK;
            }
            return Colour.WHITE;
        }

    //set up white and black chess pieces on the board
    private void setUpPieces() {}

    /*start method (this method should start and run the actual game)*/
    public void start() {
        ChessBoardPrinter chessBoardPrinter = new ChessBoardPrinter();
        chessBoardPrinter.print(chessboard);
    }



    /*inGameMethods (these methods take in input from the user
    e.g. (Ne4 meaning "Knight to e4") and change the chessboard state)*/


}
