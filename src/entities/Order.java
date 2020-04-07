package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date moment;
	private OrderStatus status;
	private Client cliente;
	
	List<OrderItem> items = new ArrayList<>();
	
	public Order() {
		
	}

	public Order(Date moment, OrderStatus status, Client cliente) {
		this.moment = moment;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}

	public List<OrderItem> getOrders() {
		return items;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double total=0;
		for(OrderItem i : items) {
			total+=i.subTotal();
		}
		return total;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		 sb.append("Order moment:" + sdf.format(moment)+"\n");
		 sb.append("Order status: "+status+"\n");
		 sb.append("Client: "+cliente.getName()+ " ("+sdf2.format(cliente.getBirthDate())+") - "+cliente.getEmail()+"\n");
		 sb.append("Order items:\n");
		 for(OrderItem i : items) {
			 sb.append(i.getProduto().getName()+ ", $" + String.format("%.2f", i.getProduto().getPrice())
			 +", Quantity: "+i.getQuantity()+", Subtotal: $"+String.format("%.2f", i.subTotal())+"\n");
		 }
		 sb.append("Total price: $"+String.format("%.2f", total()));
		 return sb.toString();
	}
	
	
	
	
	
	
}
