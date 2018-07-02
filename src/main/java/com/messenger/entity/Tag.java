package com.messenger.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Tag {
	@NotNull
	//@Pattern(regexp="[a-zA-Z]")
	@Size(min = 2, message = "Name should have at least two charaters")
	private String name;

	@NotNull
	@Min(value=1,message="Id should have at least 1")
	@Max(1000)
	private Integer id;

	@Min(0)
	private int like;
	
	public String getName() {
		return name;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
