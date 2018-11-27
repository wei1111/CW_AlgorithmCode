package gready_heap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/26 15:06
 * @Description: 这个题目的贪心的原则是按照最早结束来贪心的
 * 一些项目要占用一个会议室宣讲， 会议室不能同时容纳两个项目
 * 的宣讲。 给你每一个项目开始的时间和结束的时间(给你一个数
 * 组， 里面 是一个个具体的项目)， 你来安排宣讲的日程， 要求会
 * 议室进行 的宣讲的场次最多。 返回这个最多的宣讲场次。
 */
public class BestArrange {
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program> {
        //按照结束时间来排序
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(Program[] programs, int start) {
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if (programs[i].start <= start) {
                result++;
                start = programs[i].end;
            }
        }

        return result;
    }
}