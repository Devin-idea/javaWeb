package miniTomcat;

import java.io.IOException;
import java.io.InputStream;

public class MyHttpRequest {
    private InputStream inputStream;
    private String uir;

    public MyHttpRequest(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void parse(){
        StringBuffer stringBuffer = new StringBuffer(1024);
        int i = 0;
        byte[] buffer = new byte[1024];
        try {
            i = inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int j = 0; j < i; j++) {
            stringBuffer.append((char)buffer[j]);
            System.out.println(stringBuffer);
            uir = parseUri(stringBuffer.toString());
            System.out.println("_____________________");
            System.out.println(uir);
        }
    }

    public String parseUri(String requestStr) {
        int index1, index2;
        index1 = requestStr.indexOf(' ');

        if (index1 != 1) {
            index2 = requestStr.indexOf(' ', index1 + 1);
            if (index2 > index1) {
                return requestStr.substring(index1 + 1, index2);
            }
        }
        return null;
    }

    public String getUir(){
        return this.uir;
    }

}

