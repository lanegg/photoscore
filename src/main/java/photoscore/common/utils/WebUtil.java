package photoscore.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lanegg on 16-4-12.
 */
public class WebUtil {

    /**
     * 获取当前request
     * @return
     */
    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /**
     * 获取当前session
     * @return
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 从session中取值
     * @param key
     * @return
     */
    public static Object getSessionAttribute(String key) {
        return getSession().getAttribute(key);
    }

    /**
     * 向session中设置值
     * @param key
     * @param o
     * @return
     */
    public static boolean setSessionAttribute(String key, Object o) {

        try {
            getSession().setAttribute(key, o);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }


}
