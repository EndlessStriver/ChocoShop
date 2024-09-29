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
@Table(name = "province")
public class Province {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "province_id")
	private long provinceId;
	
	@Column(name = "province_name", nullable = false)
	private String provinceName;
	
	@OneToMany(mappedBy = "province", fetch = FetchType.LAZY)
	private List<District> districts;
	
	@OneToMany(mappedBy = "province", fetch = FetchType.LAZY)
	private List<Address> address;
	
	@OneToMany(mappedBy = "province", fetch = FetchType.LAZY)
	private List<Order> order;
}
