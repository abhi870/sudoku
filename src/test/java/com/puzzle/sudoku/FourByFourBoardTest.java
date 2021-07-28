package com.puzzle.sudoku;

import com.puzzle.sudoku.model.BoardColumnsValidator;
import com.puzzle.sudoku.model.BoardRowsValidator;
import com.puzzle.sudoku.model.BoardSubSquareBoxValidator;
import com.puzzle.sudoku.model.SudokuBoard;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourByFourBoardTest {

    @Test
    public void testInvalidState(){
        //construct board
        List<List<Integer>> currentboard = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(2);row1.add(2);row1.add(3);row1.add(4);
        List<Integer> row2 = new ArrayList<>();
        row2.add(2);row2.add(3);row2.add(4);row2.add(1);
        List<Integer> row3 = new ArrayList<>();
        row3.add(3);row3.add(4);row3.add(1);row3.add(2);
        List<Integer> row4 = new ArrayList<>();
        row4.add(4);row4.add(1);row4.add(2);row4.add(3);
        currentboard.add(row1);
        currentboard.add(row2);
        currentboard.add(row3);
        currentboard.add(row4);

        //construct SudokuBoard Object
        SudokuBoard board = new SudokuBoard(currentboard, new ArrayList<>());
        board.getValidators().add(new BoardRowsValidator());
        board.getValidators().add(new BoardColumnsValidator());
        board.getValidators().add(new BoardSubSquareBoxValidator());
        assertEquals(board.validateBoardState(),false);
    }

    @Test
    public void testValidState(){
        List<List<Integer>> currentboard = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);row1.add(2);row1.add(3);row1.add(-1);
        List<Integer> row2 = new ArrayList<>();
        row2.add(-1);row2.add(3);row2.add(4);row2.add(1);
        List<Integer> row3 = new ArrayList<>();
        row3.add(3);row3.add(-1);row3.add(1);row3.add(2);
        List<Integer> row4 = new ArrayList<>();
        row4.add(4);row4.add(1);row4.add(-1);row4.add(3);
        currentboard.add(row1);
        currentboard.add(row2);
        currentboard.add(row3);
        currentboard.add(row4);

        //construct SudokuBoard Object
        SudokuBoard board = new SudokuBoard(currentboard, new ArrayList<>());
        board.getValidators().add(new BoardRowsValidator());
        board.getValidators().add(new BoardColumnsValidator());
        board.getValidators().add(new BoardSubSquareBoxValidator());
        assertEquals(board.validateBoardState(),true);
    }
}
