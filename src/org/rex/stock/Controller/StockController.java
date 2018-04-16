package org.rex.stock.Controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import org.rex.stock.Model.StockData;
import org.rex.stock.Model.TableSet;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

/**
 * @Author:REX
 * @Date: Create in 10:32 2018/4/13
 */
public class StockController {
	public StockController() {
	}

	public Pane pane;
	public TextField text;
	@FXML
	private TableView<TableSet> table;
	@FXML
	private TableColumn<TableSet, String> idCol;
	@FXML
	private TableColumn<TableSet, String> nameCol;
	@FXML
	private TableColumn<TableSet, String> openCol;
	@FXML
	private TableColumn<TableSet, String> lastCloseCol;
	@FXML
	private TableColumn<TableSet, String> priceCol;
	@FXML
	private TableColumn<TableSet, String> todayHighCol;
	@FXML
	private TableColumn<TableSet, String> todayLowCol;
	@FXML
	private TableColumn<TableSet, String> countCol;
	@FXML
	private TableColumn<TableSet, String> totalCol;
	@FXML
	private TableColumn<TableSet, String> dateCol;
	@FXML
	private TableColumn<TableSet, String> timeCol;
	@FXML
	private TableColumn<TableSet, Object> kLineCol;

	@FXML
	private void init() {//初始化
		idCol.setCellValueFactory(cellData -> cellData.getValue().idProperty());
		nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		openCol.setCellValueFactory(cellData -> cellData.getValue().openProperty());
		lastCloseCol.setCellValueFactory(cellData -> cellData.getValue().lastCloseProperty());
		priceCol.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
		todayHighCol.setCellValueFactory(cellData -> cellData.getValue().todayHighProperty());
		todayLowCol.setCellValueFactory(cellData -> cellData.getValue().todayLowProperty());
		countCol.setCellValueFactory(cellData -> cellData.getValue().countProperty());
		totalCol.setCellValueFactory(cellData -> cellData.getValue().totalProperty());
		dateCol.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
		timeCol.setCellValueFactory(cellData -> cellData.getValue().timeProperty());
		kLineCol.setCellValueFactory(cellData -> cellData.getValue().kLineProperty());
	}

	public void addList(StockData back) {//将数据加入列表
		table.setItems(back.getTableData());
	}

	public void btnAction(Event e) {
		java.util.Timer timer = new java.util.Timer();
		String value = text.getText();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				Calendar calendar = Calendar.getInstance();
				Date times = calendar.getTime();
				System.out.println((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(times));
				StockData data = new StockData(value);
				init();
				addList(data);
			}
		}, 1000, 10000);
	}

	public void closeBtn(Event e) {
		System.exit(0);
	}

}
