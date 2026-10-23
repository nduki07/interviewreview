package com.ppra.interview.RestClientRevision.RestClientController;

import com.ppra.interview.RestClientRevision.RestCleintModel.NewsResponse;
import com.ppra.interview.RestClientRevision.RestCleintService.NewsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class Newsontroller {
    private final NewsService newsService;
    public Newsontroller(NewsService newsService){
        this.newsService=newsService;
    }
    @GetMapping("/news")
    public NewsResponse getNews(@RequestParam String q, @RequestParam String from, @RequestParam String sortBy){
        return newsService.newsResponse(q,from,sortBy);
    }
}