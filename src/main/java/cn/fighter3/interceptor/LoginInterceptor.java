package cn.fighter3.interceptor;



import cn.fighter3.entity.Result;
import cn.fighter3.util.HttpContextUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Cxb
 * @Date 2021-03-26 10:50
 */
public class LoginInterceptor implements HandlerInterceptor {
@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws IOException{
             String token = request.getHeader("token");
             if(StringUtils.isBlank(token)){
                 setReturn(response,400,"yonghuweidenglv");
                 return false;
             }

        return true;

    }

    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler,Exception ex){

    }
    //返回Json错误格式
    private static void setReturn(HttpServletResponse response,Integer code,String msg) throws IOException{
         HttpServletResponse httpResponse = (HttpServletResponse) response;
         httpResponse.setHeader("Access-Control-Allow-Credentials","true");
         httpResponse.setHeader("Access-Control-Allow-Origin",HttpContextUtil.getOrigin());
         httpResponse.setCharacterEncoding("UTF-8");
         response.setContentType("application/json;charset=utf-8");
        Result result = new Result(code,msg,"");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(result);
        httpResponse.getWriter().print(json);
    }



}
