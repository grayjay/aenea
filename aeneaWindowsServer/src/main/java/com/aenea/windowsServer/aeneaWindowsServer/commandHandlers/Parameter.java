package com.aenea.windowsServer.aeneaWindowsServer.commandHandlers;


class Parameter {
  private final String myName;
  private final Class<?> myType;

  public Parameter(String aName, Class<?> aType) {
    myName = aName;
    myType = aType;
  }
  
  public String getName() {
    return myName;
  }

  public Class<?> getType() {
    return myType;
  }
}
