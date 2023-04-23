package com.locShop.DTO;

public class ProductDetailsDTO {

	private Long proId;
	
	private String size;
	
	private int quantity;
	
	public ProductDetailsDTO() {
		
	}

	public ProductDetailsDTO(Long proId, String size, int quantity) {
		super();
		this.proId = proId;
		this.size = size;
		this.quantity = quantity;
	}
	public Long getProId() {
		return proId;
	}

	public void setProId(Long proId) {
		this.proId = proId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
