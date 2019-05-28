package org.flyants.authorize.domain.message;

/**
 * @Author zhangchao
 * @Date 2019/5/28 17:18
 * @Version v1.0
 */
public enum  MessageType {
    TEXT(new TextMessageHandler());
//    IAMGE,
//    AUDIO,
//    VIDEO;

    private MessageHandler messageHandler;

    public MessageHandler getMessageHandler() {
        return messageHandler;
    }

    MessageType(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }}