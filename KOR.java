package com.example.realopencv;

import org.opencv.core.Rect;

import java.util.ArrayList;

public class KOR extends Locate {

    private final static String ENG = "en";

    private final static int CENTER = 0, LEFT = 1, RIGHT = 2;
    private final static String[] directions = {"앞에", "왼쪽에 ", "오른쪽에"};

    @Override
    public String getLocateSign() {
        return ENG;
    }

    private static String getDirectionByX(int direction) {

        if(direction > 75)
            return directions[RIGHT];

        if(direction < 25)
            return directions[LEFT];

        return directions[CENTER];

    }

    public static String getNum(ArrayList<String> numArr){

        String str = "";

        if(numArr.size() > 0){
            for (int i = 0; i < numArr.size(); i++) {

                str += (i != 0) ? "또는" : "";

                str += numArr.get(i);
            }
            str = "번 " + str;
        }



        return str;
    }

    @Override
    public String getBus(BusSounding.Bus bus) {
        return getDirectionByX((bus.rect.x + bus.rect.width / 2) * 100 / MainActivity.width) +getNum(bus.numberWay) +
                " 버스가 있습니다 " +
                ". " ;
    }

    @Override
    public String getGuideMsg(int guideMsg) {
        String str = "";

        switch (guideMsg){

            case SpeechGenerator.CONECTION_ERROR : str = "인터넷과 연결되어 있지 않습니다.";
                break;

            case SpeechGenerator.SUCCESSFUL_DOWNLOAD : str = "추가 모듈이 다운로드 되었습니다.앱이 다시 켜질때 까지 기다리세요";
                break;

            case SpeechGenerator.BEGIN : str = "시작합니다!";
                break;

            case SpeechGenerator.GUIDE: str = "핸드폰을 세로로 들어주세요";
                break;

            case SpeechGenerator.WAIT : str = "어플이 추가 모듈 다운로드를 시작합니다." +
                    "100 메가바이트의 용량을 차지합니다. 만약 용량이 부족하다면 어플을 닫고 여유 용량을 확보해주세요." +
                    " 다운로드 중에는 인터넷 연결을 유지해주세요."
                   ;
                break;
        }

        return str;
    }
}
