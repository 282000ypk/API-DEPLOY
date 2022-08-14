package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/data")
public class NewsController {
	
	@Value("${newsapi.key}")
	String apikey;

    @GetMapping
    public String getData(){
    	String image = WebClient.create("https://newsapi.org/v2/top-headlines?country=us&apiKey=" + apikey)
    	        .get()
    	        .retrieve()
    	        .bodyToMono(String.class)
    	        .block();
    	return image;
    }
}
