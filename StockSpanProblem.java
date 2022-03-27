    public static int[] calculateSpan(int[] price, int n) {
        // create a stack
        Stack<Integer> stack = new Stack<>();

        // declare result[]
        int result[] = new int[n];

        // push 0 in stack and 1 in result[0]
        stack.push(0);
        result[0] = 1;

        // start loop 1 -> n-1
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && price[i] >= price[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = (i + 1);
            } else {
                result[i] = i - stack.peek();
            }

            stack.push(i);
        }

        return result;
    }
