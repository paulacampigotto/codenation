package br.com.codenation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		Double soma = Double.valueOf(0);
		for(OrderItem item: items) {
			if(productRepository.findById(item.getProductId()).get() == null) continue;
			Product product = productRepository.findById(item.getProductId()).get();
			if(product.getIsSale()) soma+= (product.getValue()*item.getQuantity()*.8);
			else soma+= (product.getValue()*item.getQuantity());
		}
		return soma;
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		Set<Product> products = new HashSet<Product>();
		for(Long id: ids) {
			if(productRepository.findById(id).get() == null) continue;
			Product product = productRepository.findById(id).get();
			products.add(product);
		}
		return products;
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		Double soma = Double.valueOf(0);
		for(List<OrderItem> lista: orders) {
			soma+= calculateOrderValue(lista);
		}
		return soma;
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		Map<Boolean, List<Product>> products = new HashMap<Boolean, List<Product>>();
		List<Product> isSale = new ArrayList<>();
		List<Product> isNotSale = new ArrayList<>();
		for(Long id: productIds) {
			if(productRepository.findById(id).get() == null) continue;
			Product product = productRepository.findById(id).get();
			if(product.getIsSale()) isSale.add(product);
			else isNotSale.add(product);
		}
		products.put(true, isSale);
		products.put(false, isNotSale);
		return products;
	}

}