package io.datajek.spring.basics.movierecommendersystem.lesson11;

import io.datajek.spring.basics.movierecommendersystem.lesson2.Filter;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class ContentBasedFilter implements Filter {

    private static int instances = 0;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ContentBasedFilter() {
        instances++;
        System.out.println("ContentBasedFilter constructor called");
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("In ContentBasedFilter postConstruct method");
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("In ContentBasedFilter preDestroy method");
    }

    public static int getInstances() {
        return instances;
    }

    public String[] getRecommendations(String movie) {
        return new String[] {"Happy Feet", "Ice Age", "Shark Tale"};
    }
}
