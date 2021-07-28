package com.puzzle.sudoku.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SudokuBoard {

    private List<List<Integer>> board;
    private List<BoardValidator> validators;

    public boolean validateBoardState(){
        for(BoardValidator validator: validators){
            if(!validator.validate(this))
                return false;
        }
        return true;
    }
}
