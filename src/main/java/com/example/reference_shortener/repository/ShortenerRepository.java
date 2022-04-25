package com.example.reference_shortener.repository;

import com.example.reference_shortener.mapper.ShortenerMapper;
import com.example.reference_shortener.model.Shortener;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Класс ShortenerRepository
 */
@Repository
@Transactional
@AllArgsConstructor
public class ShortenerRepository {
	JdbcTemplate jdbcTemplate;


	public String findOriginalUrlByShort(String shortUrl) {
		String sql = "select originalurl from shortener where shorturl = ?";
		return jdbcTemplate.queryForObject(sql, String.class, shortUrl);
	}

	public void saveShortUrl(String originalUrl, String shortUrl) {
		String sql = "insert into shortener(originalUrl,shortUrl, created_at) values(?,?, NOW())";
		jdbcTemplate.update(sql, originalUrl, shortUrl);
	}


	public List<Shortener> findAll() {
		String sql = "select* from shortener";
		List<Shortener> shorteners = jdbcTemplate.query(sql, new ShortenerMapper());
		return shorteners;
	}

	public void deleteById(int id) {
		String sql = "delete from shortener where id = ?";
		jdbcTemplate.update(sql, id);
	}

	public void clearOldLinks() {
		String clear = "delete from shortener where created_at < (now()- interval '5 day');";
		jdbcTemplate.update(clear);
	}

}