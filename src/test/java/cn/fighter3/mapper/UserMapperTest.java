package cn.fighter3.mapper;

import cn.fighter3.entity.User;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author Cxb
 * @Date 2021-03-26 8:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    @DisplayName("插入数据")
    public void testInsert(){
        User user=new User("0326","test","t123","男","test1@qq.com","满都镇");
        Integer id=userMapper.insert(user);
        System.out.printf(id.toString());
    }

    @Test
    @DisplayName("根据id查找")
    public void testSelectById(){
        User user=userMapper.selectById(11);
        System.out.println(user.toString());
    }

    @Test
    @DisplayName("查找所有")
    public void testSelectAll(){
        List userList=userMapper.selectObjs(null);
        System.out.println(userList.size());
    }

    @Test
    @DisplayName("更新")
    public void testUpdate(){
        User user=new User();
        user.setId(2);
        user.setAddress("金葫芦镇0326");
        Integer id=userMapper.updateById(user);
        System.out.println(id);
    }

//    @Test
//    @DisplayName("删除")
//    public void testDelete(){
//        userMapper.deleteById(1);
//    }

}