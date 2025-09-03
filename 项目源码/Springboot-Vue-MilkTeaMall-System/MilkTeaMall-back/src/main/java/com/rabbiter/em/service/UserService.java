package com.rabbiter.em.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rabbiter.em.common.Result;
import com.rabbiter.em.constants.Constants;
import com.rabbiter.em.constants.RedisConstants;
import com.rabbiter.em.entity.LoginForm;
import com.rabbiter.em.entity.User;
import com.rabbiter.em.entity.dto.UserDTO;
import com.rabbiter.em.exception.ServiceException;
import com.rabbiter.em.mapper.UserMapper;
import com.rabbiter.em.utils.TokenUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;


@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    @Resource
    RedisTemplate<String,User> redisTemplate;

    public UserDTO login(LoginForm loginForm) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",loginForm.getUsername());
        queryWrapper.eq("password",loginForm.getPassword());
        User user = getOne(queryWrapper);
        System.out.println(loginForm.getUsername());
        System.out.println(loginForm.getPassword());
        System.out.println(user);
        if(user == null) {
            throw new ServiceException(Constants.CODE_403,"用户名或密码错误");
        }
        String token = TokenUtils.genToken(user.getId().toString(), user.getUsername());
        //把用户存到redis中
        redisTemplate.opsForValue().set(RedisConstants.USER_TOKEN_KEY + token,user);
        //jwt不设置过期时间，只设置redis过期时间。
        redisTemplate.expire(RedisConstants.USER_TOKEN_KEY +token, RedisConstants.USER_TOKEN_TTL, TimeUnit.MINUTES);
        //把查到的user的一些属性赋值给userDTO
        UserDTO userDTO = BeanUtil.copyProperties(user,UserDTO.class);
        //设置token
        userDTO.setToken(token);
        return userDTO;

    }

    public User register(LoginForm loginForm) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",loginForm.getUsername());
        User user = getOne(queryWrapper);
        if(user!=null){
            throw new ServiceException(Constants.CODE_403,"用户名已被使用");
        }else{
            user = new User();
            BeanUtils.copyProperties(loginForm,user);
            user.setNickname("新用户");
            user.setRole("user");
            save(user);
            return user;
        }
    }

    public User getOne(String username){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        return getOne(queryWrapper);
    }

    public Result saveUpdate(User user) {
        if(user.getId() != null) {
            // 修改
            User old = this.baseMapper.selectById(user.getId());
            old.setNickname(ObjectUtils.isEmpty(user.getNickname()) ? old.getNickname() : user.getNickname());
            old.setAvatarUrl(ObjectUtils.isEmpty(user.getAvatarUrl()) ? old.getAvatarUrl() : user.getAvatarUrl());
            old.setRole(ObjectUtils.isEmpty(user.getRole()) ? old.getRole() : user.getRole());
            old.setPhone(ObjectUtils.isEmpty(user.getPhone()) ? old.getPhone() : user.getPhone());
            old.setEmail(ObjectUtils.isEmpty(user.getEmail()) ? old.getEmail() : user.getEmail());
            old.setAddress(ObjectUtils.isEmpty(user.getAddress()) ? old.getAddress() : user.getAddress());
            super.updateById(old);
            return Result.success("修改成功");
        } else {
            // 新增
            if(!ObjectUtils.isEmpty(this.getOne(user.getUsername()))) {
                return Result.error("400", "用户名已存在");
            }
            user.setPassword(user.getNewPassword());
            super.save(user);
            return Result.success("新增成功");
        }
    }

    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    /**
     * 重置密码
     *
     * @param id          用户id
     * @param newPassword 新密码
     */
    public void resetPassword(String id, String newPassword) {
        User user = this.getById(id);
        if(user == null) {
            return;
        }
        user.setPassword(newPassword);
        this.updateById(user);
    }
}
