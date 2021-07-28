package com.puzzle.sudoku;

import com.puzzle.sudoku.model.BoardColumnsValidator;
import com.puzzle.sudoku.model.BoardRowsValidator;
import com.puzzle.sudoku.model.BoardSubSquareBoxValidator;
import com.puzzle.sudoku.model.SudokuBoard;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SudokuApplication {

	public static void main(String[] args) {
		SpringApplication.run(SudokuApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				List<List<Integer>> currentboard = new ArrayList<>();
				List<Integer> row1 = new ArrayList<>();
				row1.add(2);row1.add(2);row1.add(3);row1.add(4);
				List<Integer> row2 = new ArrayList<>();
				row2.add(2);row2.add(3);row2.add(4);row2.add(1);
				List<Integer> row3 = new ArrayList<>();
				row3.add(3);row3.add(4);row3.add(1);row3.add(2);
				List<Integer> row4 = new ArrayList<>();
				row4.add(4);row4.add(1);row4.add(2);row4.add(3);
//				List<Integer> row1 = new ArrayList<>();
//				List<Integer> row2 = new ArrayList<>();
//				row1.add(1); row1.add(2);
//				row2.add(2);row2.add(1);
				currentboard.add(row1);
				currentboard.add(row2);
				currentboard.add(row3);
				currentboard.add(row4);
				SudokuBoard board = new SudokuBoard(currentboard, new ArrayList<>());
				board.getValidators().add(new BoardRowsValidator());
				board.getValidators().add(new BoardColumnsValidator());
				board.getValidators().add(new BoardSubSquareBoxValidator());
				System.out.println(board.validateBoardState());
			}
		};
	}
}
