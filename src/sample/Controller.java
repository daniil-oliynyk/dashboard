package sample;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    private ArrayList<String> information;

    @FXML
    private JFXTextField searchTF;

    @FXML
    private JFXButton clear_button;

    @FXML
    private JFXButton close_button;

    @FXML
    void closeButtonAction(MouseEvent event) {
        Platform.exit();
    }
    @FXML
    void clearButtonAction(MouseEvent event) {
        searchTF.clear();
    }
    @FXML
    void search(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
            String text = searchTF.getText().toUpperCase();

            Header header = new BasicHeader("X-CMC_PRO_API_KEY","583b3ead-7ac4-4169-82e1-4e0f0ea5c832");
            List<Header> headers = new ArrayList<Header>();
            headers.add(header);
            CloseableHttpClient client = HttpClients.custom().setDefaultHeaders(headers).build();
            //CloseableHttpResponse response = client.execute( new HttpGet("http://data.fixer.io/latest?access_key=b4773efeeef782cb392da95afa056b4e&symbols=CAD"));

            String url = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol="+text;
            HttpGet request = new HttpGet(url);
            //request.setHeader();
            CloseableHttpResponse response = client.execute(request);

            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);
            System.out.println(content);

            JSONParser parser = new JSONParser(content);
            information = parser.parse();

            for(String s: information){
                System.out.println(s);
            }



        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
