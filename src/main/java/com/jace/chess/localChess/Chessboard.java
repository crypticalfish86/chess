package com.jace.chess.localChess;

import java.util.ArrayList;
import java.util.Optional;

//holds the chessboard and performs instructions inputted from the chessApplication

public class Chessboard {
    private final LocalChessApplication application; //The application the board is running on
    private Tile[][] chessboard;
    private final ArrayList<Piece> pieces = new ArrayList<Piece>();
    private Piece whiteKing; //The white king
    private Piece blackKing; //The black king


    /**
     * Constructor which sets up chessboard
     */
    Chessboard(LocalChessApplication application) {
        this.application = application;
        ChessBoardInitializer.initializeBoard(this);
    }

    //getters
    /**
     * Returns the pieces on the chessboard
     * @return List of pieces on the chessboard
     */
    public ArrayList<Piece> getPieces() {
        return this.pieces;
    }

    public Tile[][] getChessboard() {
        return this.chessboard;
    }

    //setters
    public void setChessboard(Tile[][] chessboard) {
        this.chessboard = chessboard;
    }

    /**
     * Set the white or black king
     * @param king the king to be set as the white or black king
     * @throws IllegalArgumentException Thrown if you try and set a white/black king when a king was already set
     */
    public void setKing(King king) throws IllegalArgumentException {
        if (king.getColour() == Colour.WHITE && whiteKing == null) {
            this.whiteKing = king;
        } else if (blackKing == null) {
            this.blackKing = king;
        } else {
            String errorMessage = String.format("Error: cannot set %s as king already set", king.toString());
        }
    }

    //game methods

    /**
     * The main method that the application will be interacting with, takes in instructions to move pieces on chessboard.
     * Instructions formatted as follows: "Colour" "Piece_type"" "Piece_ID" "Coordinate_To_Move_To" No Spaces in between
     * Colour always one char (W or B).
     * Piece type always oen char (conversions to piece type shown clearly in helper method below this method).
     * ID is the only variable length, always a string of integers.
     * Coordinate to move to is always the last 2 characters of the string.
     * @param instruction The String detailing the instructions to move a piece on the board
     * @return The chessboard returned after the state change
     * @throws IllegalArgumentException If the instruction is invalid and would cause an illegal state for the board.
     */
    public Tile[][] inputInstruction(String instruction) throws IllegalArgumentException {
        //split instruction into relevant pieces
        Colour movingPieceColour = instruction.charAt(0) == 'W' ? Colour.WHITE : Colour.BLACK;
        PieceType movingPieceType = charToPieceType(instruction.charAt(1));
        int movingPieceID = Integer.parseInt(instruction.substring(2, instruction.length() - 2));
        String coordinateToMoveTo = instruction.substring(instruction.length() - 2);

        //check the piece exists
        Piece movingPiece = null;
        for (Piece piece : this.pieces) {
            if (piece.getColour().equals(movingPieceColour) && piece.getPieceID() == movingPieceID) {
                movingPiece = piece;
                break;
            }
        }
        if (movingPiece == null) {
            throw new IllegalArgumentException("Error: That Piece does not exist on the chessboard");
        }

        //check the piece is alive
        if (!movingPiece.getAliveStatus()) {
            throw new IllegalArgumentException("Error: That piece has been taken and is no longer on the chessboard");
        }

        //check if piece can actually move to that tile
        Tile tileToMoveTo = null;
        for (Tile tile : movingPiece.getAllPossibleMoves()) {
            if (tile.toString().equals(coordinateToMoveTo)) {
                tileToMoveTo = tile;
            }
        }
        if (tileToMoveTo == null) {
            throw new IllegalArgumentException("Error: That's not a valid square on the board for that piece to move to");
        }

        //actually move the piece
        Optional<Piece> takenPiece = tileToMoveTo.updatePiece(movingPiece);
        if (takenPiece.isPresent()) {
            takenPiece.get().removeFromBoard();
        }

        //update every pieces possible moves
        for (Piece piece : this.pieces) {
            piece.updatePossibleMoves();
        }
        //return the chessboard (to print to console and continue the game)
        return this.chessboard;
    }

    /* HELPER: turns a character into a piece type request*/
    private PieceType charToPieceType(char pieceTypeID) {
        return switch (Character.toUpperCase(pieceTypeID)) {
            case 'K' ->  PieceType.KING;
            case 'Q' -> PieceType.QUEEN;
            case 'B' -> PieceType.BISHOP;
            case 'N' -> PieceType.KNIGHT;
            case 'R' -> PieceType.ROOK;
            case 'P' -> PieceType.PAWN;
            default -> throw new IllegalArgumentException("Error, invalid piece type");
        };
    }


    /**
     * Called by the king to signal to the chessboard it's been checkmated, this method should end the game
     * @param checkmatedKing The king that has been checkmated
     */
    public void checkmate(King checkmatedKing) {
        application.endGameInCheckmate(checkmatedKing);
    }
}
