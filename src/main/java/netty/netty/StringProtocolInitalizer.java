package netty.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author
 * @Date 2019/1/11
 * @Description     初始化的相关配置
 */
@Component
@Qualifier("springProtocolInitializer")
public class StringProtocolInitalizer extends ChannelInitializer<SocketChannel> {


    @Autowired
    StringDecoder stringDecoder;

    @Autowired
    StringEncoder stringEncoder;

    @Autowired
    ServerHandler serverHandler;


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        // HttpServerCodec：将请求和应答消息解码为HTTP消息
        pipeline.addLast("http-codec",new HttpServerCodec());
        pipeline.addLast("decoder", stringDecoder);
        pipeline.addLast("handler", serverHandler);
        pipeline.addLast("encoder", stringEncoder);
    }

    public StringDecoder getStringDecoder() {
        return stringDecoder;
    }

    public void setStringDecoder(StringDecoder stringDecoder) {
        this.stringDecoder = stringDecoder;
    }

    public StringEncoder getStringEncoder() {
        return stringEncoder;
    }

    public void setStringEncoder(StringEncoder stringEncoder) {
        this.stringEncoder = stringEncoder;
    }

    public ServerHandler getServerHandler() {
        return serverHandler;
    }

    public void setServerHandler(ServerHandler serverHandler) {
        this.serverHandler = serverHandler;
    }

}
