package medium;

/**
 * @author wxs
 * @create 2020/8/3   21:38
 */

//给定一个 n × n 的二维矩阵表示一个图像,将图像顺时针旋转 90 度。
public class RotateGraph {
    //最直接的想法是先转置矩阵，然后翻转每一行
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //转置
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //翻转
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=temp;
            }
        }


    }
}
