package rail.gabdullin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    private int result = 0;

    private int arg1 = 0;

    private int arg2 = 0;

    private boolean firstArgIsReady = false;

    private boolean gotResult = false;

    private JLabel resultText = new JLabel();

    private char operation;

    Window(){

        super ("Калькулятор");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(360, 500));

        JPanel buttonsPane = new JPanel(new GridLayout(4,4));

        //Генерируем панель мат. операций
        Button [] operationsButtons = new Button[4];

        operationsButtons [0] = new Button("+");
        OperationActionListener listenerPlus = new OperationActionListener('+', this);
        operationsButtons[0].addActionListener(listenerPlus);


        operationsButtons [1] = new Button("-");
        OperationActionListener listenerMinus = new OperationActionListener('-', this);
        operationsButtons[1].addActionListener(listenerMinus);

        operationsButtons [2] = new Button("*");
        OperationActionListener listenerMultiplication = new OperationActionListener('*', this);
        operationsButtons[2].addActionListener(listenerMultiplication);

        operationsButtons [3] = new Button("/");
        OperationActionListener listenerDivision = new OperationActionListener('/', this);
        operationsButtons[3].addActionListener(listenerDivision);

        //Генерируем массив кнопок для ввода цифр
        Button [] numbersButtons = new Button[10];
        NumberActionListener [] numberButtonListener = new NumberActionListener[10];
        for (int i = 0; i < numbersButtons.length; i++) {
            numbersButtons[i] = new Button(""+i);
            int finalI = i;
            numberButtonListener [i] = new NumberActionListener(i,this);
            numbersButtons[i].addActionListener(numberButtonListener[i]);
        }

        Button clearButton = new Button("C");
        ActionListener clearListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        };
        clearButton.addActionListener(clearListener);

        //Добавляем кнопки цифр и операторо в панель кнопок
        int j = 0;
        int k = 0;
        for (int i = 0; i <= 15; i++) {
            if (i == 3 || i == 7 || i == 11 || i == 15) {
                buttonsPane.add(operationsButtons[k]);
                k++;
            } else if (i == 13) {
                buttonsPane.add(numbersButtons[j]);
            } else if (i == 14){
                buttonsPane.add(clearButton);
            }else if (i >= 12){
                buttonsPane.add(new Box(1));
            } else {
                buttonsPane.add(numbersButtons[j]);
                j++;
            }
        }

        //Отдельно создаем и добавляем кнопку "равно"
        Button showResult = new Button("=");
        EqualActionListener listenerEqual = new EqualActionListener(this);
        showResult.addActionListener(listenerEqual);

        Box showResultBox = Box.createHorizontalBox();
        showResultBox.setPreferredSize(new Dimension(360, 75));
        showResultBox.add(showResult);

        //Создаем табло с результатом ввода и вывода
        Box box = Box.createHorizontalBox();
        box.setPreferredSize(new Dimension(360, 75));
        box.add(resultText);
        resultText.setHorizontalAlignment(SwingConstants.RIGHT);

        //Добавляем экран и кнопки в contentPane
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(box, BorderLayout.NORTH);
        container.add(buttonsPane, BorderLayout.CENTER);
        container.add(showResultBox, BorderLayout.SOUTH);
        setVisible(true);
        pack();
    }

    public void showResult(){
        switch (operation){
            case '+':
                result = arg1 + arg2;
                setResultText("" + result);
                gotResult = true;
                break;
            case '-':
                result = arg1 - arg2;
                setResultText("" + result);
                gotResult = true;
                break;
            case '*':
                result = arg1 * arg2;
                setResultText("" + result);
                gotResult = true;
                break;
            case '/':
                if (arg2 == 0){
                    setResultText("Ошибка дел.ноль");
                    gotResult = true;
                } else {
                    result = arg1 / arg2;
                    setResultText("" + result);
                    gotResult = true;
                }
                break;
            default:
                setResultText("ERROR");

        }
    }

    public String getResultText() {
        return resultText.getText();
    }

    public void setResultText(String text){
        resultText.setText("<html><font size = 17>" + text + "<font>");
    }

    public boolean isFirstArgIsReady() {
        return firstArgIsReady;
    }

    public void setFirstArgIsReady(boolean firstArgIsReady) {
        this.firstArgIsReady = firstArgIsReady;
    }

    public void setArg1(int arg1) {
        this.arg1 = arg1;
    }

    public int getArg1() {
        return arg1;
    }

    public void setArg2(int arg2) {
        this.arg2 = arg2;
    }

    public int getArg2() {
        return arg2;
    }

    public boolean isGotResult() {
        return gotResult;
    }

    public void setGotResult(boolean gotResult) {
        this.gotResult = gotResult;
    }

    public int getResult() {
        return result;
    }

    public void setOperation(char operation) {
        this.operation = operation;
        setResultText(getResultText() + String.valueOf(operation));
    }

    void clear(){
            setResultText("");
            setFirstArgIsReady(false);
            setArg1(0);
            setArg2(0);
            setGotResult(false);
    }
}
