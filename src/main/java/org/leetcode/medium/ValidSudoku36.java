package org.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku36 {
  public static void main(String[] args) {
    ValidSudoku36 v = new ValidSudoku36();
    char[][] sudokuBoard = {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };
    System.out.println(v.isValidSudoku(sudokuBoard));
  }

  public boolean isValidSudoku(char[][] board) {
    if (!checkVertically(board)) return false;
    if (!checkHorizontal(board)) return false;
    return checkBlock(board);
  }

  private boolean checkBlock(char[][] board) {
    Map<String, Set<Character>> cMap = new HashMap<>();
    Map<String, Integer> iMap = new HashMap<>();


    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        String key = getKey(i, j);
        Set<Character> set = cMap.get(key);
        if (set == null) {
          set = new HashSet<>();
          if (board[i][j] != '.') {
            set.add(board[i][j]);
            int counter = 1;
            iMap.put(key, counter);
            cMap.put(key, set);
          }
        } else {
          if (board[i][j] != '.') {
            set.add(board[i][j]);
            int counter = iMap.get(key);
            counter = counter + 1;
            iMap.put(key, counter);
            cMap.put(key, set);
          }
        }
      }
    }

    for (String key : cMap.keySet()) {
      Set<Character> chars = cMap.get(key);
      int counter = iMap.get(key);
      if (chars.size() != counter) {
        return false;
      }
    }
    return true;
  }

  public String getKey(int i, int j) {
    return String.valueOf(i / 3) + (j / 3);
  }

  public boolean checkVertically(char[][] board) {
    int counter = 0;
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (char[] chars : board) {
        if (chars[i] != '.') {
          set.add(chars[i]);
          counter++;
        }
      }
      if (set.size() != counter) {
        return false;
      } else {
        set = new HashSet<>();
        counter = 0;
      }

    }
    return true;
  }

  private boolean checkHorizontal(char[][] board) {
    int counter = 0;
    Set<Character> set = new HashSet<>();
    for (char[] chars : board) {
      for (int j = 0; j < board.length; j++) {
        if (chars[j] != '.') {
          set.add(chars[j]);
          counter++;
        }
      }
      if (set.size() != counter) {
        return false;
      } else {
        set = new HashSet<>();
        counter = 0;
      }
    }
    return true;
  }
}
