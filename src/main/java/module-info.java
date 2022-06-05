module com.example.cs102wordle {
	requires javafx.controls;
	requires javafx.fxml;
	requires org.jsoup;
	requires java.sql;
	requires java.persistence;
	requires org.hibernate.orm.core;

	exports com.example.cs102wordle;
	exports building_classes;
	opens building_classes to javafx.fxml;
	exports utils;
	opens utils to javafx.fxml;
}