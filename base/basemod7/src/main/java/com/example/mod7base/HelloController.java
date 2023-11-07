//не получилось скомпилировать код, вероятнее ошибка либо в версии и подключениях, либо в пути файлов
//реализовывал в основном вслепую, основываясь на видеоуроках, теоретически реализован весь функционал fxml файла
package com.example.mod7base;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private TextField Number; // поле для ввода числа

    @FXML
    private ChoiceBox<String> Button; // выпадающий список для выбора единицы измерения (т,кг,г)

    @FXML
    private Label Ton; // метка для вывода значения в тоннах

    @FXML
    private Label Kilo; // метка для вывода значения в килограммах

    @FXML
    private Label Gra; // метка для вывода значения в граммах

    public HelloController() {
        // добавляем слушателя события для текстового поля Number
        Number.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                handleConvert(); // Вызываем метод конвертации при изменении текста
            }
        });

        // добавляем варианты выбора в ChoiceBox
        Button.getItems().addAll("Тонны", "Килограммы", "Граммы");
    }

    @FXML
    protected void handleConvertButtonAction() {
        handleConvert(); // вызываем метод конвертации при нажатии кнопки
    }

    private void handleConvert() {
        try {
            double inputValue = Double.parseDouble(Number.getText()); // Получаем введенное пользователем число
            String selectedUnit = Button.getValue(); // Получаем выбранную единицу измерения

            // переменные для хранения конвертированных значений
            double convertedTon = 0.0;
            double convertedKilo = 0.0;
            double convertedGra = 0.0;

            // конвертация в зависимости от выбранной единицы измерения
            if (selectedUnit.equals("Тонны")) {
                convertedTon = inputValue;
                convertedKilo = inputValue * 1000;
                convertedGra = inputValue * 1000000;
            } else if (selectedUnit.equals("Килограммы")) {
                convertedTon = inputValue / 1000;
                convertedKilo = inputValue;
                convertedGra = inputValue * 1000;
            } else if (selectedUnit.equals("Граммы")) {
                convertedTon = inputValue / 1000000;
                convertedKilo = inputValue / 1000;
                convertedGra = inputValue;
            }

            // обновляем значения на экране округляя до 2 знаков после запятой
            Ton.setText(String.format("%.2f", convertedTon));
            Kilo.setText(String.format("%.2f", convertedKilo));
            Gra.setText(String.format("%.2f", convertedGra));
        } catch (NumberFormatException e) {
            // обработка ошибки ввода числа
            Ton.setText("Ошибка");
            Kilo.setText("Ошибка");
            Gra.setText("Ошибка");
        }
    }
}