package com.anilized.fullstackrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anilized.fullstackrest.entity.GameEntity;
import com.anilized.fullstackrest.service.GameDbService;

@RestController
public class GameDbController {

	@Autowired
	GameDbService service;

	@GetMapping("games/{limit}")
	public List<GameEntity> findGameByName(@PathVariable String limit) {
		List<GameEntity> games = service.getNameById(limit);
		return games;
	}
	
	@GetMapping("/top100")
	public List<GameEntity> topHundredGames(@RequestParam(name = "start", required = true) String start, @RequestParam(name = "end", required = true) String end){
		List<GameEntity> games =  service.getTopHundred(start, end);
		return games;
	}

}
