package com.yeyu.simplebot.domain;

import lombok.Data;

import java.util.List;

@Data
public class MessageEvent {
    private long time;
    private long self_id;
    private String post_type;
    private String message_type;
    private String sub_type;
    private int message_id;
    private long target_id;
    private long peer_id;
    private long user_id;
    private List<Message> message;
    private String raw_message;
    private int font;
    private Sender sender;

    // Getters and Setters
    @Data
    public static class Message {
        private MessageData data;
        private String type;

        // Getters and Setters
        @Data
        public static class MessageData {
            private String text;

            // Getters and Setters
        }
    }

    @Data
    public static class Sender {
        private long user_id;
        private String nickname;
        private String card;
        private String role;
        private String title;
        private String level;

        // Getters and Setters
    }
}
