import java.util.Arrays;

public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new int[0];
        }
        int len = matrix.length * matrix[0].length;
        int[] res = new int[len];
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1, index = 0;
        while(index < len){
            for (int i = left; index < len && i <= right; i++) {
                res[index++] = matrix[up][i];
            }
            up++;
            for (int i = up; index < len && i <= down; i++) {
                res[index++] = matrix[i][right];
            }
            right--;
            for (int i = right; index < len && i >= left; i--) {
                res[index++] = matrix[down][i];
            }
            down--;
            for (int i = down; index < len && i >= up; i--) {
                res[index++] = matrix[i][left];
            }
            left++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        SpiralOrder spiralOrder = new SpiralOrder();
        System.out.println(Arrays.toString(spiralOrder.spiralOrder(matrix)));
    }
}