package jianzhioffer;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/8 20:57
 * @Description: 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一
 * 个整数，判断数组中是否含有该整数。
 */
public class Find {
    public boolean find(int target, int[][] array) {
        int x = array[0].length;
        int y = 0;//array.length;
        while (x >= 1 && y <= array.length - 1) {
            if (array[y][x - 1] > target) {
                x--;
                continue;
            } else if (array[y][x - 1] < target) {
                y++;
                continue;
            } else {
                return true;
            }
        }
        return false;
    }
}
