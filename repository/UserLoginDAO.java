package com.smart.project.web.home.repository;

import com.smart.project.proc.UserMapper;
import com.smart.project.web.home.vo.UserLoginVO;
import com.smart.project.web.home.vo.userVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserLoginDAO {

    @Autowired
    SqlSession session;

    public String insertUser(userVO user) {
        String result = "";
        UserMapper mapper = session.getMapper(UserMapper.class);

        try {
           result = String.valueOf(mapper.userInsert(user));
        } catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }



//    public UserLoginVO loginUser(UserLoginVO user) {
//        UserLoginVO result = null;
//
//        UserMapper mapper = session.getMapper(UserMapper.class);
//
////        try {
////            //result = mapper.loginAction(user);
////        }
//    }
}
