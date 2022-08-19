package com.wjh.statemachine.entity;

import java.util.HashMap;
import java.util.Map;

public class StateMachine {
    private Map<Reason, Result> map = new HashMap<>();

    public void add(String currentState, String event, String nextState, String action) {
        map.put(new Reason().setCurrentState(currentState).setEvent(event),
                new Result().setNextState(nextState).setAction(action));
    }

    public boolean canStateFlow(String currentStat, String nextState) {
        return true;
    }

    public Result getResult(Reason reason) {
        return null;
    }

    @Override
    public String toString() {
        if (map == null) {
            return null;
        }

        StringBuffer sb = new StringBuffer();
        map.forEach((k, v) -> {
            String item = String.format("%s==%s==>%s/%s", k.getCurrentState(), k.getEvent(), v.getNextState(), v.getAction());
            sb.append(item);
            sb.append("\n");
        });
        return sb.toString();
    }
}
