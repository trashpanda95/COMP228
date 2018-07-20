import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/*
 * @author Ilia Nika
 * @version 1.0
 */
public class LayoutManagersTest extends JFrame {
    private JPanel pNorth, pCenter,pWest, pEast,
            pSouth;
    private JLabel lblName,lblPosition;
    private JTextField txtName, txtPosition;
    private JButton left, center,right;
    private JButton bEast, bWest;
    private JButton bSouth1, bSouth2;
    //
    //create GUI components in constructor
    public LayoutManagersTest() {
        //create the panels for each of the areas of this frame
        pNorth = new JPanel();
        pCenter = new JPanel();
        pWest = new JPanel();
        pEast = new JPanel();
        pSouth = new JPanel();

        //create the JButtons
        left = new JButton("Left");
        center = new JButton("Center");
        right = new JButton("Right");
        bWest = new JButton("West");
        bEast = new JButton("East");
        bSouth1 = new JButton("Java Programming");
        bSouth2 = new JButton("COMP228");
        //register buttons with an action listener
        ButtonHandler bHandler = new ButtonHandler();
        left.addActionListener(bHandler);
        center.addActionListener(bHandler);
        right.addActionListener(bHandler);
        //place the buttons on the north panel
        pNorth.add(left);
        pNorth.add(center);
        pNorth.add(right);
        pNorth.setBackground(Color.red);
        //create simple entry screen in the center panel
        pCenter.setLayout(new GridLayout(2,2,5,5));
        lblName = new JLabel("Name:");
        lblPosition = new JLabel("Position:");
        txtName = new JTextField(20);
        txtPosition = new JTextField(20);
        pCenter.add(lblName);
        pCenter.add(txtName);
        pCenter.add(lblPosition);
        pCenter.add(txtPosition);
        pCenter.setBackground(Color.green);
        //add a button to east panel
        pEast.add(bEast);
        pEast.setBackground(Color.green);
        //add a button to west panel
        pWest.add(bWest);
        pWest.setBackground(Color.orange);
        //add two buttons to south panel
        pSouth.add(bSouth1);
        pSouth.add(bSouth2);
        pSouth.setBackground(Color.lightGray);
        //add panels to the container

        add(pNorth,BorderLayout.NORTH);
        add(pCenter,BorderLayout.CENTER);
        add(pEast,BorderLayout.EAST);
        add(pWest,BorderLayout.WEST);
        add(pSouth,BorderLayout.SOUTH);
        pack();
        //
    }
    private class ButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==left)
                pNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
            else if (e.getSource()==center)
                pNorth.setLayout(new FlowLayout(FlowLayout.CENTER));
            else if (e.getSource()==right)
                pNorth.setLayout(new FlowLayout(FlowLayout.RIGHT));
            pNorth.validate();
        }
    }
    public static void main(String[] args) {
        LayoutManagersTest testLayoutManagers1 = new LayoutManagersTest();
        testLayoutManagers1.setTitle("TESTING THE LAYOUT MANAGERS");
        testLayoutManagers1.setSize(500,300);
        testLayoutManagers1.setVisible(true);
    }
}
