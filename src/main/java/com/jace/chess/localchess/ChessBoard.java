package com.jace.chess.localchess;

//This object is the actual chessboard
public class ChessBoard {
    private final Tile[][] chessboard = new Tile[8][8]; //The chessboard (always 8x8 grid)


    public ChessBoard() {
        initializeChessBoard();
        setUpPieces();
    }

    public Tile[][] getChessboard() {
        return this.chessboard;
    }

    //initialize tiles in the chessboard array (for xcoords use casted chars)
    private void initializeChessBoard() {
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
        //helper method to switch colour
        private Colour switchColour(Colour colour) {
            if (colour == Colour.WHITE) {
                return Colour.BLACK;
            }
            return Colour.WHITE;
        }

    private void setUpPieces() {};
}
