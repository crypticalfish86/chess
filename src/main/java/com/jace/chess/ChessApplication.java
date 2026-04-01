package com.jace.chess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jace.chess.localChess.LocalChessApplication;

@SpringBootApplication
public class ChessApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChessApplication.class, args);

		//local test (delete when prototype is finished)
		LocalChessApplication application = new LocalChessApplication();
		application.startGame();
	}

}
