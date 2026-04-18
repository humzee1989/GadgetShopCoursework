import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class GadgetShop extends Application
{
    private TextField modelField;
    private TextField priceField;
    private TextField weightField;
    private TextField sizeField;
    private TextField creditField;
    private TextField memoryField;
    private TextField phoneField;
    private TextField durationField;
    private TextField downloadField;
    private TextField displayField;

    private TextArea outputArea;

    private ArrayList<Gadget> gadgets;

    @Override
    public void start(Stage stage)
    {
        gadgets = new ArrayList<Gadget>();

        Label modelLabel = new Label("Model");
        Label priceLabel = new Label("Price");
        Label weightLabel = new Label("Weight");
        Label sizeLabel = new Label("Size");
        Label creditLabel = new Label("Initial Credit");
        Label memoryLabel = new Label("Initial Memory");
        Label phoneLabel = new Label("Phone Number");
        Label durationLabel = new Label("Duration");
        Label downloadLabel = new Label("Download Size");
        Label displayLabel = new Label("Display Number");

        modelField = new TextField();
        priceField = new TextField();
        weightField = new TextField();
        sizeField = new TextField();
        creditField = new TextField();
        memoryField = new TextField();
        phoneField = new TextField();
        durationField = new TextField();
        downloadField = new TextField();
        displayField = new TextField();

        Button addMobileButton = new Button("Add Mobile");
        Button addMP3Button = new Button("Add MP3");
        Button clearButton = new Button("Clear");
        Button displayButton = new Button("Display All");
        Button callButton = new Button("Make A Call");
        Button downloadButton = new Button("Download Music");

        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefHeight(250);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15));

        grid.add(modelLabel, 0, 0);
        grid.add(modelField, 1, 0);

        grid.add(priceLabel, 0, 1);
        grid.add(priceField, 1, 1);

        grid.add(weightLabel, 0, 2);
        grid.add(weightField, 1, 2);

        grid.add(sizeLabel, 0, 3);
        grid.add(sizeField, 1, 3);

        grid.add(creditLabel, 0, 4);
        grid.add(creditField, 1, 4);

        grid.add(memoryLabel, 0, 5);
        grid.add(memoryField, 1, 5);

        grid.add(phoneLabel, 0, 6);
        grid.add(phoneField, 1, 6);

        grid.add(durationLabel, 0, 7);
        grid.add(durationField, 1, 7);

        grid.add(downloadLabel, 0, 8);
        grid.add(downloadField, 1, 8);

        grid.add(displayLabel, 0, 9);
        grid.add(displayField, 1, 9);

        HBox buttonsRow1 = new HBox(10);
        buttonsRow1.getChildren().addAll(addMobileButton, addMP3Button, clearButton);

        HBox buttonsRow2 = new HBox(10);
        buttonsRow2.getChildren().addAll(displayButton, callButton, downloadButton);

        VBox root = new VBox(15);
        root.setPadding(new Insets(15));
        root.getChildren().addAll(grid, buttonsRow1, buttonsRow2, new Label("Output"), outputArea);

        addMobileButton.setOnAction(e -> addMobile());
        addMP3Button.setOnAction(e -> addMP3());
        clearButton.setOnAction(e -> clearFields());
        displayButton.setOnAction(e -> displayAll());
        callButton.setOnAction(e -> makeCall());
        downloadButton.setOnAction(e -> downloadMusic());

        Scene scene = new Scene(root, 700, 650);
        stage.setTitle("Gadget Shop");
        stage.setScene(scene);
        stage.show();
    }

    private String getModel()
    {
        return modelField.getText().trim();
    }

    private double getPrice()
    {
        return Double.parseDouble(priceField.getText().trim());
    }

    private int getWeight()
    {
        return Integer.parseInt(weightField.getText().trim());
    }

    private String getSize()
    {
        return sizeField.getText().trim();
    }

    private int getCredit()
    {
        return Integer.parseInt(creditField.getText().trim());
    }

    private int getMemory()
    {
        return Integer.parseInt(memoryField.getText().trim());
    }

    private String getPhoneNumber()
    {
        return phoneField.getText().trim();
    }

    private int getDuration()
    {
        return Integer.parseInt(durationField.getText().trim());
    }

    private int getDownloadSize()
    {
        return Integer.parseInt(downloadField.getText().trim());
    }

    private int getDisplayNumber()
    {
        int displayNumber = -1;

        try
        {
            displayNumber = Integer.parseInt(displayField.getText().trim());

            if(displayNumber < 0 || displayNumber >= gadgets.size())
            {
                showError("Please enter a display number within the valid range.");
                displayNumber = -1;
            }
        }
        catch(NumberFormatException ex)
        {
            showError("Display number must be an integer.");
        }

        return displayNumber;
    }

    private void addMobile()
    {
        try
        {
            String model = getModel();
            double price = getPrice();
            int weight = getWeight();
            String size = getSize();
            int credit = getCredit();

            Mobile mobile = new Mobile(model, price, weight, size, credit);
            gadgets.add(mobile);

            outputArea.setText("Mobile added successfully.");
        }
        catch(NumberFormatException ex)
        {
            showError("Please enter valid values for price, weight and credit.");
        }
    }

    private void addMP3()
    {
        try
        {
            String model = getModel();
            double price = getPrice();
            int weight = getWeight();
            String size = getSize();
            int memory = getMemory();

            MP3 mp3 = new MP3(model, price, weight, size, memory);
            gadgets.add(mp3);

            outputArea.setText("MP3 added successfully.");
        }
        catch(NumberFormatException ex)
        {
            showError("Please enter valid values for price, weight and memory.");
        }
    }

    private void clearFields()
    {
        modelField.clear();
        priceField.clear();
        weightField.clear();
        sizeField.clear();
        creditField.clear();
        memoryField.clear();
        phoneField.clear();
        durationField.clear();
        downloadField.clear();
        displayField.clear();
        outputArea.clear();
    }

    private void displayAll()
    {
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < gadgets.size(); i++)
        {
            Gadget gadget = gadgets.get(i);

            output.append("Display Number: ").append(i).append("\n");
            output.append("Model: ").append(gadget.getModel()).append("\n");
            output.append("Price: £").append(gadget.getPrice()).append("\n");
            output.append("Weight: ").append(gadget.getWeight()).append(" grams\n");
            output.append("Size: ").append(gadget.getSize()).append("\n");

            if(gadget instanceof Mobile)
            {
                Mobile mobile = (Mobile) gadget;
                output.append("Calling Credit: ").append(mobile.getCredit()).append(" minutes\n");
            }
            else if(gadget instanceof MP3)
            {
                MP3 mp3 = (MP3) gadget;
                output.append("Available Memory: ").append(mp3.getMemory()).append("\n");
            }

            output.append("\n");

            gadget.display();
            System.out.println();
        }

        outputArea.setText(output.toString());
    }

    private void makeCall()
    {
        try
        {
            int index = getDisplayNumber();

            if(index == -1)
            {
                return;
            }

            String phoneNumber = getPhoneNumber();
            int duration = getDuration();

            Gadget gadget = gadgets.get(index);

            if(gadget instanceof Mobile)
            {
                Mobile mobile = (Mobile) gadget;

                if(duration <= 0)
                {
                    outputArea.setText("Please enter a valid call duration.");
                }
                else if(mobile.getCredit() >= duration)
                {
                    mobile.makeACall(phoneNumber, duration);
                    outputArea.setText("Calling " + phoneNumber + " for " + duration + " minutes.\n"
                            + "Remaining credit: " + mobile.getCredit() + " minutes.");
                }
                else
                {
                    outputArea.setText("Insufficient credit to make the call.");
                }
            }
            else
            {
                outputArea.setText("Selected gadget is not a mobile phone.");
            }
        }
        catch(NumberFormatException ex)
        {
            showError("Please enter a valid duration.");
        }
    }

    private void downloadMusic()
    {
        try
        {
            int index = getDisplayNumber();

            if(index == -1)
            {
                return;
            }

            int downloadSize = getDownloadSize();
            Gadget gadget = gadgets.get(index);

            if(gadget instanceof MP3)
            {
                MP3 mp3 = (MP3) gadget;

                if(downloadSize <= 0)
                {
                    outputArea.setText("Please enter a valid download size.");
                }
                else if(mp3.getMemory() >= downloadSize)
                {
                    mp3.downloadMusic(downloadSize);
                    outputArea.setText("Music downloaded successfully.\n"
                            + "Available memory: " + mp3.getMemory());
                }
                else
                {
                    outputArea.setText("Not enough available memory.");
                }
            }
            else
            {
                outputArea.setText("Selected gadget is not an MP3 player.");
            }
        }
        catch(NumberFormatException ex)
        {
            showError("Please enter a valid download size.");
        }
    }

    private void showError(String message)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
