package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wxs
 * @create 2020/8/5   20:24
 */
public class IslandNums {
    //深度优先遍历dfs
    /*
    nums:保存已经找到的岛屿数
    遍历表格，每遇到1就将nums+1,然后将从该1出发能到达的1全部置0
     */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length==0){
            return 0;
        }
        int r = grid.length;    //行数
        int c = grid[0].length; //列数
        int nums = 0;       //保存已经找到的岛屿数
        //遍历表格
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1'){
                    nums++;
                    //dfs(grid,i,j);
                    bfs(grid,i,j);

                }
            }
        }
        return nums;

    }

    public void dfs(char[][] grid,int r,int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';

        //
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }
    //广度优先搜索：用队列
    public void bfs(char[][] grid,int r,int c){
        grid[r][c] = '0';
        int nr = grid.length; //行数
        int nc = grid[0].length; //列数

        Queue<Integer> neighbors = new LinkedList<>();   //队列
        neighbors.add(r*nc+c);
        while(!neighbors.isEmpty()){
            int id = neighbors.remove();
            //得到从队列取出的点的行数和列数
            int row = id/nc;
            int column = id%nc;

            //上
            if(row-1>=0 && grid[row-1][column]=='1'){
                neighbors.add((row-1)*nc+column);
                grid[row-1][column] = '0';
            }
            //下
            if(row+1<nr && grid[row+1][column]=='1'){
                neighbors.add((row+1)*nc+column);
                grid[row+1][column] = '0';
            }
            //左
            if(column-1>=0 && grid[row][column-1]=='1'){
                neighbors.add(row*nc+column-1);
                grid[row][column-1] = '0';
            }
            //右
            if(column+1<nc && grid[row][column+1]=='1'){
                neighbors.add(row*nc+column+1);
                grid[row][column+1] = '0';
            }

        }
    }


}
