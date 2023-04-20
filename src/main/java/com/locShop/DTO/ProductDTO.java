package com.locShop.DTO;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import com.locShop.model.CategoryEntity;

public class ProductDTO {

	private Long id;
	
	private Date created_at;

	private Date updated_at;

	private Date delete_at;

	@NotEmpty(message = "tên không được để trống")
	@Length(min = 3, message = "tên sản phẩm phải có ít nhất 3 ký tự")
	private String name;

	@NotEmpty(message = "bạn phải chọn ảnh")
	private String image;

	@NotNull(message = "giá sản phẩm không được đê trống")
	private Float price;

	private Float sale_price;

	private String description;
	
	@NotNull(message = "bạn phải chọn ảnh")
	private MultipartFile fileUpload;
	
	private Long category_id;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}
	

	public ProductDTO(
			@NotEmpty(message = "tên không được để trống") @Length(min = 3, message = "tên sản phẩm phải có ít nhất 3 ký tự") String name,
			@NotEmpty(message = "bạn phải chọn ảnh") String image, Float price, Float sale_price, String description,Long category_id) {
		super();
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


	public MultipartFile getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(MultipartFile fileUpload) {
		this.fileUpload = fileUpload;
	}


	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

}
