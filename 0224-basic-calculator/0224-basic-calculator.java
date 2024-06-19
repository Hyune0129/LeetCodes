import java.util.StringTokenizer;

class Solution {
    public int calculate(String s) {
        String postfix;
        postfix = infixToPostfix(s);
        // System.out.println(postfix);
        return postCalculate(postfix);
        // return 0;
    }

    private String infixToPostfix(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean isWriteNumber = false;
        for (char c : s.toCharArray()) {
            // System.out.println(c);
            if (c == ' ')
                continue;
            if (Character.isDigit(c)) {
                temp.append(c);
            } else { // operator
                if (temp.length() != 0) {
                    sb.append(temp + " ");
                    temp.setLength(0);
                    isWriteNumber = true;
                }
                switch (c) {
                    case ')':
                        while (stack.peek() != '(') {
                            // System.out.println(stack.peek());
                            sb.append(stack.pop() + " ");
                        }
                        stack.pop(); // remove '('
                        break;
                    case '(':
                        isWriteNumber = false;
                        stack.push(c);
                        break;
                    case '+':
                        if(!stack.isEmpty() && (stack.peek() != '(')) {
                            sb.append(stack.pop() + " ");
                        }
                        stack.push(c);
                        break;
                    case '-':
                        if(!isWriteNumber) {
                            sb.append(0 + " ");
                        }
                        if(!stack.isEmpty() && (stack.peek() != '(')) {
                            sb.append(stack.pop() + " ");
                        }

                        stack.push(c);
                        break;
                }
            }
        }
        if (temp.length() != 0) {
            sb.append(temp + " ");
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        return sb.toString();
    }

    private int postCalculate(String postfix) {
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(postfix);
        int x, y;
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            // System.out.println(s);
            switch (s) {
                case "+":
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(x + y);
                    break;
                case "-":
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y - x);
                    break;
                default: // num
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}