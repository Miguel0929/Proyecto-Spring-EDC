package uttt.edu.mx.edc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="productos")
public class Producto {

	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "El campo no debe estar Vacio")
	@Column(name="strDescripcion")
	private String strDescripcion;
	
	@NotNull(message = "El campo no debe estar Vacio")
	@Column(name="strPrecioUnidad")
	private Float strPrecioUnidad;
	
	@NotNull(message = "El campo no debe estar Vacio")
	@Column(name="strStock")
	private int strStock;
	
	@NotNull(message = "El campo no debe estar Vacio")
	@OneToOne
    @JoinColumn(name = "FK_PROVEEDOR", updatable = false, nullable = false)
    private Proveedor proveedor;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStrDescripcion() {
		return strDescripcion;
	}


	public void setStrDescripcion(String strDescripcion) {
		this.strDescripcion = strDescripcion;
	}


	public Float getStrPrecioUnidad() {
		return strPrecioUnidad;
	}


	public void setStrPrecioUnidad(Float strPrecioUnidad) {
		this.strPrecioUnidad = strPrecioUnidad;
	}


	public int getStrStock() {
		return strStock;
	}


	public void setStrStock(int strStock) {
		this.strStock = strStock;
	}


	public Proveedor getProveedor() {
		return proveedor;
	}


	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


	


	
	
}
