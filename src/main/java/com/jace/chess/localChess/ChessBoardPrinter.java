package com.jace.chess.localChess;

/*Helper class which prints the board to the console*/
public class ChessBoardPrinter {
    //Tile background colours
    public static final String whiteTileColour = "\u001B[47;1m"; //Bright white
    public static final String blackTileColour = "\u001B[100m"; //Dark grey
    public static final String resetBackground = "\u001B[0m"; //reset background colour

    //Piece colours
    public static final String whitePieceColour = "\u001B[31m"; //RED
    public static final String blackPieceColour = "\u001B[34m"; //BLUE
    public static final String resetTextColour = "\u001B[0m"; //reset text colour

    //Piece type ascii representations
    public static final String King = "K";
    public static final String Queen = "Q";
    public static final String Bishop = "B";
    public static final String Knight = "N";
    public static final String Rook = "R";
    public static final String Pawn = "P";


    public static void printChessBoard(Chessboard chessboard) {
        Tile[][] board = chessboard.getChessboard();

        System.out.println();
        for (Tile[] row : board) {
            for (Tile tile : row) {

                String tileColour = tile.getTileColour().equals(Colour.WHITE) ? whiteTileColour : blackTileColour;

                String pieceColour = "";
                String pieceAscii = "";
                if (tile.getPiece().isPresent()) { //if a piece is present get the correct ascii rep
                    pieceColour =
                            tile.getPiece().get().getColour().equals(Colour.WHITE) ? whitePieceColour : blackPieceColour;
                    pieceAscii = getPieceAsciiRep(tile.getPiece().get());
                } else { //otherwise just put a space there to represent an empty tile (consistent tile sizes this way)
                    pieceAscii = " ";
                }

                String finalConsoleRepresentation =
                        String.format("%s %s%s %s%s", tileColour, pieceColour, pieceAscii, resetBackground, resetTextColour);

                System.out.print(finalConsoleRepresentation);

            }
            System.out.println();
        }
    }

    /* HELPER: returns the correct ascii representation for the piece*/
    private static String getPieceAsciiRep(Piece piece) {
        PieceType pieceType = piece.getPieceType();

        return switch (pieceType) {
            case KING -> King;
            case QUEEN -> Queen;
            case BISHOP -> Bishop;
            case KNIGHT -> Knight;
            case ROOK -> Rook;
            case PAWN -> Pawn;
        };
    }
}
