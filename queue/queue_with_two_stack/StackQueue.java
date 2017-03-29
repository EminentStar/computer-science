/**
 * Created by junkyu on 2017. 3. 26...
 */
public class StackQueue<T> {
    private Stack<T> oldStack;
    private Stack<T> newStack;

    public StackQueue(){
        this.oldStack = new Stack<T>();
        this.newStack = new Stack<T>();
    }

    public StackQueue(T value){
        this.oldStack = new Stack<T>();
        this.newStack = new Stack<T>();

        this.oldStack.push(value);
    }

    public void insert(T value){
        this.oldStack.push(value);
    }

    public Object remove(){
        this.shiftToNew();
        return this.newStack.pop();
    }

    public void shiftToNew(){
        if(this.newStack.isEmpty()){
            Object obj = this.oldStack.pop();
            while(obj != null){
                this.newStack.push((T)obj);
                obj = this.oldStack.pop();
            }
        }
    }

}

