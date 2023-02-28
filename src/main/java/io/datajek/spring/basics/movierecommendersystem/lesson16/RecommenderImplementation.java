package io.datajek.spring.basics.movierecommendersystem.lesson16;

import io.datajek.spring.basics.movierecommendersystem.lesson2.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommenderImplementation {
    @Autowired
    private Filter filter;

    public RecommenderImplementation() {
        super();
    }

    public String[] recommendMovies(String movie) {
        System.out.println("Name of the filter in use: " + filter + "\n");
        String[] result = filter.getRecommendations(movie);
        return result;
    }

}
