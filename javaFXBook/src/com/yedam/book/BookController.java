package com.yedam.book;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BookController implements Initializable {
@FXML
TableView<Book> tableView;
@FXML
Button btnAdd;
ObservableList<Book> list;
Stage primaryStage;
public void setPrimaryStage(Stage primaryStage) {
	this.primaryStage = primaryStage;
}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TableColumn<Book, ?> tc = tableView.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("title"));
		tc =tableView.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("name"));
		tc =tableView.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("pub"));
		tc =tableView.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		list = FXCollections.observableArrayList();
		tableView.setItems(list);
		
		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleBtnAddAction();
			}
		});
		tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(event.getClickCount() ==2) {
					String selectedTitle = 
			     tableView.getSelectionModel().getSelectedItem().getTitle();
				handleDoubleClickAction(selectedTitle);
			}
			}
		});
	}
	public void handleDoubleClickAction(String title) {
		Stage stage = new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(btnAdd.getScene().getWindow());
		
		try {
	         Parent parent = FXMLLoader.load(getClass().getResource("BookUpdate.fxml"));
	         
	         Scene scene = new Scene(parent);
	         stage.setTitle("수정");
	         stage.setScene(scene);
	         stage.show();
	         
	         Button btnUpdate = (Button) parent.lookup("#btnUpdate");
	         TextField txtTitle = (TextField) parent.lookup("#txtTitle");
	         TextField txtName = (TextField) parent.lookup("#txtName");
	         TextField txtPub = (TextField) parent.lookup("#txtPub");
	         TextField txtPrice = (TextField) parent.lookup("#txtPrice");
	         
	         for(Book bookList : list) {
	        	 if(bookList.getTitle().equals(title)) {
	        		 txtTitle.setText(String.valueOf(bookList.getTitle()));
	        		 txtName.setText(String.valueOf(bookList.getName()));
	        		 txtPub.setText(String.valueOf(bookList.getPub()));
	        		 txtPrice.setText(String.valueOf(bookList.getPrice()));
	        	 }
	         }
			
			btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					for(int i =0; i<list.size(); i++) {
						if(list.get(i).getTitle().equals(title)) {
							Book book = new Book(title,
									             txtName.getText(),
									              txtPub.getText(),
									           Integer.parseInt(txtPrice.getText()));
						list.set(i, book);
						}
					}
					stage.close();
				}
			});
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
public void handleBtnAddAction() {
	Stage stage = new Stage(StageStyle.UTILITY);
	stage.initModality(Modality.WINDOW_MODAL);
	stage.initOwner(btnAdd.getScene().getWindow());
	try {
		Parent parent = FXMLLoader.load(getClass().getResource("BookAdd.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
		Button btnFormAdd = (Button) parent.lookup("#btnFormAdd");
		btnFormAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				TextField txtTitle = (TextField) parent.lookup("#txtTitle");
				TextField txtName = (TextField) parent.lookup("#txtName");
				TextField txtPub = (TextField) parent.lookup("#txtPub");
				TextField txtPrice = (TextField) parent.lookup("#txtPrice");
				Book book = new Book(txtTitle.getText(),
						             txtName.getText(),
						              txtPub.getText(),
						           Integer.parseInt(txtPrice.getText()));
				list.add(book);
				stage.close();
			}
		});
		Button btnFormCancel = (Button) parent.lookup("#btnFormCancel");
		btnFormCancel.setOnAction(e -> {
			TextField txtTitle = (TextField) parent.lookup("#txtTitle");
			TextField txtName = (TextField) parent.lookup("#txtName");
			TextField txtPub = (TextField) parent.lookup("#txtPub");
			TextField txtPrice = (TextField) parent.lookup("#txtPrice");

			txtTitle.clear();
			txtName.clear();
			txtPub.clear();
			txtPrice.clear();
			stage.close();

		});
	}catch (IOException e) {
		e.printStackTrace();
	}
	
 }
}
