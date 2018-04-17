package org.rex.stock.Controller;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

import jdk.internal.util.xml.impl.Input;
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
        final String ID = id;

        InputStream inputStream = getGif(ID);
        Image image = new Image(inputStream);
        imageView.setImage(image);

        Button refresh = new Button("自动刷新");
        Button close = new Button("关闭窗口");
        VBox vBox = new VBox();
        vBox.setSpacing(20);
        vBox.getChildren().addAll(refresh, close);
        vBox.setAlignment(Pos.CENTER);

        gridPane.add(imageView, 0, 0);
        gridPane.add(vBox, 1, 0);

        Stage stage = new Stage();
        stage.setScene(new Scene(gridPane));
        stage.show();

        // BTN METHOD
        close.setOnAction(e -> {
            stage.close();
        });

        refresh.setOnAction(e -> {
            Timer re_timer = new Timer();
            re_timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    InputStream inputStream1 = null;
                    try {
                        inputStream1 = getGif(ID);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    Image image1 = new Image(inputStream1);
                    imageView.setImage(image1);
                }
            }, 1000, 5000);
        });
    }

    public InputStream getGif(String s) throws IOException {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault(); //1、创建实例
        String url = "http://image.sinajs.cn/newchart/min/n/" + s + ".gif";
        System.out.println(url);
        HttpGet httpGet = new HttpGet(url); //2、创建请求

        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet); //3、执行
        HttpEntity httpEntity = closeableHttpResponse.getEntity(); //4、获取实体

        if (httpEntity != null) {
            // System.out.println("ContentType:"+httpEntity.getContentType().getValue());
            InputStream inputStream = httpEntity.getContent();
            return inputStream;
        }
        closeableHttpResponse.close();
        closeableHttpClient.close();
        return null;
    }
}
