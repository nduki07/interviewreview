package com.ppra.interview.RestClientRevision.RestCleintService;

import com.ppra.interview.RestClientRevision.RestCleintModel.NewsResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class NewsService {
    @Value("${api.key}")
    public String apiKey;

    @Value("${baseUrl}")
    private String baseUrl;

    private String url ="/v2/everything";

    private RestClient restClient;

    @PostConstruct
    public void init(){
        restClient= RestClient.builder().baseUrl(baseUrl).build();
    }
    public NewsResponse newsResponse(String q,String from,String sortedBy){
        return restClient.get().uri("/v2/everything?q={q}&from={from}&sortBy={sortedBy}&apiKey={apiKey}",q,from,sortedBy,apiKey)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        (request,response)->{throw new RuntimeException("client error while while fetching news");})
                .onStatus(HttpStatusCode::is5xxServerError,((request, response) -> {
                    throw new RuntimeException("server error");
                })).body(NewsResponse.class);


    }

}
