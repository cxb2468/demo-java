package cn.fighter3.service;

import cn.fighter3.dto.LoginDTO;
import cn.fighter3.entity.LoginVO;
import cn.fighter3.entity.Result;
import cn.fighter3.entity.User;
import cn.fighter3.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @Author Cxb
 * @Date 2021-03-25 16:32
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result login(LoginDTO loginDTO) {
        if (StringUtils.isEmpty(loginDTO.getLoginName())){
            return new Result(400,"账号不能为空","");
        }
        if (StringUtils.isEmpty(loginDTO.getPassword())){
            return new Result(400,"密码不能为空","");
        }
        //通过登录名查询用户
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("login_name", loginDTO.getLoginName());
        User uer=userMapper.selectOne(wrapper);
        //比较密码
        if (uer!=null&&uer.getPassword().equals(loginDTO.getPassword())){
            LoginVO loginVO=new LoginVO();
            loginVO.setId(uer.getId());
            //这里token直接使用一个uuid
            //使用jwt的情况下 会生成一各jwt token，其中包含用户信息
            loginVO.setToken(UUID.randomUUID().toString());
            loginVO.setUser(uer);


            return new Result(200,"",loginVO);
        }
        return new Result(400,"登录失败","");
    }
}
