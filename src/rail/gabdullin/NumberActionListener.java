package rail.gabdullin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberActionListener implements ActionListener {

    private int buttonNumber;
    private Window window;

    NumberActionListener(int buttonNumber, Window window){
        this.buttonNumber = buttonNumber;
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (window.isGotResult()) { window.clear();}
        if (!window.isFirstArgIsReady()) {
            window.setArg1(window.getArg1() * 10 + buttonNumber);
            window.setResultText(window.getResultText() + "" + buttonNumber);
        } else {
            window.setArg2(window.getArg2() * 10 + buttonNumber);
            window.setResultText(window.getResultText() + "" + buttonNumber);
        }
    }
}
