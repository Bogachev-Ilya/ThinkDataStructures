package com.allendowney.thinkdast;

import java.util.Stack;

public class ParenthesesChecker {
    public static void main(String[] args) {

        System.out.println(checkParentheses("[]{([])}"));
    }

    private static boolean checkParentheses(String inputString){
        if (inputString.isEmpty()) {
            return true;
        }
        Stack<Character> parenthesesCounter =  new Stack();
        char[] chars = inputString.toCharArray();
        if (chars[0] == ')' || chars[0] ==']' || chars[0] =='}') {
            return false;
        }
        for (char pointedChar : chars) {
            if (pointedChar == '(' || pointedChar == '[' || pointedChar == '{') {
                parenthesesCounter.push(pointedChar);
            } else {
                if (pointedChar == ')' && parenthesesCounter.peek() == '(') {
                    parenthesesCounter.pop();
                }
                if (pointedChar == ']' && parenthesesCounter.peek() == '[') {
                    parenthesesCounter.pop();
                }
                if (pointedChar == '}' && parenthesesCounter.peek() == '{') {
                    parenthesesCounter.pop();
                }
            }
        }
        return parenthesesCounter.isEmpty();
    }
}
