package com.jace.chess.localchess;

/*This is a helper class that simply prints the chessboard it's fed. It prints the chessboard in the console
* (including pieces) each tile should be 3 characters wide with the middle replaced the occupying chess piece
* (if there isn't a piece on the tile it should be replaced with an empty space " ")*/
public class ChessBoardPrinter {

    /*print the chessboard (including pieces), each tile should be 3 characters wide with the middle replaced
     * with the chess piece occupying the square if there is one (if not should be a space " "*/
    public void print(Tile[][] chessboard) {

        //print each row
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
        //if no piece just return empty ascii
        if (piece == null) {
            return BoardAscii.EMPTY;
        }


        //start building ascii representation and add text colour
        String asciiRep = "";
        if (piece.getColour() == Colour.WHITE) {
            asciiRep += BoardAscii.WHITE_PIECE_COLOUR;
        } else {
            asciiRep += BoardAscii.BLACK_PIECE_COLOUR;
        }

        //add and return the relevant piece type ascii
        return switch (piece.getPieceType()) {
            case PieceType.KING -> asciiRep + BoardAscii.KING;
            case PieceType.QUEEN -> asciiRep + BoardAscii.QUEEN;
            case PieceType.BISHOP -> asciiRep + BoardAscii.BISHOP;
            case PieceType.KNIGHT -> asciiRep + BoardAscii.KNIGHT;
            case PieceType.ROOK -> asciiRep + BoardAscii.ROOK;
            case PieceType.PAWN -> asciiRep + BoardAscii.PAWN;
        };
    }
}
