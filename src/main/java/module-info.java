module com.github.leblancjs.email.client.harold {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;

    opens com.github.leblancjs.email.client.harold to javafx.graphics;
}