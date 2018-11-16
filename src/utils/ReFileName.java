package utils;

import org.junit.Test;

import java.io.File;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/14 1:17
 * @Description:
 */
public class ReFileName {

    public static void rename(String path, String containStr, String newStr) {
        // 要批量修改的文件所在的目录
        File file = new File(path);
        boolean isDirectory = file.isDirectory();
        if (!isDirectory) {
            // 如果不是文件夹，就返回
            System.out.println(path + "不是文件夹！");
            return;
        }
        String[] files = file.list();
        File f;

        String newFileName;
        // 旧的文件名字
        String oldFileName;
        // 遍历该文件夹下的所有文件
        for (int i = 0; i < files.length; i++) {
            oldFileName = files[i];
            // 如果不是以特定形式开头的文件，跳过它
            if (!oldFileName.contains(containStr)) {
                continue;
            }

            /**
             * 重新生成修改后的文件名称
             * 我这里统一将"[迅雷下载www.2tu.cc]爱情公寓EP02.03.rmvb"
             * 修改为"爱情公寓第二季-03.rmvb"
             */
            newFileName =
                    oldFileName.replace(containStr, newStr);
            System.out.println(oldFileName + " : " + newFileName);

            // 将修改后的文件保存在原目录下
            f = new File(path + "/" + oldFileName);
            f.renameTo(new File(path + "/" + newFileName));
        }
    }

    @Test
    public void test() {
        String path = "D:\\Java课程\\030 Java读源码之Netty深入剖析";
        String containStr = "【www.zxit8.com】 ";
        String newStr = "";
        rename(path, containStr, newStr);
    }
}
