package com.smart.project.web.home.biz;

import com.smart.project.proc.Test;
import com.smart.project.web.home.vo.DeptVO;
import com.smart.project.web.home.vo.SchVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
@Slf4j
public class HomeServices {

    @Autowired
    Test test;

    public List<DeptVO> test(int deptNo){
        List<DeptVO> data = test.sqlMenu2(deptNo);
        log.error("test data===>{}", data);
        return null;
    }


    public List<DeptVO> test2(SchVO param){
        List<DeptVO> data = test.sqlMenu3(param);
        log.error("test2 data===>{}", data);
        return null;
    }

}
