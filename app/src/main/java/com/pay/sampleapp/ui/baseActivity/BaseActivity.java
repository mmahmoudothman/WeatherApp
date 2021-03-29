package com.pay.sampleapp.ui.baseActivity;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;
import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;
import com.pay.sampleapp.utils.MyObserver;
import com.pay.sampleapp.R;


public abstract class BaseActivity<T extends BaseActivityViewModel> extends AppCompatActivity {

    private Dialog loadingDialog;

    public T viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onStart() {
        super.onStart();
        observeViewModel();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void showLoadingProgress() {
        if (loadingDialog == null) {
            loadingDialog = new Dialog(this);
            loadingDialog.setCancelable(false);
            loadingDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            loadingDialog.setContentView(R.layout.dialog_loading);
        }
        if (!loadingDialog.isShowing())
            loadingDialog.show();
    }

    public void hideLoadingProgress() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    protected void observeViewModel() {
        if (!viewModel.getShowLoadingProgress().hasObservers())
            viewModel.getShowLoadingProgress().observe(this, aBoolean -> {
                if (aBoolean)
                    showLoadingProgress();
                else
                    hideLoadingProgress();
            });
        if (!viewModel.getFailMessage().hasObservers())
            viewModel.getFailMessage().observe(this, new MyObserver<String>() {
                @Override
                public void valueChanged(String s) {
                    showFailMessage(s);
                }
            });
    }

    public void showFailMessage(String message) {
        viewModel.setShowLoadingProgress(false);
        SweetAlertDialog dialog = new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(getString(R.string.dialog_failure_title))
                .setContentText(message);
        dialog.setCancelable(false);
        dialog.show();
        viewModel.setFailMessage(null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }
}
