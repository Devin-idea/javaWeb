package miniTomcat;

public class Test {
    public static void main(String[] args) {
        System.out.println("Sever start");
        MyHttpServer server = new MyHttpServer();
        server.receiving();
    }
}
