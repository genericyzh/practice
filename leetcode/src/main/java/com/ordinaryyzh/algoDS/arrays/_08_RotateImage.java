package com.ordinaryyzh.algoDS.arrays;

/**
 * https://leetcode.com/problems/rotate-image/#/description
 * 参考：http://www.cnblogs.com/grandyang/p/4389572.html
 * 解法一：
 * 对于90度的翻转有很多方法，一步或多步都可以解，我们先来看一种直接的方法，对于当前位置，计算旋转后的新位置，
 * 然后再计算下一个新位置，第四个位置又变成当前位置了，所以这个方法每次循环换四个数字，如下所示：
 * 1  2  3                 7  2  1                  7  4  1
 * 4  5  6        -->      4  5  6        -->       8  5  2
 * 7  8  9                 9  8  3　　        　　　 9  6  3
 * 即从最外层开始循环，一直到最内层
 *
 * @author genericyzh
 * @date 2017/7/1 23:20
 */
public class _08_RotateImage {

    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) { // 这里注意：不能加'='号
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        _08_RotateImage rotateImage = new _08_RotateImage();
        int[][] a = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotateImage.rotate(a);
    }

}
