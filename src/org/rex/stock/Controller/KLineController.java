package org.rex.stock.Controller;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


/**
 * @Author:REX
 * @Date: Create in 20:00 2018/4/13
 */
public class KLineController {
	public void show(String id) throws IOException {
		//System.out.println("id = " + id);
		GridPane gridPane = new GridPane();
		ImageView imageView = new ImageView();

		InputStream inputStream = getGif(id);
		Image image = new Image(inputStream);
		imageView.setImage(image);

		gridPane.add(imageView, 0, 0);
		Stage stage = new Stage();
		stage.setScene(new Scene(gridPane));
		stage.show();
	}

	public InputStream getGif(String s) throws IOException {
		CloseableHttpClient closeableHttpClient= HttpClients.createDefault(); //1、创建实例
		String url = "http://image.sinajs.cn/newchart/min/n/"+ s + ".gif";
		System.out.println(url);
		HttpGet httpGet=new HttpGet(url); //2、创建请求

		CloseableHttpResponse closeableHttpResponse=closeableHttpClient.execute(httpGet); //3、执行
		HttpEntity httpEntity=closeableHttpResponse.getEntity(); //4、获取实体

		if(httpEntity != null){
			// System.out.println("ContentType:"+httpEntity.getContentType().getValue());
			InputStream inputStream = httpEntity.getContent();
			return inputStream;
		}
		closeableHttpResponse.close();
		closeableHttpClient.close();
		return null;
	}
}
