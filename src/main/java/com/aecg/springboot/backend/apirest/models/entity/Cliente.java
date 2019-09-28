package com.aecg.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@Entity
@Table(name="clientes")
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@NotEmpty(message = "no puede estar vacio")
	@Size(min=4, max=12, message= "el tamaño tiene que estar entre 4 y 12")
	@Column(nullable=false)
	private String nombre;

	@NotEmpty(message = "no puede estar vacio")
	private String apellido;

	@NotEmpty(message = "no puede estar vacio")
	@Email(message ="no es una dirección de correo bien formada")
	@Column(nullable=false, unique=true)
	private String email;

	@NotNull(message = "no puede estar vacio")
	@Column(name ="create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	private String foto;

	@NotNull(message = "la región no puede ser vacia")
	// Muchos clientes pueden ser de una sola región por eso hacemos una relacion Many to One y le asignamos la carga perezosa.
	@ManyToOne(fetch=FetchType.LAZY)
	// Definimos el nombre que se va a crear en la relación, pero si no lo creamos se crearía automáticamente igual.
	@JoinColumn(name="region_id")
	// Cuando generemos el json hay que excluir los campos propios de la gestión del framework que nada tienen que ver con
	// el objeto, ignoramos el hibernateLazyInitializer y el handler.
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Region region;
	
	//mappedBy="cliente" tiene que coincidir con el nombre de la variable Cliente en la clase factura.
	@JsonIgnoreProperties(value={"cliente","hibernateLazyInitializer","handler"}, allowSetters=true)
	@OneToMany(fetch=FetchType.LAZY, mappedBy="cliente", cascade=CascadeType.ALL)
	private List<Factura> facturas;

	public Cliente() {
		this.facturas = new ArrayList<>();
	}
	
	/* Queremos que el campo se rellene obligatoriamente por lo que quitamos la condición prePersist.
	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}*/


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public List<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
}
