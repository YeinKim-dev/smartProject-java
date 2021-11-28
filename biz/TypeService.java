package com.smart.project.web.home.biz;

import com.smart.project.proc.TypeMapper;
import com.smart.project.web.home.vo.HeartVO;
import com.smart.project.web.home.vo.MatchingVO;
import com.smart.project.web.home.vo.TypeVO;
import com.smart.project.web.home.vo.userVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TypeService {

    @Autowired
    TypeMapper typeMapper;

    // mbti 결과 c출력
    public List<TypeVO> mbtiResult(){
        List<TypeVO> result;
        result = typeMapper.mbtiResult();
        return result;
    }

    // 주파수 유형 업데이트
    public void mbtiUpdate(userVO User) {
        int result = 0;
        try {
            result = typeMapper.mbtiUpdate(User);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("주파수 유형 업데이트 개수 : " + result);
    }


    public void HeartInsert(HeartVO heartvo) { // 좋아요 누르는 내id 상대id 입력

        try{
            typeMapper.HeartInsert(heartvo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<userVO> heartList(userVO user){
        System.out.println(user.getUserId());
        List<userVO> result;
        result = typeMapper.heartList(user);
        return result;
    }




}
