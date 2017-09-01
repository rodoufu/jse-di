package com.gitlab.rodoufu.jsedi.pojo;

import java.util.Random;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Store {
	private Integer id;
	private String name;

	public Store() {
		setId(new Random().nextInt(100));
		setName(String.format("%s%02d", getClass().getSimpleName(), getId()));
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
