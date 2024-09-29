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
@Table(name = "ward")
public class Ward {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ward_id")
	private long wardId;
	
	@Column(name = "ward_name", nullable = false)
	private String wardName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "district_id")
	private District district;
	
	@OneToMany(mappedBy = "ward", fetch = FetchType.LAZY)
	private List<Address> address;
	
	@OneToMany(mappedBy = "ward", fetch = FetchType.LAZY)
	private List<Order> orders;
	
}
