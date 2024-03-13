package jp.ac.group.manage.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
 
@Data
@Entity
@Table(name = "productlist")
public class ProductList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
 
	@Column(length = 64, nullable = false)
	private String name;
	
	@Column(length = 64, nullable = false)
	private Integer number;
	
	@Column(length = 64, nullable = false)
	private Integer price;
	
	@Column(length = 64, nullable = false)
	private Integer stock;
	 
	
	
	public long getId() {
		return id;
	}
	public void  setId(long id) {
		this.id = id;
	}
	public String getName () {
		return name;
	}
	public void getName(String name) {
		this.name = name;
	}
	public Integer getNumber () {
		return number;
	}
	public void getNumber(Integer number) {
		this.number = number;
	}
	public Integer getPrice () {
		return price;
	}
	public void getPrice(Integer price) {
		this.price = price;
	}
	public Integer getStock () {
		return stock;
	}
	public void getStock(Integer stock) {
		this.price = stock;
	}

}