package entity;

import java.time.LocalDate;
import java.util.List;

import entity.enumtype.Role;
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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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
	
	@NotBlank(message = "Username is mandatory")
	@Column(name = "user_name", unique = true, nullable = false)
	private String userName;
	
	@NotBlank(message = "First name is mandatory")
	@Size(min = 1, max = 50, message = "First name must be between 1 and 50 characters")
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@NotBlank(message = "Last name is mandatory")
	@Size(min = 1, max = 50, message = "Last name must be between 1 and 50 characters")
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@NotBlank(message = "Phone number is mandatory")
	@Size(min = 10, max = 10, message = "Phone number must be 10 characters")
	@Column(name = "phone_number", unique = true, nullable = false)
	private String phoneNumber;
	
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email is invalid")
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@NotNull(message = "Gender cannot be empty")
    @Column(name = "gender", nullable = false)
    private boolean gender;

    @Size(max = 255, message = "Avatar cannot exceed 255 characters")
    @Column(name = "avatar", nullable = true)
    private String avatar;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull(message = "Birthday cannot be empty")
    @Past(message = "Birthday must be a past date")
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Role cannot be empty")
    @Column(name = "role", nullable = false)
    private Role role;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Order> orders;
}
