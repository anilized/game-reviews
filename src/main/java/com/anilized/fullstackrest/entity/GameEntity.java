package com.anilized.fullstackrest.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameEntity {

	private String name;

	private String id;

	private String slug;

	private String storyline;

	private String summary;

	private String rating;

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getStoryLine() {
		return storyline;
	}

	public void setStoryLine(String storyline) {
		this.storyline = storyline;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public GameEntity() {
	}

	public GameEntity(String name, String id, String slug, String storyline, String summary, String rating) {
		super();
		this.name = name;
		this.id = id;
		this.slug = slug;
		this.storyline = storyline;
		this.summary = summary;
		this.rating = rating;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
