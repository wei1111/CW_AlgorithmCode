package number;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/2 18:01
 * @Description: 对于每个点a，构建 斜率->点数 的map。
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class MaxPoints {

    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public int maxPoints(Point[] points) {
        int len = points.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            int x1 = points[i].x;
            int y1 = points[i].y;
            // 分别统计与点i重合以及垂直的点的个数
            int dup = 1, vtl = 0;
            Map<Double, Integer> map = new HashMap(16);

            for (int j = i + 1; j < len; j++) {
                int x2 = points[j].x;
                int y2 = points[j].y;
                if (x2 - x1 == 0) {
                    if (y2 - y1 == 0) {
                        dup++;
                    } else {
                        vtl++;
                    }
                } else {
                    Double k = (double) (y2 - y1) / (x2 - x1);
                    //分+0.0 和 -0.0
                    if (k == 0) {
                        k = 0.0;
                    }
                    if (map.get(k) == null) {
                        map.put(k, 1);
                    } else {
                        map.put(k, map.get(k) + 1);
                    }
                }
            }
            int max = Integer.MIN_VALUE;
            for (int v : map.values()) {
                max = Math.max(max, v);
            }
            max = Math.max(vtl, max);
            result = Math.max(max + dup, result);
        }
        return result;
    }

    @Test
    public void test() {
        //[(0,0),(1,1),(1,-1)]
        Point[] ps = new Point[3];
        ps[0] = new Point(2, 3);
        ps[1] = new Point(3, 3);
        ps[2] = new Point(-5, 3);

        System.out.println(maxPoints(ps));
    }
}
