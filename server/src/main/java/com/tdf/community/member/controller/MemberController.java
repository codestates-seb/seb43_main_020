package com.tdf.community.member.controller;

import com.tdf.community.member.dto.MemberDto;
import com.tdf.community.member.dto.MultiResponseDto;
import com.tdf.community.member.entity.Member;
import com.tdf.community.member.mapper.MemberMapper;
import com.tdf.community.member.service.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/members")
@Validated
public class MemberController {

    private final static String MEMBER_DEFAULT_URL="/members";
    private final MemberService memberService;
    private final MemberMapper mapper;

    public MemberController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }

    @PostMapping(value = "/join",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity postMember(@Valid @RequestPart MemberDto.Post requestBody,
                                     @RequestPart MultipartFile profileImage){

        Member createdMember=memberService.createMember(mapper.memberPostDtoToMember(requestBody),profileImage);
        URI location= UriComponentsBuilder.newInstance()
                .path(MEMBER_DEFAULT_URL+"/{createdMember.getMemberId()}")
                .buildAndExpand(createdMember.getMemberId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/update/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive long memberId,
                                      @RequestBody MemberDto.Patch requestBody){

        requestBody.setMemberId(memberId);
        Member updatedMember = memberService.updateMember(mapper.memberPatchDtoToMember(requestBody));

        return new ResponseEntity<>(mapper.memberToMemberResponseDto(updatedMember),HttpStatus.OK);
    }

    @GetMapping("/find/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId){

        Member findMember= memberService.findMember(memberId);

        return new ResponseEntity<>(mapper.memberToMemberResponseDto(findMember),HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity getMembers(@Positive @RequestParam int page,
                                     @Positive @RequestParam int size){
        Page<Member> pageMembers= memberService.findMembers(page-1,size);
        List<Member> members= pageMembers.getContent();

        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.membersTomemberResponseDtos(members),
                        pageMembers),HttpStatus.OK);
    }

    //관리자삭제
    @DeleteMapping("/admin/delete/{member-id}")
    public ResponseEntity adminDeleteMember(@PathVariable("member-id")long memberId){
        memberService.adminDeleteMember(memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/admin/delete")
    public ResponseEntity adminDeleteMembers(){
        memberService.adminDeleteMembers();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    //상태값변경삭제;;
    @DeleteMapping("/user/delete/{member-id}")
    public ResponseEntity userDeleteMember(@PathVariable("member-id")long memberId){
        memberService.userDeleteMember(memberId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}