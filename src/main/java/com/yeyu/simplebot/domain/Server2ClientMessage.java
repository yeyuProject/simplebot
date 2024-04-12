package com.yeyu.simplebot.domain;

import lombok.Data;

@Data
public class Server2ClientMessage<T> {
    private String action;
    private T params;
    private String echo;

}
