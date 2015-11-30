package file_data_store;

//public class synch1 {

//}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class synch1
{
   public static void main(String[] args)
   {
        File file = new File("D:/WangRen University Course Documents/DC1-sampleQueries.txt");
       StringBuffer contents = new StringBuffer();
       BufferedReader reader = null;

       try
        {
           reader = new BufferedReader(new FileReader(file));
           String text = null;
            // repeat until all lines is read
            while ((text = reader.readLine()) != null)
            {
                contents.append(text)
                   .append(System.getProperty(
                       "line.separator"));
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (reader != null)
               {
                  reader.close();
                }
          } catch (IOException e)
           {
                e.printStackTrace();
            }
        }

        // show file contents here
        // System.out.println(contents.toString());

}
}