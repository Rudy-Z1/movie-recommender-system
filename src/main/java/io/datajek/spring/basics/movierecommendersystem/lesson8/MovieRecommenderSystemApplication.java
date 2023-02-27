package io.datajek.spring.basics.movierecommendersystem.lesson8;

import io.datajek.spring.basics.movierecommendersystem.lesson7.RecommenderImplementation2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {
		// ApplicationContext manages beans and dependencies
		ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);

		// Demonstration for singleton scope (default)
		ContentBasedFilter cbf1 = appContext.getBean(ContentBasedFilter.class);
		ContentBasedFilter cbf2 = appContext.getBean(ContentBasedFilter.class);
		ContentBasedFilter cbf3 = appContext.getBean(ContentBasedFilter.class);

		System.out.println(cbf1);
		System.out.println(cbf2);
		System.out.println(cbf3);

		// Demonstration for prototype scope
		CollaborativeFilter cf1 = appContext.getBean(CollaborativeFilter.class);
		CollaborativeFilter cf2 = appContext.getBean(CollaborativeFilter.class);
		CollaborativeFilter cf3 = appContext.getBean(CollaborativeFilter.class);

		System.out.println(cf1);
		System.out.println(cf2);
		System.out.println(cf3);
	}

}
