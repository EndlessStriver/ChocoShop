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
@Table(name = "district")
public class District {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "district_id")
	private long districtId;
	
	@Column(name = "district_name", nullable = false)
	private String districtName;
	
	@OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
	private List<Ward> wards;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "province_id")
	private Province province;
	
	@OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
	private List<Address> addresses;
	
	@OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
	private List<Order> orders;
}
