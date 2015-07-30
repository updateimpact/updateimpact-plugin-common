package com.updateimpact.report;

import java.io.*;

public class IvyReport {
    private final String config;
    private final String compressedIvyReport;

    public IvyReport(String config, String compressedIvyReport) {
        this.config = config;
        this.compressedIvyReport = compressedIvyReport;
    }

    public String getConfig() {
        return config;
    }

    public String getCompressedIvyReport() {
        return compressedIvyReport;
    }

    public String decompressReport() throws IOException {
        return ZIP.decompress(compressedIvyReport);
    }

    public static IvyReport newWithCompressedReport(String config, File report) throws IOException {
        return new IvyReport(config, ZIP.compress(readFile(report)));
    }

    private static String readFile(File f) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(f));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
}
