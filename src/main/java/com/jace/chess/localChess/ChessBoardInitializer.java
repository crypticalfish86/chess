package com.jace.chess.localChess;

//A helper class for Chessboard with static methods which just return a freshly initialized chessboard with pieces
public class ChessBoardInitializer {
    private static Tile[][] initializedBoard;

    /**
     * Initializes the chessboard 8x8 chessboard with position [0][0] being tile A1
     * @param chessboard The completed chessboard
     */
    public static void initializeBoard(Chessboard chessboard) {
        initializedBoard = new Tile[8][8];

        //build row by row, connecting each row to the one before it (via the below tile)
        Colour rowStartingColour = Colour.WHITE;
        for (int row = 0; row < initializedBoard.length; row++) {
            rowStartingColour = flipColour(rowStartingColour);
            Colour columnColour = rowStartingColour;

            for (int col = 0; col < initializedBoard[row].length; col++) {
                Tile tile = new Tile(columnColour, chessboard, translateCoordinate(row, col));
                initializedBoard[row][col] = tile;
                //left
                if (col != 0) {
                    Tile leftTile = initializedBoard[row][col - 1];
                    tile.setLeftTile(leftTile);
                    leftTile.setRightTile(tile);
                }
                //down
                if (row != 0) {
                    Tile belowTile = initializedBoard[row - 1][col];
                    tile.setBelowTile(belowTile);
                    belowTile.setAboveTile(tile);
                }

                columnColour = flipColour(columnColour);
            }
        }

        setPiecesOnBoard(chessboard);
        //initialize possible moves for every piece
        chessboard.updateBoardMoves();
        //return chessboard
        chessboard.setChessboard(initializedBoard);
    }

    //simple helper method to flip the colour
    private static Colour flipColour(Colour colour) {
        return colour == Colour.WHITE ? Colour.BLACK : Colour.WHITE;
    }

    //simple helper method to translate the row and column into a coordinate position for a tile
    private static String translateCoordinate(int y, int x) {
        int row = y + 1;
        char column = (char) ('A' + x);
        return String.format("%c%d", column, row);
    }

    //helper method which sets up the pieces on the now initialized tiles on the board COME BACK TO THIS WHEN YOU'VE MADE ALL PIECES
    private static void setPiecesOnBoard(Chessboard chessboard) {
        //white back-line
        initializedBoard[0][0].updatePiece(new Rook(Colour.WHITE, 1, chessboard, initializedBoard[0][0]));
        initializedBoard[0][1].updatePiece(new Knight(Colour.WHITE, 1, chessboard, initializedBoard[0][1]));
        initializedBoard[0][2].updatePiece(new Bishop(Colour.WHITE, 1, chessboard, initializedBoard[0][2]));
        initializedBoard[0][3].updatePiece(new Queen(Colour.WHITE, 1, chessboard, initializedBoard[0][3]));
        initializedBoard[0][4].updatePiece(new King(Colour.WHITE, 1, chessboard, initializedBoard[0][4]));
        initializedBoard[0][5].updatePiece(new Bishop(Colour.WHITE, 2, chessboard, initializedBoard[0][5]));
        initializedBoard[0][6].updatePiece(new Knight(Colour.WHITE, 2, chessboard, initializedBoard[0][6]));
        initializedBoard[0][7].updatePiece(new Rook(Colour.WHITE, 2, chessboard, initializedBoard[0][7]));
        //white pawn-line
        initializedBoard[1][0].updatePiece(new Pawn(Colour.WHITE, 1, chessboard, initializedBoard[1][0]));
        initializedBoard[1][1].updatePiece(new Pawn(Colour.WHITE, 2, chessboard, initializedBoard[1][1]));
        initializedBoard[1][2].updatePiece(new Pawn(Colour.WHITE, 3, chessboard, initializedBoard[1][2]));
        initializedBoard[1][3].updatePiece(new Pawn(Colour.WHITE, 4, chessboard, initializedBoard[1][3]));
        initializedBoard[1][4].updatePiece(new Pawn(Colour.WHITE, 5, chessboard, initializedBoard[1][4]));
        initializedBoard[1][5].updatePiece(new Pawn(Colour.WHITE, 6, chessboard, initializedBoard[1][5]));
        initializedBoard[1][6].updatePiece(new Pawn(Colour.WHITE, 7, chessboard, initializedBoard[1][6]));
        initializedBoard[1][7].updatePiece(new Pawn(Colour.WHITE, 8, chessboard, initializedBoard[1][7]));

        //black pawn-line
        initializedBoard[6][0].updatePiece(new Pawn(Colour.BLACK, 1, chessboard, initializedBoard[6][0]));
        initializedBoard[6][1].updatePiece(new Pawn(Colour.BLACK, 2, chessboard, initializedBoard[6][1]));
        initializedBoard[6][2].updatePiece(new Pawn(Colour.BLACK, 3, chessboard, initializedBoard[6][2]));
        initializedBoard[6][3].updatePiece(new Pawn(Colour.BLACK, 4, chessboard, initializedBoard[6][3]));
        initializedBoard[6][4].updatePiece(new Pawn(Colour.BLACK, 5, chessboard, initializedBoard[6][4]));
        initializedBoard[6][5].updatePiece(new Pawn(Colour.BLACK, 6, chessboard, initializedBoard[6][5]));
        initializedBoard[6][6].updatePiece(new Pawn(Colour.BLACK, 7, chessboard, initializedBoard[6][6]));
        initializedBoard[6][7].updatePiece(new Pawn(Colour.BLACK, 8, chessboard, initializedBoard[6][7]));
        //black back-line
        initializedBoard[7][0].updatePiece(new Rook(Colour.BLACK, 1, chessboard, initializedBoard[7][0]));
        initializedBoard[7][1].updatePiece(new Knight(Colour.BLACK, 1, chessboard, initializedBoard[7][1]));
        initializedBoard[7][2].updatePiece(new Bishop(Colour.BLACK, 1, chessboard, initializedBoard[7][2]));
        initializedBoard[7][3].updatePiece(new Queen(Colour.BLACK, 1, chessboard, initializedBoard[7][3]));
        initializedBoard[7][4].updatePiece(new King(Colour.BLACK, 1, chessboard, initializedBoard[7][4]));
        initializedBoard[7][5].updatePiece(new Bishop(Colour.BLACK, 2, chessboard, initializedBoard[7][5]));
        initializedBoard[7][6].updatePiece(new Knight(Colour.BLACK, 2, chessboard, initializedBoard[7][6]));
        initializedBoard[7][7].updatePiece(new Rook(Colour.BLACK, 2, chessboard, initializedBoard[7][7]));
    }
}
