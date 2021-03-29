package cn.fighter3.entity;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.io.Serializable;

/**
 * @Author Cxb
 * @Date 2021-03-26 14:02
 */
public class LoginVO  implements Serializable {
    private Integer id;
    private String token;
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
