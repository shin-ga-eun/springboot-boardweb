package com.shingaeun.board.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    //기존가입자인지 신규가입자인지 판단
    Optional<Member> findByEmail (String email);


}
