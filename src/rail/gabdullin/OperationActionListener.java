package rail.gabdullin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationActionListener implements ActionListener {

    private char operation;
    private Window window;

    public OperationActionListener (char operation, Window window){
        this.operation = operation;
        this.window = window;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(window.getResultText().length() > 0 && window.getResultText().charAt(window.getResultText().length() - 1) != operation) {
            if (!window.isFirstArgIsReady()) {
                window.setFirstArgIsReady(true);
                window.setOperation(operation);
            } else {
                    window.showResult();
                    window.setArg1(window.getResult());
                    window.setArg2(0);
                    window.setGotResult(false);
                    window.setOperation(operation);
            }
        }
    }
}
