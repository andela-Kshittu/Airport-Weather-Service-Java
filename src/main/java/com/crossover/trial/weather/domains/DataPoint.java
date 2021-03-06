package com.crossover.trial.weather.domains;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * A collected point, including some information about the range of collected values
 *
 * @author code test administrator
 */
public final class DataPoint {

    private double mMean = 0.0;

    private int mFirst = 0;

    private int mMedian = 0;

    private int mLast = 0;

    private int mCount = 0;

    /**
     * private constructor, use the builder to create this object
     */
    private DataPoint() {
    }

    protected DataPoint(int first, int median, double mean, int last, int count) {
        this.setFirst(first);
        this.setMean(mean);
        this.setMedian(median);
        this.setLast(last);
        this.setCount(count);
    }

    /**
     * the mMean of the observations
     */
    public double getMean() {
        return mMean;
    }

    private void setMean(double mean) {
        this.mMean = mean;
    }

    /**
     * 1st quartile -- useful as a lower bound
     */
    public int getFirst() {
        return mFirst;
    }

    private void setFirst(int first) {
        this.mFirst = first;
    }

    /**
     * 2nd quartile -- mMedian value
     */
    public int getMedian() {
        return mMedian;
    }

    private void setMedian(int median) {
        this.mMedian = median;
    }

    /**
     * 3rd quartile value -- less noisy upper value
     */
    public int getLast() {
        return mLast;
    }

    private void setLast(int last) {
        this.mLast = last;
    }

    /**
     * the total number of measurements
     */
    public int getCount() {
        return mCount;
    }

    private void setCount(int count) {
        this.mCount = count;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
    }

    public boolean equals(Object that) {
        if (this == that)
            return true;
        if (that == null || getClass() != that.getClass())
            return false;
        return this.toString().equals(that.toString());
    }

    static public class Builder {
        int first;
        double mean;
        int median;
        int last;
        int count;

        public Builder() {
        }

        public Builder withFirst(int first) {
            this.first = first;
            return this;
        }

        public Builder withMean(double mean) {
            this.mean = mean;
            return this;
        }

        public Builder withMedian(int median) {
            this.median = median;
            return this;
        }

        public Builder withCount(int count) {
            this.count = count;
            return this;
        }

        public Builder withLast(int last) {
            this.last = last;
            return this;
        }

        public DataPoint build() {
            return new DataPoint(this.first, this.median, this.mean,this.last, this.count);
        }
    }
}
