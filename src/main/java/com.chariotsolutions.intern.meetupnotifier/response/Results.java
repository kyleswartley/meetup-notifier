package com.chariotsolutions.intern.meetupnotifier.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Results {
    private List<Result> results;
    @JsonIgnore
    private Meta meta;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "Results{" +
                "results=" + results +
                ", meta=" + meta +
                '}';
    }
}
