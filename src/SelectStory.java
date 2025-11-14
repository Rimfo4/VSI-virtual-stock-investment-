import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SelectStory extends Story{
    boolean checkFlag = false;
    JPanel selectStoryPanel = new JPanel();
    JTextArea storyBlock_1 = new JTextArea();
    JTextArea storyBlock_2 = new JTextArea();
    ButtonGroup bg = new ButtonGroup();
    JRadioButton selectStoryButton1 =  new JRadioButton();
    JRadioButton selectStoryButton2 =  new JRadioButton();
    JLabel pickStory = new JLabel();
    JButton nextScreen = new JButton("다음 화면");

    int randomNum1  = (int)(randomNum(0, 3));// 매개변수 max에 story.length 값 보내기
    int randomNum2  = (int)(randomNum(0, 3));// 매개변수 max에 story.length 값 보내기
    SelectStory(){
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //랜덤 수에 맞는 story[] 인덱스를 선택해서 시나리오 storyBlock_1, storyBlock_2를 설정해야한다.

        System.out.println("----------시나리오 1번----------");
        System.out.println(story[randomNum1]); //story[]배열을 랜덤 수에 맞는 인덱스 방을 출력
        System.out.println();
        System.out.println("----------시나리오 2번----------");
        System.out.println(story[randomNum2]);//story[]배열을 랜덤 수에 맞는 인덱스 방을 출력

        //시나리오 블럭
        storyBlock_1.setBounds(20, 150, 1050, 150);
        storyBlock_1.setText(story[randomNum1]);
        storyBlock_1.setFont(f3);
        //storyBlock_1.setOpaque(false);
        storyBlock_1.setEditable(false);
        selectStoryPanel.add(storyBlock_1);

        storyBlock_2.setBounds(20, 350, 1050, 150);
        storyBlock_2.setText(story[randomNum2]);
        storyBlock_2.setFont(f3);
        //storyBlock_2.setOpaque(false);
        storyBlock_2.setEditable(false);
        selectStoryPanel.add(storyBlock_2);

        //선택 버튼 블럭
        selectStoryButton1.setBounds(1100,150, 100, 100);
        selectStoryButton1.setText("시나리오 1");
        selectStoryButton1.setFont(new Font("나눔고딕",Font.BOLD,15));
        EventLists(2);
        selectStoryPanel.add(selectStoryButton1);

        selectStoryButton2.setBounds(1100,350, 100, 100);
        selectStoryButton2.setText("시나리오 2");
        selectStoryButton2.setFont(new Font("나눔고딕",Font.BOLD,15));
        EventLists(3);
        selectStoryPanel.add(selectStoryButton2);

        //다음 화면
        nextScreen.setFont(f2);
        nextScreen.setBounds(500, 500, 180, 50);
        nextScreen.setForeground(Color.blue);
        EventLists(1);
        selectStoryPanel.add(nextScreen);

        pickStory.setBounds(500, 100, 300, 50);
        selectStoryPanel.add(pickStory);

        bg.add(selectStoryButton1);
        bg.add(selectStoryButton2);
        checkCoin();
        selectStoryPanel.setBounds(0,0,1280,720);
        selectStoryPanel.setLayout(null);
        add(selectStoryPanel);
        setting();

    }
    void EventLists(int key){
        switch(key) {
            case 1 -> nextScreen.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(checkFlag){
                        setVisible(false);
                        new StockScreen();
                    }
                    else {
                        pickStory.setText("시나리오를 선택해야합니다");
                        pickStory.setFont(f3);
                        pickStory.setForeground(Color.BLUE);
                    }
                }
            });
            case 2 -> selectStoryButton1.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent e){
                    if(e.getStateChange() == ItemEvent.SELECTED){
                        if(selectStoryButton1.isSelected()){
                            pickStory.setText("시나리오 1 선택");     //story[]배열을 랜덤 수에 맞는 인덱스 방을 대입
                            pickStory.setFont(f3);
                            pickStory.setForeground(Color.BLUE);
                            checkFlag = true;
                            setStory(randomNum1);                   //story[]배열을 랜덤 수에 맞는 인덱스으로 전달
                        }
                    }
                }
            });
            case 3 -> selectStoryButton2.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent e){
                    if(e.getStateChange() == ItemEvent.SELECTED){
                        if(selectStoryButton2.isSelected()){
                            pickStory.setText("시나리오 2 선택");     //story[]배열을 랜덤 수에 맞는 인덱스 방을 대입
                            pickStory.setFont(f3);
                            pickStory.setForeground(Color.BLUE);
                            checkFlag = true;
                            selectStoryPanel.add(pickStory);
                            setStory(randomNum1);                   //story[]배열을 랜덤 수에 맞는 인덱스으로 전달
                        }
                    }
                }
            });
        }
    }
}
