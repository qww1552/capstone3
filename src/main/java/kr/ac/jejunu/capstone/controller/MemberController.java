package kr.ac.jejunu.capstone.controller;

import kr.ac.jejunu.capstone.configuration.security.JwtTokenProvider;
import kr.ac.jejunu.capstone.configuration.security.user.Member;
import kr.ac.jejunu.capstone.configuration.security.user.MemberRepository;
import kr.ac.jejunu.capstone.exception.UserDuplicatedException;
import kr.ac.jejunu.capstone.exception.UserNotExistException;
import kr.ac.jejunu.capstone.model.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/join")
    public ResponseEntity join(@RequestBody Map<String, String> member) {
        if (memberRepository.findByEmail(member.get("email")).isPresent()) {
            throw new UserDuplicatedException("이미 가입된 회원입니다.");
        }
        Member newMember = Member.builder()
                .email(member.get("email"))
                .password(passwordEncoder.encode(member.get("password")))
                .roles(Collections.singletonList("ROLE_USER"))
                .build();
        memberRepository.save(newMember);
        return ApiResponse.getResponseEntity(newMember);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Map<String, String> user) {
        Member member = memberRepository.findByEmail(user.get("email"))
                .orElseThrow(() -> new UserNotExistException("존재하지 않는 회원입니다."));
        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        String jwtToken = jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
        return ApiResponse.getResponseEntity(jwtToken);
    }
}
