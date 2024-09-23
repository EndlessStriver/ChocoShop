package Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "price_history")
public class PriceHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "price_history_id")
	private long priceHistoryId;
	
	@Column(name = "pricce_change_date", nullable = false)
	private LocalDateTime priceChangeDate;
	
	@Column(name = "previous_price", nullable = false)
	private double previousPrice;
	
	@Column(name = "new_price", nullable = false)
	private double newPrice;
	
	@Column(name = "price_change_reason", nullable = false)
	private String priceChangeReason;
	
	@Column(name = "effective_date", nullable = false)
	private LocalDateTime effectiveDate;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@OneToMany(mappedBy = "priceHistory")
	private OrderDetail orderDetail;
}
