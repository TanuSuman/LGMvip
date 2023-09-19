import javax.swing.*;
import java.awt.*;

// Class that extends JFrame and implements the text editor
public class Task1 extends JFrame {

    private JTextArea textArea;
    private JMenuBar menuBar;

    public Task1() {
        // Create a new JTextArea component
        textArea = new JTextArea();

        // Create a new JMenuBar component
        menuBar = new JMenuBar();

        // Create a File menu
        JMenu fileMenu = new JMenu("File");

        // Add menu items to the File menu
        fileMenu.add(new JMenuItem("New"));
        fileMenu.add(new JMenuItem("Open"));
        fileMenu.add(new JMenuItem("Save"));
        fileMenu.add(new JMenuItem("Save As"));
        fileMenu.add(new JMenuItem("Print"));
        fileMenu.add(new JMenuItem("Exit"));

        // Create an Edit menu
        JMenu editMenu = new JMenu("Edit");

        // Add menu items to the Edit menu
        editMenu.add(new JMenuItem("Cut"));
        editMenu.add(new JMenuItem("Copy"));
        editMenu.add(new JMenuItem("Paste"));
        editMenu.add(new JMenuItem("Undo"));
        editMenu.add(new JMenuItem("Redo"));

        // Add the File and Edit menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        // Add the text area and menu bar to the main window
        add(textArea, BorderLayout.CENTER);
        setJMenuBar(menuBar);

        // Set the title of the main window
        setTitle("Text Editor");

        // Set the size of the main window
        setSize(800, 600);

        // Set the main window to be visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new Task1();
    }
}
