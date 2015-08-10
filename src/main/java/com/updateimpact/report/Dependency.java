package com.updateimpact.report;

import java.util.List;

public class Dependency {
    private final DependencyId id;
    private final List<DependencyChild> dependencies;

    public Dependency(DependencyId id, List<DependencyChild> dependencies) {
        this.id = id;
        this.dependencies = dependencies;
    }

    public DependencyId getId() {
        return id;
    }

    public List<DependencyChild> getDependencies() {
        return dependencies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dependency that = (Dependency) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return !(dependencies != null ? !dependencies.equals(that.dependencies) : that.dependencies != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dependencies != null ? dependencies.hashCode() : 0);
        return result;
    }
}
