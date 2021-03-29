package com.pay.sampleapp.ui.baseActivity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public abstract class BaseActivityViewModel extends ViewModel {

    private MutableLiveData<Boolean> showLoadingProgress = new MutableLiveData<Boolean>();
    private MutableLiveData<String> failMessage = new MutableLiveData<>();

    MutableLiveData<Boolean> getShowLoadingProgress() {
        return showLoadingProgress;
    }

    public void setShowLoadingProgress(boolean showLoadingProgress) {
        this.showLoadingProgress.setValue(showLoadingProgress);
    }

    public MutableLiveData<String> getFailMessage() {
        return failMessage;
    }

    public void setFailMessage(String failMessage) {
        setShowLoadingProgress(false);
        this.failMessage.setValue(failMessage);
    }
}
