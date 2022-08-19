package com.wjh.statemachine;

import com.wjh.statemachine.entity.StateMachine;

public class StateMachineTest {

    public static void main(String[] args) {
        StateMachine sm = new StateMachine();
        sm.add("健康","休息","健康", "开心work");
        sm.add("健康","淋雨","感冒", "请假休息吃药");

        System.out.println(sm);
    }
}
