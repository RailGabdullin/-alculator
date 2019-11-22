package rail.gabdullin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EqualActionListener implements ActionListener {

    private Window window;

    public EqualActionListener(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (window.isGotResult()) {
            window.setArg1(window.getResult());
            window.clear(); }
        if(window.getResultText().length() > 0 &&
                window.getResultText().charAt(window.getResultText().length() - 1) != '+'&&
                window.getResultText().charAt(window.getResultText().length() - 1) != '-'&&
                window.getResultText().charAt(window.getResultText().length() - 1) != '/'&&
                window.getResultText().charAt(window.getResultText().length() - 1) != '*'&&
                window.isFirstArgIsReady()) {
            window.showResult();
        }
    }
}
