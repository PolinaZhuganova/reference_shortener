package com.example.reference_shortener.model;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * Класс Shortener
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shortener {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="originalurl")
	private String originalUrl;
	@Column(name="shorturl")
	private String shortUrl;
	@Column(name="created_at", columnDefinition = "TIMESTAMP")
	private ZonedDateTime createdAt;
	@Column(name="link_status")
	private String linkStatus;
}