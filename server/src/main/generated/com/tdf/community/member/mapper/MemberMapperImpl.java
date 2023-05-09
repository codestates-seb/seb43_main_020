package com.tdf.community.member.mapper;

import com.tdf.community.member.dto.MemberDto;
import com.tdf.community.member.entity.Member;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-09T15:41:45+0900",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 11.0.17 (Azul Systems, Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberPostDtoToMember(MemberDto.Post requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Member member = new Member();

        member.setEmail( requestBody.getEmail() );
        member.setPassword( requestBody.getPassword() );
        member.setNickname( requestBody.getNickname() );
        member.setAge( requestBody.getAge() );
        member.setGender( requestBody.getGender() );
        member.setAddress( requestBody.getAddress() );

        return member;
    }

    @Override
    public Member memberPatchDtoToMember(MemberDto.Patch requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Member member = new Member();

        member.setMemberId( requestBody.getMemberId() );
        member.setPassword( requestBody.getPassword() );
        member.setNickname( requestBody.getNickname() );
        member.setAge( requestBody.getAge() );
        member.setGender( requestBody.getGender() );
        member.setAddress( requestBody.getAddress() );
        member.setMemberStatus( requestBody.getMemberStatus() );

        return member;
    }

    @Override
    public Member memberResponseDtoToMember(MemberDto.Response requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Member member = new Member();

        member.setMemberId( requestBody.getMemberId() );
        member.setEmail( requestBody.getEmail() );
        member.setNickname( requestBody.getNickname() );
        member.setAge( requestBody.getAge() );
        member.setGender( requestBody.getGender() );
        member.setAddress( requestBody.getAddress() );
        member.setMemberStatus( requestBody.getMemberStatus() );
        member.setCreated_At( requestBody.getCreated_At() );

        return member;
    }

    @Override
    public MemberDto.Response memberToMemberResponseDto(Member member) {
        if ( member == null ) {
            return null;
        }

        Long memberId = null;
        String email = null;
        String nickname = null;
        int age = 0;
        String gender = null;
        String address = null;
        Member.MemberStatus memberStatus = null;
        ZonedDateTime created_At = null;

        memberId = member.getMemberId();
        email = member.getEmail();
        nickname = member.getNickname();
        age = member.getAge();
        gender = member.getGender();
        address = member.getAddress();
        memberStatus = member.getMemberStatus();
        created_At = member.getCreated_At();

        MemberDto.Response response = new MemberDto.Response( memberId, email, nickname, age, gender, address, memberStatus, created_At );

        return response;
    }

    @Override
    public List<MemberDto.Response> membersTomemberResponseDtos(List<Member> findMembers) {
        if ( findMembers == null ) {
            return null;
        }

        List<MemberDto.Response> list = new ArrayList<MemberDto.Response>( findMembers.size() );
        for ( Member member : findMembers ) {
            list.add( memberToMemberResponseDto( member ) );
        }

        return list;
    }
}
