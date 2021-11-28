package com.smart.project.web.home.biz;

import com.smart.project.proc.UserMapper;
import com.smart.project.web.home.vo.UserLoginVO;
import com.smart.project.web.home.vo.userVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class UserService {

    @Autowired
    UserMapper userMapper;

    // 회원가입
    public String Signup(userVO info) {
        String user = "";
        try{
            user = userMapper.userInsert(info);
            user = "success";
        } catch (Exception e) {
            user = "fail";
            e.printStackTrace();
        }
        System.out.println(user);
        return user;
    }

    public List<userVO> UserList() { // 전체 리스트 조회
        return userMapper.userList();
    }

    // 마이페이지
    public userVO userInfo(userVO info) throws Exception {
        return userMapper.userInfo(info);
    }

    // 로그인
    public userVO Login(userVO login) {
        return userMapper.loginAction(login);
    }

    // 아이디 체크
    public int idChk(userVO vo) throws Exception {
        return userMapper.idChk(vo);
    }

    // 회원정보 수정
    public int userUpdate(userVO user) {
        int result = 0;
        try {
            result = userMapper.userUpdate(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("업데이트 행 개수 : " + result);
        return result;
    }

}