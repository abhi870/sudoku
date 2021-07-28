package com.puzzle.sudoku.model;

import com.puzzle.sudoku.util.BoardUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Slf4j
public class BoardSubSquareBoxValidator implements BoardValidator{

    @Override
    public boolean validate(SudokuBoard board) {
        int noOfRows = board.getBoard().size();
        int noOfColumns = board.getBoard().get(0).size();
        int mid = (noOfColumns/2);
        if(validateSubSquare(board.getBoard(), 0,0,mid, mid)
        && validateSubSquare(board.getBoard(), 0, mid, mid, noOfColumns)
        && validateSubSquare(board.getBoard(), mid, 0, noOfRows, mid)
        && validateSubSquare(board.getBoard(), mid, mid, noOfRows, noOfColumns))
            return true;
        else
            return false;
    }

    private boolean validateSubSquare(List<List<Integer>> board, int startI, int startJ, int endI, int endJ){
        Set<Integer> set = new HashSet<>();
        for(int i=startI;i<endI;i++){
            for(int j=startJ;j<endJ;j++){
                if(!BoardUtils.isBlankCell(board, i, j)) {
                    if (set.contains(board.get(i).get(j))) {
                        log.info("Failed for +" + this.getClass().getName() + " with coordinates " + i + " " + j);
                        return false;
                    } else
                        set.add(board.get(i).get(j));
                }

            }
        }
        return true;
    }
}
