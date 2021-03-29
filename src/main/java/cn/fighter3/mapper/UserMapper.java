package cn.fighter3.mapper;

import cn.fighter3.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/**
 * @Author Cxb
 * @Date 2021-03-25 16:20
 */
public interface UserMapper extends BaseMapper<User> {
    IPage<User> selectUserPage(Page<User> page, String keyword);
}
