import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Part2 extends Story implements ActionListener{
    JLabel stockTitle = new JLabel("주식 종류");
    JButton[] stockList = new JButton[7];
    JButton nextP3 = new JButton("다음 화면");

    int x = 70;
    int y = 250;

    Part2(){
        //주식 종류
        stockTitle.setFont(new Font("나눔고딕", Font.BOLD, 70));
        stockTitle.setBounds(500,50,400,80);
        stockTitle.setForeground(Color.pink);
        add(stockTitle);

        //주식 배치
        for(int i = 0; i < stockList.length; i++){
            stockList[i] = new JButton();
            stockList[i].setText(stockName[i]);
            stockList[i].setFont(f1);
            stockList[i].setForeground(Color.BLACK);
            stockList[i].setBounds(x,y,250,70);
            if(i == 3) x = 250;
            else x += 300;
            y += (i == 3) ? 150 : 0;
            stockList[i].setActionCommand(Integer.toString(i));
            stockList[i].addActionListener(this);
            add(stockList[i]);
        }

        nextP3.setFont(f2);
        nextP3.setBounds(950, 600, 200, 50);
        nextP3.setForeground(Color.blue);
        add(nextP3);

        checkDay();
        checkCoin();
        EventLists();
        this.setLayout(null);
        setting();
    }
    public void actionPerformed(ActionEvent e){
        switch(e.getActionCommand()) {
            case "0" -> JOptionPane.showMessageDialog(this, "엠비디아 기업은 주로 그래픽카드를 제작하는 기업입니다.\n" +
                    "AI시대에는 그래픽카드가 너무나도 필요합니다.👍");
            case "1" -> JOptionPane.showMessageDialog(this,"테술라 기업은 차세대 미래를 위한 전기차를 생산하는 기업입니다.\n" +
                    "차 뿐만 아니라 우주선, 전세계 와이파이 등 여러가지 활동을 합니다. 🦾");
            case "2" -> JOptionPane.showMessageDialog(this, "넹슨 기업은 유명한 게임 IP 보유 및 게임을 만드는 기업입니다.\n" +
                    "시대가 바뀌어도 게임 시장은 커져가기에 장기 투자에 좋습니다. 갓상혁🌟");
            case "3" -> JOptionPane.showMessageDialog(this, "사성전자 기업은 핸드폰을 주로 만드는 반도체 기업입니다.\n" +
                    "\"일상에 편리함을 준다\"라는 신념을 갖고 있기에 다른 전자제품도 제작하고 있습니다.\n" +
                    "또한 파인애플 기업과 라이벌 관계를 형성하고 있습니다. 🌌");
            case "4" -> JOptionPane.showMessageDialog(this, "파인애플 기업은 핸드폰이 주 무기인 반도체 기업입니다.\n" +
                    "\"기기는 심플하게\"라는 신념으로 기업의 이미지와 특유의 감성이 더해져 고급진 기업을 상기시킵니다.\n" +
                    "또한 사성전자와 라이벌 관계를 형성하고 있습니다. 🍎");
            case "5" -> JOptionPane.showMessageDialog(this, "넷폴릭스 기업은 OTT라는 무시무시한 인터넷 스트리밍 기업입니다.\n" +
                    "다양한 컨텐츠와 세계를 뒤집는 참신한 유행을 선도하는 기업입니다. 🍿");
            case "6" -> JOptionPane.showMessageDialog(this, "켈로그 기업은 간식, 음식 등을 만드는 식품기업입니다.\n" +
                    "사용자에게 좋은 식품을 준다는 신념으로 선행을 하는 기업입니다.🥣");
        }
    }
    void EventLists(){
        nextP3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SelectStory();
                setVisible(false);
            }
        });
    }
}
