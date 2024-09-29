package entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "publisher")
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "publisher_id")
	private long publisherId;
	
	@Column(name = "publisher_name", nullable = false)
	private String publisherName;
	
	@Column(name = "phone_number", nullable = false, unique = true)
	private String phoneNumber;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
	private List<Product> products;
	
}
