/**
 * Jesus Salas
 * CSIS 24
 * Created and finished: 11/22/2016
 * This program will run a demo version of a tic tac toe game
 */
import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.awt.event.*;
import java.io.*;


public class TicTacToeDemo extends JFrame
{

    JFrame mainFrame = new JFrame("TIC-TAC-TOE!");
    private JPanel p1;
    private JTextArea textArea = new JTextArea("Player X's Turn!");
    JButton b[][] = new JButton[3][3];
    private boolean replay, buttonOption;
    private int count = 0;

    //constructor
    public TicTacToeDemo ()
    {

        // initialize JFrame, JButton Array, and local variables
        mainFrame.setSize(600,600);
        p1 = new JPanel();
        mainFrame.setResizable(false);


        //add windowListener to close on exit
        mainFrame.addWindowListener(new WindowAdapter() {


            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

    }

    public void initializeComponents ()
    {

        textArea.setFont(new Font("SanSerif", Font.BOLD, 70));
        textArea.setForeground(Color.BLACK);
        textArea.setEditable(false);
        p1.setLayout(new GridLayout(3,3));


        int count = 0;
        //Assign numbers to each button

        for(int i = 0; i < b.length; i++)
        {

            for (int j = 0; j < b.length; j++)
            {
                count++;

                String stringCount = Integer.toString(count);

                b[i][j] = new JButton(stringCount);

            }
        }

        // create container and organize buttons in GridLayout
        mainFrame.setLayout(new BorderLayout());

        for(int i = 0; i < b.length; i++)
        {
            for (int j = 0; j < b.length; j++)
                p1.add(b[i][j]);

        }

        // assign each button to Event Handler
        ButtonHandlingX handler1 = new ButtonHandlingX();

        for (int i = 0; i < b.length; i++)
        {
            for (int j = 0; j < b.length; j++)
            {
                b[i][j].addActionListener(handler1);

            }
        }
        mainFrame.add(p1, BorderLayout.CENTER);
        mainFrame.add(textArea, BorderLayout.NORTH);

        //make window visible and in the center of the screen
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }


    //inner class to handle button array
    class ButtonHandlingX implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            if (buttonOption == false)
            {

                if (e.getSource() instanceof JButton)
                {
                    ((JButton) e.getSource()).setBackground(Color.BLUE);
                    ((JButton) e.getSource()).setFont(new Font("TimesNewRoman", Font.BOLD, 40));
                    ((JButton) e.getSource()).setText("X");
                    ((JButton) e.getSource()).setForeground(Color.white);
                    ((JButton) e.getSource()).setEnabled(false);
                    textArea.setText("Player O's turn!");
                    textArea.setEditable(false);

                    // top row
                    if(b[0][0].getText() == b[0][1].getText() && b[0][1].getText() == b[0][2].getText() && b[0][0].getText() == b[0][2].getText())
                    {
                        JOptionPane.showMessageDialog(null, b[0][0].getText() + " Wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                        // Left column
                    else if(b[0][0].getText() == b[1][0].getText() && b[1][0].getText() == b[2][0].getText() && b[0][0].getText() == b[2][0].getText())
                    {
                        JOptionPane.showMessageDialog(null, b[0][0].getText() + " Wins!", "Winner", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                        // Middle column
                    else if(b[0][1].getText() == b[1][1].getText() && b[1][1].getText() == b[2][1].getText() && b[0][1].getText() == b[2][1].getText())
                    {
                        JOptionPane.showMessageDialog(null, b[0][1].getText() + " Wins!", "Winner", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                        // Right column
                    else if(b[0][2].getText() == b[1][2].getText() && b[1][2].getText() == b[2][2].getText() && b[0][2].getText() == b[2][2].getText())
                    {
                        JOptionPane.showMessageDialog(null, b[0][2].getText() + " Wins!", "Winner", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                        // Bottom row
                    else if(b[2][0].getText() == b[2][1].getText() && b[2][1].getText() == b[2][2].getText() && b[2][0].getText() == b[2][2].getText())
                    {
                        JOptionPane.showMessageDialog(null, b[2][0].getText() + " Wins!", "Winner", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                        // Middle row
                    else if(b[1][0].getText() == b[1][1].getText() && b[1][1].getText() == b[1][2].getText() && b[1][0].getText() == b[1][2].getText())
                    {
                        JOptionPane.showMessageDialog(null, b[1][0].getText() + " Wins!", "Winner", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                        // Diagonal 1
                    else if(b[0][0].getText() == b[1][1].getText() && b[1][1].getText() == b[2][2].getText() && b[0][0].getText() == b[2][2].getText())
                    {
                        JOptionPane.showMessageDialog(null, b[0][0].getText() + " Wins!", "Winner", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                        // Diagonal 2
                    else if(b[0][2].getText() == b[1][1].getText() && b[1][1].getText() == b[2][0].getText() && b[0][2].getText() == b[2][0].getText())
                    {
                        JOptionPane.showMessageDialog(null, b[0][2].getText() + " Wins!", "Winner", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                    else
                        count++;

                    checkTie();
                }

                buttonOption = true;

            }

            else
            {
                if (e.getSource() instanceof JButton) {
                    ((JButton) e.getSource()).setBackground(Color.RED);
                    ((JButton) e.getSource()).setFont(new Font("TimesNewRoman", Font.BOLD, 40));
                    ((JButton) e.getSource()).setText("O");
                    ((JButton) e.getSource()).setForeground(Color.white);
                    ((JButton) e.getSource()).setEnabled(false);
                    textArea.setText("Player X's turn!");
                    textArea.setEditable(false);

                    // top row
                    if(b[0][0].getText() == b[0][1].getText() && b[0][1].getText() == b[0][2].getText() && b[0][0].getText() == b[0][2].getText())
                    {
                        JOptionPane.showMessageDialog(null, b[0][0].getText() + " Wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                    // Left column
                    else if(b[0][0].getText() == b[1][0].getText() && b[1][0].getText() == b[2][0].getText() && b[0][0].getText() == b[2][0].getText())
                    {
                        JOptionPane.showMessageDialog(null, b[0][0].getText() + " Wins!", "Winner", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                    // Middle column
                    else if(b[0][1].getText() == b[1][1].getText() && b[1][1].getText() == b[2][1].getText() && b[0][1].getText() == b[2][1].getText())
                    {
                        JOptionPane.showMessageDialog(null, b[0][1].getText() + " Wins!", "Winner", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                    // Right column
                    else if(b[0][2].getText() == b[1][2].getText() && b[1][2].getText() == b[2][2].getText() && b[0][2].getText() == b[2][2].getText())
                    {
                        JOptionPane.showMessageDialog(null, b[0][2].getText() + " Wins!", "Winner", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                    // Bottom row
                    else if(b[2][0].getText() == b[2][1].getText() && b[2][1].getText() == b[2][2].getText() && b[2][0].getText() == b[2][2].getText())
                    {
                        JOptionPane.showMessageDialog(null, b[2][0].getText() + " Wins!", "Winner", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                    // Middle row
                    else if(b[1][0].getText() == b[1][1].getText() && b[1][1].getText() == b[1][2].getText() && b[1][0].getText() == b[1][2].getText())
                    {
                        JOptionPane.showMessageDialog(null, b[1][0].getText() + " Wins!", "Winner", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                    // Diagonal 1
                    else if(b[0][0].getText() == b[1][1].getText() && b[1][1].getText() == b[2][2].getText() && b[0][0].getText() == b[2][2].getText())
                    {
                        JOptionPane.showMessageDialog(null, b[0][0].getText() + " Wins!", "Winner", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                    // Diagonal 2
                    else if(b[0][2].getText() == b[1][1].getText() && b[1][1].getText() == b[2][0].getText() && b[0][2].getText() == b[2][0].getText())
                    {
                        JOptionPane.showMessageDialog(null, b[0][2].getText() + " Wins!", "Winner", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                    else
                        count++;

                    checkTie();

                }

                buttonOption = false;
            }

        }



    }



    public void checkTie()
    {

        int turns =0;

        if(count == 9)
        {
            JOptionPane.showMessageDialog(null, "Tie Game!", "Tie", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        else
            turns++;

    }




    public static void main (String[] args)
    {

        TicTacToeDemo trial1 = new TicTacToeDemo();
        trial1.initializeComponents();

    }

}
