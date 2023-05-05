package com.tdf.community.member.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;//(long타입/Long타입구분)

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,unique = true)
    private String nickname;

    private int age;

    private String gender;

    private String address;

    private String profileImageName;

    @Enumerated(value = EnumType.STRING)
    @Column(length =20,nullable = false)
    private MemberStatus memberStatus =MemberStatus.MEMBER_JOIN;

//    private List<String> roles = new ArrayList<>();

    //프리때 엉뚱한 시간이 들어가서 시도해본 코드
    @CreatedDate
    @Column(name="created_at",updatable = false)
    private ZonedDateTime created_At = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

//    @Column(name="deleted_at")
//    private LocalDateTime deletedAt;
    //언제 크리에이트엣을 사용하고 언제 딜리티드엣을 사용할지 생각해봐야할것같다.


    public enum MemberStatus {
        MEMBER_JOIN("회원가입"),
        MEMBER_QUIT("회원탈퇴");

        @Getter
        private String status;

        MemberStatus(String status) {
            this.status = status;
        }
    }
}
