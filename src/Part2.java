import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Part2 extends Story {
    JLabel stockTitle = new JLabel("주식 종류");
    JLabel[] stockList = new JLabel[7];
    JButton nextP3 = new JButton("다음 화면");

    int x = 150;
    int y = 150;

    Part2(){
        //주식 종류
        stockTitle.setFont(f1);
        stockTitle.setBounds(500,50,400,50);
        add(stockTitle);

        //주식 배치
        for(int i = 0; i < stockList.length; i++){
            stockList[i] = new JLabel();
            stockList[i].setText(stockName[i]);
            stockList[i].setFont(f2);
            stockList[i].setForeground(Color.BLACK);
            stockList[i].setBounds(x,y,300,40);
            if(i == 4) x = 150;
            else x += 200;
            y += i == 4 ? 100 : 0;
            add(stockList[i]);
        }

        nextP3.setFont(f2);
        nextP3.setBounds(800, 500, 200, 50);
        nextP3.setForeground(Color.blue);
        EventLists(1);
        add(nextP3);

        checkCoin();
        this.setLayout(null);
        setting();
    }
    void EventLists(int key){
        if(key == 1) {
            nextP3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new SelectStory();
                    setVisible(false);
                }
            });
        }
    }
}
