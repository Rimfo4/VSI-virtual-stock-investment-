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
    JDialog loadPopup = new JDialog(StockScreen.this, "로딩 중", false);

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
            case 3 ->{
                stockPrice[0] += randomNormal();
                stockPrice[1] += randomNum(19, 27);
                stockPrice[2] += randomNormal();
                stockPrice[3] += randomNormal();
                stockPrice[4] += randomNormal();
                stockPrice[5] += randomNormal();
                stockPrice[6] += randomNum(10, 15);
            }
            case 4 ->{
                stockPrice[0] += randomNormal();
                stockPrice[1] += randomNormal();
                stockPrice[2] += randomNormal();
                stockPrice[3] += randomNum(-18, -11);
                stockPrice[4] += randomNum(20, 30);
                stockPrice[5] += randomNormal();
                stockPrice[6] += randomNormal();
            }
            case 5 ->{
                stockPrice[0] += randomNum(20, 25);
                stockPrice[1] += randomNormal();
                stockPrice[2] += randomNormal();
                stockPrice[3] += randomNum(30, 35);
                stockPrice[4] += randomNormal();
                stockPrice[5] += randomNum(-18, -12);
                stockPrice[6] += randomNormal();
            }
            case 6 ->{
                stockPrice[0] += randomNormal();
                stockPrice[1] += randomNormal();
                stockPrice[2] += randomNum(-18, -14);
                stockPrice[3] += randomNormal();
                stockPrice[4] += randomNum(-21, -10);
                stockPrice[5] += randomNormal();
                stockPrice[6] += randomNormal();
            }
            case 7 ->{
                stockPrice[0] += randomNum(9, 14);
                stockPrice[1] += randomNum(12, 23);
                stockPrice[2] += randomNormal();
                stockPrice[3] += randomNormal();
                stockPrice[4] += randomNormal();
                stockPrice[5] += randomNum(23, 27);
                stockPrice[6] += randomNormal();
            }
            case 8 ->{
                stockPrice[0] += randomNum(-27, -19);
                stockPrice[1] += randomNormal();
                stockPrice[2] += randomNormal();
                stockPrice[3] += randomNormal();
                stockPrice[4] += randomNum(-8, -6);
                stockPrice[5] += randomNormal();
                stockPrice[6] += randomNum(12, 17);
            }
            case 9 ->{
                stockPrice[0] += randomNormal();
                stockPrice[1] += randomNormal();
                stockPrice[2] += randomNormal();
                stockPrice[3] += randomNum(17, 21);
                stockPrice[4] += randomNum(15, 23);
                stockPrice[5] += randomNormal();
                stockPrice[6] += randomNormal();
            }
            case 10 ->{
                stockPrice[0] += randomNormal();
                stockPrice[1] += randomNum(23, 31);
                stockPrice[2] += randomNum(19, 25);
                stockPrice[3] += randomNormal();
                stockPrice[4] += randomNormal();
                stockPrice[5] += randomNum(27, 32);
                stockPrice[6] += randomNormal();
            }
            case 11 ->{
                stockPrice[0] += randomNum(-48, -37);
                stockPrice[1] += randomNum(-36, -28);
                stockPrice[2] += randomNum(-26, -19);
                stockPrice[3] += randomNormal();
                stockPrice[4] += randomNormal();
                stockPrice[5] += randomNormal();
                stockPrice[6] += randomNormal();
            }
            case 12 ->{
                stockPrice[0] += randomNormal();
                stockPrice[1] += randomNum(16, 20);
                stockPrice[2] += randomNum(14, 21);
                stockPrice[3] += randomNormal();
                stockPrice[4] += randomNormal();
                stockPrice[5] += randomNormal();
                stockPrice[6] += randomNormal();
            }
            case 13 ->{
                stockPrice[0] += randomNormal();
                stockPrice[1] += randomNormal();
                stockPrice[2] += randomNormal();
                stockPrice[3] += randomNum(-21, -17);
                stockPrice[4] += randomNum(-26, -20);
                stockPrice[5] += randomNormal();
                stockPrice[6] += randomNum(-15, -13);
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
        nextScreen.setBounds(1050, 600, 170, 50);
        nextScreen.setForeground(Color.blue);
        add(nextScreen);

        loadPopup.setSize(250, 100);
        loadPopup.setLocationRelativeTo(StockScreen.this);
        loadPopup.setLayout(new BorderLayout());
        loadPopup.add(new JLabel("시스템 처리 중입니다...", SwingConstants.CENTER), BorderLayout.CENTER);

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
                stockSelectNum = 0;
                stockSelectLabel.setText("갖고 있는 엠비디아 주 : "+stockItem[stockSelectNum]);
            }
            case "1" -> {
                stockSelectNum = 1;
                stockSelectLabel.setText("갖고 있는 테술라 주 : "+stockItem[stockSelectNum]);
            }
            case "2" -> {
                stockSelectNum = 2;
                stockSelectLabel.setText("갖고 있는 넹슨 주 : "+stockItem[stockSelectNum]);
            }
            case "3" -> {
                stockSelectNum = 3;
                stockSelectLabel.setText("갖고 있는 사성전자 주 : "+stockItem[stockSelectNum]);
            }
            case "4" -> {
                stockSelectNum = 4;
                stockSelectLabel.setText("갖고 있는 파인애플 주 : "+stockItem[stockSelectNum]);
            }
            case "5" -> {
                stockSelectNum = 5;
                stockSelectLabel.setText("갖고 있는 넷폴릭스 주 : "+stockItem[stockSelectNum]);
            }
            case "6" -> {
                stockSelectNum = 6;
                stockSelectLabel.setText("갖고 있는 켈로그 주 : "+stockItem[stockSelectNum]);
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
                t1 = new Timer(250, after->{
                    new Home();
                    setVisible(false);
                });
                t1.setRepeats(false);
                t1.start();

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
                loadPopup.setVisible(true);

                t1 = new Timer(1500, after -> {
                    loadPopup.setVisible(false);
                    if (coinBoolean(-stockPrice[stockSelectNum] * stockCnt)) {
                        JOptionPane.showMessageDialog(StockScreen.this, stockName[stockSelectNum] + "주식의 " + stockCnt + "주를 매수했습니다.", "매수 완료!",JOptionPane.PLAIN_MESSAGE);
                        stockThenPrice[stockSelectNum] = stockPrice[stockSelectNum];
                        //주 매수
                        stockBonus(stockSelectNum, stockCnt);
                    } else {
                        JOptionPane.showMessageDialog(StockScreen.this, "보유한 코인이 부족합니다.", "오류", JOptionPane.ERROR_MESSAGE);
                    }
                    //화면에 코인 새로고침
                    reloadCoin();
                    nowCoin.repaint();
                });
                //한번만 실행
                t1.setRepeats(false);
                t1.start();
            }
        });
        stockSellButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                loadPopup.setVisible(true);

                t1 = new Timer(1500, after -> {
                    loadPopup.setVisible(false);
                    if (stockBoolean(stockSelectNum, stockCnt)) {
                        JOptionPane.showMessageDialog(StockScreen.this, stockName[stockSelectNum] + "주식의 " + stockCnt + "주를 매도했습니다.", "매도 완료!",JOptionPane.PLAIN_MESSAGE);
                        //코인 추가
                        coinBonus(stockPrice[stockSelectNum] * stockCnt);
                    } else {
                        JOptionPane.showMessageDialog(StockScreen.this, "보유한 주식이 부족합니다.", "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
                    }

                    //화면에 코인 새로고침
                    reloadCoin();
                    nowCoin.repaint();
                });
                // 한번만 실행
                t1.setRepeats(false);
                t1.start();
            }
        });
    }
}
