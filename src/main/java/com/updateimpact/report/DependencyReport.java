package com.updateimpact.report;

import java.util.Collection;

/**
 * Typically contains either:
 * - <code>moduleDependencies</code> with already process information on each module's dependencies
 * - <code>moduleIvyReports</code> with raw data from which dependency information has to be extracted server-side
 */
public class DependencyReport {
    private final String projectName;
    private final String apikey;
    private final String buildId;
    private final Collection<ModuleDependencies> moduleDependencies;
    private final Collection<ModuleIvyReport> moduleIvyReports;
    private final String formatVersion;
    private final String submittedWith;

    public DependencyReport(String projectName,
                            String apikey,
                            String buildId,
                            Collection<ModuleDependencies> moduleDependencies,
                            Collection<ModuleIvyReport> moduleIvyReports,
                            String formatVersion,
                            String submittedWith) {
        this.projectName = projectName;
        this.apikey = apikey;
        this.buildId = buildId;
        this.moduleDependencies = moduleDependencies;
        this.moduleIvyReports = moduleIvyReports;
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

    public Collection<ModuleIvyReport> getModuleIvyReports() {
        return moduleIvyReports;
    }

    public String getFormatVersion() {
        return formatVersion;
    }

    public String getSubmittedWith() {
        return submittedWith;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DependencyReport that = (DependencyReport) o;

        if (projectName != null ? !projectName.equals(that.projectName) : that.projectName != null) return false;
        if (apikey != null ? !apikey.equals(that.apikey) : that.apikey != null) return false;
        if (buildId != null ? !buildId.equals(that.buildId) : that.buildId != null) return false;
        if (moduleDependencies != null ? !moduleDependencies.equals(that.moduleDependencies) : that.moduleDependencies != null)
            return false;
        if (moduleIvyReports != null ? !moduleIvyReports.equals(that.moduleIvyReports) : that.moduleIvyReports != null)
            return false;
        if (formatVersion != null ? !formatVersion.equals(that.formatVersion) : that.formatVersion != null)
            return false;
        return !(submittedWith != null ? !submittedWith.equals(that.submittedWith) : that.submittedWith != null);

    }

    @Override
    public int hashCode() {
        int result = projectName != null ? projectName.hashCode() : 0;
        result = 31 * result + (apikey != null ? apikey.hashCode() : 0);
        result = 31 * result + (buildId != null ? buildId.hashCode() : 0);
        result = 31 * result + (moduleDependencies != null ? moduleDependencies.hashCode() : 0);
        result = 31 * result + (moduleIvyReports != null ? moduleIvyReports.hashCode() : 0);
        result = 31 * result + (formatVersion != null ? formatVersion.hashCode() : 0);
        result = 31 * result + (submittedWith != null ? submittedWith.hashCode() : 0);
        return result;
    }
}
