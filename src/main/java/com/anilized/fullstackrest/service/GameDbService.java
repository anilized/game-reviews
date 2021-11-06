package com.anilized.fullstackrest.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.anilized.fullstackrest.constants.Constants;
import com.anilized.fullstackrest.entity.GameEntity;

import kong.unirest.GenericType;
import kong.unirest.HttpResponse;

import kong.unirest.Unirest;

@Service
public class GameDbService {

	public List<GameEntity> getNameById(String limit) {
		HttpResponse<List<GameEntity>> jsonResponse = Unirest.post(Constants.ENDPOINT + "games")
				.header("Client-ID", Constants.CLIENT_ID).header("Authorization", Constants.ACCESS_TOKEN)
				.header("Accept", "application/json").body("fields name; limit " + limit + ";")
				.asObject(new GenericType<List<GameEntity>>() {
				});

		List<GameEntity> games = jsonResponse.getBody();
		System.out.println(games);
		return games;

	}

	public List<GameEntity> getTopHundred(String startRating, String endRating) {
		HttpResponse<List<GameEntity>> jsonResponse = Unirest.post(Constants.ENDPOINT + "games")
				.header("Client-ID", Constants.CLIENT_ID).header("Authorization", Constants.ACCESS_TOKEN)
				.header("Accept", "application/json")
				.body("fields name, " + "slug, " + "storyline, " + "summary, " + "rating, " + "rating_count, "
						+ "total_rating; " + "limit 100; " + "where total_rating > " + startRating + "& total_rating < "
						+ endRating + "; " + "sort total_rating_count desc; ")

				.asObject(new GenericType<List<GameEntity>>() {
				});
		
		List<GameEntity> top100Games = jsonResponse.getBody();
		return top100Games;
	}

}
