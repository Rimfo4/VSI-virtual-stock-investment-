import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends Story {
    JPanel mainPane = new JPanel();
    JButton explain = new JButton("설명창");
    JButton gameStart = new JButton("게임시작!");
    JLabel choJM = new JLabel();

    ImageIcon icon = new ImageIcon("imgs/VSITitle.png");
    Image image = icon.getImage();
    ImageIcon realIcon = new ImageIcon(image.getScaledInstance(500, 300, Image.SCALE_SMOOTH));
    JLabel titleImg = new JLabel(realIcon);
    int cnt = 0;
    boolean many = true;

    public Main(){
        //처음 화면
        setTitle("@@가상주식게임@@");

        //타이틀 이미지
        titleImg.setBounds(400, 20, 500, 300);
        mainPane.add(titleImg);

        //게임시작 버튼
        gameStart.setFont(f1);
        gameStart.setForeground(Color.RED);
        gameStart.setBounds(280,400, 280, 140);
        mainPane.add(gameStart);

        //설명창 버튼
        explain.setFont(f1);
        explain.setForeground(Color.blue);
        explain.setBounds(720,400, 280, 140);
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
                t1 = new Timer(250, a->{
                    new Part2();
                    setVisible(false);
                });
                t1.setRepeats(false);
                t1.start();
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