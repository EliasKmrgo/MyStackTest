package co.edu.upct.DataStructures;

public class MyStack<T>{

    private MyList<T> myList;

    public MyStack() {
        myList = new MyList<T>();
    }
    
    public void push(T data){
        myList.add(data);
    }

    public T pop(){
        if (!myList.isEmpty()) {
            T deleted = myList.get(myList.size()-1);
            myList.remove(deleted);
            return deleted;
        }else{
            return null;
        }
    }
    
    public T peek(){
        if (!myList.isEmpty()) {
            T deleted = myList.get(myList.size()-1);
            return deleted;
        }else{
            return null;
        }
    }

    public boolean isEmpty(){
        return myList.isEmpty();
    }

    public int size() {
        return myList.size();
    }

    public boolean exist(T data){
        return myList.contains(data);
    }
}
