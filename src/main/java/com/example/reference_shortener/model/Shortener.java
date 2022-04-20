package com.example.reference_shortener.model;

import lombok.*;

/**
 * Класс Shortener
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shortener {

	private int id;
	private String originalUrl;
	private String shortUrl;
}