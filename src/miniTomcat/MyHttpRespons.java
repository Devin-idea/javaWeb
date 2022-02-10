package miniTomcat;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

public class
MyHttpRespons {
    private OutputStream outputStream;

    public MyHttpRespons(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void sendStaticResource(MyHttpRequest request){
        byte[] bytes = new byte[1024];
        FileInputStream fileInputStream= null;
//        将请求中包含的资源进行返回
//        获取请求资源
        String filepath = request.getUir();
//        资源不存在,返回 404
//        资源存在返回资源
//                返回默认资源
        if (filepath.equals("/")) {
            System.out.println("默认资源");
            filepath = "index.html";
        }else{
            System.out.println("返回" + filepath);
        }

        try {
            String response = null;
            File file = new File(MyHttpServer.webContent, filepath);
            byte[] fileByte = new byte[(int) file.length()];
            if (file.exists()){
                fileInputStream = new FileInputStream(file);
                fileInputStream.read(fileByte);
                response = new String(fileByte);
//                System.out.println(response);
                response = warmMessage("200",response);


            }else {
                response = warmMessage("404","404 File Not Find! The requested URL /404/ was" +
                        "not find on this sever. ");

            }
            this.outputStream.write(response.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public String warmMessage(String status,String response){
        return "HTTP/1.1 "+ status + "\r\n"+"Content-type: text/html\r\n"
                +"Content-Length: " + response.length()
                +"\r\n" + "\r\n" +response;
    }
}
