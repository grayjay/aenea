package com.aenea.windowsServer.aeneaWindowsServer.commandHandlers;


class OptionalParameter extends Parameter {
  private final Object myDefault;
  
  public OptionalParameter(String aName, Class<?> aType, Object aDefault) {
    super(aName, aType);
    myDefault = aDefault;
  }
  
  public Object getDefault() {
    return myDefault;
  }
}
