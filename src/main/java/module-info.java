module com.example.cs102wordle {
	requires javafx.controls;
	requires javafx.fxml;
	requires org.jsoup;
	requires java.sql;
	requires java.persistence;
	requires org.hibernate.orm.core;
	requires org.junit.jupiter.api;
	requires org.junit.platform.commons;
	requires org.junit.platform.engine;
	requires testng;
	requires org.mockito;

	exports com.example.Main;
	exports building_classes;
	opens building_classes to javafx.fxml;
	opens entities to javafx.base;
	exports utils;
	opens utils to javafx.fxml;
	exports tests;
	exports entities;
	exports controllers;
	opens tests to javafx.fxml;
}