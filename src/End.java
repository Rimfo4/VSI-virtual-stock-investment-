import javax.swing.*;
import java.awt.*;

public class End extends Story{
    JLabel playerLabel = new JLabel();
    JLabel[] totalLabel = new JLabel[4];
    JLabel rankLabel = new JLabel();
    String rank = "";

    End(){
        playerLabel.setText("<<"+player+"님의 통계>>");
        playerLabel.setBounds(400, 50, 600, 50);
        playerLabel.setFont(f1);
        playerLabel.setForeground(Color.pink);
        add(playerLabel);

        totalLabel[0] = new JLabel("누적 코인 거래 수 : "+coinTotal);
        totalLabel[0].setBounds(500, 200, 400, 50);
        totalLabel[0].setFont(f2);
        add(totalLabel[0]);

        totalLabel[1] = new JLabel("누적 주식 거래 수 : "+stockTotal);
        totalLabel[1].setBounds(500, 240, 400, 50);
        totalLabel[1].setFont(f2);
        add(totalLabel[1]);

        if (5000 <= coinTotal) rank = "S";
        else if(4000 <= coinTotal) rank = "A";
        else if(3000 <= coinTotal) rank = "B";
        else if(2000 <= coinTotal) rank = "C";
        else if(1000 <= coinTotal) rank = "D";
        else rank = "E";

        rankLabel.setText(rank);
        rankLabel.setBounds(600, 450, 100, 100);
        rankLabel.setFont(f1);
        rankLabel.setForeground(Color.green);
        add(rankLabel);

        setLayout(null);
        setting();
    }
}
