package com.product.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cate_id")
	@NotNull
	private int categoryId;

	@Column(name = "category_name")
	@NotNull
	private String categoryName;
	
	@Column(name="ngay_thang")
	@NotNull
	private String date;
	
	/*@OneToMany
	private List<ProductEntity> list;

	public List<ProductEntity> getList() {
		return list;
	}

	public void setList(List<ProductEntity> list) {
		this.list = list;
	}*/

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
