package Patterns.MatrixTraversal_Internally_BFSorDFS;

import java.util.ArrayList;
import java.util.List;

class NumberOfIsland_200_M {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] isVisited = new boolean[row][col];
        int count = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!isVisited[i][j] && grid[i][j]=='1'){
                    count++;
                    traverse(isVisited,row,col,i,j,grid);                    
                }
            }
        }
        return count;
    }
    public void traverse(boolean[][] isVisited,int row,int col,int curRow,int curCol,char[][] grid){
        if(isVisited[curRow][curCol]){
            return ;
        }else{
            isVisited[curRow][curCol] = true;
            List<List<Integer>> list = listOfAdj(row, col, curRow, curCol, grid); 
            for(int i=0;i<list.size();i++){
                traverse(isVisited, row, col, list.get(i).get(0), list.get(i).get(1), grid);
            }
        }
    }
    public List<List<Integer>> listOfAdj(int row, int col, int curr, int curc, char[][] grid) {
        List<List<Integer>> list = new ArrayList<>();
        int[][] directions = {
            {-1, 0}, // Up
            {0, 1},                    // Right
            {1, 0}, //down
            {0, -1}                    // Left
        };
    
        for (int[] dir : directions) {
            int newRow = curr + dir[0];
            int newCol = curc + dir[1];
            if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && grid[newRow][newCol] == '1') {
                List<Integer> cell = new ArrayList<>();
                cell.add(newRow);
                cell.add(newCol);
                list.add(cell);
            }
        }
        return list;
    }
    
    
    public static void main(String[] args) {
        new NumberOfIsland_200_M().numIslands(new char[][]{{'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}});
    }
}