module com.example.f22comp1011s2movies {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.f22comp1011s2movies to javafx.fxml;
    exports com.example.f22comp1011s2movies;
}