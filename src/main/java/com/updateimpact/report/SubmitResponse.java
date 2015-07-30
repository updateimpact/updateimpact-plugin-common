package com.updateimpact.report;

public class SubmitResponse {
    private final String userIdStr;
    private final String buildId;

    public SubmitResponse(String userIdStr, String buildId) {
        this.userIdStr = userIdStr;
        this.buildId = buildId;
    }

    public String getUserIdStr() {
        return userIdStr;
    }

    public String getBuildId() {
        return buildId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubmitResponse that = (SubmitResponse) o;

        if (userIdStr != null ? !userIdStr.equals(that.userIdStr) : that.userIdStr != null) return false;
        return !(buildId != null ? !buildId.equals(that.buildId) : that.buildId != null);

    }

    @Override
    public int hashCode() {
        int result = userIdStr != null ? userIdStr.hashCode() : 0;
        result = 31 * result + (buildId != null ? buildId.hashCode() : 0);
        return result;
    }
}
