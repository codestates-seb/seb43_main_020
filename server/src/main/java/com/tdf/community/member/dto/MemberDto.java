package com.tdf.community.member.dto;

import com.tdf.community.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class MemberDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        @Email(message = "이메일의 형식이 올바르지 않습니다.")
        @NotBlank(message = "아이디는 필수 입력 값 입니다.")
        private String email;

        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$",
                 message = "비밀번호는 영문,특수문자,숫자를 포함하여 8자리 이상이여야합니다.")
        @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
        private String password;

        @NotBlank(message = "닉네임은 필수 입력 값 입니다.")
        @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$", message = "닉네임은 특수문자를 제외한 2~10자리여야 합니다.")
        private String nickname;

        private int age;

        private String gender;

        private String address;


    }
    @Getter
    @AllArgsConstructor
    public static class Patch{

        private Long memberId;

        @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$", message = "닉네임은 특수문자를 제외한 2~10자리여야 합니다.")
        private String password;
        //테스트에서 비밀번호 수정가능한지 확인하기

        private String nickname;

        private int age;

        private String gender;

        private String address;


        private Member.MemberStatus memberStatus;
        //회원상태를 수정할일이 뭐가 있을까

        public void setMemberId(Long memberId) {
            this.memberId = memberId;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Response{

        private Long memberId;

        private String email;

        private String nickname;

        private int age;

        private String gender;

        private String address;
        private Member.MemberStatus memberStatus;

        private ZonedDateTime created_At;

  //    private LocalDateTime deleted_At

        public String getMemberStatus() {
            return memberStatus.getStatus();
        }


        }
}


