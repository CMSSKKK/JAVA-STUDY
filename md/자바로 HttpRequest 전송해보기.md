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

=