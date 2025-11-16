import javax.swing.*;
import java.awt.*;

public abstract class Story extends JFrame{
    //시나리오
    //하루는 5분 총 7일간 진행, 주식의 가격은 1분 마다 변동
    //주식 매수, 매도 후 약간의 딜레이 + 완료했다는 메세지 띄우기

    static String[] story = new String[14];
    {
        // 테술라(-20 ~ -40), 사성전자(-10 ~ -25), 파인애플(-15 ~ -27), 엠비디아(-30 ~ -40) 주가 하락 | 하락장 뉴스
        story[0] = "(Calendar 클래스로 채울 예정)년 ()월 ()일 JM뉴스입니다. \n" +
                "미국 정부의 의하면 전기차 보조금 페지를 추진하고 있다고 합니다.\n"+
                "다음으로 반도체 부품 재료인 리튬, 희토류, 니켈 등 자원의 고갈로 인해 반도체 제작이 어려워지고 있습니다. \n"+
                "지금까지 JM뉴스 였습니다.\n";
        // 넹슨(25 ~ 40) 엄청난 주가 상승, 엠비디아(-10 ~ -20), 테슬라(-5 ~ -10) 사소한 주가 하락 | 인생역전 뉴스
        story[1] = "JM뉴스입니다. \n"+
                "요즘 MZ세대들에게 수집형게임이 유행하고 있습니다. \n"+
                "이 게임은 특별하게 게임을 하면 현금을 교환할 수 있으며 \n" +
                "기부도 가능한 게임으로 전문가들의 말에 따르면 엄청난 흥행을 예상 되고 있습니다. \n"+
                "다음으로 AI열풍 시대 차세대 AI모델들의 성과가 뛰어나 기존 AI 시장에 레드 오션으로 치열한 경쟁이 전망됩니다.\n";
        // 켈로그(-10 ~ -20) 주가 하락, 엠비디아(15 ~ 30) 좋은 주가 상승 | 상승과 하락을 같이 넣은 뉴스
        story[2] = "JM뉴스입니다. \n"+
                "속보입니다. 전세계 아이스크림에 들어가 있는 재료에 \n" +
                "싸구려 재료가 첨가 되어 구매자의 불만이 속출하고 있습니다.\n"+
                "다음으로 AI열풍으로 인해 AI 학습용 그래픽카드 하드웨어가 부족하다고 합니다.\n";
        // 테슬라(19 ~ 27), 켈로그(10 ~ 15) 주가 상승 | 주가 상승만 있는 행복한 뉴스
        story[3] = "JM뉴스입니다. \n" +
                "***기업의 우주선 개발이 점차 성공된다는 정보가 들어왔습니다.\n" +
                "다른 소식으론 @@@기업에서 식품 안에 사람들의 이름을 새겨 본인의 이름을 찾는 이벤트를 개최하였습니다.\n" +
                "이벤트를 개최하자마자 누리집에서는 즐거운 유행이 불고 있습니다.";
        // 파인애플(20 ~ 30), 사성전자(-11 ~ -18) | 하락과 상승이 둘다 있는 혼란의 뉴스
        story[4] = "JM뉴스입니다.\n" +
                "***기업에서 새로운 핸드폰을 출시하였습니다. \n" +
                "이 핸드폰은 전작과 달리 엄청난 색상과 심플한 디자인으로 사람들에게 관심받고 있습니다.\n" +
                "다른 소식으론 @@@기업에 핸드폰 제품이 먹통이 되는 사태가 있어 문제의 제품을 모두 회수 조치 되었습니다.";
        //엠비디아(20 ~ 25), 사성전자(30 ~ 35), 넷폴릭스(-12 ~ -18) | 엄청난 주가 상승 속에 핀 슬픈 하락소리의 뉴스
        story[5] = "JM뉴스입니다.\n" +
                "***기업과 @@@기업의 CEO들이 국제 행사에서 한 말이 화제입니다.\n" +
                "두 기업의 CEO들은 오랜전부터 알고지낸 사이로 ***기업은 @@@기업에게 그래픽카드 5만장을 주기로 하였습니다.\n" +
                "@@@기업은 받은 그래픽카드로 가전제품에 더욱 뛰어난 성능을 제작할 것으로 보입니다.\n" +
                "다른 속보로는 &&&기업이 모든 스트리밍 요금제를 기존의 20% 상향한다고 합니다.";
        //파인애플(-10 ~ -21), 넹슨(-14 ~ -18) | 하락장 뉴스
        story[6] = "JM뉴스입니다.\n" +
                "***기업에서 일체형 컴퓨터 디자인에 결함이 생겨 ***기업의 시그니처인 심플한 디자인을 포기하였다고 합니다.\n" +
                "또한 성능도 전작이랑 비교하면 뛰어난 부분이 없다고 합니다.\n" +
                "다음 속보는 @@@기업의 유명한 게임 캐릭터가 다른 게임기업에 저작권을 침해하였다고 합니다.\n" +
                "이 때문에 캐릭터 사용에 대한 법적 조치가 이루어질 예정입니다.";
        //엠비디아(9 ~ 14), 테슬라(12 ~ 23), 넷폴릭스(23 ~ 27), | 행복한 상승장 뉴스
        story[7] = "JM뉴스입니다.\n" +
                "속보입니다. 요즘들어 AI에 대한 성능이 나날이 갈수록 겉잡을 수 없이 늘어나고 있습니다.\n" +
                "***기업은 AI를 이용하여 사용자의 동영상 시청을 분석하여 다양한 컨텐츠를 추천하며 \n" +
                "AI를 이용한 새로운 유행을 이끌어 가고 있습니다.\n" +
                "또한 @@@기업은 전기차에 AI를 도입하여 자율주행, 전력 관리 등 다양한 부분에서 엄청난 성능을 보이고 있습니다.";
        //엠비디아(-19 ~ -27), 파인애플(-6 ~ -8), 켈로그(12 ~ 17) | 하락, 상승 뉴스
        story[8] = "JM뉴스입니다.\n" +
                "@@@기업의 노트북이 ***기업의 그래픽카드 성능의 오류와 허위 정보 제공, 갑질 등 여러이유로 인해 심플하고\n" +
                "강력한 성능의 노트북을 전량회수하기로 하였습니다. 이로인해 @@@기업과 ***기업의 계약을 끊고 결별했습니다.\n " +
                "다음 소식은 &&&기업이 한달간 판매한 $$$과자의 수익 전체를 어린이 재단에 기부한다고 합니다.\n" +
                "이러한 선행이 많았으면 좋겠네요.";
        //사성전자(17 ~ 21), 넷폴릭스(15 ~ 23) | 상승장 뉴스
        story[9] = "JM뉴스입니다.\n" +
                "@@@기업이 차세대 핸드폰인 세 번 접히는 핸드폰을 출시하였습니다. 이 핸드폰은 @@@기업의 다른 \n" +
                "전자제품과 호환이 매우 잘되며 최신 프로세서를 탑제하여 전작과 비교불과 수준의 성능을 보여줍니다.\n" +
                "다음 소식은 ***기업의 K-pop 컨텐츠인 오징어게임이 전세계 인터넷에서 엄청난 흥행을 거두고 있습니다.\n" +
                "오징어게임은 전세계 실시간검색어 1위에 등극하여 유행의 선두를 이끌고 있습니다.";
        //테술라(23 ~ 31), 넹슨(19 ~ 25), 넷풀릭스(27 ~ 32) | 엄청난 상승장 뉴스
        story[10] = "JM뉴스입니다.\n" +
                "전세계의 정체불명인 신종바이러스가 퍼지고 있습니다. 그로인해 집에 머무는 시간이 많아졌는데요.\n" +
                "***기업은 우주선 개발을 토대로 전세계의 인터넷을 띄워 인터넷 사용이 어려운 나라에서 사용하게끔 해줬습니다.\n" +
                "또한 인터넷 스트리밍 시스템과 인터넷 게임의 사용률이 엄청 뛰고 있습니다.\n" +
                "신종바이러스로 인해 사람들이 인터넷 생활을 많이 하다보니 인터넷의 시스템들이 각광받고 있습니다.";
        //엠비디아(-37 ~ -48), 테슬라(-28 ~ -36), 넹슨(-19 ~ -26) | 엄청난 하락장 뉴스
        story[11] = "JM뉴스입니다.\n" +
                "긴급 속보입니다. 오늘 ***기업에 그래픽카드가 평균 전력량을 훨씬 넘게 사용해 그래픽카드가 폭발하여 사용자가\n"+
                "부상당했다고 합니다. 또한 @@@기업 전기차에 탑재된 배터리도 터져 주차장이 불타는 사고가 발생했습니다.\n" +
                "###기업에 ??개발자가 게임 구상에 대한 갈굼, 고된 스케줄로 인해 과로로 쓰러지게 되었습니다.";
        //테슬라(16 ~ 20), 넹슨(14 ~ 21) | 상승장 뉴스
        story[12] = "JM뉴스입니다.\n" +
                "***기업이 미국 정부의 정책을 담당하여 전기차를 구매한 차주에게 추후 케어 보험 서비스를 제공한다고 합니다.\n" +
                "다음 뉴스는 @@@기업이 게임 열풍으로 인해 게임 개발자 캠프, 대회를 성공적으로 개최하여 전세계 게이머들에게\n" +
                "찬사를 받고 있다고 합니다.";
        //사성전자(~17 ~ -21), 파인애플(-20 ~ 26), 켈로그(-13 ~ -15) | 하락장 뉴스
        story[13] = "JM뉴스입니다.\n" +
                "두 기업이 손을 붙잡는 날이 올지 몰랐습니다. ***기업과 @@@기업은 핸드폰 시장 라이벌로 여겨졌는데\n" +
                "두 기업이 손잡고 핸드폰 가격 상승 및 타 기업의 핸드폰 시장 진출을 막기위한 압박 공격을 한 경향이 만천하에\n" +
                "드러났습니다. 빠른 시일 내에 법적 조치를 받을 예정입니다.\n" +
                "&&&기업이 광고에 나온 식품과 다르게 과도한 질소 포장으로 소비자 기만으로 신고를 받았다고 합니다.";
    }
    //사용자 이름
    static String player = "123456789";

