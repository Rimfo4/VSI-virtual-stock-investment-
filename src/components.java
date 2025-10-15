import javax.swing.*;

public class components {
    public JFrame firstScreen = new FristScreen();
    public JFrame gameTitle = new GameTitle();
}

class FristScreen extends JFrame {
    FristScreen(){
        setTitle("@@가상주식게임@@");
    }
}

class GameTitle extends JFrame{
    GameTitle(){
        //게임 제목
        JLabel manuName = new JLabel("!가상주식게임!");
        manuName.setBounds(450,50, 350, 70);
        //manuName.setFont(f1);
        add(manuName);
    }
}
