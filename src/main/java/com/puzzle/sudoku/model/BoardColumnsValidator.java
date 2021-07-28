package com.puzzle.sudoku.model;

import com.puzzle.sudoku.util.BoardUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
public class BoardColumnsValidator implements BoardValidator{

    @Override
    public boolean validate(SudokuBoard board) {
        Integer noOfColumns = board.getBoard().get(0).size();
        Integer noOfRows = board.getBoard().size();
        for(int i=0;i<noOfColumns;i++){
            Set<Integer> set = new HashSet<>();
            for(int j = 0;j<noOfRows;j++){
                if(!BoardUtils.isBlankCell(board,j, i)) {
                    if (set.contains(board.getBoard().get(j).get(i))) {
                        log.info("Failed for" + this.getClass().getName() + " with coordinates " + i + " " + j);
                        return false;
                    } else
                        set.add(board.getBoard().get(j).get(i));
                }
            }
        }
        return true;
    }

}
