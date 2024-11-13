package org.example;


import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class HomeWork {

    private int n, query;
    private long[] a = new long[200001];

    /**
     * <h1>Задание 1.</h1>
     * Решить задачу UPIT из файла contest7_tasks.pdf
     */
    @SneakyThrows
    public void upit(InputStream in, OutputStream out) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        PrintWriter writer = new PrintWriter(out);

        String[] firstLine = reader.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]);
        query = Integer.parseInt(firstLine[1]);

        String[] arrayValues = reader.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(arrayValues[i - 1]);
        }

        while (query > 0) {
            query--;
            String[] command = reader.readLine().split(" ");
            int t = Integer.parseInt(command[0]);

            if (t == 1) {
                int x = Integer.parseInt(command[1]);
                int y = Integer.parseInt(command[2]);
                long d = Long.parseLong(command[3]);
                for (int i = x; i <= y; i++) {
                    a[i] = d;
                }
            } else if (t == 2) {
                int x = Integer.parseInt(command[1]);
                int y = Integer.parseInt(command[2]);
                long d = Long.parseLong(command[3]);
                long sum = 0;
                for (int i = x; i <= y; i++) {
                    sum += d;
                    a[i] += sum;
                }
            } else if (t == 3) {
                int p = Integer.parseInt(command[1]);
                long x = Long.parseLong(command[2]);
                n++;
                for (int i = n; i > p; i--) {
                    a[i] = a[i - 1];
                }
                a[p] = x;
            } else if (t == 4) {
                int x = Integer.parseInt(command[1]);
                int y = Integer.parseInt(command[2]);
                long sum = 0;
                for (int i = x; i <= y; i++) {
                    sum += a[i];
                }
                writer.println(sum);
            }
        }

        writer.flush();
    }
}