//螺旋矩阵
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res =new int[n][n];
        //定义循环次数
        int loop = n / 2;
        //定义每次循环的起始位置
        int startX = 0;
        int startY = 0;
        //定义循环偏移量
        int offset = 1;
        //定义填充数字
        int count = 1;
        //定义中间位置
        int mid = n / 2;

        //保持每次在一个方向上遍历是区间都是左闭右开的
        while (loop >= 0) {
            //遍历的index
            int i = startX;
            int j = startY;
            //从左向右遍历（上左）
            for (; j < startY + n - offset; j++) {
                res[i][j] = count++;
            }

            //从上向下遍历（上右）
            for (; i < startX + n - offset; i++) {
                res[i][j] = count++;
            }

            //从右向左遍历（下右）
            for (; j > startY; j--) {
                res[i][j] = count++;
            }

            //从下向上遍历（下左）
            for (; i > startX; i--) {
                res[i][j] = count++;
            }

            startX += 1;
            startY += 1;
            offset += 2;
            loop--;
        }

        if (n % 2 == 1) {
            res[mid][mid] = count;
        }
        return res;
    }

}