import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockScreen extends Story{
    JLabel[] stockList = new JLabel[7];
    JLabel[] nowStockPrice = new JLabel[7];

    JButton nextScreen = new JButton("다음 화면");
    StockScreen(){
        //"300, 210, 40, 120, 240, 170, 90"
        switch(getStory()){
            case 0 -> {
                stockPrice[0] += randomNum(-40, -30);
                stockPrice[1] += randomNum(-40, -20);
                stockPrice[2] += randomNormal();
                stockPrice[3] += randomNum(-25, -10);
                stockPrice[4] += randomNum(-27, -15);
                stockPrice[5] += randomNormal();
                stockPrice[6] += randomNormal();
            }
            case 1 ->{
                stockPrice[0] += randomNum(-20, -10);
                stockPrice[1] += randomNum(-10, -5);
                stockPrice[2] += randomNum(25, 40);
                stockPrice[3] += randomNormal();
                stockPrice[4] += randomNormal();
                stockPrice[5] += randomNormal();
                stockPrice[6] += randomNormal();
            }
            case 2 ->{
                stockPrice[0] += randomNum(15, 30);
                stockPrice[1] += randomNormal();
                stockPrice[2] += randomNormal();
                stockPrice[3] += randomNormal();
                stockPrice[4] += randomNormal();
                stockPrice[5] += randomNormal();
                stockPrice[6] += randomNum(-20, -10);
            }
        }

        //주식 배치
        for(int i = 0; i < stockList.length; i++){
            //주식 리스트
            stockList[i] = new JLabel();
            stockList[i].setText(stockName[i]);
            stockList[i].setFont(f2);
            stockList[i].setForeground(Color.BLACK);
            stockList[i].setBounds(30,i*100,300,40);
            add(stockList[i]);
            //현재 주식 가격
            nowStockPrice[i] = new JLabel();
            stockPrice[i] *= 100;
            double temp = (int)stockPrice[i];
            stockPrice[i] = temp/100;
            nowStockPrice[i].setText(String.valueOf(stockPrice[i]));
            nowStockPrice[i].setFont(f3);
            nowStockPrice[i].setForeground(Color.BLACK);
            nowStockPrice[i].setBounds(200,i*100,200,40);
            add(nowStockPrice[i]);
            // 매수
            stockBuyButton[i] = new JButton("1주 매수");
            stockBuyButton[i].setFont(f3);
            stockBuyButton[i].setBounds(300,i*100,120,40);
            stockBuyButton[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    coinPlus(-1);
                    //System.out.println(stockName[i]+"1주를 구매했습니다.");
                    checkCoin();
                }
            });
            add(stockBuyButton[i]);
            // 매도
            stockSellButton[i] = new JButton("1주 매도");
            stockSellButton[i].setFont(f3);
            stockSellButton[i].setBounds(430,i*100,120,40);
            add(stockSellButton[i]);
        }



        //다음 화면
        nextScreen.setFont(f2);
        nextScreen.setBounds(1050, 600, 180, 50);
        nextScreen.setForeground(Color.blue);
        EventLists("0");
        add(nextScreen);

        checkDay();
        checkCoin();
        setLayout(null);
        setting();
    }
    void EventLists(String key){
        switch (key){
            case "0" ->{
                nextScreen.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        new Home();
                        setVisible(false);
                    }
                });
            }
            /*case "01", ->{
                stockBuyButton[1].addActionListener(new ActionListener()){
                    public void actionPerformed(ActionEvent e){

                    }
                }
            }*/

        }

    }
}
