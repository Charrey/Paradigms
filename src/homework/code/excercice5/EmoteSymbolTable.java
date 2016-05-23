package homework.code.excercice5;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Hans on 20-5-2016.
 */
public class EmoteSymbolTable implements SymbolTable {
    
    Stack<Map<String, Integer>> stack = new Stack<>();
    Map<String, Integer> currentScope = new HashMap<>();

    private Stack<Map<String,Integer>> init() {
        Stack<Map<String,Integer>> returnStack = new Stack<>();
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
            currentScope.put(id,(Integer) rec);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean contains(String id) {
        Stack<Map<String, Integer>> stackcopy = (Stack<Map<String, Integer>>) stack.clone();
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

    public boolean add(String id) {
        return add(id, 0);
    }

    public int getInsensity(String id) {
        Stack<Map<String, Integer>> stackcopy = (Stack<Map<String, Integer>>) stack.clone();
        if(currentScope.containsKey(id)){
            return currentScope.get(id);
        } else {
            while (!stackcopy.empty()){
                if(stackcopy.peek().containsKey(id)){
                    return stackcopy.peek().get(id);
                }
                stackcopy.pop();
            }
            return 0;
        }
    }

    public boolean incrementIntensity(String id) {
        if(contains(id)){
            currentScope.put(id, getInsensity(id)+1);
            return true;
        } else {
            add(id, 1);
            return true;
        }
    }
}
