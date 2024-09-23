package Entity;

import java.time.LocalDateTime;
import java.util.List;

import Entity.Enum.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "user_name", unique = true, nullable = false)
	private String userName;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "phone_number", unique = true, nullable = false)
	private String phoneNumber;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "gender", nullable = false)
	private boolean gender;
	
	@Column(name = "avatar", nullable = true)
	private String avatar;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "birthday", nullable = false)
	private LocalDateTime birthday;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false)
	private Role role;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Order> orders;
}
