package logic;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> orderItemList;
	private static int totalOrderCount = 0;
	private int orderNumber;
	
	public Order() {
		// TODO
		orderItemList = new ArrayList<OrderItem>();
		orderNumber = totalOrderCount;
		totalOrderCount++;
	}

	public OrderItem addItem(Item item, int amount) {
		// TODO
		// Loop the orderItemList to find if item of any orderItem equals to the given item
		// if there is orderItem with given item, increase that orderItem itemAmount with amount
		// and return that orderItem

		// else create new orderItem with given item and amount, then return the new orderItem

		for(OrderItem orderItem:orderItemList){
			if(orderItem.getItem().getName().equals(item.getName())){
				orderItem.increaseItemAmount(amount);
				return orderItem;
			}
		}
		OrderItem newOrderItem = new OrderItem(item, amount);

		orderItemList.add(newOrderItem);
		return newOrderItem;
	}


	public int calculateOrderTotalPrice() {
		// TODO
		// Calculate total price of the order by summing total price of each orderItem in orderItemList
		int total = 0;
		for(OrderItem orderItem : orderItemList){
			total += orderItem.calculateTotalPrice();
		}
		return total;
	}


	public static int getTotalOrderCount() {
		return totalOrderCount;
	}
	
	public static void resetTotalOrderCount() {
		totalOrderCount = 0;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	
	
}
