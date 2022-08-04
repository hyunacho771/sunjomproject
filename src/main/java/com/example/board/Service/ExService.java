package com.example.board.Service;

import com.example.board.MyUserDetail;
import com.example.board.domain.entity.MemberEntity;
import com.example.board.domain.repository.ExRepository;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Member;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExService implements UserDetailsService {
    private final ExRepository repository;

    @Transactional
    public void joinUser(MemberEntity user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.saveUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //여기서 받은 유저 패스워드와 비교하여 로그인 인증
        MemberEntity user = repository.findUserByEmail(email);
        return new MyUserDetail(user);
    }
}