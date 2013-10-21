package com.aenea.windowsServer.aeneaWindowsServer.commandHandlers;

import java.util.*;

public class GetContextHandler extends AbstractHandler {
  private static final String METHOD = "get_context";

  @Override
  protected String getMethodName() {
    return METHOD;
  }

  @Override
  protected Object process(Map<Parameter, Object> aArgs) {
    Map<String, Object> mResult = new HashMap<>();
    mResult.put("id", "");
    mResult.put("title", "");
    return mResult;
  }

  @Override
  protected Collection<Parameter> getRequiredParams() {
    return Collections.emptySet();
  }

  @Override
  protected Collection<OptionalParameter> getOptionalParams() {
    return Collections.emptySet();
  }

}
