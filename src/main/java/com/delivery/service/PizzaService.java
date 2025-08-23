package com.delivery.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delivery.persistence.entity.Pizza;
import com.delivery.persistence.repository.PizzaPagSortRepository;
import com.delivery.persistence.repository.PizzaRepository;
import com.delivery.service.dto.UpdatePizzaPriceDto;
import com.delivery.service.exception.EmailApiException;

@Service
public class PizzaService {

	private final PizzaRepository pizzaRepository;
	private final PizzaPagSortRepository pizzaPagSortRepository;

	public PizzaService(PizzaRepository pizzaRepository,
			PizzaPagSortRepository pizzaPagSortRepository) {
		super();
		this.pizzaRepository = pizzaRepository;
		this.pizzaPagSortRepository = pizzaPagSortRepository;
	}

	public Page<Pizza> getAll(int page, int elements) {
		Pageable pageRequest = PageRequest.of(page, elements);
		return pizzaPagSortRepository.findAll(pageRequest);
	}
	
	public Page<Pizza> getAvailable(int page, int elements, String sortBy, String sortDirection) {
		//System.out.println("count:" + this.pizzaRepository.countByVeganTrue());
		//return this.pizzaRepository.findAllByAvailableTrueOrderByPrice();
		Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
		Pageable pageRequest = PageRequest.of(page, elements, sort);
		return this.pizzaPagSortRepository.findByAvailableTrue(pageRequest);
	}
	
	public Pizza getByName(String name) {
		return this.pizzaRepository
				.findFirstByAvailableTrueAndNameIgnoreCase(name)
				.orElseThrow(() -> new RuntimeException("la pizza no existe"));
	}
	
	public List<Pizza> getWith(String ingredient) {
		return this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingredient);
	}
	
	public List<Pizza> getWithout(String ingredient) {
		return this.pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingredient);
	}
	
	public List<Pizza> getCheapest(double price) {
		return this.pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
	}

	public Pizza get(int id) {
		return pizzaRepository.findById(id).orElse(null);
	}
	
	public Pizza save(Pizza pizza) {
		return pizzaRepository.save(pizza);
	}
	
	public void delete(int id) {
		this.pizzaRepository.deleteById(id);
	}
	
	@Transactional(noRollbackFor = EmailApiException.class)
	public void updatePrice(UpdatePizzaPriceDto dto) {
		this.pizzaRepository.updatePrice(dto);
		this.sendEmail();
	}
	
	private void sendEmail() {
		throw new EmailApiException("Error al enviar el email! ...");
	}
	
	public boolean existe(int id) {
		return pizzaRepository.existsById(id); 
	}
	
	

}
