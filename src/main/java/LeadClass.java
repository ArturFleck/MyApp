import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class LeadClass {
    static String pathTo = "D:/_profile/Desktop/Типові меблі ЕЛКОН ДІЗАЙН/ТИПОВІ КУХНІ/Пеналы 1/";
    static File pathToMove = new File(pathTo);
    static File pathFromExport = new File("C:/Test5/3D-CON~1/KM5/Export/");
    static File pathFromTMP = new File("C:/Elecran/3D-Constructor 7/KM5/TMP/");
    static File pathFromPrograms = new File("D:/_profile/Desktop/Программы BHX/");

    public static void main(String[] args) throws IOException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        JTextField textField, textField1, textField2, textField3;

        textField = new JTextField();
        textField.setText("D:/_profile/Desktop/Типові меблі ЕЛКОН ДІЗАЙН/ТИПОВІ КУХНІ/Пеналы 1/");
        textField.setBounds(10, 10, 400, 20);
        textField.setEnabled(false);

        textField1 = new JTextField();
        textField1.setText("C:/Test5/3D-CON~1/KM5/Export/");
        textField1.setBounds(10, 40, 400, 20);
        textField1.setEnabled(false);

        textField2 = new JTextField();
        textField2.setText("C:/Elecran/3D-Constructor 7/KM5/TMP/");
        textField2.setBounds(10, 70, 400, 20);
        textField2.setEnabled(false);

        textField3 = new JTextField();
        textField3.setText("D:/_profile/Desktop/Программы BHX/");
        textField3.setBounds(10, 100, 400, 20);
        textField3.setEnabled(false);


        JCheckBox checkBox, checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;

        checkBox = new JCheckBox();
        checkBox.setBounds(10, 130, 170, 20);
        checkBox.setText("dwg Mover");
        checkBox.setBorderPaintedFlat(false);

        checkBox1 = new JCheckBox();
        checkBox1.setBounds(10, 160, 170, 20);
        checkBox1.setText("Create Directories");
        checkBox1.setBorderPaintedFlat(false);

        checkBox2 = new JCheckBox();
        checkBox2.setBounds(10, 190, 170, 20);
        checkBox2.setText("excel Mover");
        checkBox2.setBorderPaintedFlat(false);

        checkBox3 = new JCheckBox();
        checkBox3.setBounds(10, 220, 170, 20);
        checkBox3.setText("project Mover");
        checkBox3.setBorderPaintedFlat(false);

        checkBox4 = new JCheckBox();
        checkBox4.setBounds(10, 250, 170, 20);
        checkBox4.setText("merge PDF");
        checkBox4.setBorderPaintedFlat(false);

        checkBox5 = new JCheckBox();
        checkBox5.setBounds(10, 280, 170, 20);
        checkBox5.setText("BHX programs Mover");
        checkBox5.setBorderPaintedFlat(false);


        JButton button, button1, button2, button3, button4, button5;

        button = new JButton("where to move");
        button.setBounds(420, 10, 120, 20);
        button.setFocusable(false);
        button.setToolTipText("where is your root folder");
        button.setFont(new Font("Times New Roman", Font.PLAIN, 13));

        button1 = new JButton("excel  dir");
        button1.setBounds(420, 40, 120, 20);
        button1.setFocusable(false);
        button1.setToolTipText("where lies your excel files");
        button1.setFont(new Font("Times New Roman", Font.PLAIN, 13));

        button2 = new JButton("PDF / project dir");
        button2.setBounds(420, 70, 120, 20);
        button2.setFocusable(false);
        button2.setFont(new Font("Times New Roman", Font.PLAIN, 13));

        button3 = new JButton("prog dir");
        button3.setBounds(420, 100, 120, 20);
        button3.setFocusable(false);
        button3.setFont(new Font("Times New Roman", Font.PLAIN, 13));

        button4 = new JButton("EXECUTE");
        button4.setBounds(50, 320, 120, 30);
        button4.setFocusable(false);
        button4.setToolTipText("let the magic happens :-)");
        button4.setFont(new Font("Times New Roman", Font.BOLD, 13));
        button4.setBackground(Color.ORANGE);

        button5 = new JButton("EXIT");
        button5.setBounds(380, 320, 120, 30);
        button5.setFocusable(false);
        button5.setToolTipText("end of it all");
        button5.setFont(new Font("Times New Roman", Font.BOLD, 13));
        button5.setBackground(Color.RED);


        frame.add(textField);
        frame.add(textField1);
        frame.add(textField2);
        frame.add(textField3);
        frame.add(checkBox);
        frame.add(checkBox1);
        frame.add(checkBox2);
        frame.add(checkBox3);
        frame.add(checkBox4);
        frame.add(checkBox5);
        frame.add(button);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);

        frame.setSize(570, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JFrame.setDefaultLookAndFeelDecorated(true);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File(textField.getText()));
                chooser.setDialogTitle("choose your directory");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
                    System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
                    String newPath = String.valueOf(chooser.getSelectedFile()).replace("\\", "/");
                    newPath += "/";
                    textField.setText(newPath);
                    pathTo = newPath;
                    pathToMove = new File(pathTo);
                } else {
                    System.out.println("Nothing was Selected");
                }
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File(textField1.getText()));
                chooser.setDialogTitle("choose your directory");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
                    System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
                    String newPath = String.valueOf(chooser.getSelectedFile()).replace("\\", "/");
                    newPath += "/";
                    textField1.setText(newPath);
                    pathFromExport = new File(newPath);
                } else {
                    System.out.println("Nothing was Selected");
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File(textField2.getText()));
                chooser.setDialogTitle("choose your directory");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
                    System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
                    String newPath = String.valueOf(chooser.getSelectedFile()).replace("\\", "/");
                    newPath += "/";
                    textField2.setText(newPath);
                    pathFromTMP = new File(newPath);
                } else {
                    System.out.println("Nothing was Selected");
                }
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File(textField3.getText()));
                chooser.setDialogTitle("choose your directory");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
                    System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
                    String newPath = String.valueOf(chooser.getSelectedFile()).replace("\\", "/");
                    newPath += "/";
                    textField3.setText(newPath);
                    pathFromPrograms = new File(newPath);
                } else {
                    System.out.println("Nothing was Selected");
                }
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println(pathToMove);
                System.out.println(pathFromExport);
                System.out.println(pathFromTMP);
                System.out.println(pathTo);

                if (checkBox.isSelected()){
                    FileMover.dwgMover(pathToMove);
                }
                if (checkBox1.isSelected()){
                    DirectoriesCreator.mkDir(pathToMove);
                }
                if (checkBox2.isSelected()){
                    FileManager.excelMover(pathFromExport, pathTo);
                }
                if (checkBox3.isSelected()){
                    FileManager.projectMover(pathFromTMP,pathTo);
                }
                if (checkBox4.isSelected()){
                    try {
                        PDFMerger.mergePDF(pathFromTMP, pathTo);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if (checkBox5.isSelected()){
                    try {
                        FileMover.programsMover(pathFromPrograms, pathToMove);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }

            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // stop program
                frame.dispose(); // close window
                frame.setVisible(false); // hide window
            }
        });


    }
}
