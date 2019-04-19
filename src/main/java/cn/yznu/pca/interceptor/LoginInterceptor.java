package cn.yznu.pca.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author yangbaiwan
 * @date 2019-04-15
 */
public class LoginInterceptor implements HandlerInterceptor {
    private List<String > excludeUrls;

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
        String serverletPath = request.getServletPath();
        if (excludeUrls.contains(serverletPath)) {
            return true;
        }else {
            HttpSession session = request.getSession();
            Object sessionInfo = session.getAttribute("user");
            if (sessionInfo!=null) {
                return true;
            }else {
                request.getRequestDispatcher("/views/login.jsp").forward(request, arg1);
            }
        }
        return false;

    }

    public List<String> getExcludeUrls() {
        return excludeUrls;
    }
    public void setExcludeUrls(List<String> excludeUrls) {
        this.excludeUrls = excludeUrls;
    }
}
