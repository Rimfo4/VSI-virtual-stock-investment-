import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends Story {
    JPanel mainPane = new JPanel();
    JButton explain = new JButton("설명창");
    JButton gameStart = new JButton("게임시작!");
    JLabel choJM = new JLabel();
    JLabel menuName = new JLabel("!가상주식게임!");
    ImageIcon icon = new ImageIcon("imgs/VSITitle.png");
    JLabel titleImg = new JLabel(icon);
    int cnt = 0;
    boolean many = true;

    public Main(){
        //처음 화면
        setTitle("@@가상주식게임@@");

        //게임 제목
        menuName.setBounds(450,50, 350, 70);
        menuName.setFont(f1);
        mainPane.add(menuName);

        //타이틀 이미지
        titleImg.setBounds(520, 200, 400, 400);
        mainPane.add(titleImg);

        //게임시작 버튼
        gameStart.setFont(f2);
        gameStart.setForeground(Color.RED);
        gameStart.setBounds(300,400, 200, 140);
        mainPane.add(gameStart);

        //설명창 버튼
        explain.setFont(f2);
        explain.setForeground(Color.blue);
        explain.setBounds(600,400, 200, 140);
        mainPane.add(explain);

        //개발자 이름
        choJM.setText("개발자 : 1416_조정모");
        choJM.setFont(f2);
        choJM.setForeground(Color.DARK_GRAY);
        choJM.setBounds(950,630, 400, 40);
        mainPane.add(choJM);

        mainPane.setLayout(null);
        setting();
        this.add(mainPane);
        EventLists();

        coinBonus(500);
    }
    void EventLists(){
        //게임시작 버튼 누르면 2번째 창 이동
        gameStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Part2();
                setVisible(false);
            }
        });
        //설명창 누르면 설명
        explain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cnt < 5 && many) {
                    JOptionPane.showMessageDialog(Main.this, playExplain());
                    System.out.println(playExplain());
                    cnt++;
                }
                else if (many) {
                    JOptionPane.showMessageDialog(Main.this, "너무 많이 입력하였습니다.");
                    System.out.println("너무 많이 입력하였습니다.");
                    many = false;
                }
            }
        });
    }
    public static void main(String[] args) {
        new Main();
    }
}