package com.aenea.windowsServer.aeneaWindowsServer.commandHandlers;

import java.util.*;

public class PauseHandler extends AbstractHandler {
  private static final String METHOD = "pause";
  
  private static final Parameter AMOUNT = new Parameter("amount", Number.class);
  
  @Override
  protected String getMethodName() {
    return METHOD;
  }

  @Override
  protected Object process(Map<Parameter, Object> aArgs) {
    int mPauseMillis = ((Number) aArgs.get(AMOUNT)).intValue();
    try {
      Thread.sleep(mPauseMillis);
    } catch (InterruptedException e) {
      // allow to return
      Thread.currentThread().interrupt();
    }
    return null;
  }

  @Override
  protected Collection<Parameter> getRequiredParams() {
    return Arrays.asList(AMOUNT);
  }

  @Override
  protected Collection<OptionalParameter> getOptionalParams() {
    return Collections.emptyList();
  }
}
