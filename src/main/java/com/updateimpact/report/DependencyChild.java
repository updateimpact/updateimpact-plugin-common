package com.updateimpact.report;

public class DependencyChild {
    private final DependencyId id;
    private final String evictedByVersion;
    private final Boolean cycle;

    public DependencyChild(DependencyId id, String evictedByVersion, Boolean cycle) {
        this.id = id;
        this.evictedByVersion = evictedByVersion;
        this.cycle = cycle;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DependencyChild that = (DependencyChild) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (evictedByVersion != null ? !evictedByVersion.equals(that.evictedByVersion) : that.evictedByVersion != null)
            return false;
        return !(cycle != null ? !cycle.equals(that.cycle) : that.cycle != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (evictedByVersion != null ? evictedByVersion.hashCode() : 0);
        result = 31 * result + (cycle != null ? cycle.hashCode() : 0);
        return result;
    }
}
