package org.rex.stock.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import org.rex.stock.Controller.KLineController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author:REX
 * @Date: Create in 10:56 2018/4/13
 */
public class StockData implements StockInterface{
	public String string;
	ObservableList<TableSet> tableData = FXCollections.observableArrayList();

	public StockData() {
	}

	public StockData(String string) {
		this.string = string;
		prePare(string);
	}

	// 输入的字符串 判断多少组数据 再循环调用httpdata
	private void prePare(String string) {
		// 统计多组数据
		String[] sourceArr = string.split(",");
		for(int i = 0;i < sourceArr.length;i++){
			// Http请求数据
			String temp = httpData(sourceArr[i]);
			System.out.println(temp);
			String data[] = convert(temp);
			addData(data);
		}
	}

	public String httpData(String s) {
		String httpPost = "http://hq.sinajs.cn/list=";
		BufferedReader bufferedReader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		httpPost += s;
		try {
			URL url = new URL(httpPost);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			InputStream inputStream = connection.getInputStream();
			// 接口编码为GBK 不是UTF-8
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"GBK"));
			String strRead = null;
			while((strRead = bufferedReader.readLine()) != null){
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			bufferedReader.close();
			result = sbf.toString();
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}

	public String[] convert(String temp){
		// 各参数转化
		String[] arr;
		String data = temp.substring(temp.indexOf("\"")+1,temp.length());
		arr = data.split(",");
		arr[6] = temp.substring(11,19);
		return arr;
	}


	public void addData(String[] data) {
		Calendar calendar = Calendar.getInstance();
		Date now = calendar.getTime();
		String df=(new SimpleDateFormat("yyyy-MM-dd")).format(now);
		String dt=(new SimpleDateFormat("HH:mm:ss")).format(now);
		Button button = new Button("查看");
		tableData.add(new TableSet(data[6],data[0],data[1],data[2],data[3],data[4],data[5],data[8],data[9],df,dt,button));
		button.setId(data[6]);
		button.setOnAction(e -> {
			KLineController kLineController = new KLineController();
			try {
				kLineController.show(button.getId());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}

	public ObservableList<TableSet> getTableData(){
		return this.tableData;
	}

	// END
}
