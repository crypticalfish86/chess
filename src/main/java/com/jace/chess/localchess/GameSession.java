package com.jace.chess.localchess;


//The top class that manages the whole game, class holds the chessboard and manages turns and input from user
public class GameSession {


    private final ChessBoard chessboard; //The chessboard (always 8x8 grid)
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
