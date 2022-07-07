package com.company.jmixexpenses.app;

import com.company.jmixexpenses.exception.ExceedingFundsLimitException;
import io.jmix.core.Messages;
import io.jmix.ui.Notifications;
import io.jmix.ui.exception.AbstractUiExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;

@Component("com.company.jmixexpenses.app.ExceedingFundsLimitExceptionHandler")
public class ExceedingFundsLimitExceptionHandler extends AbstractUiExceptionHandler {
    @Autowired
    private Messages messages;

    public ExceedingFundsLimitExceptionHandler(){
        super(ExceedingFundsLimitException.class.getName());
    }

    @Override
    protected void doHandle(String className, String message, @Nullable Throwable throwable, UiContext context) {
        context.getDialogs().createExceptionDialog()
                .withThrowable(throwable)
                .withCaption(messages.getMessage("com.company.jmixexpenses.captionError"))
                .withMessage(messages.getMessage("com.company.jmixexpenses.exception/ExceedingFundsLimitExceptionMessage"))
                .show();
    }
}