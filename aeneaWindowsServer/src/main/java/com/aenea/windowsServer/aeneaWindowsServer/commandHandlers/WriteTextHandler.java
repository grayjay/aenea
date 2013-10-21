package com.aenea.windowsServer.aeneaWindowsServer.commandHandlers;

import java.util.*;

import com.aenea.windowsServer.aeneaWindowsServer.*;
import com.aenea.windowsServer.aeneaWindowsServer.WindowsKeys.Key;


public class WriteTextHandler extends AbstractHandler {
  private static final String METHOD = "write_text";
  
  private static final Parameter TEXT = new Parameter("text", String.class);
  
  @Override
  protected String getMethodName() {
    return METHOD;
  }

  @Override
  protected Object process(Map<Parameter, Object> aArgs) {
    String mText = (String) aArgs.get(TEXT);
    WindowsKeys mWindowsKeys = new WindowsKeys();
    char[] mChars = new char[mText.length()];
    mText.getChars(0, mText.length(), mChars, 0);
    for (char mChar : mChars) {
      Key mKey = WindowsKeys.getKey(mChar);
      mWindowsKeys.press(mKey);
    }
    return null;
  }

  @Override
  protected Collection<Parameter> getRequiredParams() {
    return Arrays.asList(TEXT);
  }

  @Override
  protected Collection<OptionalParameter> getOptionalParams() {
    return Collections.emptyList();
  }
}
