package com.updateimpact.report;

import java.io.*;

public class ModuleIvyReport {
    private final DependencyId moduleId;
    private final String config;
    private final String compressedIvyReport;

    public ModuleIvyReport(DependencyId moduleId, String config, String compressedIvyReport) {
        this.moduleId = moduleId;
        this.config = config;
        this.compressedIvyReport = compressedIvyReport;
    }

    public String getConfig() {
        return config;
    }

    public String getCompressedIvyReport() {
        return compressedIvyReport;
    }

    public static ModuleIvyReport newWithCompressedReport(DependencyId moduleId, String config, File report) throws IOException {
        return new ModuleIvyReport(moduleId, config, ZIP.compress(readFile(report)));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModuleIvyReport that = (ModuleIvyReport) o;

        if (moduleId != null ? !moduleId.equals(that.moduleId) : that.moduleId != null) return false;
        if (config != null ? !config.equals(that.config) : that.config != null) return false;
        return !(compressedIvyReport != null ? !compressedIvyReport.equals(that.compressedIvyReport) : that.compressedIvyReport != null);

    }

    @Override
    public int hashCode() {
        int result = moduleId != null ? moduleId.hashCode() : 0;
        result = 31 * result + (config != null ? config.hashCode() : 0);
        result = 31 * result + (compressedIvyReport != null ? compressedIvyReport.hashCode() : 0);
        return result;
    }
}
