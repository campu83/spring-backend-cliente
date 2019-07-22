package com.aecg.springboot.backend.apirest.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true, length = 20)
	private String username;

	@Column(length = 60)
	private String password;

	private Boolean enabled;

	// Relacion de muchos a muchos. Con carga perezosa
	// La cascada es para que la creación o eliminación de
	// usuario o de sus roles se haran en cascada.
	// Esto provoca la creación de una tabla intermedia de relación entre ambas.
	// Con joinTable definimos la creación de la tabla y los nombres de las
	// foreign keys. No es necesario ya que se crea automáticamente cogiendo los
	// nombres de ambas tablas
	// Con uniqueConstraints indicamos que no se puede repetir esta relación.
	@ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name = "usuarios_roles",
			joinColumns =  @JoinColumn(name="usuario_id"),
			inverseJoinColumns = @JoinColumn(name= "role_id"),
			uniqueConstraints =  {@UniqueConstraint(columnNames =  {"usuario_id", "role_id"})})
	private List<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
