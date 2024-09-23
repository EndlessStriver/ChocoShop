package Entity;

import java.time.LocalDateTime;
import java.util.List;

import Entity.Enum.OrderStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private long orderId;
	
	@Column(name = "order_date", nullable = false)
	private LocalDateTime orderDate;
	
	@Column(name = "total_amount", nullable = false)
	private double totalAmount;
	
	@Column(name = "status", nullable = true)
	private String note;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	private List<OrderDetail> orderDetails;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "order_status")
	private OrderStatus orderStatus;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "province_id")
	private Province province;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "district_id")
	private District district;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ward_id")
	private Ward ward;
}
