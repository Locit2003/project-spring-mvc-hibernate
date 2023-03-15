package com.locShop.model;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class BookEntity {
	@NotNull(message = "id không được đê trống")
	private Long bookId;
	
	@NotNull(message = "tên không được đê trống")
	@Length(min=3, max=150)
	private String bookName;
	
	@NotNull(message = "tác giả không được đê trống")
	@Length(min=3, max=150)
	private String author;
	
	@NotNull(message = "nhà sản xuất không được đê trống")
	@Length(min=3, max=150)
	private String producer;
	
	private String image;
	
	@NotNull(message = "ngày tạo không được đê trống")
	@DateTimeFormat(pattern = "dd/MM/YYYY", fallbackPatterns = "bạn phải nhập đúng định dạng")
	private String createdAt;
	
	@NotNull(message = "số lượng trang không được đê trống")
	private int quantityPage;
	
	@NotNull(message = "giá không được đê trống")
	private Float price;
	
	@NotNull(message = "bạn phải chọn ảnh")
	private MultipartFile fileUpload;
	
	public Long getBookId() {
		return bookId;
	}
	
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public int getQuantityPage() {
		return quantityPage;
	}
	public void setQuantityPage(int quantityPage) {
		this.quantityPage = quantityPage;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public MultipartFile getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(MultipartFile fileUpload) {
		this.fileUpload = fileUpload;
	}
	
	
}
