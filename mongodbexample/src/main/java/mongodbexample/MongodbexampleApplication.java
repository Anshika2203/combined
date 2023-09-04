package mongodbexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static spark.Spark.port;


public class MongodbexampleApplication {

	public static void main(String[] args) {
		port(8080);
	}

}
