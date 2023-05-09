package com.tdf.community;

import com.google.gson.Gson;
import com.tdf.community.member.controller.MemberController;
import com.tdf.community.member.dto.MemberDto;
import com.tdf.community.member.entity.Member;
import com.tdf.community.member.mapper.MemberMapper;
import com.tdf.community.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MemberController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class RestDocsMemberTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @MockBean
    private MemberMapper mapper;

    @Autowired
    private Gson gson;

    @Test
    public void postMemberTest() throws Exception {
        // given
        MemberDto.Post post = new MemberDto.Post("dmswjd4015@gmail.com", "dkssudgktpdy1!", "서은정", 18, "여성", "서울시구로구");
        String content = gson.toJson(post);


        //Mock 객체를 이용한 Stubbing
        given(mapper.memberPostDtoToMember(Mockito.any(MemberDto.Post.class))).willReturn(new Member());

        Member mockResultMember = new Member();
        mockResultMember.setMemberId(1L);

        MockMultipartFile mockFile = new MockMultipartFile("profile.jpg", "profile.jpg", "file/plain", "test data".getBytes());

        given(memberService.createMember(Mockito.eq(mockResultMember),Mockito.eq(mockFile))).willReturn(mockResultMember);


        // when
        ResultActions actions =
                mockMvc.perform(
                        multipart("/members/join")
                                .file(mockFile)
                                .content(content)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)


                );

        // then
        actions
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", is(startsWith("/members/"))))
                .andDo(document(
                        "post-member",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestFields(
                                List.of(
                                        fieldWithPath("email").type(JsonFieldType.STRING).description("회원아이디"),
                                        fieldWithPath("password").type(JsonFieldType.STRING).description("비밀번호"),
                                        fieldWithPath("nickname").type(JsonFieldType.STRING).description("닉네임"),
                                        fieldWithPath("age").type(JsonFieldType.NUMBER).description("나이"),
                                        fieldWithPath("gender").type(JsonFieldType.STRING).description("성별"),
                                        fieldWithPath("address").type(JsonFieldType.STRING).description("주소")
                                )
                        ),
                        responseHeaders(
                                headerWithName(HttpHeaders.LOCATION).description("Location header. 등록된 리소스의 URI")
                        )
                ));
    }

    @Test
    public void patchMemberTest() throws Exception {
        Long memberId = 1L;
        MemberDto.Patch patch = new MemberDto.Patch(memberId,"dkssudgktpdy!","뎡이",20,"여성","서울시구로구개봉동",Member.MemberStatus.MEMBER_JOIN);
        String content = gson.toJson(patch);

        MemberDto.Response responseDto =
                new MemberDto.Response(1L, "dmswjd4015@gmail.com", "뎡이", 20, "여성", "서울시구로구개봉동", Member.MemberStatus.MEMBER_JOIN, ZonedDateTime.now());

        given(mapper.memberPatchDtoToMember(Mockito.any(MemberDto.Patch.class))).willReturn(new Member());

        given(memberService.updateMember(Mockito.any(Member.class))).willReturn(new Member());

        given(mapper.memberToMemberResponseDto(Mockito.any(Member.class))).willReturn(responseDto);

        ResultActions actions =
                mockMvc.perform(
                        RestDocumentationRequestBuilders.patch("/members/update/{member-id}", memberId)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );
        ConstraintDescriptions patchMemberConstraints = new ConstraintDescriptions(MemberDto.Patch.class); // 유효성 검증 조건 정보 객체 생성
        List<String> nameDescriptions = patchMemberConstraints.descriptionsForProperty("name"); // name 필드의 유효성 검증 정보 얻기
        List<String> phoneDescriptions = patchMemberConstraints.descriptionsForProperty("phone"); // phone 필드의 유효성 검증 정보 얻기


        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.memberId").value(memberId))
                .andExpect(jsonPath("$.nickname").value(patch.getNickname()))
                .andExpect(jsonPath("$.age").value(patch.getAge()))
                .andExpect(jsonPath("$.gender").value(patch.getGender()))
                .andExpect(jsonPath("$.address").value(patch.getAddress()))
                .andExpect(jsonPath("$.memberStatus").value(patch.getMemberStatus().getStatus()))
                .andDo(document(
                        "patch-member",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                parameterWithName("member-id").description("회원 식별자")
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원식별자").ignored(),
                                        fieldWithPath("password").type(JsonFieldType.STRING).description("비밀번호").optional(),
                                        fieldWithPath("nickname").type(JsonFieldType.STRING).description("닉네임").optional(),
                                        fieldWithPath("age").type(JsonFieldType.NUMBER).description("나이").optional(),
                                        fieldWithPath("gender").type(JsonFieldType.STRING).description("성별").optional(),
                                        fieldWithPath("address").type(JsonFieldType.STRING).description("주소").optional(),
                                        fieldWithPath("image").type(JsonFieldType.STRING).description("프로필사진").optional(),
                                        fieldWithPath("memberStatus").type(JsonFieldType.STRING).description("회원 상태: MEMBER_JOIN / MEMBER_QUIT").optional()
                                )
                        ),
                        responseFields(
                                List.of(
                                       fieldWithPath(".memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                       fieldWithPath(".email").type(JsonFieldType.STRING).description("회원아이디"),
                                       fieldWithPath(".nickname").type(JsonFieldType.STRING).description("넥네임"),
                                       fieldWithPath(".age").type(JsonFieldType.NUMBER).description("나이"),
                                       fieldWithPath(".gender").type(JsonFieldType.STRING).description("성별"),
                                       fieldWithPath(".address").type(JsonFieldType.STRING).description("주소"),
                                       fieldWithPath(".memberStatus").type(JsonFieldType.STRING).description("회원상태: 가입회원/탈퇴회원"),
                                       fieldWithPath(".created_At").type(JsonFieldType.STRING).description("생성일")

                                )
                        )));
}

    @Test
    public void getMemberTest() throws Exception {
        Long memberId= 1L;
        //given
        MemberDto.Response response = new MemberDto.Response(1L,
                "dmswjd4015@naver.com", "서은정", 20, "여성",
                "서울시구로구", Member.MemberStatus.MEMBER_JOIN, ZonedDateTime.now());

        given(memberService.findMember(Mockito.anyLong())).willReturn(new Member());
        given(mapper.memberToMemberResponseDto(Mockito.any(Member.class))).willReturn(response);

        //when

        ResultActions actions =
                mockMvc.perform(
                        RestDocumentationRequestBuilders.get("/members/find/{member-id}",memberId)
                                .accept(MediaType.APPLICATION_JSON));
        //then

        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.memberId").value(memberId))
                .andExpect(jsonPath("$.nickname").value(response.getNickname()))
                .andDo(
                        document("get-member",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        List.of(parameterWithName("member-id").description("회원식별자"))
                                ),
                                responseFields(
                                        List.of(
                                                fieldWithPath(".memberId").type(JsonFieldType.NUMBER).description("회원식별자"),
                                                fieldWithPath(".email").type(JsonFieldType.STRING).description("회원아이디"),
                                                fieldWithPath(".nickname").type(JsonFieldType.STRING).description("회원닉네임"),
                                                fieldWithPath(".age").type(JsonFieldType.NUMBER).description("나이"),
                                                fieldWithPath(".gender").type(JsonFieldType.STRING).description("성별"),
                                                fieldWithPath(".address").type(JsonFieldType.STRING).description("주소"),
                                                fieldWithPath(".memberStatus").type(JsonFieldType.STRING).description("회원 상태: MEMBER_JOIN(회원가입) /MEMBER_QUIT(회원탈퇴)"),
                                                fieldWithPath(".created_At").type(JsonFieldType.STRING).description("생성일")
                                        )
                                )
                                )
                );

    }

    @Test
    public void userDeleteMemberTest() throws Exception {
        // given
        long memberId = 1L;
        doNothing().when(memberService).userDeleteMember(Mockito.anyLong());

        // when
        ResultActions actions = mockMvc.perform(
                delete("/members/user/delete/{member-id}", memberId));
        // then
        actions.andExpect(status().isNoContent())
                .andDo(
                        document(
                                "user-delete-member",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        Arrays.asList(parameterWithName("member-id").description("회원 식별자 ID"))
                                )
                        )
                );
    }

    @Test
    public void adminDeleteMemberTest() throws Exception {
        // given
        long memberId = 1L;
        doNothing().when(memberService).adminDeleteMember(Mockito.anyLong());

        // when
        ResultActions actions = mockMvc.perform(
                delete("/members/admin/delete/{member-id}", memberId));
        // then
        actions.andExpect(status().isNoContent())
                .andDo(
                        document(
                                "admin-delete-member",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        Arrays.asList(parameterWithName("member-id").description("회원 식별자 ID"))
                                )
                        )
                );
    }
    @Test
    public void adminDeleteMembersTest() throws Exception {
        // given
        doNothing().when(memberService).adminDeleteMember(Mockito.anyLong());

        // when
        ResultActions actions = mockMvc.perform(
                delete("/members/admin/delete"));
        // then
        actions.andExpect(status().isNoContent())
                .andDo(
                        document(
                                "admin-delete-members",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint())
                                )
                );
    }
}

