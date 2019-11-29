package io.sufeng.impl.websocket.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.sufeng.impl.websocket.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 将URI地址栏的参数去掉,并存入channel的属性里面方便后续handler获取
 * @Author zhangchao
 * @Date 2019/3/26 15:26
 * @Version 1.0
 */
@Component
@ChannelHandler.Sharable
public class HttpRequestUriHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    @Autowired
    Config config;

    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        if(request.uri().startsWith(config.getWebsocketUri())){
            QueryStringDecoder queryStringDecoder = new QueryStringDecoder(request.uri());
            logger.info("{}",request.uri());
            ctx.channel().attr(Config.URI_PARAMS).set(queryStringDecoder.parameters());
            request.setUri(config.getWebsocketUri());
            ctx.fireChannelRead(request.retain());
        }
    }

}