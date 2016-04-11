package photoscore.common.utils;

import java.util.Random;

/**
 * Created by lanegg on 16/4/10.
 */
public class StringUtils {

    /**
     * 检查所有字符串是否存在空
     *
     * false  有空值
     * true   不存在null
     *
     * @param args
     * @return
     */
    public static boolean isNotNull(String...args) {

        for(String s : args) {
            if (null != s && !"".equals(s)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * 生成随机字符串
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

}
