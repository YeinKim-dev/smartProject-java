package com.smart.project.web.home.act;

import com.smart.project.web.home.biz.UserService;
import com.smart.project.web.home.vo.UserLoginVO;
import com.smart.project.web.home.vo.userVO;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.slf4j.Slf4j;
import oracle.ucp.proxy.annotation.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    ResourceLoader resourceLoader;

    // 홈화면
    @GetMapping("")
    public String home(userVO vo, Model model) {
        model.addAttribute("userId", vo.getUserId());
        System.out.println("hihihihi");
        return "/HTML/home";
    }

    // 홈화면
    @RequestMapping("home")
    public String mainpage(userVO vo, Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        model.addAttribute("userId", session.getAttribute("user"));
        return "HTML/home";
    }

    // 아이디 중복체크
    @ResponseBody
    @RequestMapping(value = "idChk", method = RequestMethod.POST)
    public int idChk(userVO user) throws Exception {
        return userService.idChk(user);
    }

    // 회원가입
    @PostMapping("users/new")
    public String Join(@ModelAttribute userVO user, HttpServletRequest request) throws Exception{
        int result = userService.idChk(user);
        String url = "";
        try {
            if(result == 1) {
                url = "HTML/join";
            } else if(result == 0) {

                user.setUserImg(user.getFiles().getOriginalFilename());
                userService.Signup(user);

                String filePath = "C:/users/smhrd/Desktop/smart_project/src/main/resources/static/images/human/"+ user.getFiles().getOriginalFilename();
                System.out.println(filePath);
                File dest = new File(filePath);
                user.getFiles().transferTo(dest); // 파일 업로드 작업 수행
                url = "HTML/login";
            }
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }

        System.out.println("아이디 = " + user.getUserId());
        return url;
    }

    // 회원 전체 리스트 조회 -> 관리자용 (사용X)
    @RequestMapping("userlist")
    public String List(@ModelAttribute userVO list, Model model){
        List<userVO> users = userService.UserList();
        model.addAttribute("user",users);

        System.out.println(users.get(0));
        System.out.println(users.get(1));
        System.out.println(users.get(2));
        System.out.println(users.get(3));
        System.out.println(users.get(4));
        return "userlist";
    }

    // 로그인
    @PostMapping("/LoginAction")
    public String login(@ModelAttribute userVO log, Model model, HttpServletRequest req) throws Exception {

        userVO user = userService.Login(log);
        String url = "";

        HttpSession session = req.getSession();
        System.out.println(user);
        model.addAttribute("userId", log.getUserId());

        if (user != null) {
            session.setAttribute("userId", log.getUserId());
            session.setAttribute("user", user);
            session.setAttribute("userName", user);
            System.out.println(log.getUserId() + "님 로그인 성공!");
            url = "/HTML/home";
        } else {
            session.setAttribute("userId", "");
            session.setAttribute("user", "");
            System.out.println("로그인 실패");
            url = "/HTML/login";
        }
        return url;
    }


    // 마이페이지 - 회원 개인정보
    @RequestMapping(value = "mypage")
    public String Mypage(@ModelAttribute userVO info, HttpServletRequest req, Model model) throws Exception {
        HttpSession session = req.getSession();
        userVO userInfo = userService.userInfo((userVO) session.getAttribute("user"));

        String id = (String) session.getAttribute("userId");
        System.out.println("결과는..." + userInfo);

        System.out.println(userInfo.getUserImg());

        model.addAttribute("userId",id);
        model.addAttribute("userImg", userInfo.getUserImg());
        model.addAttribute("userPw",userInfo.getUserPw());
        model.addAttribute("userName",userInfo.getUserName());
        model.addAttribute("userBirth",userInfo.getUserBirth());
        model.addAttribute("userSex",userInfo.getUserSex());
        model.addAttribute("userTel",userInfo.getUserTel());
        model.addAttribute("userSmoke",userInfo.getUserSmoke());
        model.addAttribute("userDrink",userInfo.getUserDrink());
        model.addAttribute("userHobby",userInfo.getUserHobby());
        model.addAttribute("userLoc",userInfo.getUserLoc());
        model.addAttribute("userReligion",userInfo.getUserReligion());
        model.addAttribute("userIntd",userInfo.getUserIntd());
        model.addAttribute("userType",userInfo.getUserType());
        return "HTML/mypage";
    }

    // 회원정보 업데이트
    @PostMapping ("infoUpdate")
    public String Update(@ModelAttribute userVO user, HttpServletRequest req, Model model) throws Exception {
        HttpSession session = req.getSession();
        //model.addAttribute("user", session.getAttribute("user"));
        userVO update = (userVO)session.getAttribute("user");

        update.setUserSmoke(user.getUserSmoke());
        update.setUserDrink(user.getUserDrink());
        update.setUserLoc(user.getUserLoc());
        update.setUserHobby(user.getUserHobby());
        update.setUserReligion(user.getUserReligion());


        userService.userUpdate(update);
        return "redirect:/mypage";
        }


    // 회원가입 페이지로 넘어감. 작동안함
    @GetMapping("join")
    public String Signup(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        model.addAttribute("userId", session.getAttribute("user"));
        return "HTML/join";
    }

    // 로그인 페이지로 넘어감.
    @RequestMapping("login")
    public String Signin(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        model.addAttribute("userId", session.getAttribute("user"));
        return "HTML/login";
    }

    // 로그아웃
    @GetMapping("signout")
    public String Signout(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.setAttribute("user", null);
        return "redirect:/";
    }

}
