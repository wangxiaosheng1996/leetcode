package easy;

/**
 * @author wxs
 * @create 2020/9/14   19:20
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 */
public class ClimbStairs {
    public int climbStairs(int n){
        int p=0;
        int q = 0;
        int r = 1;
        for(int i=1;i<=n;i++){
            p = q;
            q = r;
            r = p+q;
        }
        return r;
    }





    public int climbStairs2(int n) {
        int x = n / 2;//最多有x个2
        int count = 0;
        for(int i=0;i<=x;i++){//有i个2
            if(i==0){
                count++;
            }else{
                //有j个1
                int j = n-2*i;
                if(j==0){
                    count++;
                }else{
                    //(i+j)取i
                    count += combination(i+j,i);
                }

            }
        }
        return count;
    }
    //C m 取 n , m>=n>0
    public int combination(int m,int n){
        if(n>m/2){
            return combination(m,m-n);
        }else{
            int num = 1;
            for(int i = m;i>m-n;i--){
                num *= i;
            }
            return  num/factorial(n);
        }
    }


    //阶乘 n>0
    public int factorial(int n){
        if(n==1){
            return 1;
        }else{
            return n*factorial(n-1);
        }

    }

    //不能连续跳两步
    public int climbStairs3(int n){
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }else{
            int a=0,b=1,c=1,d=2;
            for(int i=3;i<=n;i++){
                a=b;
                b=c;
                c=d;
                d=a+c;
            }
            return d;
        }

    }



}














