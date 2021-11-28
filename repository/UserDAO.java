package com.smart.project.web.home.repository;

import com.smart.project.web.home.vo.userVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserDAO {

    List<userVO> selectUsers(userVO param) throws Exception;
    void userInsert(userVO param) throws Exception;
    List<userVO> FindUserWithID(userVO param) throws Exception;
    List<userVO> SignIn(userVO param) throws Exception;

}
