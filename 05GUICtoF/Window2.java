import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Window2 extends JFrame implements ActionListener{
    private Container pane;

    private JButton far,cel;
    private JLabel answer;
    private JTextField text;
    public Window2() {
	this.setTitle("My first GUI");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);


	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	answer=new JLabel("");
	far = new JButton("Convert to Farenheit");
	cel = new JButton("Convert to Celsius");
	text = new JTextField(12);
	pane.add(far);
	pane.add(cel);
	pane.add(text);
	pane.add(answer);
	far.addActionListener(this);
	far.setActionCommand("tofar");
	cel.addActionListener(this);
	cel.setActionCommand("tocel");
    }
    public void actionPerformed(ActionEvent e){
	String s=e.getActionCommand();
	String theInput=text.getText();
	try{
	    Double ans=Double.valueOf(theInput);
	    if (s=="tofar"){
		ans=ans*9/5+32;
		answer.setText(""+ans+" F");
	    }
	    else if(s=="tocel"){
		ans=(ans-32)*5/9;
		answer.setText(""+ans+" C");
	    }
	}catch(NumberFormatException n){
	    System.out.println("Please enter a number");
	}
    }
    public static void main(String[] args) {
	Window2 g = new Window2();
        g.setVisible(true);
    }
}
