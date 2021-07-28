package com.puzzle.sudoku.model;

import com.puzzle.sudoku.util.BoardUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Slf4j
public class BoardRowsValidator implements BoardValidator{
    @Override
    public boolean validate(SudokuBoard board) {
        List<List<Integer>> sudoku = board.getBoard();
        for(int i=0;i<sudoku.size();i++){
            Set<Integer> currentRowSet = new HashSet<>();
            List<Integer> currentRow = sudoku.get(i);
            for(int j=0;j<currentRow.size();j++){
                if(!BoardUtils.isBlankCell(currentRow, j)) {
                    if (currentRowSet.contains(currentRow.get(j))) {
                        log.info("Failed for" + this.getClass().getName() + " with coordinates " + i + " " + j);
                        return false;
                    } else
                        currentRowSet.add(currentRow.get(j));
                }
            }
        };
        return true;
    }
}
