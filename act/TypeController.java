package com.smart.project.web.home.act;

import com.smart.project.web.home.biz.TypeService;
import com.smart.project.web.home.vo.HeartVO;
import com.smart.project.web.home.vo.MatchingVO;
import com.smart.project.web.home.vo.TypeVO;
import com.smart.project.web.home.vo.userVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Controller
public class TypeController {

    @Autowired
    TypeService typeService;

    @PostMapping("getAccessOtherId")
    public String getAccessToken(@ModelAttribute userVO log, Model model, HttpSession session){
        String id = (String)session.getAttribute("userId");
        String otherId = log.getUserId();
        HeartVO vo = new HeartVO();
        vo.setUserId(id);
        vo.setOtherId(otherId);
        typeService.HeartInsert(vo);

        return "HTML/tournament";
    }
    // mbti 결과
    @GetMapping("mbti")
    public String mbtiResult(Model model, HttpServletRequest req){
        HttpSession session = req.getSession();
        model.addAttribute("userId", session.getAttribute("user"));

        List<TypeVO> lst = typeService.mbtiResult();
        model.addAttribute("userType", lst);

        return "HTML/mbti";
    }

    // mbti 결과 DB에 저장
    @GetMapping("mbtiUpdate")
    public String mbtiUpdate(@ModelAttribute userVO log, Model model, HttpServletRequest req){

        HttpSession session = req.getSession();
        model.addAttribute("userId", session.getAttribute("user"));

        String next = log.getUserName();
        session.setAttribute("mbti", log);

        userVO sessionVo = (userVO) session.getAttribute("user");

        log.setUserId((String)session.getAttribute("userId"));
        typeService.mbtiUpdate(log);

        userVO user = (userVO) session.getAttribute("user");
        user.setUserType(log.getUserType());
        session.setAttribute("user", user);
        System.out.println(log.getUserType());
        return "redirect:/" + next;
    }

    @GetMapping("HeartInsert")
    public void HeartInsert(HttpSession session, Model model, HttpServletRequest req){
        session = req.getSession();
        model.addAttribute("userId", ((userVO)session.getAttribute("user")).getUserId());
        model.addAttribute("otherId",session.getAttribute("otherId"));
    }


    @RequestMapping("chat")
    public String hearList(HttpSession session, Model model, userVO user, HttpServletRequest req) {

        session = req.getSession();
        model.addAttribute("userId", session.getAttribute("user"));

        user.setUserId((String) session.getAttribute("userId"));
        List<userVO> lst = typeService.heartList(user);
        //System.out.println("lst 값 : "+lst);
        List<userVO> result = new ArrayList<>();
        int size = lst.size();
        for (int i=0; i<size; i++) {
            Collections.shuffle(lst);
            userVO tmp = lst.get(0);
            lst.remove(0);
            result.add(tmp);
            System.out.println("여기여기" + result.get(i));
        }
        model.addAttribute("Result", result);
        model.addAttribute("matchingImg", user.getUserImg());

        //System.out.println(model.getAttribute("Result"));

        return "HTML/chat";
    }

}
