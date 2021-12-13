package ru.vsu.cs.novichikhin;

import ru.vsu.cs.util.ArrayUtils;
import ru.vsu.cs.util.JTableUtils;
import ru.vsu.cs.util.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.List;
import java.util.Objects;

public class FrameMain extends JFrame {
    private JButton buttonLoadFromInputFile;
    private JButton buttonRandomInput;
    private JButton buttonSaveToInputFile;
    private JButton buttonCreateNewList;
    private JTable tableOutput;
    private JTable tableFirstList;
    private JTable tableSecondList;
    private JButton buttonSaveToOutputFile;
    private JPanel panelMain;
    private final JFileChooser fileChooserOpen;
    private final JFileChooser fileChooserSave;

    public FrameMain() {
        this.setTitle("Создание нового списка");
        this.setContentPane(panelMain);
        this.setBounds(450, 0, 300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(tableFirstList, 40, false, true, false, true);
        JTableUtils.initJTableForArray(tableSecondList, 40, false, true, false, true);
        JTableUtils.initJTableForArray(tableOutput, 40, false, true, false, true);
        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("C:\\Users\\ВЯЧЕСЛАВ\\ВГУ\\ВВП\\Nine\\Nine"));
        fileChooserSave.setCurrentDirectory(new File("C:\\Users\\ВЯЧЕСЛАВ\\ВГУ\\ВВП\\Nine\\Nine"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        buttonLoadFromInputFile.addActionListener(actionEvent -> {
            try {
                if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    int[] firstArray = ArrayUtils.readIntArrayFromFile(fileChooserOpen.getSelectedFile().getPath(), 0);
                    int[] secondArray = ArrayUtils.readIntArrayFromFile(fileChooserOpen.getSelectedFile().getPath(), 1);

                    JTableUtils.writeArrayToJTable(tableFirstList, firstArray);
                    JTableUtils.writeArrayToJTable(tableSecondList, secondArray);
                }
            } catch (Exception e) {
                SwingUtils.showInfoMessageBox("Данные в файле некоректны (в файле должно быть 2 строчки, " +
                        "причём во второй строчке должен содержаться хотя бы один элемент из первой)", "Ошибка");
            }
        });

        buttonRandomInput.addActionListener(actionEvent -> {
            try {
                int[][] matrix1 = ArrayUtils.createRandomIntMatrix(
                        tableFirstList.getRowCount(), tableFirstList.getColumnCount(), 100);
                JTableUtils.writeArrayToJTable(tableFirstList, matrix1);
                int[][] matrix2 = ArrayUtils.createRandomIntMatrix(
                        tableFirstList.getRowCount(), tableSecondList.getColumnCount(), 100);
                JTableUtils.writeArrayToJTable(tableSecondList, matrix2);
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });

        buttonSaveToInputFile.addActionListener(actionEvent -> {
            try {
                if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    int[][] firstList = JTableUtils.readIntMatrixFromJTable(tableFirstList);
                    int[][] secondList = JTableUtils.readIntMatrixFromJTable(tableSecondList);
                    String file = fileChooserSave.getSelectedFile().getPath();
                    if (!file.toLowerCase().endsWith(".txt")) {
                        file += ".txt";
                    }
                    ArrayUtils.writeArrayToFile(file, firstList);
                    ArrayUtils.writeArrayToFile(file, secondList);
                }
            } catch (Exception e) {
                SwingUtils.showInfoMessageBox("Не уадётся сохранить в файл", "Ошибка");
            }
        });

        buttonCreateNewList.addActionListener(actionEvent -> {
            try {
                NewList newList = new NewList(ArrayUtils.intArrayToList(Objects.requireNonNull(JTableUtils.readIntArrayFromJTable(tableFirstList))),
                        ArrayUtils.intArrayToList(Objects.requireNonNull(JTableUtils.readIntArrayFromJTable(tableSecondList))));

                List<Integer> list = newList.createNewList();
                Objects.requireNonNull(list);
                JTableUtils.writeArrayToJTable(tableOutput, ArrayUtils.listToIntArray(list));
            } catch (Exception e) {
                SwingUtils.showInfoMessageBox("Во втором списке должен содержаться хотя бы один элемент" +
                        " из первого", "Ошибка");
            }
        });

        buttonSaveToOutputFile.addActionListener(actionEvent -> {
            try {
                if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    int[][] calendar = JTableUtils.readIntMatrixFromJTable(tableOutput);
                    String file = fileChooserSave.getSelectedFile().getPath();
                    if (!file.toLowerCase().endsWith(".txt")) {
                        file += ".txt";
                    }
                    ArrayUtils.writeArrayToFile(file, calendar);
                }
            } catch (Exception e) {
                SwingUtils.showInfoMessageBox("Не уадётся сохранить в файл", "Ошибка");
            }
        });
    }
}
