package com.example.jpa03.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.jpa03.entity.Board;

public interface BoardRepository extends PagingAndSortingRepository<Board, Integer> {
	@Query(value = "SELECT * FROM board b JOIN member m ON b.userid = m.userid WHERE m.name LIKE %:keyword%", nativeQuery = true)
	Page<Board> findByAll(@Param("keyword") String keyword, Pageable pageable);

	@Query(value = "SELECT * FROM board b JOIN member m ON b.userid = m.userid WHERE m.name LIKE %:keyword% ", nativeQuery = true)
	Page<Board> findByKeyword(@Param("keyword") String keyword, Pageable pageable);

	Page<Board> findByTitleContaining(String title, Pageable pageable);

	Page<Board> findByContentsContaining(String content, Pageable pageable);

	Board save(Board b);

	Optional<Board> findById(int idx);

	void deleteById(int idx);
}
