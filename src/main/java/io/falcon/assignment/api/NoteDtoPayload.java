package io.falcon.assignment.api;

import javax.validation.constraints.NotBlank;

public class NoteDtoPayload {

    @NotBlank(message = "Empty property: content")
    private String content;
    @NotBlank(message = "Empty property: timestamp")
    private String timestamp;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
