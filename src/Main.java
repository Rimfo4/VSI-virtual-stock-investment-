import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    public Main(){
        //처음 화면
        setTitle("@@가상주식게임@@");

        //게임 제목
        Font f1 = new Font("나눔고딕",Font.BOLD,50);
        JLabel manuName = new JLabel("!가상주식게임!");
        manuName.setBounds(450,50, 350, 70);
        manuName.setFont(f1);
        add(manuName);

        //게임시작 버튼
        Font f2 = new Font("나눔고딕",Font.BOLD,30);
        JButton gameStart = new JButton("게임시작!");
        gameStart.setFont(f2);
        gameStart.setForeground(Color.RED);
        gameStart.setBounds(520,200, 200, 140);
        gameStart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Part2();
                setVisible(false);
            }
        });
        add(gameStart);

        //설명창 버튼
        JButton explain = new JButton("설명창");
        explain.setFont(f2);
        explain.setForeground(Color.blue);
        explain.setBounds(520,400, 200, 140);
        explain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cnt = 0;
                if(cnt < 5){
                    System.out.println("가상주식게임은 1주일 동안 총 7번 주식을 매도,매수 할 수 있습니다.\n하루마다 시나리오 2개가 창에 띄워집니다.");
                    System.out.println("시나리오를 하나를 선택하면, 선택한 시나리오에 맞게 주가가 변동됩니다.");
                    System.out.println("열심히해서 부자가 되어보십시오!\n");
                }
                else System.out.println("너무 많이 입력하였습니다.");
            }
        });
        add(explain);

        //개발자 이름
        JLabel choJM = new JLabel();
        choJM.setText("개발자 : 1416_조정모");
        choJM.setFont(f2);
        choJM.setForeground(Color.DARK_GRAY);
        choJM.setBounds(900,600, 400, 40);
        add(choJM);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLayout(null);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }
}
