package cn.fighter3.dto;

import javax.print.DocFlavor;

/**
 * @Author Cxb
 * @Date 2021-03-25 16:27
 */
public class LoginDTO {
    private String loginName;
    private String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
