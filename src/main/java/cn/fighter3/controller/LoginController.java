package cn.fighter3.controller;

import cn.fighter3.dto.LoginDTO;
import cn.fighter3.entity.Result;
import cn.fighter3.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Cxb
 * @Date 2021-03-25 16:28
 */
@RestController
public class LoginController {

    @Autowired
    private  LoginService loginService;

    @PostMapping(value = "/api/login")
    @CrossOrigin
    public Result login(@RequestBody LoginDTO loginDTO){
        return loginService.login(loginDTO);
    }


}
