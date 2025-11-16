import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends Story{
    JLabel title = new JLabel();
    JButton[] objButton = new JButton[3];

    Home(){
        objButton[0] = new JButton();
        objButton[0].setText("보유한 주식");
        objButton[0].setBounds(50, 300, 300, 150);
        objButton[0].setFont(new Font("나눔고딕", Font.BOLD, 45));
        add(objButton[0]);

        objButton[1] = new JButton();
        objButton[1].setText("잡화점");
        objButton[1].setBounds(900, 300, 300, 150);
        objButton[1].setFont(new Font("나눔고딕", Font.BOLD, 60));
        add(objButton[1]);

        objButton[2] = new JButton();
        objButton[2].setText("하루 끝내기");
        objButton[2].setBounds(450, 500, 300, 150);
        objButton[2].setFont(new Font("나눔고딕", Font.BOLD, 45));
        add(objButton[2]);

        title.setText("메뉴창");
        title.setFont(new Font("나눔고딕", Font.BOLD, 70));
        title.setBounds(500, 50, 300, 70);
        title.setForeground(Color.pink);
        add(title);

        setLayout(null);
        EventList();
        checkDay();
        checkCoin();
        setting();
        setVisible(true);
    }

    void EventList(){
        objButton[0].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new HaveStock();
            }
        });
        objButton[1].addActionListener((new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new Shop();
            }
        }));
        objButton[2].addActionListener((new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dayPlus();
                t1 = new Timer(250, after->{
                    //8일차 인지 체크용
                    if(toEndDay()) {
                        new End();
                        setVisible(false);
                    }
                    else{
                        new SelectStory();
                        setVisible(false);
                    }
                });
                t1.setRepeats(false);
                t1.start();

            }
        }));
    }
}
