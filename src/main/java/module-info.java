module com.example.f22comp1011s2movies {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;

    opens com.example.f22comp1011s2movies to javafx.fxml, com.google.gson;
    exports com.example.f22comp1011s2movies;
}