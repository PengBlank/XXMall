import com.blank.utils.FastDFSClient;
import org.junit.jupiter.api.Test;


public class FdfsTest {

  @Test
  public void testFastDFS() throws Exception{
    FastDFSClient fastDFSClient = new FastDFSClient("classpath:properties/fdfs_client.conf");
    String url = fastDFSClient.uploadFile("C:\\Users\\Blank\\Desktop\\test.jpg");
    System.out.println(url); //group1/M00/00/00/wKgZhVbnom2AFJlBAAPbBHXc8bE723.jpg
  }
}

