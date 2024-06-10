package com.example.jpa02.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa02.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
	Optional<Member> findByUseridAndPasswd(String userid, String passwd);
}
