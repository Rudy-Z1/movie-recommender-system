package io.datajek.spring.basics.movierecommendersystem.lesson9;

import io.datajek.spring.basics.movierecommendersystem.lesson8.CollaborativeFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages="io.datajek.spring.basics.movierecommendersystem.lesson10")
@ComponentScan(includeFilters = @ComponentScan.Filter (type = FilterType.REGEX, pattern = "io.datajek.spring.basics.movierecommendersystem.lesson9.*"))
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class);

		// Retrieve singleton bean of CBF from appContext
		ContentBasedFilter filter = appContext.getBean(ContentBasedFilter.class);
		System.out.println("\nContentBasedFilter with singleton scope");
		System.out.println(filter);

		// Retrieve prototype beans from the singleton bean thrice
		Movie movie1 = filter.getMovie();
		Movie movie2 = filter.getMovie();
		Movie movie3 = filter.getMovie();

		System.out.println("\nMovie beans with prototype scope");
		System.out.println(movie1);
		System.out.println(movie2);
		System.out.println(movie3);

		// Print out instances numbers of each kind of bean
		System.out.println("\nContentBasedFilter instance(s) created: " + ContentBasedFilter.getInstances());
		System.out.println("\nMovie instance(s) created: " + Movie.getInstances());

		//
		System.out.println("ContentBasedFilter bean found = " + appContext.containsBean("contentBasedFilter"));
		System.out.println("CollaborativeFilter bean found = " + appContext.containsBean("collaborativeFilter"));
	}

}
