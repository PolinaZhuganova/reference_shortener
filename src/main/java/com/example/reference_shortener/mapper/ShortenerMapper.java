package com.example.reference_shortener.mapper;

import com.example.reference_shortener.model.Shortener;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;

/**
 * Класс ShortenerMapper
 */
public class ShortenerMapper implements RowMapper<Shortener> {

	@Override
	public Shortener mapRow(ResultSet rs, int rowNum) throws SQLException {
		return Shortener.builder()
			.id(rs.getInt("id"))
			.shortUrl(rs.getString("shorturl"))
			.originalUrl(rs.getString("originalurl"))
			.build();
	}
}