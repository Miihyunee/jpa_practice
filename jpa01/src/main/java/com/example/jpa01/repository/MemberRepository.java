package com.example.jpa01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa01.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
	// Optional : null 처리
	// findBy필드명, findBy필드명And필드명(2개 이상일 때)
	Optional<Member> findByUseridAndPasswd(String userid, String passwd);
	// SELECT * FROM member WHERE userid = ? AND passwd = ?
}