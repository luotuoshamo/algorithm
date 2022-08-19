package com.wjh.statemachine.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Reason {
    private String currentState;
    private String event;
}
