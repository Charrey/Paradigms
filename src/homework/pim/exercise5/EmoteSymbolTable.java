package homework.pim.exercise5;

import java.util.Map;
import java.util.Stack;

/**
 * Created by poesd_000 on 20/05/2016.
 */
public class EmoteSymbolTable extends MySymbolTable {

    public boolean raiseIntensity(String string) {
        if (currentScope.containsKey(string)) {
            currentScope.put(string, ((Integer) currentScope.get(string)) + 1);
            return true;
        } else {
            currentScope.put(string, 1);
            return false;
        }
    }

    @Override
    public boolean add(String id, Object rec) {
        assert rec.equals(new Integer(0));
        return super.add(id, rec);
    }

    public Integer getIntensity(String text) {
        int raisecount = raiseCount(text);
        if (raisecount==0) {
            return -1;
        }
        return raisecount;
    }

    private int raiseCount(String var) {
        Stack<Map<String, Integer>> copy = new Stack<>();
        copy.addAll(stack);
        int count = 0;
        if (currentScope.containsKey(var)) {
            count+= (Integer) currentScope.get(var);
        }
        while (!copy.isEmpty()) {
            Map<String, Integer> top = copy.pop();
            if (top.containsKey(var)) {
                count+=top.get(var);
            }
        }
        return count;

    }
}
