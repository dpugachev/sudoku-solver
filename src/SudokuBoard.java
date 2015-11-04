/**
 * Created by Dimitri on 03/11/2015.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SudokuBoard extends JFrame{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Rectangle rect = new Rectangle(screenSize.width/2 - screenSize.width/4,
            screenSize.height/2 - screenSize.height/4, screenSize.width/2,
            screenSize.height/2);
    final static int maxGap = 2;
    JButton solveButton = new JButton("Solve");
    GridLayout sudokuGrid = new GridLayout(9,9);




    public SudokuBoard(String name){
        super(name);
        setResizable(false);
    }

    public void addComponentsToPane(final Container pane) {
        final JPanel sudokuPanel = new JPanel();
        sudokuPanel.setLayout(sudokuGrid);
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(3, 1));

        // Set up components preferred size
        sudokuPanel.setPreferredSize(new Dimension(rect.width, rect.height));

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudokuPanel.add(new JButton("Button"));
            }
            }
            // add buttons to set up horizontal and vertical gaps
            buttons.add(solveButton);

            solveButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    sudokuGrid.setHgap(5);
                    sudokuGrid.setVgap(5);
                    sudokuGrid.layoutContainer(sudokuPanel);
                }
            });

            pane.add(sudokuPanel, BorderLayout.WEST);
            //  pane.add(new JSeparator(), BorderLayout.CENTER);
            pane.add(buttons, BorderLayout.EAST);

        }



    // Create the GUI and show it
    private static void createAndShowGUI(){
        // Create and set up the window
        SudokuBoard frame = new SudokuBoard("Sudoku Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


       /* JMenuBar mBar = new JMenuBar();
        mBar.setOpaque(true);
        mBar.setBackground(new Color(0, 255, 255));
        mBar.setPreferredSize(new Dimension(200, 20));
    */

        //Set up the content pane
        frame.addComponentsToPane(frame.getContentPane());

        // Display window
        frame.pack();
        frame.setVisible(true);
    }



    public static void main(String[] args){
        /* Use an appropriate Look and Feel */
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        // Schedule a job for the event dispatch thread:
        // creating and showing this applicaiton's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                createAndShowGUI();
            };
        });









    }

}