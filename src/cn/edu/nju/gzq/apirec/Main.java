package cn.edu.nju.gzq.apirec;

import com.github.gumtreediff.client.Run;

import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {

        String src = "res/Main1.java";
        String dst = "res/Main2.java";
        String out = "res/out.txt";
        getDiff(src, dst, out);
    }


    /**
     * Get the fine-grained changes (Transaction) information of specific source file.
     * 获取指定文件的细粒度变更信息
     *
     * @param prev source file of previous revision 上版本的代码文件
     * @param next source file of next revision     下版本的代码文件
     * @param out output file of Transactions 变更事务的输出文件
     */
    public static void getDiff(String prev, String next, String out) {
        Run.initGenerators();
        String tempFile = "res/tmp.txt";
        String[] args = new String[]{"diff", "-o", tempFile, prev, next};
        Run.main(args);
        // 去除Match的部分, 保留变更的部分, 并且调整变更格式为 Oper. \t AST Node Type \t Label
        List<String> lines = FileHandle.readFileToLines(tempFile);
        StringBuilder text = new StringBuilder();
        for (String line : lines) {
            if (line.startsWith("Match")) continue;
            String[] temp = line.split("\\(");
            String[] part = temp[0].split(" |\\: ");

            text.append(part[0]).append("\t").append(part[1]).append("\t");
            if (part.length == 2) text.append(part[1]).append("\n");
            else text.append(part[2]).append("\n");
        }
        FileHandle.writeStringToFile(out, text.toString());
    }
}
