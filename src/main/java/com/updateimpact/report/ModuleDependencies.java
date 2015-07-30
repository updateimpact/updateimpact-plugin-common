package com.updateimpact.report;

import java.util.Collection;

public class ModuleDependencies {
    private final DependencyId moduleId;
    private final String config;
    private final Collection<Dependency> dependencies;

    public ModuleDependencies(DependencyId moduleId, String config, Collection<Dependency> dependencies) {
        this.moduleId = moduleId;
        this.config = config;
        this.dependencies = dependencies;
    }

    public DependencyId getModuleId() {
        return moduleId;
    }

    public String getConfig() {
        return config;
    }

    public Collection<Dependency> getDependencies() {
        return dependencies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModuleDependencies that = (ModuleDependencies) o;

        if (moduleId != null ? !moduleId.equals(that.moduleId) : that.moduleId != null) return false;
        if (config != null ? !config.equals(that.config) : that.config != null) return false;
        return !(dependencies != null ? !dependencies.equals(that.dependencies) : that.dependencies != null);

    }

    @Override
    public int hashCode() {
        int result = moduleId != null ? moduleId.hashCode() : 0;
        result = 31 * result + (config != null ? config.hashCode() : 0);
        result = 31 * result + (dependencies != null ? dependencies.hashCode() : 0);
        return result;
    }
}
