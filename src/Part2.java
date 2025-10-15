import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Part2 extends Story {
    JLabel stockTitle = new JLabel("주식 종류");
    JLabel[] stock = new JLabel[7];
    JButton nextP3 = new JButton("다음으로");

    int x = 150;
    int y = 150;
    Part2(){
        //주식 종류
        stockTitle.setFont(f1);
        stockTitle.setBounds(500,50,400,50);
        add(stockTitle);

        //주식 배치
        for(int i = 0; i < stock.length; i++){
            stock[i] = new JLabel();
            stock[i].setText(Main.stockName[i]);
            stock[i].setFont(f2);
            stock[i].setForeground(Color.BLACK);
            stock[i].setBounds(x,y,300,40);
            if(i == 4) x = 150;
            else x += 200;
            y += i == 4 ? 100 : 0;
            add(stock[i]);
        }

        nowMoney.setFont(f1);
        nowMoney.setBounds(300, 500, 500, 50);
        add(nowMoney);

        nextP3.setFont(f2);
        nextP3.setBounds(800, 500, 300, 50);
        add(nextP3);
        nextP3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new SelectStory();
                setVisible(false);
            }
        });

        this.setLayout(null);
        setting();
    }
}
