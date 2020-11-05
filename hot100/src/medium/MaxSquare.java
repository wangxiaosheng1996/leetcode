package medium;

import javax.imageio.ImageReader;

/**
 * @author wxs
 * @create 2020/8/6   13:17
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 */
public class MaxSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0){
            return 0;
        }
        //遍历二维矩阵，遇到'1'的话，将这个'1'作为正方形的左上角元素，并检查以此为左上角的正方形能否扩展到2x2、3x3...
        int nr = matrix.length;
        int nc = matrix[0].length;
        int maxlength = 0;  //动态存储最大正方形的边长
        for(int i=0;i<nr;i++){
            for(int j=0;j<nc;j++){
                if(matrix[i][j]=='1'){
                    if(1>maxlength){
                        maxlength = 1;
                    }

                    outer:for(int k=2;k<=Math.min(nr,nc);k++){
                        if(i+k-1>=nr || j+k-1>=nc){
                            break outer;
                        }
                        for(int p=0;p<k;p++){
                            if(matrix[i+p][j+k-1]=='0' || matrix[i+k-1][j+p]=='0'){
                                break outer;
                            }
                        }


//                        for(int m=i;m<i+k;m++){
//                            for(int n=j;n<j+k;n++){
//                                if(matrix[m][n]=='0'){
//                                    break outer;
//                                }
//                            }
//                        }
                        if(k>maxlength){
                            maxlength=k;
                        }

                    }


                }
            }
        }
        return maxlength*maxlength;

    }


    //动态规划
    //dp(i,j)表示以(i,j)为右下角的全为'1'的正方形的最大边长
    //更新公式：dp(i,j)=min(dp(i-1,j-1),dp(i-1,j),dp(i,j-1))+1
    //时间复杂度:O(mn):遍历了数组
    //空间复杂度:O(mn):使用了一个数组来存储动态规划值
    public int maximalSquare2(char[][] matrix){
        if(matrix == null || matrix.length==0){
            return 0;
        }
        int nr = matrix.length;
        int nc = matrix[0].length;
        int maxSide=0;
        int[][] dp = new int[nr][nc];
        for(int i=0;i<nr;i++){
            for(int j=0;j<nc;j++){
                if(matrix[i][j]=='1'){
                    if(i==0 || j==0){
                        dp[i][j]=1;
                    }else{
                        dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                    }
                    maxSide=Math.max(maxSide,dp[i][j]);

                }
            }
        }
        return maxSide*maxSide;



    }
}











