package com.example.gnss;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;


class FibAsyncTaskRunner extends AsyncTask<Integer, Integer, Integer> {

    public ProgressBar pb;
    public TextView debug;
    public TextView result;

    private Integer max;

    @Override
    protected Integer doInBackground(Integer... n) {
        publishProgress(0); // Calls onProgressUpdate()
        Integer resp = 0;
        try {

            // Remember the maximum iterations value.
            // This will be used by the fibonacci calculation code to determine progress.
            Double A = 0.2088906673;
            Double B = 0.070613648;
            Double offset = 0.42;
            Double est_fn = 100.0;
            if (n[0]>5) {
                est_fn = java.lang.Math.pow(10, A * n[0] + B - offset);
                max = est_fn.intValue();
                try {
                    debug.setText("Calculating n=" + n[0] + ", est. F(n)=" + est_fn + ", int(est_fn)=" + max + "\n");
                } catch (java.lang.Exception e) {

                }
            } else {
                max = n[0];
            }

            // Call the actual Fibonacci calculation.
            resp = fib(n[0], true);

        } catch (Exception e) {
            e.printStackTrace();
            // resp = e.getMessage();
            return -2;
        }
        return resp;
    }


    @Override
    protected void onPostExecute(Integer n) {
        // execution of result of Long time consuming operation
        debug.append("We're done!\n");
        result.setText(n.toString());
    }


    @Override
    protected void onPreExecute() {
        debug.setText("");
    }


    @Override
    protected void onProgressUpdate(Integer... n) {

        pb.setProgress(n[0]*1000/max);
        // debug.append("Setting progress.\n");
        result.setText(n[0].toString());

    }

    // Fibonacci sequence implementation
    public Integer fib(Integer i, boolean update) {
        if (i < 1)
            return 0;
        if (i == 1)
            return 1;


        Integer val = fib(i - 2, update) + fib(i -1, false);

        if (update) {
            Double tmp = val*1000.0 / max;
            Integer pb_val = tmp.intValue();

            pb.setProgress(pb_val);
        }
        return val;
    }

}