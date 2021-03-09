package com.example.mid.models;

	import java.util.Set;

	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.ManyToMany;
	import javax.persistence.OneToOne;
	import javax.persistence.Transient;
	import javax.validation.constraints.Email;
	import javax.validation.constraints.NotBlank;

	import com.fasterxml.jackson.annotation.JsonBackReference;

	//import lombok.Builder;
	import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

	@Entity
	@Getter
	@Setter
	
	//@Builder // to generate builder function & Constructor
	@NoArgsConstructor
	@Data	//Give setters,getters and toString
	public class User {
		
			@Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private int id;

		    @Column(nullable = false)
		    @NotBlank(message = "This field is required")
		    private String username;

		    @Column(nullable = false)
		    @NotBlank(message = "This field is required")
		    private String password;

		    @NotBlank(message = "This field is required")
		    @Transient
		    private String passwordConfirmation;

		    @Column(nullable = false)
		    @NotBlank(message = "This field is required")
		    @Email(message = "Invalid email")
		    private String email;

		    private boolean active;

		    @ManyToMany(fetch = FetchType.LAZY)
		    @JsonBackReference
		    private Set<Role> roles;
		    
		    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
		    private Employee emp;
		    
		    public User(String username, String password, String role, boolean active, Employee emp) {
				super();
				this.username = username;
				this.password = password;
				this.active = active;
				this.emp = emp;
			}
	}

