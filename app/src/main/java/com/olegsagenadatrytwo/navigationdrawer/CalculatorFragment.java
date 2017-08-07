package com.olegsagenadatrytwo.navigationdrawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CalculatorFragment extends Fragment implements View.OnClickListener{

    private static final String TAG = "MainActivity";

    private TextView screen;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button plus;
    private Button minus;
    private Button multiply;
    private Button divide;
    private Button equals;
    private Button clear;

    //this array list will be used to determine the order of operations
    private ArrayList<String> numbersAndOperands;
    private String currentNumber = "0";
    private boolean isContinueFromResult = false;


    public CalculatorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        //initialize all Buttons
        one      = (Button)view.findViewById(R.id.one);
        two      = (Button)view.findViewById(R.id.two);
        three    = (Button)view.findViewById(R.id.three);
        four     = (Button)view.findViewById(R.id.four);
        five     = (Button)view.findViewById(R.id.five);
        six      = (Button)view.findViewById(R.id.six);
        seven    = (Button)view.findViewById(R.id.seven);
        eight    = (Button)view.findViewById(R.id.eight);
        nine     = (Button)view.findViewById(R.id.nine);
        zero     = (Button)view.findViewById(R.id.zero);
        plus     = (Button)view.findViewById(R.id.plus);
        minus    = (Button)view.findViewById(R.id.minus);
        multiply = (Button)view.findViewById(R.id.multiply);
        divide   = (Button)view.findViewById(R.id.divide);
        equals   = (Button)view.findViewById(R.id.equals);
        clear    = (Button)view.findViewById(R.id.clear);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        equals.setOnClickListener(this);
        clear.setOnClickListener(this);

        //initialize TextView
        screen = (TextView)view.findViewById(R.id.tvScreen);
        //initialize ArrayList that will store all numbers and operands
        numbersAndOperands = new ArrayList<>();

        return view;
    }

    //onClick for all the buttons
    @Override
    public void onClick(View view) {
        //switch statement to determine which button was cliked
        switch (view.getId()){
            //case when number one was clicked
            case R.id.one:
                //if the the screen shows 0 then we just replace the 0 with 1, and set currentNumber
                if(screen.getText().toString().equals("0")) {
                    screen.setText(one.getText().toString());
                    currentNumber = one.getText().toString();
                }else{
                    //if the screen shows something besides 0, we concatenate whatever was on the
                    //screen before plus the 1, and put it on the screen, and update current number
                    //accordingly
                    screen.setText(screen.getText().toString() + one.getText().toString());
                    currentNumber = currentNumber + one.getText().toString();
                }
                break;

            //cases two - zero are same as case one except the number changes
            case R.id.two:
                if(screen.getText().toString().equals("0")) {
                    screen.setText(two.getText().toString());
                    currentNumber = two.getText().toString();
                }else{
                    screen.setText(screen.getText().toString() + two.getText().toString());
                    currentNumber = currentNumber + two.getText().toString();
                }
                break;

            case R.id.three:
                if(screen.getText().toString().equals("0")) {
                    screen.setText(three.getText().toString());
                    currentNumber = three.getText().toString();
                }else{
                    screen.setText(screen.getText().toString() + three.getText().toString());
                    currentNumber = currentNumber + three.getText().toString();
                }
                break;

            case R.id.four:
                if(screen.getText().toString().equals("0")) {
                    screen.setText(four.getText().toString());
                    currentNumber = four.getText().toString();
                }else{
                    screen.setText(screen.getText().toString() + four.getText().toString());
                    currentNumber = currentNumber + four.getText().toString();
                }
                break;

            case R.id.five:
                if(screen.getText().toString().equals("0")) {
                    screen.setText(five.getText().toString());
                    currentNumber = five.getText().toString();
                }else{
                    screen.setText(screen.getText().toString() + five.getText().toString());
                    currentNumber = currentNumber + five.getText().toString();
                }
                break;

            case R.id.six:
                if(screen.getText().toString().equals("0")) {
                    screen.setText(six.getText().toString());
                    currentNumber = six.getText().toString();
                }else{
                    screen.setText(screen.getText().toString() + six.getText().toString());
                    currentNumber = currentNumber + six.getText().toString();
                }
                break;

            case R.id.seven:
                if(screen.getText().toString().equals("0")) {
                    screen.setText(seven.getText().toString());
                    currentNumber = seven.getText().toString();
                }else{
                    screen.setText(screen.getText().toString() + seven.getText().toString());
                    currentNumber = currentNumber + seven.getText().toString();
                }
                break;

            case R.id.eight:
                if(screen.getText().toString().equals("0")) {
                    screen.setText(eight.getText().toString());
                    currentNumber = eight.getText().toString();
                }else{
                    screen.setText(screen.getText().toString() + eight.getText().toString());
                    currentNumber = currentNumber + eight.getText().toString();
                }
                break;

            case R.id.nine:
                if(screen.getText().toString().equals("0")) {
                    screen.setText(nine.getText().toString());
                    currentNumber = nine.getText().toString();
                }else{
                    screen.setText(screen.getText().toString() + nine.getText().toString());
                    currentNumber = currentNumber + nine.getText().toString();
                }
                break;

            case R.id.zero:
                if(screen.getText().toString().equals("0")) {
                    screen.setText(zero.getText().toString());
                    currentNumber = zero.getText().toString();
                }else{
                    screen.setText(screen.getText().toString() + zero.getText().toString());
                    currentNumber = currentNumber + zero.getText().toString();

                }
                break;

            //case plus, minus, multiply, and divide are very similar, so comments here can be used
            //for all
            //When plus is clicked we will add the current number and plus sign to the numberAndOperands array
            //and update the screen accordingly
            case R.id.plus:
                //if the user is not performing operation on a result of a previous calculation
                //then this if statement will run
                if(!isContinueFromResult) {
                    //if current number is not equal to "" that means user has a number before this
                    //plus sign.
                    if(!currentNumber.equals("")) {
                        //so we add the currentNumber and the + sign to the array list of Operands
                        //and numbers and update the screen accordingly
                        numbersAndOperands.add(currentNumber);
                        numbersAndOperands.add("+");
                        screen.setText(screen.getText().toString() + plus.getText().toString());
                    }
                    //if the current number is "" that means that the user is trying to click an
                    //operand right after another operand. So in that case we do the following
                    else{
                        //replace the last operand with current operand
                        String newScreen = screen.getText().toString().substring(0, screen.getText().toString().length() - 1) + "+";
                        numbersAndOperands.remove(numbersAndOperands.size() - 1);
                        numbersAndOperands.add("+");
                        screen.setText(newScreen);
                    }
                }
                //else means that the user is performing an operation on a result from previous
                //calculations
                else{
                    if(!currentNumber.equals("")) {
                        numbersAndOperands.add(currentNumber);
                        numbersAndOperands.add("+");
                        //so instead of updating the screen from what it already had, we update it
                        //with current number and the operand, because inside the equals case the
                        //current number is being set to the result of calculations
                        screen.setText(currentNumber + plus.getText().toString());
                        isContinueFromResult = false;
                    }
                }
                //in the end we set the current number to "" because we want to keep track of
                //when the user is clicking numbers are Operands
                currentNumber = "";
                break;

            case R.id.minus:
                if(!isContinueFromResult) {
                    if(!currentNumber.equals("")) {
                        numbersAndOperands.add(currentNumber);
                        numbersAndOperands.add("-");
                        screen.setText(screen.getText().toString() + minus.getText().toString());
                    }else{
                        //replace the last operand with current
                        String newScreen = screen.getText().toString().substring(0, screen.getText().toString().length() - 1) + "-";
                        numbersAndOperands.remove(numbersAndOperands.size() - 1);
                        numbersAndOperands.add("-");
                        screen.setText(newScreen);
                    }
                }else {
                    if(!currentNumber.equals("")) {
                        numbersAndOperands.add(currentNumber);
                        numbersAndOperands.add("-");
                        screen.setText(currentNumber + minus.getText().toString());
                        isContinueFromResult = false;
                    }
                }
                currentNumber = "";
                break;

            case R.id.multiply:
                if(!isContinueFromResult) {
                    if(!currentNumber.equals("")) {
                        numbersAndOperands.add(currentNumber);
                        numbersAndOperands.add("*");
                        screen.setText(screen.getText().toString() + multiply.getText().toString());
                    }else{
                        //replace the last operand with current
                        String newScreen = screen.getText().toString().substring(0, screen.getText().toString().length() - 1) + "*";
                        numbersAndOperands.remove(numbersAndOperands.size() - 1);
                        numbersAndOperands.add("*");
                        screen.setText(newScreen);
                    }
                }else {
                    if(!currentNumber.equals("")) {
                        numbersAndOperands.add(currentNumber);
                        numbersAndOperands.add("*");
                        screen.setText(currentNumber + multiply.getText().toString());
                        isContinueFromResult = false;
                    }
                }
                currentNumber = "";
                break;

            case R.id.divide:
                if(!isContinueFromResult) {
                    if(!currentNumber.equals("")) {
                        numbersAndOperands.add(currentNumber);
                        numbersAndOperands.add("/");
                        screen.setText(screen.getText().toString() + divide.getText().toString());
                    }else{
                        //replace the last operand with current
                        String newScreen = screen.getText().toString().substring(0, screen.getText().toString().length() - 1) + "/";
                        numbersAndOperands.remove(numbersAndOperands.size() - 1);
                        numbersAndOperands.add("/");
                        screen.setText(newScreen);
                    }
                }else{
                    if(!currentNumber.equals("")) {
                        numbersAndOperands.add(currentNumber);
                        numbersAndOperands.add("/");
                        screen.setText(currentNumber + divide.getText().toString());
                        isContinueFromResult = false;
                    }
                }
                currentNumber = "";
                break;



            case R.id.equals:
                //the following if statement will add the last number to the numbersAndOperands array
                if(!currentNumber.equals("")){
                    numbersAndOperands.add(currentNumber);
                }

                //if the last thing in the array numbersAndOperands is +-*/ that means it is an invalid
                //and we tell the user and it is invalid and do not do any calculations
                if(numbersAndOperands.get(numbersAndOperands.size() - 1).equals("+") ||
                        numbersAndOperands.get(numbersAndOperands.size() - 1).equals("-") ||
                        numbersAndOperands.get(numbersAndOperands.size() - 1).equals("*") ||
                        numbersAndOperands.get(numbersAndOperands.size() - 1).equals("/")){
                    Toast.makeText(getActivity(), "Invalid", Toast.LENGTH_SHORT).show();
                }
                //When the last thing in the array of numbersAndOperands is a number then we can
                //do the following and calculate the result
                else {
                    numbersAndOperands.add("=");
                    currentNumber = "";
                    screen.setText(screen.getText().toString() + equals.getText().toString());

                    //find all the multiplications and divisions first, and do the calculations
                    for (int i = 1; i < numbersAndOperands.size(); i++) {
                        if (numbersAndOperands.get(i).equals("*") || numbersAndOperands.get(i).equals("/")) {
                            if (numbersAndOperands.get(i).equals("*")) {
                                double n1 = Double.parseDouble(numbersAndOperands.get(i - 1));
                                double n2 = Double.parseDouble(numbersAndOperands.get(i + 1));
                                double result = n1 * n2;

                                numbersAndOperands.remove(i);
                                numbersAndOperands.remove(i);
                                numbersAndOperands.remove(i - 1);
                                numbersAndOperands.add(i - 1, result + "");
                                i--;

                            } else {
                                double n1 = Double.parseDouble(numbersAndOperands.get(i - 1));
                                double n2 = Double.parseDouble(numbersAndOperands.get(i + 1));
                                double result = n1 / n2;

                                numbersAndOperands.remove(i);
                                numbersAndOperands.remove(i);
                                numbersAndOperands.remove(i - 1);
                                numbersAndOperands.add(i - 1, result + "");
                                i--;
                            }
                        }
                    }

                    //find all the plus and minus and do the calculations
                    for (int i = 1; i < numbersAndOperands.size(); i++) {
                        if (numbersAndOperands.get(i).equals("+") || numbersAndOperands.get(i).equals("-")) {
                            if (numbersAndOperands.get(i).equals("+")) {
                                double n1 = Double.parseDouble(numbersAndOperands.get(i - 1));
                                double n2 = Double.parseDouble(numbersAndOperands.get(i + 1));
                                double result = n1 + n2;

                                numbersAndOperands.remove(i);
                                numbersAndOperands.remove(i);
                                numbersAndOperands.remove(i - 1);
                                numbersAndOperands.add(i - 1, result + "");
                                i--;
                            } else {

                                double n1 = Double.parseDouble(numbersAndOperands.get(i - 1));
                                double n2 = Double.parseDouble(numbersAndOperands.get(i + 1));
                                double result = n1 - n2;

                                numbersAndOperands.remove(i);
                                numbersAndOperands.remove(i);
                                numbersAndOperands.remove(i - 1);
                                numbersAndOperands.add(i - 1, result + "");
                                i--;
                            }
                        }
                    }

                    //display the answer and prepare for the next round of the calculations if
                    //the user were to perform calculations on the result
                    screen.setText(screen.getText().toString() + numbersAndOperands.get(0));
                    currentNumber = numbersAndOperands.get(0);
                    numbersAndOperands.clear();
                    isContinueFromResult = true;
                }
                break;

            //here we reset everything we are using to keep track of order of operations and all
            case R.id.clear:
                numbersAndOperands.clear();
                currentNumber = "0";
                screen.setText("0");
                break;
        }


    }


}
