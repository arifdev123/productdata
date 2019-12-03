package in.co.javacoder.product.repository;

import org.springframework.data.repository.CrudRepository;

import in.co.javacoder.product.entities.Product;

public interface ProductRespository extends CrudRepository<Product, Integer> {

}
