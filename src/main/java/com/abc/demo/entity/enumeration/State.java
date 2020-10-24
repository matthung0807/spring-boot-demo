package com.abc.demo.entity.enumeration;

import lombok.Getter;

/**
 * 員工狀態
 */
public enum State {

    /** 正常 */
    NORMAL(0),
    /** 缺席 */
    LEAVE(1),
    /** 離職 */
    QUIT(2),
    /** 其他 */
    OTHERS(3),
    ;

    @Getter
    private final int code;

    State(int code) {
        this.code = code;
    }

    public static State of(int code) {
        for (State state : State.values()) {
            if (state.getCode() == code) {
                return state;
            }
        }
        return State.OTHERS;
    }
}
