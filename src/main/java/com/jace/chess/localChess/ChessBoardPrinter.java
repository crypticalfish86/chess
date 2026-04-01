package com.jace.chess.localChess;

import java.util.Stack;

/*Helper class which prints the board to the console*/
public class ChessBoardPrinter {
    //Tile background colours
    private static final String whiteTileColour = "\u001B[47;1m"; //Bright white
    private static final String blackTileColour = "\u001B[100m"; //Dark grey
    private static final String resetBackground = "\u001B[0m"; //reset background colour

    //Piece colours
    private static final String whitePieceColour = "\u001B[38;2;139;0;0m"; //RED
    private static final String blackPieceColour = "\u001B[38;2;0;0;139m"; //BLUE
    private static final String resetTextColour = "\u001B[0m"; //reset text colour

    //Piece type ascii representations
    private static final String King = "K";
    private static final String Queen = "Q";
    private static final String Bishop = "B";
    private static final String Knight = "N";
    private static final String Rook = "R";
    private static final String Pawn = "P";

    //extra misc fields
    private static final Stack<String> rowNumber = new Stack<>();

    public static void printChessBoard(Chessboard chessboard) {
        rowNumber.add("1");
        rowNumber.add("2");
        rowNumber.add("3");
        rowNumber.add("4");
        rowNumber.add("5");
        rowNumber.add("6");
        rowNumber.add("7");
        rowNumber.add("8");

        System.out.println();
        Tile[][] board = reverseBoard(chessboard.getChessboard()); //need to reverse board (visually, board is backwards)


        for (Tile[] row : board) {
            System.out.print(rowNumber.pop() + " ");
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
        System.out.print("   A  B  C  D  E  F  G  H");
        rowNumber.clear();
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

    /* HELPER: fixes visualisation of the board being the wrong way round in terms of rows*/
    private static Tile[][] reverseBoard(Tile[][] board) {
        Tile[][] reversedBoard = new Tile[board.length][board[0].length];

        int j = 0;
        for (int i = reversedBoard.length - 1; i >= 0 && j < board.length; i--) {
            reversedBoard[i] = board[j];
            j++;
        }

        return reversedBoard;
    }
}
