package homework.pim.exercise5;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class MySymbolTable<R> implements SymbolTable {

    Stack<Map<String, R>> stack = new Stack<>();
    Map<String, R> currentScope = new HashMap<>();

    private Stack<Map<String,R>> init() {
        Stack<Map<String,R>> returnStack = new Stack<>();
        returnStack.push(new HashMap());
        return returnStack;
    }

    @Override
    public void openScope() {
        stack.push(currentScope);
        currentScope = new HashMap<>();
    }

    @Override
    public void closeScope() {
        currentScope = stack.pop();
    }

    @Override
    public boolean add(String id, Object rec) {
        if(!currentScope.containsKey(id)){
            currentScope.put(id,(R) rec);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean contains(String id) {
        Stack<Map<String, R>> stackcopy = (Stack<Map<String, R>>) stack.clone();
        if(currentScope.containsKey(id)){
            return true;
        } else {
            while (!stackcopy.empty()){
                if(stackcopy.pop().containsKey(id)){
                    return true;
                }
            }
            return false;
        }
    }
}
