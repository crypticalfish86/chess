package com.jace.chess.localchess;

/*
    This object is the actual chess board.
    chessboard[0][0] is A8, chessboard[0][7] is H8, chessboard [7][0] is A1, chessboard[7][7] is H1
*/
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

    //set up the initial pieces on the chessboard
    private void setUpPieces() {
        //Row 8 (black back row)
        setupBackRow(chessboard[0], Colour.BLACK);

        //Row 7 (black pawn row)
        for (int i = 0; i < chessboard[1].length; i++) {
            chessboard[1][i].updateHeldPiece(new Piece(Colour.BLACK, PieceType.PAWN));
        }

        //Row 2 (white pawn row)
        for (int i = 0; i < chessboard[6].length; i++) {
            chessboard[6][i].updateHeldPiece(new Piece(Colour.WHITE, PieceType.PAWN));
        }

        //Row 1 (white back row)
        setupBackRow(chessboard[7], Colour.WHITE);
    }
        //helper function to set up white and blacks back row
        private void setupBackRow(Tile[] row, Colour colour) {
            row[0].updateHeldPiece(new Piece(colour, PieceType.ROOK));
            row[1].updateHeldPiece(new Piece(colour, PieceType.KNIGHT));
            row[2].updateHeldPiece(new Piece(colour, PieceType.BISHOP));
            row[3].updateHeldPiece(new Piece(colour, PieceType.QUEEN));
            row[4].updateHeldPiece(new Piece(colour, PieceType.KING));
            row[5].updateHeldPiece(new Piece(colour, PieceType.BISHOP));
            row[6].updateHeldPiece(new Piece(colour, PieceType.KNIGHT));
            row[7].updateHeldPiece(new Piece(colour, PieceType.ROOK));
        }




}
