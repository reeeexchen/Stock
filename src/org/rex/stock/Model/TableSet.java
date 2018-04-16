package org.rex.stock.Model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @Author:REX
 * @Date: Create in 10:56 2018/4/13
 */
public class TableSet {
	// 股票代码
	private StringProperty id;
	// 股票名称
	private StringProperty name;
	// 今天开盘价
	private StringProperty open;
	// 昨日收盘价
	private StringProperty lastClose;
	// 当前价格
	private StringProperty price;
	// 今日最高价
	private StringProperty todayHigh;
	// 今日最低价
	private StringProperty todayLow;
	// 成交股数
	private StringProperty count;
	// 成交金额
	private StringProperty total;
	// 当前日期
	private StringProperty date;
	// 当前时间
	private StringProperty time;
	// K线图
	private ObjectProperty kLine;

	public Object getkLine() {
		return kLine.get();
	}

	public ObjectProperty kLineProperty() {
		return kLine;
	}

	public void setkLine(Object kLine) {
		this.kLine.set(kLine);
	}

	public String getName() {
		return name.get();
	}

	public StringProperty nameProperty() {
		return name;
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getOpen() {
		return open.get();
	}

	public StringProperty openProperty() {
		return open;
	}

	public void setOpen(String open) {
		this.open.set(open);
	}

	public String getLastClose() {
		return lastClose.get();
	}

	public StringProperty lastCloseProperty() {
		return lastClose;
	}

	public void setLastClose(String lastClose) {
		this.lastClose.set(lastClose);
	}

	public String getPrice() {
		return price.get();
	}

	public StringProperty priceProperty() {
		return price;
	}

	public void setPrice(String price) {
		this.price.set(price);
	}

	public String getTodayHigh() {
		return todayHigh.get();
	}

	public StringProperty todayHighProperty() {
		return todayHigh;
	}

	public void setTodayHigh(String todayHigh) {
		this.todayHigh.set(todayHigh);
	}

	public String getTodayLow() {
		return todayLow.get();
	}

	public StringProperty todayLowProperty() {
		return todayLow;
	}

	public void setTodayLow(String todayLow) {
		this.todayLow.set(todayLow);
	}

	public String getCount() {
		return count.get();
	}

	public StringProperty countProperty() {
		return count;
	}

	public void setCount(String count) {
		this.count.set(count);
	}

	public String getTotal() {
		return total.get();
	}

	public StringProperty totalProperty() {
		return total;
	}

	public void setTotal(String total) {
		this.total.set(total);
	}

	public String getDate() {
		return date.get();
	}

	public StringProperty dateProperty() {
		return date;
	}

	public void setDate(String date) {
		this.date.set(date);
	}

	public String getTime() {
		return time.get();
	}

	public StringProperty timeProperty() {
		return time;
	}

	public void setTime(String time) {
		this.time.set(time);
	}

	public String getId() {
		return id.get();
	}

	public StringProperty idProperty() {
		return id;
	}

	public void setId(String id) {
		this.id.set(id);
	}

	public TableSet(String id, String name, String open, String lastClose, String price, String todayHigh, String todayLow, String count, String total, String date, String time, Object kLine) {
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.open = new SimpleStringProperty(open);
		this.lastClose = new SimpleStringProperty(lastClose);
		this.price = new SimpleStringProperty(price);
		this.todayHigh = new SimpleStringProperty(todayHigh);
		this.todayLow = new SimpleStringProperty(todayLow);
		this.count = new SimpleStringProperty(count);
		this.total = new SimpleStringProperty(total);
		this.date = new SimpleStringProperty(date);
		this.time = new SimpleStringProperty(time);
		this.kLine = new SimpleObjectProperty(kLine);
	}

	@Override
	public String toString() {
		return "TableSet{" + "id=" + id + ", name=" + name + ", open=" + open + ", lastClose=" + lastClose + ", price=" + price + ", todayHigh=" + todayHigh + ", todayLow=" + todayLow + ", count=" + count + ", total=" + total + ", date=" + date + ", time=" + time + ", kLine=" + kLine + '}';
	}
}
