package com.jace.chess.localChess;

public class LocalChessApplication {


    public void endGameInCheckmate(Piece checkmatedKing) {
        if (checkmatedKing.getColour().equals(Colour.WHITE)) {
            System.out.println("BLACK WINS BY CHECKMATING WHITE!");
        } else {
            System.out.println("WHITE WINS BY CHECKMATING BLACK!");
        }
    }
}
