// 
// Decompiled by Procyon v0.6.0
// 

package org.eclipse.jdt.internal.jarinjarloader;

import java.net.MalformedURLException;
import java.net.URLDecoder;
import java.io.InputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class RsrcURLConnection extends URLConnection
{
    private ClassLoader classLoader;
    
    public RsrcURLConnection(final URL url, final ClassLoader classLoader) {
        super(url);
        this.classLoader = classLoader;
    }
    
    @Override
    public void connect() throws IOException {
    }
    
    @Override
    public InputStream getInputStream() throws IOException {
        final String file = URLDecoder.decode(this.url.getFile(), "UTF-8");
        final InputStream result = this.classLoader.getResourceAsStream(file);
        if (result == null) {
            throw new MalformedURLException("Could not open InputStream for URL '" + this.url + "'");
        }
        return result;
    }
}