    //시나리오 중복 체크
    static boolean[] storyCheckBoolean = new boolean[14];

    // 주식이름
    static String[] stockName = {"엠비디아", "테술라", "넹슨", "사성전자", "파인애플", "넷폴리스", "켈로그"};

    //기본 주식 주가
    static double[] stockPrice = {300, 210, 40, 120, 240, 170, 90};

    // 매도, 매수 버튼
    JButton stockBuyButton = new JButton("매수");
    JButton stockSellButton = new JButton("매도");

    //타이머 (시간 지연 등)
    Timer t1;

    //폰트
    Font f1 = new Font("나눔고딕",Font.BOLD,50);
    Font f2 = new Font("나눔고딕",Font.BOLD,30);
    Font f3 = new Font("나눔고딕",Font.BOLD,20);

    // 주식 수량
    static int[] stockItem = new int[7];

    // 구매 당시 주가
    static double[] stockThenPrice = new double[7];

    static int stockTotal = 0;      //총 주가 구매 량
    static double coinTotal = 0;    //총 코인 량

    // 주가 구매
    static void stockBonus(int stockSelectNum, int stockCnt){
        stockItem[stockSelectNum] += stockCnt;
        stockTotal++;
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
        if(c > 0){
            coinTotal += c;
        }
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

    //7일차 끝났는 지 체크용
    boolean toEndDay(){
        if(Day == 8) return true;
        else return false;
    }

    //날짜 라벨
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
    static double randomNum(int min, int max){
        return (Math.random()*(max-min))+min;
    }

    //랜덤 뉴스에 언급없을 때 용
    double randomNormal(){
        double num = (Math.random()*7);
        int temp = (num > 3) ? -7 : 0;
        return num+temp;
    }

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
