package com.wjh.statemachine.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data@Accessors(chain = true)
public class Result {
    private String nextState;
    private String action;
}
