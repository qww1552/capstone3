package kr.ac.jejunu.capstone.controller;

import kr.ac.jejunu.capstone.configuration.security.JwtTokenProvider;
import kr.ac.jejunu.capstone.configuration.security.user.Member;
import kr.ac.jejunu.capstone.configuration.security.user.MemberRepository;
import kr.ac.jejunu.capstone.exception.UserNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/join")
    public Long join(@RequestBody Map<String, String> member) {
        return memberRepository.save(
                Member.builder()
                .email(member.get("email"))
                .password(passwordEncoder.encode(member.get("password")))
                .roles(Collections.singletonList("ROLE_USER"))
                .build()
        ).getId();
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
        Member member = memberRepository.findByEmail(user.get("email"))
                .orElseThrow(() -> new UserNotExistException("존재하지 않는 회원입니다."));
        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
    }}
