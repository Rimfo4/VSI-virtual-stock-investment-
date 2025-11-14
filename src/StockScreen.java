import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockScreen extends Story implements ActionListener{
    JLabel[] stockList = new JLabel[7];
    JLabel[] nowStockPrice = new JLabel[7];
    JButton[] stockSelectButton = new JButton[7];
    JLabel stockSelectLabel= new JLabel();

    JButton stockCountCheck = new JButton("확인");
    JTextField stockCount = new JTextField("수량 입력");
    JButton nextScreen = new JButton("다음 화면");
    int stockCnt = 0;
    int stockSelectNum = 0;
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

            //선택 버튼
            stockSelectButton[i] = new JButton("주식 선택");
            stockSelectButton[i].setFont(f3);
            stockSelectButton[i].setBounds(300,i*100,150,40);
            add(stockSelectButton[i]);
            //각 버튼의 눌렀을 때 이벤트
            stockSelectButton[i].setActionCommand(Integer.toString(i));
            stockSelectButton[i].addActionListener(this);
        }

        //매수
        stockBuyButton = new JButton("매수");
        stockBuyButton.setFont(f3);
        stockBuyButton.setBounds(600,400,120,40);
        stockBuyButton.setVisible(false);
        add(stockBuyButton);

        //매도
        stockSellButton = new JButton("매도");
        stockSellButton.setFont(f3);
        stockSellButton.setBounds(800,400,120,40);
        stockSellButton.setVisible(false);
        add(stockSellButton);

        //선택된 주식 이름
        stockSelectLabel.setBounds(550, 150, 550, 50);
        stockSelectLabel.setFont(f2);
        add(stockSelectLabel);

        //주식 수량, 확인 버튼
        stockCount.setBounds(650, 275, 200, 30);
        stockCount.setVisible(false);
        stockCount.setFont(f3);
        add(stockCount);

        stockCountCheck.setBounds(870, 275, 120, 30);
        stockCountCheck.setFont(f3);
        stockCountCheck.setVisible(false);
        add(stockCountCheck);

        //다음 화면
        nextScreen.setFont(f2);
        nextScreen.setBounds(1050, 600, 180, 50);
        nextScreen.setForeground(Color.blue);

        add(nextScreen);

        EventLists();
        checkDay();
        checkCoin();
        setLayout(null);
        setting();
    }
    //배열이기에 EventList 메소드와 따로 구분
    public void actionPerformed(ActionEvent e){
        switch(e.getActionCommand()){
            case "0" ->{
                stockSelectLabel.setText("엠비디아 주식 수량을 입력해주세요.");
                stockSelectNum = 0;
            }
            case "1" -> {
                stockSelectLabel.setText("테술라 주식 수량을 입력해주세요.");
                stockSelectNum = 1;
            }
            case "2" -> {
                stockSelectLabel.setText("넹슨 주식 수량을 입력해주세요.");
                stockSelectNum = 2;
            }
            case "3" -> {
                stockSelectLabel.setText("사성전자 주식 수량을 입력해주세요.");
                stockSelectNum = 3;
            }
            case "4" -> {
                stockSelectLabel.setText("파인애플 주식 수량을 입력해주세요.");
                stockSelectNum = 4;
            }
            case "5" -> {
                stockSelectLabel.setText("넷폴릭스 주식 수량을 입력해주세요.");
                stockSelectNum = 5;
            }
            case "6" -> {
                stockSelectLabel.setText("켈로그 주식 수량을 입력해주세요.");
                stockSelectNum = 6;
            }
        }
        stockCount.setVisible(true);
        stockCountCheck.setVisible(true);
        stockSellButton.setVisible(true);
        stockBuyButton.setVisible(true);
    }
    void EventLists(){
        nextScreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home();
                setVisible(false);
            }
        });
        stockCountCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    stockCnt = Integer.parseInt(stockCount.getText());
                    if(stockCnt < 0){
                        JOptionPane.showMessageDialog(StockScreen.this,"0 미만 숫자는 고를 수 없습니다.");
                        stockCnt = 0;
                    }
                    else{
                        JOptionPane.showMessageDialog(StockScreen.this,stockCnt+"주를 고르셨습니다.");
                    }
                }
                catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(StockScreen.this,"숫자(자연수)만 입력해주십시오.");
                }
            }
        });
        stockBuyButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(coinBoolean(-stockPrice[stockSelectNum]*stockCnt)){
                    System.out.println(stockName[stockSelectNum]+"주식의 "+stockCnt+"주를 매수했습니다.");
                    //주 매수
                    stockBonus(stockSelectNum, stockCnt);
                }
                else{
                    JOptionPane.showMessageDialog(StockScreen.this, "보유한 코인이 부족합니다.");
                }
                //화면에 코인 새로고침
                reloadCoin();
                nowCoin.repaint();
            }
        });
        stockSellButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(stockBoolean(stockSelectNum, stockCnt)){
                    System.out.println(stockName[stockSelectNum]+"주식의 "+stockCnt+"주를 매도했습니다.");
                    //코인 추가
                    coinBonus(stockPrice[stockSelectNum]*stockCnt);
                }
                else{
                    JOptionPane.showMessageDialog(StockScreen.this, "보유한 주식이 부족합니다.");
                }
                //화면에 코인 새로고침
                reloadCoin();
                nowCoin.repaint();
            }
        });
    }
}
