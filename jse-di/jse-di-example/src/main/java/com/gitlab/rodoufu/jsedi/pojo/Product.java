package com.gitlab.rodoufu.jsedi.pojo;

import java.util.Random;

public class Product {
	private Integer id;
	private String name;

	public Product() {
		setId(new Random().nextInt(1000));
		setName(String.format("%s%03d", getClass().getSimpleName(), getId()));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
