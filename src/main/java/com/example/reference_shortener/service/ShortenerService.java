package com.example.reference_shortener.service;

import com.example.reference_shortener.model.Shortener;
import com.example.reference_shortener.repository.ShortenerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Класс ShortenerService
 */
@Slf4j
@Service
@AllArgsConstructor
public class ShortenerService {

	private final UrlGeneratorService urlGeneratorService;
	private final ShortenerRepository shortenerRepository;

	public String generateShortUrl(String originalUrl, String baseUrl) {
		String shortUrl = urlGeneratorService.createURL(originalUrl, baseUrl);
		shortenerRepository.saveShortUrl(originalUrl, shortUrl);

		return shortUrl;
	}

	public String findOriginalUrl(String shortUrl) {
		return shortenerRepository.findOriginalUrlByShort(shortUrl);
	}

	public List<Shortener> getAllLinks() {
		List<Shortener> allLinks = shortenerRepository.findAll();
		log.info("-----------------" + allLinks);
		return allLinks;
	}

	public void delById(int id) {
		shortenerRepository.deleteById(id);
	}


	@Scheduled(cron="5 * * 23 * *")
	public void clearOldLinks(){
		shortenerRepository.clearOldLinks();
	}


}