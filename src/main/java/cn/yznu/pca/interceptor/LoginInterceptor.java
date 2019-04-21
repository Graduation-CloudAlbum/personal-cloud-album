package cn.yznu.pca.interceptor;

import cn.yznu.pca.model.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author yangbaiwan
 * @date 2019-04-15
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        String url = request.getServletPath();
        if(!url.equals("")){
            //判断是否登录
            User loginUser = (User)request.getSession().getAttribute("user");
            if(loginUser == null){
                //无session表示没有登录
                //request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
               // response.sendRedirect("WEB-INF/views/login.jsp");
                response.sendRedirect("/pca/user/login");
                return false;
            }
        }
        return true;

    }
}
