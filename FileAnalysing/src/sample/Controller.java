package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;

public class Controller {

    @FXML
    private Button btnSave;
    @FXML
    private Button btnChange;
    @FXML
    private Button btnOpen;

    @FXML
    private Label lblFilePath;

    @FXML
    private TextArea taFileContents;

    private ArrayList<String> txtFileLines;

    @FXML
    private void onOpenFile_pressed(ActionEvent event) throws IOException {
        System.out.println("Open file clicked!");
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open log file");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("LOG", "*.log"));
        final File file = chooser.showOpenDialog(Main.getStage());
        lblFilePath.setText("File: " + file.getAbsolutePath());
        String st;
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        System.out.println(file);
        if (txtFileLines == null) {
            txtFileLines = new ArrayList<>();
        } else {
            txtFileLines.clear();
        }
        while ((st = br.readLine()) != null) {
            System.out.println(st);
            txtFileLines.add(st);
            sb.append(st);
            sb.append("\n");
        }
        taFileContents.clear();
        taFileContents.appendText(sb.toString());
    }

    @FXML
    private void onSaveFile_pressed(ActionEvent event) {
        System.out.println("Save file clicked!");
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save log file");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("LOG", "*.log"));
        final File file = chooser.showSaveDialog(Main.getStage());
    }

    @FXML
    private void onChangeFile_pressed(ActionEvent event) {
        System.out.println("Change file clicked!");
        taFileContents.clear();
        ArrayList<String> buffer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String st :
                txtFileLines) {
            st = st.replaceAll(" 0,0", "null");
            st = st.replaceAll(" {3}0[^,]", "null");
            buffer.add(st);
            sb.append(st);
            sb.append("\n");
        }
        taFileContents.appendText(sb.toString());
        txtFileLines.clear();
        txtFileLines = buffer;
    }

}
