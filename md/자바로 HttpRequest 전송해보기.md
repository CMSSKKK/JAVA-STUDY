# 자바로 HttpRequest 전송해보기

* 소켓과 Url.openStream 활용해보기

```java
import java.io.*;
import java.net.*;

public class mySocketTest {

    public static void main(String[] args) throws IOException {

        URL url = new URL("http://www.disney.co.kr");
        InetAddress inetAddress = InetAddress.getByName(url.getHost());
        String hostIp = inetAddress.getHostAddress();
        String host = inetAddress.getHostName();
        System.out.println(host);
        System.out.println(hostIp);
        Socket socket = null;
        try {
            socket = new Socket(hostIp, url.getDefaultPort());
            System.out.println(socket.isConnected());
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());

        out.println("GET / HTTP/1.1");
        out.println("Host:"+host);
        out.println();
        
        String line = null;
        while((line = in.readLine()) != null) {

            System.out.println(line);
        }

        in.close();
        out.close();
        socket.close();

    }
}
```

```java
public class NetworkTest {

    public static void main(String[] args) {
        URL url = null;
        BufferedReader input = null;

        String address = "http://www.disney.co.kr";
        String line = "";

        try {
            url = new URL(address);
            input = new BufferedReader(new InputStreamReader(url.openStream()));

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
```

```java
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.*;

public class MySSLSocketTest {
    public static void main(String[] args) throws IOException {
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        String url = "https://www.naver.com";
        URL url1 = new URL(url);
        String host = url1.getHost();
        int port = url1.getDefaultPort();
        System.out.println(host);
        System.out.println(port);

        Socket socket = null;
        BufferedReader in = null;
        PrintStream out = null;
        try {
            socket = sslSocketFactory.createSocket(host, url1.getDefaultPort());
            socket.setSoTimeout(3000);
            System.out.println(socket.isConnected());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintStream(socket.getOutputStream());
            out.println("GET / HTTP/1.1");
            out.println("Host:" + host);
            out.println();
            out.flush();
            String line;

            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            in.close();
            out.close();
            socket.close();
        }

    }
}
```

