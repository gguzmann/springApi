package com.generation.models;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="usuarios")

public class Usuario {
	
	//Atributos 
	@Id // PRIMARY KEY
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
	private Long id;
	
	@Size(min=3, max=50)
	private String nombre;
	
	private String apellido;
	@NotNull
	private Integer edad;
	@NotNull
	private String password;
	

	@Column(updatable = false) // INDicA QUQE NO VA A PODER SER ACTUALIZAR
	private Date createdAt; // guarda fecha cuando se inserta dato
	
	private Date updatedAt; // Guarda fecha cuando se actualiza dato
	
	
		
	// Tabla Asociada sin fk.	Si se elimina algo, se elimina licencia
	@OneToOne(mappedBy="usuario", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Licencia licencia;

	//ManyToMany con roles
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="roles_usuarios",							// nombre tabla relacional
			joinColumns = @JoinColumn(name="usuario_id", nullable = false),	// columna entidad local
			inverseJoinColumns = @JoinColumn(name="rol_id", nullable = false)	// columna entidad externa
			)
	private List<Rol> roles;
	
	//Constructor
	public Usuario() {
		super();
	}

	

	public Usuario(Long id, @Size(min = 3, max = 50) String nombre, String apellido, @NotNull Integer edad,
			@NotNull String password, Date createdAt, Date updatedAt, Licencia licencia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.licencia = licencia;
	}



	//Getter and Setter
	
	
	public String getNombre() {
		return nombre;
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
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

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public Licencia getLicencia() {
		return licencia;
	}

	public void setLicencia(Licencia licencia) {
		this.licencia = licencia;
	}

	
	
	public List<Rol> getRoles() {
		return roles;
	}



	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}



	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    

	
}