package com.dog.empire.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "messagerie")
public class ChatMessage {
    @Id
    private  String id;
    private String chatId;
    private String senderId;
    private String senderName;
    private String recipientId;
    private String recipientName;
    private String content;
    private Date timestamp;
    private MessageStatus status;

    public ChatMessage() {
    }

    public String getId() {
        return id;
    }

    public ChatMessage setId(String id) {
        this.id = id;
        return this;
    }

    public String getChatId() {
        return chatId;
    }

    public ChatMessage setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public String getSenderId() {
        return senderId;
    }

    public ChatMessage setSenderId(String senderId) {
        this.senderId = senderId;
        return this;
    }

    public String getSenderName() {
        return senderName;
    }

    public ChatMessage setSenderName(String senderName) {
        this.senderName = senderName;
        return this;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public ChatMessage setRecipientId(String recipientId) {
        this.recipientId = recipientId;
        return this;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public ChatMessage setRecipientName(String recipientName) {
        this.recipientName = recipientName;
        return this;
    }

    public String getContent() {
        return content;
    }

    public ChatMessage setContent(String content) {
        this.content = content;
        return this;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public ChatMessage setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public ChatMessage setStatus(MessageStatus status) {
        this.status = status;
        return this;
    }

    public ChatMessage(String id, String chatId, String senderId, String senderName, String recipientId, String recipientName, String content, Date timestamp, MessageStatus status) {
        this.id = id;
        this.chatId = chatId;
        this.senderId = senderId;
        this.senderName = senderName;
        this.recipientId = recipientId;
        this.recipientName = recipientName;
        this.content = content;
        this.timestamp = timestamp;
        this.status = status;
    }
}
