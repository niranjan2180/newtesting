package com.eisedo.eisedo.data.local.entities;

public class HomeTaskCount {

    public long inboxCount;

    public long starredCount;

    public long overDueCount;

    public long delegateCount;

    public long completedCount;

    public long trashedCount;

    public long repeatCount;

    public long getRepeatCount() {
        return repeatCount;
    }

    public HomeTaskCount setRepeatCount(long repeatCount) {
        this.repeatCount = repeatCount;
        return this;
    }

    public long getInboxCount() {
        return inboxCount;
    }

    public void setInboxCount(long inboxCount) {
        this.inboxCount = inboxCount;
    }

    public long getStarredCount() {
        return starredCount;
    }

    public void setStarredCount(long starredCount) {
        this.starredCount = starredCount;
    }


    public long getOverDueCount() {
        return overDueCount;
    }

    public void setOverDueCount(long overDueCount) {
        this.overDueCount = overDueCount;
    }

    public long getDelegateCount() {
        return delegateCount;
    }

    public void setDelegateCount(long delegateCount) {
        this.delegateCount = delegateCount;
    }

    public long getCompletedCount() {
        return completedCount;
    }

    public void setCompletedCount(long completedCount) {
        this.completedCount = completedCount;
    }

    public long getTrashedCount() {
        return trashedCount;
    }

    public void setTrashedCount(long trashedCount) {
        this.trashedCount = trashedCount;
    }
}