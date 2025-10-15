import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends Story {
    JPanel mainPane = new JPanel();
    JButton explain = new JButton("설명창");
    JLabel choJM = new JLabel();
    JButton gameStart = new JButton("게임시작!");
    JLabel menuName = new JLabel("!가상주식게임!");

    int cnt = 0;
    boolean many = true;

    public Main(){
        //처음 화면
        setTitle("@@가상주식게임@@");

        //게임 제목
        menuName.setBounds(450,50, 350, 70);
        menuName.setFont(f1);
        mainPane.add(menuName);

        //게임시작 버튼
        gameStart.setFont(f2);
        gameStart.setForeground(Color.RED);
        gameStart.setBounds(520,200, 200, 140);
        EventLists(1);
        mainPane.add(gameStart);

        //설명창 버튼
        explain.setFont(f2);
        explain.setForeground(Color.blue);
        explain.setBounds(520,400, 200, 140);
        EventLists(2);
        mainPane.add(explain);

        //개발자 이름
        choJM.setText("개발자 : 1416_조정모");
        choJM.setFont(f2);
        choJM.setForeground(Color.DARK_GRAY);
        choJM.setBounds(900,600, 400, 40);
        mainPane.add(choJM);

        mainPane.setLayout(null);
        setting();
        this.add(mainPane);
    }
    void EventLists(int key){
        //게임시작 버튼 누르면 2번째 창 이동
        if(key == 1) {
            gameStart.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new Part2();
                    setVisible(false);
                }
            });
        }
        //설명창 누르면 설명
        if(key == 2) {
            explain.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (cnt < 5 && many) {
                        System.out.println("가상주식게임은 1주일 동안 총 7번 주식을 매도,매수 할 수 있습니다.\n하루마다 시나리오 2개가 창에 띄워집니다.");
                        System.out.println("시나리오를 하나를 선택하면, 선택한 시나리오에 맞게 주가가 변동됩니다.");
                        System.out.println("열심히해서 부자가 되어보십시오\n");
                        cnt++;
                    } else if (many) {
                        System.out.println("너무 많이 입력하였습니다.");
                        many = false;
                    }
                }
            });
        }
    }
    public static void main(String[] args) {
        new Main();
    }
}