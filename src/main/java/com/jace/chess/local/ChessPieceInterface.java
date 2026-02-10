package com.jace.chess.local;

public interface ChessPieceInterface {
    void move(); //move the piece
    void checkEnemyKing(); //put the enemy king in check (notifying game session)
}
