package uttt.edu.mx.edc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="detalles")
public class DetallePedido {

	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	//@NotNull(message = "El campo no debe estar Vacio")
	@ManyToOne
    @JoinColumn(name = "FK_PEDIDO")
    private Pedido pedido;
	
	@NotNull(message = "El campo no debe estar Vacio")
	@ManyToOne
    @JoinColumn(name = "FK_PRODUCTO")
    private Producto producto;
	
	@NotNull(message = "El campo no debe estar Vacio")
	@Column(name="strCantidad")
	private int strCantidad;
	
	@NotNull(message = "El campo no debe estar Vacio")
	@Column(name="strTotalPagar")
	private Float strTotalPagar;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getStrCantidad() {
		return strCantidad;
	}

	public void setStrCantidad(int strCantidad) {
		this.strCantidad = strCantidad;
	}

	public Float getStrTotalPagar() {
		return strTotalPagar;
	}

	public void setStrTotalPagar(Float strTotalPagar) {
		this.strTotalPagar = strTotalPagar;
	}

	

	
	
	
}
