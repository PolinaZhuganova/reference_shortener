/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.example.reference_shortener.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Класс AUser
 */
@Data
@Entity
@Table(name="shortener_users")
public class AUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "role")
	private Role role;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@Column(name = "password")
	private String password;

	@Column(name = "name")
	private String name;


}