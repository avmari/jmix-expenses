package com.company.jmixexpenses.app;

import com.company.jmixexpenses.exception.ExceedingFundsLimitException;
import io.jmix.ui.Notifications;
import io.jmix.ui.exception.AbstractUiExceptionHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;

@Component("com.company.jmixexpenses.app.ExceedingFundsLimitExceptionHandler")
public class ExceedingFundsLimitExceptionHandler extends AbstractUiExceptionHandler {

    public ExceedingFundsLimitExceptionHandler(){
        super(ExceedingFundsLimitException.class.getName());
    }

    @Override
    protected void doHandle(String className, String message, @Nullable Throwable throwable, UiContext context) {
        context.getDialogs().createExceptionDialog()
                .withThrowable(throwable)
                .withCaption("Error")
                .withMessage(message)
                .show();
    }
}