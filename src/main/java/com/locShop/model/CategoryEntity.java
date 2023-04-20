package com.locShop.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "category",uniqueConstraints = {
		@UniqueConstraint(columnNames = "name")
})
public class CategoryEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@CreationTimestamp
	@Column(name = "created_at")
	private Date created_at;
	
	@Column(name = "updated_at",nullable = true)
	private Date updated_at;
	
	@Column(name = "delete_at",nullable = true)
	private Date delete_at;
	
	@NotNull(message = "tên danh mục không được đê trống")
	@Column(name = "name")
	private String name;
	
	@Column(name = "status")
	private int status;
	
	@OneToMany(mappedBy = "id",fetch = FetchType.EAGER)
	private List<ProductEntity> listProducts;
	
	public CategoryEntity() {
		
	}

	public CategoryEntity(Long id, Date created_at, Date updated_at, Date delete_at, String name, int status,
			List<ProductEntity> listProducts) {
		super();
		this.id = id;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.delete_at = delete_at;
		this.name = name;
		this.status = status;
		this.listProducts = listProducts;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<ProductEntity> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<ProductEntity> listProducts) {
		this.listProducts = listProducts;
	}

	
}
