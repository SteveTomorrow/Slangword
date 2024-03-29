package slang.swing.quesstion;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import slang.swing.read.SlangWord;
import slang.swing.shows.MenuSWFrame;

public class QuestionSWFrame extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, btnBack;
    // final int type;
    String s[];

    public QuestionSWFrame(int type) {
        s = (SlangWord.getInstance()).quiz(type);
        // A Label
        JLabel label = new JLabel("Choose the correct answer");
        label.setForeground(Color.BLUE);
        label.setFont(new Font("Gill Sans MT", Font.PLAIN, 35));
        label.setAlignmentX(CENTER_ALIGNMENT);
        label.setAlignmentY(-100);
        JLabel questionLabel;
        if (type == 1)
            questionLabel = new JLabel("Slang " + "`" + s[0] + "`" + " nghĩa là?");
        else
            questionLabel = new JLabel("`" + s[0] + "`" + " có Slang Word là?");
        questionLabel.setForeground(Color.black);
        questionLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
        questionLabel.setAlignmentX(CENTER_ALIGNMENT);
        questionLabel.setAlignmentY(-100);

        // Add space
        // A Grid Answers
        b1 = new JButton("A." + s[1]);
        b1.addActionListener(this);
//        b1.setBackground(Color.green);
        b1.setFont(new Font("Lucida Handwriting", Font.PLAIN, 14));
        b1.setForeground(Color.red);
        b2 = new JButton("B." + s[2]);
        b2.addActionListener(this);
//        b2.setBackground(Color.green);
        b2.setFont(new Font("Lucida Handwriting", Font.PLAIN, 14));
        b2.setForeground(Color.red);
        b3 = new JButton("C." + s[3]);
        b3.addActionListener(this);
        b3.setFont(new Font("Lucida Handwriting", Font.PLAIN, 14));
        b3.setForeground(Color.red);
//        b3.setBackground(Color.green);
        b4 = new JButton("D. " + s[4]);
        b4.addActionListener(this);
        b4.setFont(new Font("Lucida Handwriting", Font.PLAIN, 14));
        b4.setForeground(Color.red);
//        b4.setBackground(Color.green);

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(2, 2, 10, 10));
        panelCenter.add(b1);
        panelCenter.add(b2);
        panelCenter.add(b3);
        panelCenter.add(b4);
        Dimension size2 = new Dimension(600, 200);
        panelCenter.setMaximumSize(size2);
        panelCenter.setPreferredSize(size2);
        panelCenter.setMinimumSize(size2);
        // Button back

        btnBack = new JButton("Back");
        btnBack.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnBack);

        Container con = this.getContentPane();
        con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
        con.add(Box.createRigidArea(new Dimension(0, 10)));
        con.add(label);
        con.add(Box.createRigidArea(new Dimension(0, 30)));
        con.add(questionLabel);
        con.add(Box.createRigidArea(new Dimension(0, 50)));
        con.add(panelCenter);
        con.add(Box.createRigidArea(new Dimension(0, 50)));
        con.add(buttonPanel);
        this.setTitle("Question Quiz");
        this.setVisible(true);
        this.setSize(700, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == b1) {
            this.answer(1);
        } else if (e.getSource() == b2) {
            this.answer(2);
        } else if (e.getSource() == b3) {
            this.answer(3);
        } else if (e.getSource() == b4) {
            this.answer(4);
        } else if (e.getSource() == btnBack) {
            this.dispose();
            new MenuSWFrame();        }
    }

    public void answer(int ans) {
        if (s[ans].equals(s[5])) {
            // default title and icon
            JOptionPane.showMessageDialog(this, "Correct Answer.");

        } else {
            JOptionPane.showMessageDialog(this, "Wrong Answer", "Inane error", JOptionPane.ERROR_MESSAGE);
            if (ans == 1)
                b1.setBackground(Color.red);
            else if (ans == 2)
                b2.setBackground(Color.red);
            else if (ans == 3)
                b3.setBackground(Color.red);
            else if (ans == 4)
                b4.setBackground(Color.red);
        }
        if (s[1].equals(s[5])) {
            b1.setEnabled(false);
            b1.setBackground(Color.yellow);
        } else {
            b1.setEnabled(false);
        }
        if (s[2].equals(s[5])) {
            b2.setEnabled(false);
            b2.setBackground(Color.yellow);
        } else {
            b2.setEnabled(false);
        }
        if (s[3].equals(s[5])) {
            b3.setEnabled(false);
            b3.setBackground(Color.yellow);
        } else {
            b3.setEnabled(false);
        }
        if (s[4].equals(s[5])) {
            b4.setEnabled(false);
            b4.setBackground(Color.yellow);
        } else {
            b4.setEnabled(false);
        }
    }
}
