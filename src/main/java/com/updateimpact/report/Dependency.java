package com.updateimpact.report;

import java.util.List;

public class Dependency {
    private final DependencyId id;
    private final String evictedByVersion;
    private final Boolean cycle;
    private final List<DependencyId> children;

    public Dependency(DependencyId id, String evictedByVersion, Boolean cycle, List<DependencyId> children) {
        this.id = id;
        this.evictedByVersion = evictedByVersion;
        this.cycle = cycle;
        this.children = children;
    }

    public DependencyId getId() {
        return id;
    }

    public String getEvictedByVersion() {
        return evictedByVersion;
    }

    public Boolean getCycle() {
        return cycle;
    }

    public List<DependencyId> getChildren() {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dependency that = (Dependency) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (evictedByVersion != null ? !evictedByVersion.equals(that.evictedByVersion) : that.evictedByVersion != null)
            return false;
        if (cycle != null ? !cycle.equals(that.cycle) : that.cycle != null) return false;
        return !(children != null ? !children.equals(that.children) : that.children != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (evictedByVersion != null ? evictedByVersion.hashCode() : 0);
        result = 31 * result + (cycle != null ? cycle.hashCode() : 0);
        result = 31 * result + (children != null ? children.hashCode() : 0);
        return result;
    }
}
