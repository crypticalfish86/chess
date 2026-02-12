package com.jace.chess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jace.chess.localchess.GameSession;

@SpringBootApplication
public class ChessApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChessApplication.class, args);

		//delete once local simulation set up and tested
		GameSession localChess = new GameSession();
		localChess.start();
	}

}
