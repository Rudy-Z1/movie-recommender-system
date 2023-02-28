package io.datajek.spring.basics.movierecommendersystem.lesson14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {

		//ApplicationContext manages the beans and dependencies
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");

		// check beans which have been loaded
		System.out.println("\nBeans loaded: ");
		System.out.println(Arrays.toString(appContext.getBeanDefinitionNames()));

		//use ApplicationContext to find which filter is being used
		RecommenderImplementation recommender = appContext.getBean("recommenderImpl", RecommenderImplementation.class);

		System.out.println(recommender);
		System.out.println(recommender.getFilter());

		System.out.println("\nDependency: " + recommender.getFilter());

		//call method to get recommendations
		String[] result = recommender.recommendMovies("Finding Dory");

		//display results
		System.out.println(Arrays.toString(result));

		appContext.close();
	}
}