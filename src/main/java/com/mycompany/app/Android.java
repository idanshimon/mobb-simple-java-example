import android.content.Intent;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyActivity {

    private static final String TAG = "MyActivity";

    // This method should be part of an Android Activity or another appropriate context.
    public void handleIntent(Intent intent) {
        String path = intent.getStringExtra("path");

        if (path == null) {
            return;
        }

        String sdcard = Environment.getExternalStorageDirectory().getPath();

        if (path.startsWith(sdcard)) {
            Log.e(TAG, "Attempt to write to sdcard");
            return;
        }

        // Call your writeToFile method here, passing the 'path' variable
        writeToFile(path);
    }

    // Your method to write to a file
    private void writeToFile(String path) {
        // Implement your file-writing logic here.
        // For example, you can use FileOutputStream to write data to the file.
        try {
            File file = new File(path);
            FileOutputStream fos = new FileOutputStream(file);
            // Write data to the file using fos.write(...)
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }
}
