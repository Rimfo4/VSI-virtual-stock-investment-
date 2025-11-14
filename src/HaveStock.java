import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HaveStock extends Story implements ActionListener{
    JButton[] stockList = new JButton[7];
    JLabel haveStock = new JLabel("보유한 주식들");
    int x = 50;
    int y = 150;

    HaveStock(){
        for(int i = 0; i < stockList.length; i++){
            stockList[i] = new JButton();
            stockList[i].setText(stockName[i]);
            stockList[i].setFont(f3);
            stockList[i].setBounds(x, y,120,40);
            if(i == 3) x = 125;
            else x += 150;
            y += (i == 3) ? 150 : 0;
            stockList[i].setActionCommand(Integer.toString(i));
            stockList[i].addActionListener(this);
            add(stockList[i]);
        }

        haveStock.setBounds(250, 40, 200, 50);
        haveStock.setFont(f2);
        haveStock.setForeground(Color.orange);
        add(haveStock);


        setLayout(null);
        setSize(720, 480);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        switch (e.getActionCommand()){
            case "0" -> {
                JOptionPane.showMessageDialog(this, "현재 갖고 있는 엠비디아 주 : "+stockItem[0]+"\n 매수 했던 당시 주가 : "+stockThenPrice[0]);
            }
            case "1" -> {
                JOptionPane.showMessageDialog(this, "현재 갖고 있는 테술라 주 : "+stockItem[1]+"\n 매수 했던 당시 주가 : "+stockThenPrice[1]);
            }
            case "2" -> {
                JOptionPane.showMessageDialog(this, "현재 갖고 있는 넹슨 주 : "+stockItem[2]+"\n 매수 했던 당시 주가 : "+stockThenPrice[2]);
            }
            case "3" -> {
                JOptionPane.showMessageDialog(this, "현재 갖고 있는 사성전자 주 : "+stockItem[3]+"\n 매수 했던 당시 주가 : "+stockThenPrice[3]);
            }
            case "4" -> {
                JOptionPane.showMessageDialog(this, "현재 갖고 있는 파인애플 주 : "+stockItem[4]+"\n 매수 했던 당시 주가 : "+stockThenPrice[4]);
            }
            case "5" -> {
                JOptionPane.showMessageDialog(this, "현재 갖고 있는 넷폴리스 주 : "+stockItem[5]+"\n 매수 했던 당시 주가 : "+stockThenPrice[5]);
            }
            case "6" -> {
                JOptionPane.showMessageDialog(this, "현재 갖고 있는 켈로그 주 : " + stockItem[6]+"\n 매수 했던 당시 주가 : "+stockThenPrice[6]);
            }
        }
    }
}
