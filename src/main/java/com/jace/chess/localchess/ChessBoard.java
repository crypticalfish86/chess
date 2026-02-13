package com.jace.chess.localchess;

import java.util.ArrayList;
import com.jace.chess.localchess.Pieces.*;

/*
    This object is the actual chess board.
    chessboard[0][0] is A8, chessboard[0][7] is H8, chessboard [7][0] is A1, chessboard[7][7] is H1
*/
public class ChessBoard {
    private final Tile[][] chessboard = new Tile[8][8]; //The chessboard (always 8x8 grid)
    private final ArrayList<Piece> deadPiecesWhite = new ArrayList<Piece>(); //the pieces of white captured by black
    private final ArrayList<Piece> alivePiecesWhite = new ArrayList<Piece>(); //current pieces in play for white
    private final ArrayList<Piece> deadPiecesBlack = new ArrayList<Piece>(); //the pieces of black captured by white
    private final ArrayList<Piece> alivePiecesBlack = new ArrayList<Piece>(); //current pieces in play for black

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

        setupBackRow(chessboard[0], Colour.BLACK, alivePiecesBlack); //Row 8 (black back row)

        for (int i = 0; i < chessboard[1].length; i++) { //Row 7 (black pawn row)
            Piece pawn = new Pawn(Colour.BLACK, PieceType.PAWN, this,i + 1);
            chessboard[1][i].updateHeldPiece(pawn);
            alivePiecesBlack.add(pawn);
        }

        for (int i = 0; i < chessboard[6].length; i++) { //Row 2 (white pawn row)
            Piece pawn = new Pawn(Colour.WHITE, PieceType.PAWN,this,i + 1);
            chessboard[6][i].updateHeldPiece(pawn);
            alivePiecesWhite.add(pawn);
        }

        setupBackRow(chessboard[7], Colour.WHITE, alivePiecesWhite); //Row 1 (white back row)
    }
        //helper function to set up white and blacks back row
        private void setupBackRow(Tile[] row, Colour colour, ArrayList<Piece> list) {
            Piece rook1 = new Rook(colour, PieceType.ROOK, this, 1);
            Piece knight1 = new Knight(colour, PieceType.KNIGHT, this,1);
            Piece bishop1 = new Bishop(colour, PieceType.BISHOP, this,1);
            Piece queen = new Queen(colour, PieceType.QUEEN, this,1);
            Piece king = new King(colour, PieceType.KING, this,1);
            Piece bishop2 = new Bishop(colour, PieceType.BISHOP, this,2);
            Piece knight2 = new Knight(colour, PieceType.KNIGHT, this,2);
            Piece rook2 = new Rook(colour, PieceType.ROOK, this,2);

            row[0].updateHeldPiece(rook1);
            row[1].updateHeldPiece(knight1);
            row[2].updateHeldPiece(bishop1);
            row[3].updateHeldPiece(queen);
            row[4].updateHeldPiece(king);
            row[5].updateHeldPiece(bishop2);
            row[6].updateHeldPiece(knight2);
            row[7].updateHeldPiece(rook2);

            list.add(rook1);
            list.add(knight1);
            list.add(bishop1);
            list.add(queen);
            list.add(king);
            list.add(bishop2);
            list.add(knight2);
            list.add(rook2);
        }
}
