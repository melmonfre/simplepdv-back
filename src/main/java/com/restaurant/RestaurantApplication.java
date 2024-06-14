package com.restaurant;

import com.restaurant.models.Enums.Categoria;
import com.restaurant.models.Enums.Medida;
import com.restaurant.models.ProductsEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

}
