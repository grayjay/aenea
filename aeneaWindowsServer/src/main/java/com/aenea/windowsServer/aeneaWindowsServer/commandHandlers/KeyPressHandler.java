package com.aenea.windowsServer.aeneaWindowsServer.commandHandlers;

import java.util.*;

import com.aenea.windowsServer.aeneaWindowsServer.*;
import com.aenea.windowsServer.aeneaWindowsServer.WindowsKeys.Direction;
import com.aenea.windowsServer.aeneaWindowsServer.WindowsKeys.Key;


public class KeyPressHandler extends AbstractHandler {
  private static final String METHOD = "key_press";
  
  private static final Parameter KEY = new Parameter("key", String.class);
  private static final OptionalParameter MODIFIERS = new OptionalParameter("modifiers", List.class, Collections.emptyList());
  private static final OptionalParameter DIRECTION = new OptionalParameter("direction", String.class, "press");
  private static final OptionalParameter COUNT = new OptionalParameter("count", Number.class, 1);
  private static final OptionalParameter DELAY = new OptionalParameter("delay", Number.class, WindowsKeys.DEFAULT_DELAY);
  
  @Override
  protected String getMethodName() {
    return METHOD;
  }

  @Override
  protected Object process(Map<Parameter, Object> aArgs) {
    keyPress(
        (String) aArgs.get(KEY),
        (List<String>) aArgs.get(MODIFIERS),
        (String) aArgs.get(DIRECTION),
        ((Number) aArgs.get(COUNT)).intValue(),
        ((Number) aArgs.get(DELAY)).intValue());
    return null;
  }

  @Override
  protected Collection<Parameter> getRequiredParams() {
    return Arrays.asList(KEY);
  }

  @Override
  protected Collection<OptionalParameter> getOptionalParams() {
    return Arrays.asList(MODIFIERS, DIRECTION, COUNT, DELAY);
  }

  private static void keyPress(
      String aKey,
      List<String> aModifiers,
      String aDirection,
      int aCount,
      int aDelay) {
    Key mKey = WindowsKeys.getKey(aKey);
    Collection<Key> mModifiers = new ArrayList();
    for (String mModifier : aModifiers) {
      mModifiers.add(WindowsKeys.getKey(mModifier));
    }
    Direction mDirection = WindowsKeys.getDirection(aDirection);
    WindowsKeys mWindowsKeys = new WindowsKeys();
    mWindowsKeys.keyPress(mKey, mModifiers, mDirection, aCount, aDelay);
  }
}
