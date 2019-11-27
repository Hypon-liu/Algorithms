package algorithm.basic.java11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @Author: hypon
 * @Date: 2019/11/21 14:05
 */
public class Java11 {

    private static void createList() {
        List<String> stringList = List.of("11", "22", "33", "44");
        System.out.println(stringList);
    }

    private static void fileStreamReadLines() throws IOException {
        //读取文件流、将文件流有效字节数放入缓冲区，转换为字符串读取
        FileInputStream file = new FileInputStream("/Users/hypon/IdeaProjects/Algorithms/src/main/java/algorithm/basic/java11/Java11.java");
        byte[] buffer = new byte[file.available()];
        file.read(buffer);
        file.close();
        String string = new String(buffer);
        string.lines().forEach(System.out::println);
    }

    private static void fileStreamTransfer() throws IOException {
        //输入流转换输出流
        var inputStream = new FileInputStream("/Users/hypon/IdeaProjects/Algorithms/src/main/java/algorithm/basic/java11/Java11.java");
        try (var out = new FileOutputStream("/Users/hypon/IdeaProjects/Algorithms/src/main/java/algorithm/basic/java11/Java11_temp.java")) {
            inputStream.transferTo(out);
        }
        inputStream.close();
    }

    private static void httpClient() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.baidu.com")).build();
        HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString();
        CompletableFuture<HttpResponse<String>> sendAsync = client.sendAsync(request, bodyHandler);
        HttpResponse<String> response = sendAsync.get();
        response.body().lines().forEach(System.out::println);
    }

    public static void main(String[] args) throws Exception {
        //var是根据右边的值，推断左边的参数类型
        var str = 99.0;
        System.out.println(str);

        createList();

        System.out.println("===============================");

        //fileStreamReadLines();

        System.out.println("===============================");

        //fileStreamTransfer();

        System.out.println("===============================");

        httpClient();
    }
}
