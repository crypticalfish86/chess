package com.jace.chess.localChess;

public class LocalChessApplication {

    Chessboard chessboard; //The chessboard the game is running on

    public LocalChessApplication() {
        chessboard = new Chessboard(this);
    }

    //start and run application with this method
    public void startGame() {
        ChessBoardPrinter.printChessBoard(chessboard);
        chessboard.inputInstruction("WP4D4");
        ChessBoardPrinter.printChessBoard(chessboard);
        chessboard.inputInstruction("WP4D5");
        ChessBoardPrinter.printChessBoard(chessboard);
    }


    public void endGameInCheckmate(Piece checkmatedKing) {
        if (checkmatedKing.getColour().equals(Colour.WHITE)) {
            System.out.println("BLACK WINS BY CHECKMATING WHITE!");
        } else {
            System.out.println("WHITE WINS BY CHECKMATING BLACK!");
        }
    }
}
