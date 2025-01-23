package com.aniljadhav2833.mysite.mysiteBackend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class ContactMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageId;
    private String senderName;
    private String message;

    private String senderMail;
    private String replierName;
    private String repliedMessage;

    @Column(updatable = false)
    private LocalDateTime messageDateTime;

    @Column(insertable = false)
    private LocalDateTime replyeDateTime;
    private boolean replied;


    public ContactMessage() {
    }

    public ContactMessage(int messageId, String senderName, String message, String senderMail, String replierName, String repliedMessage, LocalDateTime messageDateTime, LocalDateTime replyeDateTime, boolean isreplied) {
        this.messageId = messageId;
        this.senderName = senderName;
        this.message = message;
        this.senderMail = senderMail;
        this.replierName = replierName;
        this.repliedMessage = repliedMessage;
        this.messageDateTime = messageDateTime;
        this.replyeDateTime = replyeDateTime;
        this.replied = isreplied;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReplierName() {
        return replierName;
    }

    public void setReplierName(String replierName) {
        this.replierName = replierName;
    }

    public String getRepliedMessage() {
        return repliedMessage;
    }

    public void setRepliedMessage(String repliedMessage) {
        this.repliedMessage = repliedMessage;
    }

    public LocalDateTime getMessageDateTime() {
        return messageDateTime;
    }

    public void setMessageDateTime(LocalDateTime messageDateTime) {
        this.messageDateTime = messageDateTime;
    }

    public LocalDateTime getReplyeDateTime() {
        return replyeDateTime;
    }

    public void setReplyeDateTime(LocalDateTime replyeDateTime) {
        this.replyeDateTime = replyeDateTime;
    }

    public boolean isReplied() {
        return replied;
    }

    public void setReplied(boolean replied) {
        this.replied = replied;
    }

    public String getSenderMail() {
        return senderMail;
    }

    public void setSenderMail(String senderMail) {
        this.senderMail = senderMail;
    }
}
