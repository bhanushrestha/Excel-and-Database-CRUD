package com.bhanucodes.exceltesting.modals;

public class Item {
	private Integer itemId;
	private String name;
	private String brand;
	private String category;
	private double price;
	
	public Item() {
	}

	public Item(Integer itemId, String name, String brand, String category,
			double price) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.price = price;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", brand=" + brand
				+ ", category=" + category + ", price=" + price + "]";
	}
	
	
	
	
}