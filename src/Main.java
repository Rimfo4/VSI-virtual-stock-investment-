import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    JButton button1 = new JButton();
    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    JButton button5 = new JButton();

    public Main(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLayout(null);
        this.setButtonList();
        this.setVisible(true);
    }
    public void setButtonList(){
//        for(int i = 0; i < buttonList.length; i++){
//            buttonList[i].setText("버튼"+i);
//            this.add(buttonList[i]);
//        }
        button1.setText("버튼 1");
        button1.setBounds(100, 100, 100, 100);
        this.add(button1);

        button2.setText("버튼 2");
        button2.setBounds(300, 200, 100, 100);
        this.add(button2);

        button3.setText("버튼 3");
        button3.setBounds(500, 300, 100, 100);
        this.add(button3);

        button4.setText("버튼 4");
        button4.setBounds(700, 400, 100, 100);
        this.add(button4);

        button5.setText("버튼 5");
        button5.setBounds(900, 500, 100, 100);
        this.add(button5);
    }
    public static void main(String[] args) {
        new Main();
    }
}
