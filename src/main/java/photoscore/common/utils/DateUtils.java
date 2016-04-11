package photoscore.common.utils;

/**
 * Created by lanegg on 16/4/10.
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * 日期工具类
 *
 * Created by yisa on 14-10-16.
 */
public class DateUtils {

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentDateTime() {
        return getCurrentDate("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取当前时间
     *
     * @param format
     *            日期格式
     * @return
     */
    public static String getCurrentDate(String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        Date date = new Date();

        return df.format(date);
    }

    /**
     * 格式化日期
     * timeInMillis to format time
     * @param time
     * @param format
     * @return
     */
    public static String formatDate(Long time, String format) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        Date date = calendar.getTime();

        SimpleDateFormat df = new SimpleDateFormat(format);
        String result = df.format(date);
        return result;
    }


}
