package com.spring.app.jokes.services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class JokeService {

    private ChuckNorrisQuotes quotes;

    public JokeService(ChuckNorrisQuotes quotes) {
        this.quotes = quotes;
    }

    public String getJoke() {
        return quotes.getRandomQuote();
    }
}
