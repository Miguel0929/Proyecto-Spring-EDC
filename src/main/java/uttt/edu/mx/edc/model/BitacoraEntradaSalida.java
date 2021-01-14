package uttt.edu.mx.edc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bitacora")
public class BitacoraEntradaSalida {

	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	

	@Column(name="strFechaPedido")
	private Date strFechaHora;
	
	
	@Column(name="strDescripcion")
	private String strDescripcion;
	
	@Column(name="strCantidad")
	private int strCantidad;
	
	@Column(name="strStatus")
	private String strStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStrFechaHora() {
		return strFechaHora;
	}

	public void setStrFechaHora(Date strFechaHora) {
		this.strFechaHora = strFechaHora;
	}

	public String getStrDescripcion() {
		return strDescripcion;
	}

	public void setStrDescripcion(String strDescripcion) {
		this.strDescripcion = strDescripcion;
	}

	public int getStrCantidad() {
		return strCantidad;
	}

	public void setStrCantidad(int strCantidad) {
		this.strCantidad = strCantidad;
	}

	public String getStrStatus() {
		return strStatus;
	}

	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}
	
	
	
	
}
