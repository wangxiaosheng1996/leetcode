package medium;

/**
 * @author wxs
 * @create 2020/8/6   10:31
 * 使用并查集来解决
 * 把相邻的1合并到一个集合中
 * 最终计算总共有多少个集合，这个就是岛屿的数量
 */

public class IslandNums2 {
    //定义一个内部类，用于描述并查集
    class UnionFind{
        int[] parent;   //存储结点的根节点
        int[] rank;     //存储结点的秩(树的深度)
        int count;      //集合的数量
        //构造器
        public UnionFind(char[][] grid){
            int nr = grid.length;       //行数
            int nc = grid[0].length;    //列数
            parent = new int[nr*nc];
            rank = new int[nr*nc];
            count = 0;

            //刚开始把每个1看成单独一个集合
            for(int i=0;i<nr;i++){
                for(int j=0;j<nc;j++){
                    if(grid[i][j]=='1'){
                        count++;
                        parent[i*nc+j]=i*nc+j;
                    }
                    rank[i*nc+j]=0;
                }
            }
        }

        //查找方法:用于查找指定结点的根节点
        public int find(int x){
            if(x==parent[x]){
                return x;
            }else{
                //查找的过程进行路径压缩
                return parent[x] = find(parent[x]);
            }
        }

        //合并方法：合并两个结点：实质就是合并两个结点对影的两个根节点
        //合并原则：秩小的根节点指向秩大的根节点
        public void union(int x,int y){
            int rootx = find(x);    //x的根节点
            int rooty = find(y);    //y的根节点
            if(rootx==rooty){
                return; //两个结点的根节点相同，说明在同一个集合(树)中,不用合并
            }else{
                if(rank[rootx]>rank[rooty]){
                    parent[rooty] = rootx;
                }else if(rank[rootx]<rank[rooty]){
                    parent[rootx] = rooty;
                }else{  //两个根节点的秩相同，谁指向谁都可以
                    parent[rootx] = rooty;
                    rank[rooty]++;

                }
                //合并后，集合数减一
                count--;
            }
        }

        public int getCount(){
            return count;
        }


    }



    public int numIslands(char[][] grid){
        if(grid==null || grid.length==0){
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        //遍历表格，将相邻的1合并到同一集合
        for(int i=0;i<nr;i++){
            for(int j=0;j<nc;j++){
                if(grid[i][j]=='1'){
                    //因为是从左到右，从上到下的遍历，所以添加右、下为1的结点即可
                    if(j+1<nc && grid[i][j+1]=='1'){
                        uf.union(i*nc+j,i*nc+j+1);
                    }
                    if(i+1<nr && grid[i+1][j]=='1'){
                        uf.union(i*nc+j,(i+1)*nc+j);
                    }
                }
            }
        }
        return uf.getCount();


    }





}









