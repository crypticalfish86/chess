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
        printChessBoard();
    }

    /*print the chessboard (including pieces), each tile should be 3 characters wide with the middle replaced
    * with the chess piece occupying the square if there is one (if not should be a space " "*/
    public void printChessBoard() {

        int rowNumber = 8;
        for (Tile[] row : chessboard) {

            //initial formatting for row
            System.out.println();
            System.out.print(rowNumber);
            System.out.print(" ");

            //print each tile on the row
            for (Tile currentTile : row) {

                String tileColourAscii =
                        currentTile.getTileColour() == Colour.WHITE ?
                                BoardAscii.WHITE_TILE_COLOUR : BoardAscii.BLACK_TILE_COLOUR;

                String pieceAscii = getPieceAscii(currentTile.getHeldPiece());

                String wholeTileAscii = String.format("%s %s %s",
                        tileColourAscii,
                        pieceAscii,
                        BoardAscii.RESET_BACKGROUND_COLOUR);

                System.out.print(wholeTileAscii);
            }

            rowNumber--;
        }
        System.out.println("\n" + BoardAscii.LETTER_COLUMN);
    }
        private String getPieceAscii(Piece piece) {
            if (piece == null) {
                return BoardAscii.EMPTY;
            }
            return switch (piece.getPieceType()) {
                case PieceType.KING -> BoardAscii.KING;
                case PieceType.QUEEN -> BoardAscii.QUEEN;
                case PieceType.BISHOP -> BoardAscii.BISHOP;
                case PieceType.KNIGHT -> BoardAscii.KNIGHT;
                case PieceType.ROOK -> BoardAscii.ROOK;
                case PieceType.PAWN -> BoardAscii.PAWN;
            };
        }

    /*inGameMethods (these methods take in input from the user
    e.g. (Ne4 meaning "Knight to e4") and change the chessboard state)*/


}
