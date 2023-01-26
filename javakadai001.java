import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFileChooser;

public class javakadai001 {

    //private static final String InputData = "https://drive.google.com/drive/folders/15i1xH0jOTa8c314qsmbDZGgXCWhBA7TT";
    //private static final String OutputData = "C:\\ユーザー\\uxauser\\road_to_geek\\no_modbles";

    //private static final int BufferSize = 4096;
    
    static String downloadUrl = "https://docs.google.com/spreadsheets/d/13S7YwXs4GgGFfWoOgFkR_wICiObwJbV9i9Zlct1zMU8/edit#gid=487433194";
        
    public static void main(String[] args) throws IOException {

        //デフォルトのファイル名をURLから取得
        URL url = new URL(downloadUrl);
        String csv1 = Paths.get(url.getPath()).getFileName().toString();

        // 保存ダイアログの表示
        JFileChooser filechooser = new JFileChooser(csv1);
        // デフォルトのファイル名を指定
        filechooser.setSelectedFile(new File(csv1));
        // 保存ダイアログを表示
        if (filechooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        
        // 保存先を設定
        File saveFile = filechooser.setSelectedFile("C:\\ユーザー\\uxauser\\road_to_geek\\no_modbles\\Test1");
        try (
        // HttpClientを設定
            final CloseableHttpClient client = HttpClients.createDefault();
        
        // Get
            final CloseableHttpResponse response = client.execute(new HttpGet(downloadUrl))) {
        
        // statusを確認して通信成功したらファイル保存
            final int status = response.getStatusLine().getStatusCode();
        if (status >= 200 && status < 300) {
            final HttpEntity entity = response.getEntity();
        
        // ファイル保存
        Files.write(Paths.get(saveFile.toString()),
            entity == null ? new byte[0] : EntityUtils.toByteArray(entity));
        } else {
        throw new ClientProtocolException("Unexpected response status: " + status);

        //https://drive.google.com/drive/folders/15i1xH0jOTa8c314qsmbDZGgXCWhBA7TT
        //"C:\\ユーザー\\uxauser\\road_to_geek\\no_modbles\\Test1";

    }
    }
    }
}
