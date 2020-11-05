package medium;

/**
 * @author wxs
 * @create 2020/8/8   10:31
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 */
public class PerfectSquare {
    /**
     *
     * @param n 给定正整数
     * @return
     * 用动态规划解决：
     * 更新公式:dp[i] = min(dp[i],dp[i-j*j]+1)
     * int[] dp = new int[n+1]
     * dp[i]表示整数i可以由完全平方数组成和的最小个数
     */
    public int numSquares(int n) {
        //存储动态规划值
        int[] dp = new int[n+1];
        for(int i=0;i<n+1;i++){
            //初始化dp[i]=i,表示可以i可以由i个1组成和
            //dp[0]=0
            dp[i] = i;
        }
        for(int i=0;i<n+1;i++){
            int min = dp[i];
            for(int j=1;j*j<=i;j++){
                if((dp[i-j*j]+1)<min){
                    min = dp[i-j*j]+1;
                }
            }
            dp[i] = min;
        }
        return dp[n];



    }

    //优化：上面用了额外的整数num，可以直接在数组上动态更改
    public int numSquares2(int n) {
        //存储动态规划值
        int[] dp = new int[n+1];

        for(int i=0;i<n+1;i++){
            dp[i] = i;
            for(int j=1;j*j<=i;j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];



    }
}









