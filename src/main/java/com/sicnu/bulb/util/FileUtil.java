package com.sicnu.bulb.util;


import javax.validation.constraints.NotNull;
import java.io.*;
import java.text.ParseException;
import java.util.Objects;

/**
 * Created by HY
 * 2019/5/14 10:58
 * <p>
 * 日志文件读取工具包
 * <p>
 * 更多查看博客 {@code https://www.jianshu.com/p/3d04346bfc80}
 */
public class FileUtil {

    /**
     * 读取数据，存入集合中
     */
    public static BufferedReader getBufferReader(@NotNull File file) {

        InputStreamReader read = null;// 考虑到编码格式
        try {
//            read = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            read = new InputStreamReader(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return new BufferedReader(read);
    }

    /**
     * 按行读取文件内容并返回
     *
     * @param file file
     * @return 文件内容
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public static String readFile(File file) throws IOException, ParseException {
        BufferedReader bufferedReader = new BufferedReader(Objects.requireNonNull(getBufferReader(file)));
        String lineTxt;
        StringBuilder builder = new StringBuilder();

        while ((lineTxt = bufferedReader.readLine()) != null) {
            builder.append(lineTxt).append("\n");
        }
        bufferedReader.close();
        return builder.toString();
    }

    //写文件
    public static void writeInFile(File file, String content) {
        Writer writer = null;
        StringBuilder outputString = new StringBuilder();
        try {
            outputString.append(content).append("\r\n");
            writer = new FileWriter(file, true); // true表示追加
            writer.write(outputString.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
