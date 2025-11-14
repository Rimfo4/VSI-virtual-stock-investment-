import javax.swing.*;
import java.awt.*;

public abstract class Story extends JFrame{
    //시나리오
    //하루는 5분 총 7일간 진행, 주식의 가격은 1분 마다 변동
    String[] story = new String[14];
    {
        // 테술라(-20 ~ -40), 사성전자(-10 ~ -25), 파인애플(-15 ~ -27), 엠비디아(-30 ~ -40) 주가 하락 | 하락장 뉴스
        story[0] = "(Calendar 클래스로 채울 예정)년 ()월 ()일 미림뉴스입니다. \n" +
                "미국 정부의 의하면 전기차 보조금 페지를 추진하고 있다고 합니다.\n"+
                "다음으로 반도체 부품 재료인 리튬, 희토류, 니켈 등 자원의 고갈로 인해 반도체 제작이 어려워지고 있습니다. \n"+
                "지금까지 mir뉴스 였습니다.\n";
        // 넹슨(25 ~ 40) 엄청난 주가 상승, 엠비디아(-10 ~ -20), 테슬라(-5 ~ -10) 사소한 주가 하락 | 인생역전 뉴스
        story[1] = "미림뉴스입니다. \n"+
                "요즘 MZ세대들에게 수집형게임이 유행하고 있습니다. \n"+
                "이 게임은 특별하게 게임을 하면 현금을 교환할 수 있으며 \n" +
                "기부도 가능한 게임으로 전문가들의 말에 따르면 엄청난 흥행을 예상 되고 있습니다. \n"+
                "다음으로 AI열풍 시대 차세대 AI모델들의 성과가 뛰어나 기존 AI 시장에 레드 오션으로 치열한 경쟁이 전망됩니다.\n";
        // 켈로그(-10 ~ -20) 주가 하락, 엠비디아(15 ~ 30) 좋은 주가 상승 | 상승과 하락을 같이 넣은 뉴스
        story[2] = "mir뉴스입니다. \n"+
                "속보입니다. 전세계 아이스크림에 들어가 있는 재료에 \n" +
                "싸구려 재료가 첨가 되어 구매자의 불만이 속출하고 있습니다.\n"+
                "다음으로 AI열풍으로 인해 AI 학습용 그래픽카드 하드웨어가 부족하다고 합니다.\n";
        // 테슬라(15 ~ 23)
        story[3] = "mir뉴스입니다. \n";
    }
    // 주식이름
    static String[] stockName = {"엠비디아", "테술라", "넹슨", "사성전자", "파인애플", "넷폴리스", "켈로그"};

    //기본 주식 주가
    static double[] stockPrice = {300, 210, 40, 120, 240, 170, 90};

    // 매도, 매수 버튼
    JButton stockBuyButton = new JButton("매수");
    JButton stockSellButton = new JButton("매도");

    //폰트
    Font f1 = new Font("나눔고딕",Font.BOLD,50);
    Font f2 = new Font("나눔고딕",Font.BOLD,30);
    Font f3 = new Font("나눔고딕",Font.BOLD,20);

    // 주식 수량
    static int[] stockItem = new int[7];

    // 구매 당시 주가
    static double[] stockThenPrice = new double[7];

    // 주가 구매
    static void stockBonus(int stockSelectNum, int stockCnt){
        stockItem[stockSelectNum] += stockCnt;
    }

    // 보유한 주식이 입력한 주가 보다 많은지 체크용 메소드
    static boolean stockBoolean(int stockSelectNum, int stockCnt){
        if(stockItem[stockSelectNum] < stockCnt){
            return false;
        }
        else{
            stockBonus(stockSelectNum, -stockCnt);
            return true;
        }
    }

    //자금(코인)
    static double Coin = 0;

    //코인 보너스
    static void coinBonus(double c){
        Coin += c;
    }
    // 보유한 코인이 입력한 코인보다 많은지 체크용
    static boolean coinBoolean(double c){
        //매수 할 때는 c가 음수로 들어오기에 절댓값으로 비교
        if(getCoin() <= Math.abs(c)) {
            return false;
        }
        else{
            coinBonus(c);
            return true;
        }
    }
    static double getCoin(){
        Coin = (int)(Coin*1000);
        Coin /= 1000;
        return Coin;
    }

    // 보유한 자금 라벨
    JLabel nowCoin = new JLabel(getCoin()+"C");

    //자금 새로고침
    void reloadCoin(){
        nowCoin.setText(getCoin()+"C");
    }

    //자금 라벨
    void checkCoin(){
        nowCoin.setFont(new Font("나눔고딕",Font.BOLD,20));
        nowCoin.setForeground(Color.orange);
        nowCoin.setBounds(1120, 80, 300, 30);
        nowCoin.repaint();
        add(nowCoin);
    }
    //날짜
    static int Day = 1;

    JLabel nowDay = new JLabel(Day +" 일차");
    void checkDay(){
        nowDay.setFont(new Font("나눔고딕",Font.BOLD,50));
        nowDay.setBounds(1120, 5, 300, 60);
        add(nowDay);
    }
    void dayPlus(){
        Day++;
    }

    //렌덤
    double randomNum(int min, int max){
        return (Math.random()*(max-min))+min;
    }

    //랜덤 뉴스에 언급없을 때 용
    double randomNormal(){
        double num = (Math.random()*7);
        int temp = (num > 3) ? -7 : 0;
        return num+temp;
    }
//    Random random = new Random();
//    double randomNum = random.nextDouble(30);

    //선택된 시나리오
    static int selectStory;
    void setStory(int i){
        selectStory = i;
    }
    int getStory(){
        return selectStory;
    }

    //기본 세팅
    void setting(){
        this.setSize(1280,720);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    String playExplain(){
        return "가상주식게임은 1주일 동안 총 7번 주식을 매도,매수 할 수 있습니다.\n하루마다 시나리오 2개가 창에 띄워집니다.\n"+
        "시나리오를 하나를 선택하면, 선택한 시나리오에 맞게 주가가 변동됩니다.\n"+
        "열심히해서 부자가 되어보십시오.💰\n";
    }
}
