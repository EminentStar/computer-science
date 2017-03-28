public class StackQueue<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;
    private boolean stackNum;

    public StackQueue(){
        this.stackNum = true;
        this.stack1 = new Stack<T>();
        this.stack2 = new Stack<T>();
    }

    public StackQueue(T value){
        this.stackNum = true;
        this.stack1 = new Stack<T>();
        this.stack2 = new Stack<T>();

        this.stack1.push(value);
    }

    public void push(T value){
        if(this.stackNum){
            this.stack1.push(value);
        }else{
            this.stack2.push(value);
        }
    }

    public Object pop(){
        if(this.stackNum){
            return this.stack1.pop();
        }else{
            return this.stack2.pop();
        }
    }

    public void stackToQueue(){
        Stack from = null;
        Stack to = null;

        if(this.stackNum){
            from = this.stack1;
            to = this.stack2;
        }else{
            from = this.stack2;
            to = this.stack1;
        }

        Object obj = from.pop();
        while(obj != null){
            to.push(obj);
            obj = from.pop();
        }

        this.stackNum = !this.stackNum;
    }

}
