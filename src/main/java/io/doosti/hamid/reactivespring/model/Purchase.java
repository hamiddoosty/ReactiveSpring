package io.doosti.hamid.reactivespring.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Purchase {

	private final String name;
	private final String price;
	private final LocalDateTime createAt;
	
	@Id
	private String id;

	public String getId() {
		return id;
	}

	public Purchase(String name, String price, LocalDateTime createAt) {
		super();
		this.name = name;
		this.price = price;
		this.createAt = createAt;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}
	
	
	
	
}
