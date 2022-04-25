package com.example.reference_shortener.controller;

import com.example.reference_shortener.model.Shortener;
import com.example.reference_shortener.service.ShortenerService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.ZonedDateTime;

/**
 * Класс ShortenerController
 */
@Controller
@AllArgsConstructor
public class ShortenerController {

	private ShortenerService service;

	@PostMapping("/generate")
	@PreAuthorize("hasAuthority('user:generates')")
	public String showGenerateForm(@RequestParam(value = "originalUrl") String originalUrl, Model model) {
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequest()
			.replacePath(null)
			.build()
			.toUriString(); // получение "localhost"
		String resultString = service.generateShortUrl(originalUrl, baseUrl);
		model.addAttribute("shortUrl", resultString);
		return "short_result";
	}


	@GetMapping("/showAll")
	@PreAuthorize("hasAuthority('user:modifies')")
	public String showAllLinks(Model model) {
		Shortener shortener = new Shortener();
		model.addAttribute("allLinks", service.getAllLinks());
		model.addAttribute("shortener", shortener);
		return "modify_links";
	}

	@GetMapping("/*")
		public String goTo() {
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequest().toUriString();
		String goToUrl = service.findOriginalUrl(baseUrl);
		return "redirect:" + goToUrl;

	}

	@GetMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('user:modifies')")
	public String deleteProduct(@PathVariable(value = "id") int id) {
		service.delById(id);
		return "redirect:/showAll";
	}

}