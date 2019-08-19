package cn.edu.nju.gzq.apirec.model;

import java.util.List;

public class APIREC {

    /**
     * 获取变更上下文分数
     *
     * @return
     */
    public static double getChangeContextScore() {
        double value = .0;
        return value;
    }


    /**
     * 获取代码上下文分数
     *
     * @return
     */
    public static double getCodeContextScore(String c, List<String> tokens) {
        double value = .0;
        for (String token : tokens) value += Math.log(getScore(c, token));
        return value;
    }

    /**
     * 计算某个方法名与token的分数
     * the likelihood score that the code token ti in the surrounding context indicates the occurrence the change c
     *
     * @param c
     * @param token
     * @return
     */
    public static double getScore(String c, String token) {
        double value = .0;
        return value;
    }
}
