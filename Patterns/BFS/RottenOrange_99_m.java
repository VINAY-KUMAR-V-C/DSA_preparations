import java.util.ArrayList;
import java.util.List;

class RottenOrange_99_m {
    Integer finalOutput = -1;
    public int orangesRotting(int[][] grid) {
        List<List<Integer>> freshAppLeft = new ArrayList<>();
        List<List<Integer>> rottenAppLeft = new ArrayList<>();
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    freshAppLeft.add(list);
                }else if(grid[i][j]==2){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    rottenAppLeft.add(list);
                }

            }
        }
        if(freshAppLeft.size()==0){
            return 0;
        }
        if(rottenAppLeft.size()==0){
            return -1;
        }
        traverse(row,col,rottenAppLeft,grid);
        for(int i=0;i<freshAppLeft.size();i++){
            if(grid[freshAppLeft.get(i).get(0)][freshAppLeft.get(i).get(1)]==1){
                return -1;
            }
        }
        return finalOutput;
    }
    public void traverse(int row,int col,List<List<Integer>> rottenAppLeft,int[][] grid){
        if(rottenAppLeft.size()==0){
            return;
        }
        List<List<Integer>> nextBatch = new ArrayList<>();
        for(int i=0;i<rottenAppLeft.size();i++){
            getAdjacentFreshApplesIndex(row, col, rottenAppLeft.get(i).get(0), rottenAppLeft.get(i).get(1), grid, nextBatch);
        }
        traverse(row, col, nextBatch, grid);
        finalOutput++;
    }
    public void getAdjacentFreshApplesIndex(int row,int col,int curRow,int curCol,int[][] grid,List<List<Integer>> nextBatch){
        //left
        ArrayList<Integer> list = new ArrayList<>();
        if(curCol>0 && grid[curRow][curCol-1]==1){
            list.add(curRow);
            list.add(curCol-1);
            nextBatch.add(list);
            grid[curRow][curCol-1]=2;
        }
        //right
        if(curCol<col-1 && grid[curRow][curCol+1]==1){
            list = new ArrayList<>();
            list.add(curRow);
            list.add(curCol+1);
            nextBatch.add(list);
            grid[curRow][curCol+1]=2;
        }
        //up
        if(curRow>0 && grid[curRow-1][curCol]==1){
            list = new ArrayList<>();
            list.add(curRow-1);
            list.add(curCol);
            nextBatch.add(list);
            grid[curRow-1][curCol]=2;
        }
        //down
        if(curRow<row-1 && grid[curRow+1][curCol]==1){
            list = new ArrayList<>();
            list.add(curRow+1);
            list.add(curCol);
            nextBatch.add(list);
            grid[curRow+1][curCol]=2;
        }
    }
    public static void main(String[] args) {
        //System.out.println(new RottenOrange_99_m().orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));  // ans =4
        //System.out.println(new RottenOrange_99_m().orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}}));    // ans =4
        //System.out.println(new RottenOrange_99_m().orangesRotting(new int[][]{{0,2}}));    // ans =4
        System.out.println(new RottenOrange_99_m().orangesRotting(new int[][]{{0}}));    // ans =0
    }
}