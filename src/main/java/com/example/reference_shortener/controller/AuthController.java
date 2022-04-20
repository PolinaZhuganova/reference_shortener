/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.example.reference_shortener.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Класс AuthController
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

	@GetMapping("/login")
	public String getLoginPage() {

		return "login";
	}

	@GetMapping("/loggedIn")
	public String getSuccessPage() {
		return "loggedIn";
	}
}