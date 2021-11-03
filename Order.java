import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.*;
import java.io.*;

public class Order extends Menu {
	
	private int orderStaffID;
	private int orderTableID;
	private Date timeStamp;

	public Order(int orderStaffID, int orderTableID) {
		this.orderStaffID = orderStaffID;
		this.orderTableID = orderTableID;
		this.timeStamp = new Date();
	}
	public void print() {
		// TODO - implement Order.print
		throw new UnsupportedOperationException();
	}
	public int getOrderTableID() {
		return this.orderTableID;
	}
	public double viewOrder(){
		for(int i=0; i<orderItems.size(); i++){
			double total = (orderItems.get(i)).getPrice()) * (orderItems.get(i)).getQuantity()
			double finalAmount = finalAmount + total;
			System.out.println((orderItems.get(i)).getQuantity()+" - "+(orderItems.get(i)).getName()+"		"+total);
		}
		return finalAmount;
	}

	public void setOrderTableID(int orderTableID) {
		this.orderTableID = orderTableID;
	}

	public void addOrderItem() {
		// TODO - implement Order.addOrderItem
		throw new UnsupportedOperationException();
	}

	public void removeOrderItem() {
		// TODO - implement Order.removeOrderItem
		throw new UnsupportedOperationException();
	}

	public void editOrderItem() {
		// TODO - implement Order.editOrderItem
		throw new UnsupportedOperationException();
	}

	public Date getTimeStamp() {
		return this.timeStamp;
	}

	/**
	 * 
	 * @param timeStamp
	 */
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public float getDiscount() {
		return this.discount;
	}

	/**
	 * 
	 * @param discount
	 */
	public void setDiscount(float discount) {
		this.discount = discount;
	}

}