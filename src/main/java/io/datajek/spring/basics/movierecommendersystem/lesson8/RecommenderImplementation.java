package io.datajek.spring.basics.movierecommendersystem.lesson8;

import io.datajek.spring.basics.movierecommendersystem.lesson2.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {
    private Filter filter;

    // Constructor injection
    @Autowired
    public RecommenderImplementation(@Qualifier("CF") Filter filter) {
        this.filter = filter;
        System.out.println("Constructor invoked...");
    }

    public String[] recommendMovies(String movie) {
        System.out.println("Name of the filter in use: " + filter + "\n");
        String[] result = filter.getRecommendations(movie);
        return result;
    }
}
