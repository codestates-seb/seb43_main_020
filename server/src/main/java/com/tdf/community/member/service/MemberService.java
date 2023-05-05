package com.tdf.community.member.service;

import com.tdf.community.member.entity.Member;
import com.tdf.community.member.repository.MemberRepository;
import com.tdf.community.profile.ImageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ImageService imageService;

    public MemberService(MemberRepository memberRepository, ImageService imageService) {
        this.memberRepository = memberRepository;
        this.imageService = imageService;
    }

    public Member createMember(Member member, MultipartFile profileImage) {
        member.setProfileImageName(profileImage.getOriginalFilename());
        imageService.store(profileImage);
        Member createdMember =memberRepository.save(member);
        return createdMember;
    }

    public Member updateMember(Member member) {

        Member updateMember = findVerifiedMember(member.getMemberId());

        if (member.getNickname() != null) {
            updateMember.setNickname(member.getNickname());
        } else if (member.getPassword() != null) {
            updateMember.setPassword(member.getPassword());
        }

    return memberRepository.save(updateMember);

    }

    public Member findMember(long memberId){
        return findVerifiedMember(memberId);
    }

    private Member findVerifiedMember(long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member findMember= optionalMember.orElseThrow(()->new RuntimeException());//회원을 찾을수없습니다.
        return findMember;
    }

    public Page<Member> findMembers(int page,int size) {
       return memberRepository.findAll(PageRequest.of(page,size, Sort.by("memberId").descending()));
    }

    public void adminDeleteMember(long memberId) {
        memberRepository.deleteById(memberId);
    }

    public void adminDeleteMembers() {
        memberRepository.deleteAll();
    }

    public void userDeleteMember(long memberId) {
        Optional<Member>optionalMember=memberRepository.findById(memberId);
        Member findMember=optionalMember.orElseThrow(()->new RuntimeException());
        findMember.setMemberStatus(Member.MemberStatus.MEMBER_QUIT);
        memberRepository.save(findMember);
    }
}
