package com.project.everytime.domain.user.service;

import com.project.everytime.domain.auth.client.dto.request.SignUpRequest;
import com.project.everytime.domain.user.domain.entity.UserEntity;
import com.project.everytime.domain.user.domain.enums.School;
import com.project.everytime.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public Long save(SignUpRequest dto) {
        return userRepository.save(UserEntity.builder()
                .email(dto.email())
                .nickname(dto.nickname())
                .password(bCryptPasswordEncoder.encode(dto.password()))
                .school(School.DGSW)
                .build()).getId();
    }
}