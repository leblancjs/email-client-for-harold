package com.github.leblancjs.email.client.harold;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class EmailClientForHarold extends Application {
    private static final long DELAY_BEFORE_RESPONSE_IN_MS = 5000;

    @Override
    public void start(Stage primaryStage) {
        EmailClient client = new EmailClient(DELAY_BEFORE_RESPONSE_IN_MS);

        ObservableList<Email> emailToDisplay = FXCollections.observableArrayList();

        TableView<Email> theTable = createTable();
        theTable.setItems(emailToDisplay);
        VBox.setVgrow(theTable, Priority.ALWAYS);

        Button theButton = new Button("Get Email");
        theButton.setOnAction(evenement -> CompletableFuture.supplyAsync(client::fetchEmail)
                .thenAcceptAsync(emailToDisplay::setAll, Platform::runLater));

        primaryStage.setScene(new Scene(new VBox(theTable, theButton)));
        primaryStage.setTitle("Email Client for Harold");
        primaryStage.show();
    }

    private TableView<Email> createTable() {
        TableColumn<Email, String> senderColumn = new TableColumn<>("Sender");
        senderColumn.setCellValueFactory(dataFeatures -> new SimpleObjectProperty<>(dataFeatures.getValue().getSender()));

        TableColumn<Email, String> subjectColumn = new TableColumn<>("Subject");
        subjectColumn.setCellValueFactory(dataFeatures -> new SimpleObjectProperty<>(dataFeatures.getValue().getSubject()));

        TableColumn<Email, String> messageColumn = new TableColumn<>("Message");
        messageColumn.setCellValueFactory(dataFeatures -> new SimpleObjectProperty<>(dataFeatures.getValue().getMessage()));

        TableView<Email> table = new TableView<>();
        List.of(senderColumn, subjectColumn, messageColumn).forEach(column -> table.getColumns().add(column));

        return table;
    }
}
