package fr.client.cacount.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import fr.client.cacount.services.io.manager.LineManager;
import fr.client.cacount.services.io.reader.LineReader;
import fr.client.cacount.services.io.writer.LineWriter;

import java.io.IOException;

/**
 * Created by svirch_n on 20/02/17.
 */
public class WriteFile extends Activity {

    public static final String HEY_YOU = "Hey, you!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            LineManager lineManager = new LineManager("testFile.csv");
            lineManager.clearFile();
            LineWriter lineWriterFile = lineManager.createLineWriterFile();
            lineWriterFile.writeLine(HEY_YOU);
            lineWriterFile.close();
            LineReader lineReaderFile = lineManager.createLineReaderFile();
            String line = lineReaderFile.readLine();
            if (!HEY_YOU.equals(line)) {
                String message = "Expected: " + HEY_YOU + " Actual: " + line;
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                Log.d("tag", message);
                throw new RuntimeException(message);
            }
            lineManager.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finish();
    }
}
