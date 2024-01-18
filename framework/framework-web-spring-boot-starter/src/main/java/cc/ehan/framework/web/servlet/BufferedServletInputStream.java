package cc.ehan.framework.web.servlet;

import cn.hutool.core.io.IoUtil;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * 可重复读的 ServletInputStream 实现类
 *
 * @Author ZhangZhiYong
 */
public class BufferedServletInputStream extends ServletInputStream {

    private final ByteArrayInputStream inputStream;

    private final ServletInputStream originalServletInputStream;

    public BufferedServletInputStream(byte[] body, ServletInputStream inputStream) {
        this.inputStream = new ByteArrayInputStream(body);
        this.originalServletInputStream = inputStream;
    }

    public BufferedServletInputStream(ServletInputStream inputStream) {
        this(IoUtil.readBytes(inputStream), inputStream);
    }

    @Override
    public boolean isFinished() {
        return inputStream.available() == 0;
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setReadListener(ReadListener readListener) {
        originalServletInputStream.setReadListener(readListener);
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }


}
