package com.ppra.interview.RestClientRevision.RestCleintModel;

import lombok.Data;

import java.util.List;

@Data
public class NewsResponse {
    private String status;
    private int totalResults;
    private List<Articles> articles;

}
