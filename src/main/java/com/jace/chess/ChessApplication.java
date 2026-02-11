package com.jace.chess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.jace.chess.local.*;

@SpringBootApplication
public class ChessApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChessApplication.class, args);
		LocalChess localChess = new LocalChess(); //delete once you've run the full test simulation for local chess
	}

}
