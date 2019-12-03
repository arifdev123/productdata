package in.co.javacoder.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import in.co.javacoder.product.entities.Product;
import in.co.javacoder.product.repository.ProductRespository;

@SpringBootTest
class ProductdataApplicationTests {
	
	@Autowired
	private ProductRespository productRepository;

	//@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreateProduct() {
		
		Product product = new Product();
		product.setId(2);
		product.setName("moto");
		product.setDesc("Excellent");
		product.setPrice(400.0);
		
		productRepository.save(product);
	}
	
	@Test
	public void testReadProductDetail() {
		Optional<Product> product = productRepository.findById(1);
		assertNotNull(product);
		assertEquals("iPhone", product.get().getName());
	}
	
	@Test
	public void testUpdateProductInfo() {
		Product product = productRepository.findById(1).get();
		product.setPrice(1300d);
		productRepository.save(product);
	}
	
	@Test
	public void testDeleteProduct() {
		
		productRepository.deleteById(1);
	}
	
	@Test
	public void testExistsById() {
		
		String stock = productRepository.existsById(1)? "exists" : "NA";
		System.out.println(stock);
	}
	
	@Test
	public void testCount() {
		
		long totalRecordsInProductTable = productRepository.count();
		System.out.println(totalRecordsInProductTable);
	}
	
	

}
