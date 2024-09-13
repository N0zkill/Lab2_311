module org.example.javalab2311 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javalab2311 to javafx.fxml;
    exports org.example.javalab2311;
}