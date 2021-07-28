package com.puzzle.sudoku.util;

import com.puzzle.sudoku.model.SudokuBoard;

import java.util.List;

public class BoardUtils {
    public static boolean isBlankCell(SudokuBoard board, int i, int j){
        if(board.getBoard().get(i).get(j)==(-1))
            return true;
        else
            return false;
    }
    public static boolean isBlankCell(List<Integer> row, int i){
        if(row.get(i)==(-1))
            return true;
        else
            return false;
    }
    public static boolean isBlankCell(List<List<Integer>> board, int i, int j){
        if(board.get(i).get(j)==(-1))
            return true;
        else
            return false;
    }
}
