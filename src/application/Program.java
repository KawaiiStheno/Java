package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter client data:\nName: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		sc.nextLine();
		
		System.out.print("Enter order data:\nStatus: ");
		String status = sc.nextLine();
		Order order = new Order(new Date(System.currentTimeMillis()),OrderStatus.valueOf(status),new Client(name,email,birthDate));
		
		System.out.print("How many items to this order? ");
		int qtd = sc.nextInt();
		
		for(int i=1;i<=qtd;i++) {
			System.out.printf("Enter #%d item data:\nProduct name: ",i);
			sc.nextLine();
			String product = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			OrderItem item = new OrderItem(quantity,price,new Product(product,price));
			order.addItem(item);
		}
		
		System.out.println("\nORDER SUMMARY:");
		System.out.println(order);
		
		
		sc.close();
	}

}
