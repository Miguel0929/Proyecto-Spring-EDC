package uttt.edu.mx.edc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="proveedores")
public class Proveedor {

	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "El campo no debe estar Vacio")
	@Column(name="strNombreProveedor")
	private String strNombreProveedor;
	
	@NotBlank(message = "El campo no debe estar Vacio")
	@Column(name="strDireccion")
	private String strDireccion;
	
	@NotBlank(message = "El campo no debe estar Vacio")
	@Pattern(regexp="(^$|[0-9]{7})")
	@Column(name="strTelefono")
	private String strTelefono;
	
	@NotBlank(message = "El campo no debe estar Vacio")
	@Pattern(regexp="(^$|[0-9]{10})")
	@Column(name="strCelular")
	private String strCelular;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStrNombreProveedor() {
		return strNombreProveedor;
	}


	public void setStrNombreProveedor(String strNombreProveedor) {
		this.strNombreProveedor = strNombreProveedor;
	}


	public String getStrDireccion() {
		return strDireccion;
	}


	public void setStrDireccion(String strDireccion) {
		this.strDireccion = strDireccion;
	}


	public String getStrTelefono() {
		return strTelefono;
	}


	public void setStrTelefono(String strTelefono) {
		this.strTelefono = strTelefono;
	}


	public String getStrCelular() {
		return strCelular;
	}


	public void setStrCelular(String strCelular) {
		this.strCelular = strCelular;
	}
	
	
}
