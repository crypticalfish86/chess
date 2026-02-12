package com.jace.chess.localchess;

import java.util.ArrayList;

public class GameSession {


    private final ChessBoard chessboard; //The chessboard (always 8x8 grid)
    private final ArrayList<Piece> deadPiecesWhite = new ArrayList<Piece>(); //the pieces of white captured by black
    private final ArrayList<Piece> deadPiecesBlack = new ArrayList<Piece>(); //the pieces of black captured by white
    private boolean isWhiteTurn; //if true it is whites turn, if false it's blacks turn

    private static final ChessBoardPrinter chessBoardPrinter = new ChessBoardPrinter(); //the printer for our chessboards

    public GameSession() {
        this.isWhiteTurn = true;
        this.chessboard = new ChessBoard();
    }

    /*start method (this method should start and run the actual game until checkmate after which should exit)*/
    public void start() {
        chessBoardPrinter.print(this.chessboard.getChessboard());
    }

    /*inGameMethods (these methods take in input from the user
    e.g. (Ne4 meaning "Knight to e4") and change the chessboard state)*/


}
