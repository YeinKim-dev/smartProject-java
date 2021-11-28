package com.smart.project.web.home.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class userVO {
    private Integer userN;
    private String userImg;
    private String userId;
    private String userPw;
    private String userName;
    private String userBirth;
    private String userTel;
    private String userSex;
    private String userSmoke;
    private String userDrink;
    private String userLoc;
    private String userHobby;
    private String userReligion;
    private String userIntd;
    private String userType;
    private MultipartFile files;
    private Integer userAge;
}

