package com.tdf.community.member.mapper;

import com.tdf.community.member.dto.MemberDto;
import com.tdf.community.member.entity.Member;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-05T20:06:51+0900",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 11.0.17 (Azul Systems, Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    private final DatatypeFactory datatypeFactory;

    public MemberMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

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
        LocalDateTime created_At = null;

        memberId = member.getMemberId();
        email = member.getEmail();
        nickname = member.getNickname();
        age = member.getAge();
        gender = member.getGender();
        address = member.getAddress();
        memberStatus = member.getMemberStatus();
        created_At = xmlGregorianCalendarToLocalDateTime( zonedDateTimeToXmlGregorianCalendar( member.getCreated_At() ) );

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

    private static LocalDateTime xmlGregorianCalendarToLocalDateTime( XMLGregorianCalendar xcal ) {
        if ( xcal == null ) {
            return null;
        }

        if ( xcal.getYear() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMonth() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getDay() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getHour() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMinute() != DatatypeConstants.FIELD_UNDEFINED
        ) {
            if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED
                && xcal.getMillisecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond(),
                    Duration.ofMillis( xcal.getMillisecond() ).getNano()
                );
            }
            else if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond()
                );
            }
            else {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute()
                );
            }
        }
        return null;
    }

    private XMLGregorianCalendar zonedDateTimeToXmlGregorianCalendar( ZonedDateTime zdt ) {
        if ( zdt == null ) {
            return null;
        }

        return datatypeFactory.newXMLGregorianCalendar( GregorianCalendar.from( zdt ) );
    }
}
