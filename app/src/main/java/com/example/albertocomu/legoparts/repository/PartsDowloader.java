package com.example.albertocomu.legoparts.repository;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.albertocomu.legoparts.R;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class PartsDowloader extends AsyncTask<Void, String, Boolean> {

    private Context context;

    public PartsDowloader(Context context) {
        this.context = context;
    }

    private OnPartsLoadedListener listener = null;

    public void setOnCurrenciesLoadedListener(OnPartsLoadedListener listener) {
        this.listener = listener;
    }

    private ProgressDialog pDialog;

    @Override
    protected void onPreExecute() {
        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Downloading file. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setMax(100);
        pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pDialog.setCancelable(true);
        pDialog.setTitle(R.string.please_wait);
        String msg = context.getResources().getString(R.string.updating_currencies);
        pDialog.setMessage(msg);
        pDialog.setCancelable(true);
        pDialog.show();
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        int count;
        String codi = ???
        try {
            URL url = new URL("stucom.flx.cat/lego/get_set_parts.php?key=c7f6089a753a4a02f32023104f44e794&set=" + codi);
            URLConnection connection = url.openConnection();
            connection.connect();
            int lengthOfFile = connection.getContentLength();
            pDialog.setMax(lengthOfFile);
            InputStream input = new BufferedInputStream(url.openStream(), 8192);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte data[] = new byte[1024];
            long total = 0;
            while ((count = input.read(data)) != -1) {
                total += count;
                publishProgress("" + (int) ((total * 100) / lengthOfFile));
                output.write(data, 0, count);
            }
            input.close();
            output.flush();






        } catch (Exception e) {
            Log.e("Error: ", e.getMessage());
            return false;
        }

        return true;
    }
}