package com.updateimpact.report;

import java.util.Collection;

/**
 * Typically contains either:
 * - <code>moduleDependencies</code> with already process information on each module's dependencies
 * - <code>ivyReports</code> with raw data from which dependency information has to be extracted server-side
 */
public class DependencyReport {
    private final String projectName;
    private final String apikey;
    private final String buildId;
    private final Collection<ModuleDependencies> moduleDependencies;
    private final Collection<IvyReport> ivyReports;
    private final String formatVersion;
    private final String submittedWith;

    public DependencyReport(String projectName,
                            String apikey,
                            String buildId,
                            Collection<ModuleDependencies> moduleDependencies,
                            Collection<IvyReport> ivyReports,
                            String formatVersion,
                            String submittedWith) {
        this.projectName = projectName;
        this.apikey = apikey;
        this.buildId = buildId;
        this.moduleDependencies = moduleDependencies;
        this.ivyReports = ivyReports;
        this.formatVersion = formatVersion;
        this.submittedWith = submittedWith;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getApikey() {
        return apikey;
    }

    public String getBuildId() {
        return buildId;
    }

    public Collection<ModuleDependencies> getModuleDependencies() {
        return moduleDependencies;
    }

    public Collection<IvyReport> getIvyReports() {
        return ivyReports;
    }

    public String getFormatVersion() {
        return formatVersion;
    }

    public String getSubmittedWith() {
        return submittedWith;
    }
}
