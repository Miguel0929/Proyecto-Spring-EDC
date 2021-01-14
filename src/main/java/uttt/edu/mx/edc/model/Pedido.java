package uttt.edu.mx.edc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pedidos")
public class Pedido {

	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "El campo no debe estar Vacio")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="strFechaPedido")
	private Date strFechaPedido;
	
	@NotNull(message = "El campo no debe estar Vacio")
	@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="strFechaEntrega")
	private Date strFechaEntrega;
	
	@NotBlank(message = "El campo no debe estar Vacio")
	@Column(name="strNombreDestinatario")
	private String strNombreDestinatario;
	
	@NotBlank(message = "El campo no debe estar Vacio")
	@Column(name="strDireccionDestinatario")
	private String strDireccionDestinatario;
	
	@NotBlank(message = "El campo no debe estar Vacio")
	@Column(name="strCiudadDestinatario")
	private String strCiudadDestinatario;
	
	@NotBlank(message = "El campo no debe estar Vacio")
	@Column(name="strCodigoPostalDestinatario")
	private String strCodigoPostalDestinatario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStrFechaPedido() {
		return strFechaPedido;
	}

	public void setStrFechaPedido(Date strFechaPedido) {
		this.strFechaPedido = strFechaPedido;
	}

	public Date getStrFechaEntrega() {
		return strFechaEntrega;
	}

	public void setStrFechaEntrega(Date strFechaEntrega) {
		this.strFechaEntrega = strFechaEntrega;
	}

	public String getStrNombreDestinatario() {
		return strNombreDestinatario;
	}

	public void setStrNombreDestinatario(String strNombreDestinatario) {
		this.strNombreDestinatario = strNombreDestinatario;
	}

	public String getStrDireccionDestinatario() {
		return strDireccionDestinatario;
	}

	public void setStrDireccionDestinatario(String strDireccionDestinatario) {
		this.strDireccionDestinatario = strDireccionDestinatario;
	}

	public String getStrCiudadDestinatario() {
		return strCiudadDestinatario;
	}

	public void setStrCiudadDestinatario(String strCiudadDestinatario) {
		this.strCiudadDestinatario = strCiudadDestinatario;
	}

	public String getStrCodigoPostalDestinatario() {
		return strCodigoPostalDestinatario;
	}

	public void setStrCodigoPostalDestinatario(String strCodigoPostalDestinatario) {
		this.strCodigoPostalDestinatario = strCodigoPostalDestinatario;
	}
	
	
	
}
