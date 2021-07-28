package com.puzzle.sudoku;

import com.puzzle.sudoku.model.BoardColumnsValidator;
import com.puzzle.sudoku.model.BoardRowsValidator;
import com.puzzle.sudoku.model.BoardSubSquareBoxValidator;
import com.puzzle.sudoku.model.SudokuBoard;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoByTwoBoardTest {

    @Test
    public void validStateTest(){
        List<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row2.add(2);
        row2.add(1);
        List<List<Integer>> currentBoard = new ArrayList<>();
        currentBoard.add(row1);
        currentBoard.add(row2);

        SudokuBoard board = new SudokuBoard(currentBoard, new ArrayList<>());
        board.getValidators().add(new BoardRowsValidator());
        board.getValidators().add(new BoardColumnsValidator());
        board.getValidators().add(new BoardSubSquareBoxValidator());
        assertEquals(board.validateBoardState(), true);
    }
    @Test
    public void inValidStateWithNonEmptyCellsTest(){
        List<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>();
        row1.add(2);
        row1.add(2);
        row2.add(2);
        row2.add(2);
        List<List<Integer>> currentBoard = new ArrayList<>();
        currentBoard.add(row1);
        currentBoard.add(row2);

        SudokuBoard board = new SudokuBoard(currentBoard, new ArrayList<>());
        board.getValidators().add(new BoardRowsValidator());
        board.getValidators().add(new BoardColumnsValidator());
        board.getValidators().add(new BoardSubSquareBoxValidator());
        assertEquals(board.validateBoardState(), false);
    }
    @Test
    public void inValidStateTest(){
        List<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>();
        row1.add(1);
        row1.add(1);
        row2.add(2);
        row2.add(1);
        List<List<Integer>> currentBoard = new ArrayList<>();
        currentBoard.add(row1);
        currentBoard.add(row2);

        SudokuBoard board = new SudokuBoard(currentBoard, new ArrayList<>());
        board.getValidators().add(new BoardRowsValidator());
        board.getValidators().add(new BoardColumnsValidator());
        board.getValidators().add(new BoardSubSquareBoxValidator());
        assertEquals(board.validateBoardState(), false);
    }

    @Test
    public void emptyCellsValidityTest(){
        List<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>();
        row1.add(-1);
        row1.add(-1);
        row2.add(-1);
        row2.add(-1);
        List<List<Integer>> currentBoard = new ArrayList<>();
        currentBoard.add(row1);
        currentBoard.add(row2);

        SudokuBoard board = new SudokuBoard(currentBoard, new ArrayList<>());
        board.getValidators().add(new BoardRowsValidator());
        board.getValidators().add(new BoardColumnsValidator());
        board.getValidators().add(new BoardSubSquareBoxValidator());
        assertEquals(board.validateBoardState(), true);
    }




}
