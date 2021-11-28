package com.smart.project.web.home.act;

import com.smart.project.web.home.biz.MatchingService;
import com.smart.project.web.home.vo.userVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

import static java.util.Collections.shuffle;

@Slf4j
@Controller
public class MatchingController {

    @Autowired
    MatchingService matchingService;

    // 토너먼트용 추천리스트 뽑기 (주파수매칭)
    @RequestMapping("tournament")
    public String List(@ModelAttribute userVO list, Model model, HttpServletRequest req) throws Exception {

        HttpSession session = req.getSession();
        model.addAttribute("userId", session.getAttribute("user"));

        userVO sessionVo = (userVO) session.getAttribute("user");
        userVO vo = matchingService.genderChk(sessionVo);

        List<userVO> result = new ArrayList<>();

        if (vo.getUserId() != null) {
            if(sessionVo.getUserType().equals("108MHz") || sessionVo.getUserType().equals("94MHz")) {
                List<userVO> RecList108 = matchingService.RecList108(sessionVo);

                for(int i=0; i<8; i++) {
                    Collections.shuffle(RecList108);
                    userVO tmp = RecList108.get(0);
                    RecList108.remove(0);
                    result.add(tmp);
                }
            } else if (sessionVo.getUserType().equals("89MHz")) {
                List<userVO> RecList89 = matchingService.RecList89(sessionVo);

                for(int i=0; i<8; i++) {
                    Collections.shuffle(RecList89);
                    userVO tmp = RecList89.get(0);
                    RecList89.remove(0);
                    result.add(tmp);
                }
            } else if (sessionVo.getUserType().equals("80MHz")) {
                List<userVO> RecList80 = matchingService.RecList80(sessionVo);

                for(int i=0; i<8; i++) {
                    Collections.shuffle(RecList80);
                    userVO tmp = RecList80.get(0);
                    RecList80.remove(0);
                    result.add(tmp);
                }
            } else if (sessionVo.getUserType().equals("114MHz")) {
                List<userVO> RecList114 = matchingService.RecList114(sessionVo);

                for (int i = 0; i < 8; i++) {
                    Collections.shuffle(RecList114);
                    userVO tmp = RecList114.get(0);
                    RecList114.remove(0);
                    result.add(tmp);
                }
            } else if (sessionVo.getUserType().equals("100MHz")) {
                List<userVO> RecList100 = matchingService.RecList100(sessionVo);

                for (int i = 0; i < 8; i++) {
                    Collections.shuffle(RecList100);
                    userVO tmp = RecList100.get(0);
                    RecList100.remove(0);
                    result.add(tmp);
                }
            } else if (sessionVo.getUserType().equals("95MHz")) {
                List<userVO> RecList95 = matchingService.RecList95(sessionVo);

                for (int i = 0; i < 8; i++) {
                    Collections.shuffle(RecList95);
                    userVO tmp = RecList95.get(0);
                    RecList95.remove(0);
                    result.add(tmp);
                }
            } else if (sessionVo.getUserType().equals("109MHz")) {
                List<userVO> RecList109 = matchingService.RecList109(sessionVo);

                for (int i = 0; i < 8; i++) {
                    Collections.shuffle(RecList109);
                    userVO tmp = RecList109.get(0);
                    RecList109.remove(0);
                    result.add(tmp);
                }
            } else if (sessionVo.getUserType().equals("110MHz")) {
                List<userVO> RecList110 = matchingService.RecList110(sessionVo);

                for (int i = 0; i < 8; i++) {
                    Collections.shuffle(RecList110);
                    userVO tmp = RecList110.get(0);
                    RecList110.remove(0);
                    result.add(tmp);
                }
            } else if (sessionVo.getUserType().equals("96MHz")) {
                List<userVO> RecList96 = matchingService.RecList96(sessionVo);

                for (int i = 0; i < 8; i++) {
                    Collections.shuffle(RecList96);
                    userVO tmp = RecList96.get(0);
                    RecList96.remove(0);
                    result.add(tmp);
                    System.out.println(result.get(i));
                }
            } else if (sessionVo.getUserType().equals("91MHz")) {
                List<userVO> RecList91 = matchingService.RecList91(sessionVo);

                for (int i = 0; i < 8; i++) {
                    Collections.shuffle(RecList91);
                    userVO tmp = RecList91.get(0);
                    RecList91.remove(0);
                    result.add(tmp);
                }
            } else if (sessionVo.getUserType().equals("105MHz")) {
                List<userVO> RecList105 = matchingService.RecList105(sessionVo);

                for (int i = 0; i < 8; i++) {
                    Collections.shuffle(RecList105);
                    userVO tmp = RecList105.get(0);
                    RecList105.remove(0);
                    result.add(tmp);
                }
            } else if (sessionVo.getUserType().equals("114MHz")) {
                List<userVO> RecList104 = matchingService.RecList104(sessionVo);

                for (int i = 0; i < 8; i++) {
                    Collections.shuffle(RecList104);
                    userVO tmp = RecList104.get(0);
                    RecList104.remove(0);
                    result.add(tmp);
                }
            } else if (sessionVo.getUserType().equals("90MHz")) {
                List<userVO> RecList90 = matchingService.RecList90(sessionVo);

                for (int i = 0; i < 8; i++) {
                    Collections.shuffle(RecList90);
                    userVO tmp = RecList90.get(0);
                    RecList90.remove(0);
                    result.add(tmp);
                }
            } else if (sessionVo.getUserType().equals("85MHz")) {
                List<userVO> RecList85 = matchingService.RecList85(sessionVo);

                for (int i = 0; i < 8; i++) {
                    Collections.shuffle(RecList85);
                    userVO tmp = RecList85.get(0);
                    RecList85.remove(0);
                    result.add(tmp);
                }
            } else if (sessionVo.getUserType().equals("99MHz")) {
                List<userVO> RecList99 = matchingService.RecList99(sessionVo);

                for (int i = 0; i < 8; i++) {
                    Collections.shuffle(RecList99);
                    userVO tmp = RecList99.get(0);
                    RecList99.remove(0);
                    result.add(tmp);
                }
            }
            System.out.println("안녕안녕!");
            System.out.println(vo.getUserName() + "는 " + vo.getUserSex());
            System.out.println("나이는? : " + vo.getUserAge());
            //System.out.println(RecList.size());
        } else {
            System.out.println("토너먼트 실패 ...");
        }

        model.addAttribute("matchList",result);

        return "/HTML/tournament";
    }

    // 타입 유형 설명들
    @RequestMapping("intro")
    public String TypeIntro(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        model.addAttribute("userId", session.getAttribute("user"));
        return "HTML/intro";
    }

    // 채팅 페이지 (주파수채팅)
//    @RequestMapping("chat")
//    public String Chat(HttpServletRequest req, Model model) {
//        HttpSession session = req.getSession();
//        model.addAttribute("userId", session.getAttribute("user"));
//        return "HTML/chat";
//    }

    // mbti 테스트 페이지
//    @RequestMapping("mbti")
//    public String Mbti(HttpServletRequest req, Model model) {
//        HttpSession session = req.getSession();
//        model.addAttribute("userId", session.getAttribute("user"));
//        return "HTML/mbti";
//    }
}
