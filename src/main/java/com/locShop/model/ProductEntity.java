package com.locShop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "created_at")
	private Date created_at;

	@Column(name = "updated_at")
	private Date updated_at;

	@Column(name = "delete_at")
	private Date delete_at;

	@Column(name = "name")
	private String name;

	@Column(name = "image")
	private String image;

	@NotNull(message = "giá sản phẩm không được đê trống")
	@Column(name = "price")
	private Float price;

	@Column(name = "sale_price")
	private Float sale_price;

	@Column(name = "description")
	private String description;

	@ManyToOne()
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private CategoryEntity category_id;

	public ProductEntity() {

	}

	public ProductEntity(Long id, Date created_at, Date updated_at, Date delete_at, String name, String image,
			Float price, Float sale_price, String description, CategoryEntity category_id) {
		super();
		this.id = id;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.delete_at = delete_at;
		this.name = name;
		this.image = image;
		this.price = price;
		this.sale_price = sale_price;
		this.description = description;
		this.category_id = category_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Date getDelete_at() {
		return delete_at;
	}

	public void setDelete_at(Date delete_at) {
		this.delete_at = delete_at;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getSale_price() {
		return sale_price;
	}

	public void setSale_price(Float sale_price) {
		this.sale_price = sale_price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CategoryEntity getCategory_id() {
		return category_id;
	}

	public void setCategory_id(CategoryEntity category_id) {
		this.category_id = category_id;
	}

	

}
