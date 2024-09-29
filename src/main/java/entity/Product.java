package entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private long productId;
	
	@Column(name = "product_name", nullable = false)
	private String productName;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "dimension", nullable = false)
	private String dimension;
	
	@Column(name = "weight", nullable = false)
	private double weight;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private List<Image> images;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private List<PriceHistory> priceHistories;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private List<OrderDetail> orderDetails;
	
}
