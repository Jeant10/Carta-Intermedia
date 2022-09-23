module com.example.proyectofinal_poo_2021b_jtituana {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.proyectofinal_poo_2021b_jtituana to javafx.fxml;
    exports com.example.proyectofinal_poo_2021b_jtituana;
    exports com.example.proyectofinal_poo_2021b_jtituana.Modelo;
    opens com.example.proyectofinal_poo_2021b_jtituana.Modelo to javafx.fxml;
}