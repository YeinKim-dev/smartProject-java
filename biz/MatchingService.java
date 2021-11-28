package com.smart.project.web.home.biz;

import com.smart.project.proc.MatchingMapper;
import com.smart.project.web.home.vo.userVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MatchingService {

    @Autowired
    MatchingMapper matchingMapper;

//    public List<userVO> RecList(userVO vo) { // 추천 리스트 조회
//        return matchingMapper.RecList(vo);
//    }

    public List<userVO> RecList108(userVO vo) { // 추천 리스트 조회
        return matchingMapper.RecList108(vo);
    }

    public List<userVO> RecList89(userVO vo) { // 추천 리스트 조회
        return matchingMapper.RecList89(vo);
    }

    public List<userVO> RecList80(userVO vo) { // 추천 리스트 조회
        return matchingMapper.RecList80(vo);
    }

    public List<userVO> RecList114(userVO vo) { // 추천 리스트 조회
        return matchingMapper.RecList114(vo);
    }

    public List<userVO> RecList100(userVO vo) { // 추천 리스트 조회
        return matchingMapper.RecList100(vo);
    }

    public List<userVO> RecList95(userVO vo) { // 추천 리스트 조회
        return matchingMapper.RecList95(vo);
    }

    public List<userVO> RecList109(userVO vo) { // 추천 리스트 조회
        return matchingMapper.RecList109(vo);
    }

    public List<userVO> RecList110(userVO vo) { // 추천 리스트 조회
        return matchingMapper.RecList110(vo);
    }

    public List<userVO> RecList96(userVO vo) { // 추천 리스트 조회
        return matchingMapper.RecList96(vo);
    }

    public List<userVO> RecList91(userVO vo) { // 추천 리스트 조회
        return matchingMapper.RecList91(vo);
    }

    public List<userVO> RecList105(userVO vo) { // 추천 리스트 조회
        return matchingMapper.RecList105(vo);
    }

    public List<userVO> RecList104(userVO vo) { // 추천 리스트 조회
        return matchingMapper.RecList104(vo);
    }

    public List<userVO> RecList90(userVO vo) { // 추천 리스트 조회
        return matchingMapper.RecList90(vo);
    }

    public List<userVO> RecList85(userVO vo) { // 추천 리스트 조회
        return matchingMapper.RecList85(vo);
    }

    public List<userVO> RecList99(userVO vo) { // 추천 리스트 조회
        return matchingMapper.RecList99(vo);
    }

    public userVO genderChk(userVO check) {
        return matchingMapper.genderChk(check);
    }
}
