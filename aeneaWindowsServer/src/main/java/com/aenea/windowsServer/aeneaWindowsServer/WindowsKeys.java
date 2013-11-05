package com.aenea.windowsServer.aeneaWindowsServer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

public class WindowsKeys {
  public static final int DEFAULT_DELAY = -1;

  private final Robot myRobot;

  public enum Direction {
    PRESS,
    DOWN,
    UP
  }

  public enum Key {
    ALT(KeyEvent.VK_ALT, "alt", null, false, true),
    CTRL(KeyEvent.VK_CONTROL, "ctrl", null, false, true),
    CONTROL(KeyEvent.VK_CONTROL, "control", null, false, true),
    SHIFT(KeyEvent.VK_SHIFT, "shift", null, false, true),
    KEY_0(KeyEvent.VK_0, "0", '0', false, false),
    KEY_1(KeyEvent.VK_1, "1", '1', false, false),
    KEY_2(KeyEvent.VK_2, "2", '2', false, false),
    KEY_3(KeyEvent.VK_3, "3", '3', false, false),
    KEY_4(KeyEvent.VK_4, "4", '4', false, false),
    KEY_5(KeyEvent.VK_5, "5", '5', false, false),
    KEY_6(KeyEvent.VK_6, "6", '6', false, false),
    KEY_7(KeyEvent.VK_7, "7", '7', false, false),
    KEY_8(KeyEvent.VK_8, "8", '8', false, false),
    KEY_9(KeyEvent.VK_9, "9", '9', false, false),
    KEY_A(KeyEvent.VK_A, "A", 'A', true, false),
    KEY_B(KeyEvent.VK_B, "B", 'B', true, false),
    KEY_C(KeyEvent.VK_C, "C", 'C', true, false),
    KEY_D(KeyEvent.VK_D, "D", 'D', true, false),
    KEY_E(KeyEvent.VK_E, "E", 'E', true, false),
    KEY_F(KeyEvent.VK_F, "F", 'F', true, false),
    KEY_G(KeyEvent.VK_G, "G", 'G', true, false),
    KEY_H(KeyEvent.VK_H, "H", 'H', true, false),
    KEY_I(KeyEvent.VK_I, "I", 'I', true, false),
    KEY_J(KeyEvent.VK_J, "J", 'J', true, false),
    KEY_K(KeyEvent.VK_K, "K", 'K', true, false),
    KEY_L(KeyEvent.VK_L, "L", 'L', true, false),
    KEY_M(KeyEvent.VK_M, "M", 'M', true, false),
    KEY_N(KeyEvent.VK_N, "N", 'N', true, false),
    KEY_O(KeyEvent.VK_O, "O", 'O', true, false),
    KEY_P(KeyEvent.VK_P, "P", 'P', true, false),
    KEY_Q(KeyEvent.VK_Q, "Q", 'Q', true, false),
    KEY_R(KeyEvent.VK_R, "R", 'R', true, false),
    KEY_S(KeyEvent.VK_S, "S", 'S', true, false),
    KEY_T(KeyEvent.VK_T, "T", 'T', true, false),
    KEY_U(KeyEvent.VK_U, "U", 'U', true, false),
    KEY_V(KeyEvent.VK_V, "V", 'V', true, false),
    KEY_W(KeyEvent.VK_W, "W", 'W', true, false),
    KEY_X(KeyEvent.VK_X, "X", 'X', true, false),
    KEY_Y(KeyEvent.VK_Y, "Y", 'Y', true, false),
    KEY_Z(KeyEvent.VK_Z, "Z", 'Z', true, false),
    KEY_a(KeyEvent.VK_A, "a", 'a', false, false),
    KEY_b(KeyEvent.VK_B, "b", 'b', false, false),
    KEY_c(KeyEvent.VK_C, "c", 'c', false, false),
    KEY_d(KeyEvent.VK_D, "d", 'd', false, false),
    KEY_e(KeyEvent.VK_E, "e", 'e', false, false),
    KEY_f(KeyEvent.VK_F, "f", 'f', false, false),
    KEY_g(KeyEvent.VK_G, "g", 'g', false, false),
    KEY_h(KeyEvent.VK_H, "h", 'h', false, false),
    KEY_i(KeyEvent.VK_I, "i", 'i', false, false),
    KEY_j(KeyEvent.VK_J, "j", 'j', false, false),
    KEY_k(KeyEvent.VK_K, "k", 'k', false, false),
    KEY_l(KeyEvent.VK_L, "l", 'l', false, false),
    KEY_m(KeyEvent.VK_M, "m", 'm', false, false),
    KEY_n(KeyEvent.VK_N, "n", 'n', false, false),
    KEY_o(KeyEvent.VK_O, "o", 'o', false, false),
    KEY_p(KeyEvent.VK_P, "p", 'p', false, false),
    KEY_q(KeyEvent.VK_Q, "q", 'q', false, false),
    KEY_r(KeyEvent.VK_R, "r", 'r', false, false),
    KEY_s(KeyEvent.VK_S, "s", 's', false, false),
    KEY_t(KeyEvent.VK_T, "t", 't', false, false),
    KEY_u(KeyEvent.VK_U, "u", 'u', false, false),
    KEY_v(KeyEvent.VK_V, "v", 'v', false, false),
    KEY_w(KeyEvent.VK_W, "w", 'w', false, false),
    KEY_x(KeyEvent.VK_X, "x", 'x', false, false),
    KEY_y(KeyEvent.VK_Y, "y", 'y', false, false),
    KEY_z(KeyEvent.VK_Z, "z", 'z', false, false),
    LEFT(KeyEvent.VK_LEFT, "left", null, false, false),
    RIGHT(KeyEvent.VK_RIGHT, "right", null, false, false),
    UP(KeyEvent.VK_UP, "up", null, false, false),
    DOWN(KeyEvent.VK_DOWN, "down", null, false, false),
    PGUP(KeyEvent.VK_PAGE_UP, "pgup", null, false, false),
    PGDOWN(KeyEvent.VK_PAGE_DOWN, "pgdown", null, false, false),
    HOME(KeyEvent.VK_HOME, "home", null, false, false),
    END(KeyEvent.VK_END, "end", null, false, false),
    SPACE(KeyEvent.VK_SPACE, "space", ' ', false, false),
    TAB(KeyEvent.VK_TAB, "tab", null, false, false),
    ENTER(KeyEvent.VK_ENTER, "enter", null, false, false),
    BACKSPACE(KeyEvent.VK_BACK_SPACE, "backspace", null, false, false),
    INSERT(KeyEvent.VK_INSERT, "insert", null, false, false),
    RETURN(KeyEvent.VK_ENTER, "enter", null, false, false),
    BACK(KeyEvent.VK_BACK_SPACE, "backspace", null, false, false),
    DELETE(KeyEvent.VK_DELETE, "delete", null, false, false),
    DEL(KeyEvent.VK_DELETE, "del", null, false, false),
    LWIN(KeyEvent.VK_WINDOWS, "win", null, false, false),
    APPS(KeyEvent.VK_CONTEXT_MENU, "apps", null, false, false),
    POPUP(KeyEvent.VK_CONTEXT_MENU, "popup", null, false, false),
    PAUSE(KeyEvent.VK_PAUSE, "pause", null, false, false),
    ESCAPE(KeyEvent.VK_ESCAPE, "escape", null, false, false),
    MULTIPLY(KeyEvent.VK_MULTIPLY, "npmul", null, false, false),
    ADD(KeyEvent.VK_ADD, "npadd", null, false, false),
    SEPARATOR(KeyEvent.VK_SEPARATOR, "npsep", null, false, false),
    SUBTRACT(KeyEvent.VK_SUBTRACT, "npsub", null, false, false),
    DECIMAL(KeyEvent.VK_DECIMAL, "npdec", null, false, false),
    DIVIDE(KeyEvent.VK_DIVIDE, "npdiv", null, false, false),
    NUMPAD0(KeyEvent.VK_NUMPAD0, "np0", null, false, false),
    NUMPAD0_2(KeyEvent.VK_NUMPAD0, "numpad0", null, false, false),
    NUMPAD1(KeyEvent.VK_NUMPAD1, "np1", null, false, false),
    NUMPAD1_2(KeyEvent.VK_NUMPAD1, "numpad1", null, false, false),
    NUMPAD2(KeyEvent.VK_NUMPAD2, "np2", null, false, false),
    NUMPAD2_2(KeyEvent.VK_NUMPAD2, "numpad2", null, false, false),
    NUMPAD3(KeyEvent.VK_NUMPAD3, "np3", null, false, false),
    NUMPAD3_2(KeyEvent.VK_NUMPAD3, "numpad3", null, false, false),
    NUMPAD4(KeyEvent.VK_NUMPAD4, "np4", null, false, false),
    NUMPAD4_2(KeyEvent.VK_NUMPAD4, "numpad4", null, false, false),
    NUMPAD5(KeyEvent.VK_NUMPAD5, "np5", null, false, false),
    NUMPAD5_2(KeyEvent.VK_NUMPAD5, "numpad5", null, false, false),
    NUMPAD6(KeyEvent.VK_NUMPAD6, "np6", null, false, false),
    NUMPAD6_2(KeyEvent.VK_NUMPAD6, "numpad6", null, false, false),
    NUMPAD7(KeyEvent.VK_NUMPAD7, "np7", null, false, false),
    NUMPAD7_2(KeyEvent.VK_NUMPAD7, "numpad7", null, false, false),
    NUMPAD8(KeyEvent.VK_NUMPAD8, "np8", null, false, false),
    NUMPAD8_2(KeyEvent.VK_NUMPAD8, "numpad8", null, false, false),
    NUMPAD9(KeyEvent.VK_NUMPAD9, "np9", null, false, false),
    NUMPAD9_2(KeyEvent.VK_NUMPAD9, "numpad9", null, false, false),
    F1(KeyEvent.VK_F1, "f1", null, false, false),
    F2(KeyEvent.VK_F2, "f2", null, false, false),
    F3(KeyEvent.VK_F3, "f3", null, false, false),
    F4(KeyEvent.VK_F4, "f4", null, false, false),
    F5(KeyEvent.VK_F5, "f5", null, false, false),
    F6(KeyEvent.VK_F6, "f6", null, false, false),
    F7(KeyEvent.VK_F7, "f7", null, false, false),
    F8(KeyEvent.VK_F8, "f8", null, false, false),
    F9(KeyEvent.VK_F9, "f9", null, false, false),
    F10(KeyEvent.VK_F10, "f10", null, false, false),
    F11(KeyEvent.VK_F11, "f11", null, false, false),
    F12(KeyEvent.VK_F12, "f12", null, false, false),
    F13(KeyEvent.VK_F13, "f13", null, false, false),
    F14(KeyEvent.VK_F14, "f14", null, false, false),
    F15(KeyEvent.VK_F15, "f15", null, false, false),
    F16(KeyEvent.VK_F16, "f16", null, false, false),
    F17(KeyEvent.VK_F17, "f17", null, false, false),
    F18(KeyEvent.VK_F18, "f18", null, false, false),
    F19(KeyEvent.VK_F19, "f19", null, false, false),
    F20(KeyEvent.VK_F20, "f20", null, false, false),
    F21(KeyEvent.VK_F21, "f21", null, false, false),
    F22(KeyEvent.VK_F22, "f22", null, false, false),
    F23(KeyEvent.VK_F23, "f23", null, false, false),
    F24(KeyEvent.VK_F24, "f24", null, false, false),
    BANG(KeyEvent.VK_1, "bang", '!', true, false),
    EXPCLAMATION(KeyEvent.VK_1, "exclamation", '!', true, false),
    AT(KeyEvent.VK_2, "at", '@', true, false),
    HASH(KeyEvent.VK_3, "hash", '#', true, false),
    DOLLAR(KeyEvent.VK_4, "exclamation", '$', true, false),
    PERCENT(KeyEvent.VK_5, "percent", '%', true, false),
    CARET(KeyEvent.VK_6, "caret", '^', true, false),
    AND(KeyEvent.VK_7, "and", '&', true, false),
    AMPERSAND(KeyEvent.VK_7, "ampersand", '&', true, false),
    STAR(KeyEvent.VK_8, "star", '*', true, false),
    ASTERISK(KeyEvent.VK_8, "asterisk", '*', true, false),
    LEFT_PAREN(KeyEvent.VK_9, "leftparen", '(', true, false),
    L_PAREN(KeyEvent.VK_9, "lparen", '(', true, false),
    RIGHT_PAREN(KeyEvent.VK_0, "rightparen", ')', true, false),
    R_PAREN(KeyEvent.VK_0, "rparen", ')', true, false),
    MINUS(KeyEvent.VK_MINUS, "minus", '-', false, false),
    HYPEN(KeyEvent.VK_MINUS, "hyphen", '-', false, false),
    UNDERSCORE(KeyEvent.VK_MINUS, "underscore", '_', true, false),
    PLUS(KeyEvent.VK_EQUALS, "plus", '+', true, false),
    EQUAL(KeyEvent.VK_EQUALS, "equal", '=', false, false),
    EQUALS(KeyEvent.VK_EQUALS, "equals", '=', false, false),
    BACKTICK(KeyEvent.VK_BACK_QUOTE, "backtick", '`', false, false),
    TILDE(KeyEvent.VK_BACK_QUOTE, "tilde", '~', true, false),
    LEFT_BRACKET(KeyEvent.VK_OPEN_BRACKET, "leftbracket", '[', false, false),
    L_BRACKET(KeyEvent.VK_OPEN_BRACKET, "lbracket", '[', false, false),
    RIGHT_BRACKET(KeyEvent.VK_CLOSE_BRACKET, "rightbracket", ']', false, false),
    R_BRACKET(KeyEvent.VK_CLOSE_BRACKET, "rbracket", ']', false, false),
    LEFT_BRACE(KeyEvent.VK_OPEN_BRACKET, "leftbrace", '{', true, false),
    L_BRACE(KeyEvent.VK_OPEN_BRACKET, "lbrace", '{', true, false),
    RIGHT_BRACE(KeyEvent.VK_CLOSE_BRACKET, "rightbrace", '}', true, false),
    R_BRACE(KeyEvent.VK_CLOSE_BRACKET, "rbrace", '}', true, false),
    BACKSLASH(KeyEvent.VK_BACK_SLASH, "backslash", '\\', false, false),
    BAR(KeyEvent.VK_BACK_SLASH, "bar", '|', true, false),
    COLON(KeyEvent.VK_SEMICOLON, "colon", ':', true, false),
    SEMICOLON(KeyEvent.VK_SEMICOLON, "semicolon", ';', false, false),
    APOSTROPHE(KeyEvent.VK_QUOTE, "apostrophe", '\'', false, false),
    SINGLE_QUOTE(KeyEvent.VK_QUOTE, "singlequote", '\'', false, false),
    SQUOTE(KeyEvent.VK_QUOTE, "squote", '\'', false, false),
    QUOTE(KeyEvent.VK_QUOTE, "quote", '"', true, false),
    DOUBLE_QUOTE(KeyEvent.VK_QUOTE, "doublequote", '"', true, false),
    DQUOTE(KeyEvent.VK_QUOTE, "dquote", '"', true, false),
    COMMA(KeyEvent.VK_COMMA, "comma", ',', false, false),
    DOT(KeyEvent.VK_PERIOD, "dot", '.', false, false),
    SLASH(KeyEvent.VK_SLASH, "slash", '/', false, false),
    LESS_THAN(KeyEvent.VK_COMMA, "lessthan", '<', true, false),
    LEFT_ANGLE(KeyEvent.VK_COMMA, "leftangle", '<', true, false),
    LANGLE(KeyEvent.VK_COMMA, "langle", '<', true, false),
    GREATER_THAN(KeyEvent.VK_PERIOD, "greaterthan", '>', true, false),
    RIGHT_ANGLE(KeyEvent.VK_PERIOD, "rightangle", '>', true, false),
    RANGLE(KeyEvent.VK_PERIOD, "rangle", '>', true, false),
    QUESTION(KeyEvent.VK_SLASH, "question", '?', true, false);
    
    private final int myCode;
    private final String myName;
    private final Character myCharacter;
    private final boolean myRequiresShift;
    private final boolean myIsModifier;

    Key(int aCode, String aName, Character aCharacter, boolean aRequiresShift, boolean aIsModifier) {
      myCode = aCode;
      myName = aName;
      myCharacter = aCharacter;
      myRequiresShift = aRequiresShift;
      myIsModifier = aIsModifier;
    }

    public String getName() {
      return myName;
    }

    public Character getCharacter() {
      return myCharacter;
    }

    public boolean requiresShift() {
      return myRequiresShift;
    }

    public boolean isModifier() {
      return myIsModifier;
    }

    int getKeyCode() {
      return myCode;
    }
  }

  private static final Map<String, Key> myKeyNameMap;
  private static final Map<Character, Key> myKeyCharMap;
  private static final Map<String, Direction> myDirectionMap;

  static {
    myKeyNameMap = new HashMap<>();
    for (Key mKey : Key.values()) {
      myKeyNameMap.put(mKey.getName(), mKey);
    }
    myKeyCharMap = new HashMap<>();
    for (Key mKey : Key.values()) {
      Character mChar = mKey.getCharacter();
      if (mChar != null) {
        myKeyCharMap.put(mKey.getCharacter(), mKey);
      }
    }
    myDirectionMap = new HashMap<>();
    for (Direction mDirection : Direction.values()) {
      myDirectionMap.put(mDirection.name().toLowerCase(), mDirection);
    }
  }

  public static Key getKey(String aName) {
    if (!myKeyNameMap.containsKey(aName)) {
      throw new IllegalArgumentException("Key not found: " + aName);
    }
    return myKeyNameMap.get(aName);
  }

  public static Key getKey(Character aCharacter) {
    if (!myKeyCharMap.containsKey(aCharacter)) {
      throw new IllegalArgumentException("Key not found: " + aCharacter);
    }
    return myKeyCharMap.get(aCharacter);
  }

  public static Direction getDirection(String aDirection) {
    if (!myDirectionMap.containsKey(aDirection)) {
      throw new IllegalArgumentException("Direction not found: " + aDirection);
    }
    return myDirectionMap.get(aDirection);
  }

  public WindowsKeys() {
    try {
      myRobot = new Robot();
    } catch (AWTException e) {
      throw new RuntimeException(e);
    }
  }

  public void keyPress(
      Key aKey,
      Collection<Key> aModifiers,
      Direction aDirection,
      int aCount,
      int aDelayMillis) {
    int mOldDelay = myRobot.getAutoDelay();
    try {
      if (aDelayMillis >= 0) {
        myRobot.setAutoDelay(aDelayMillis);
      }
      Collection<Key> mModifiers = null;
      if (aKey.requiresShift()) {
        mModifiers = new HashSet<>(aModifiers);
        mModifiers.add(Key.SHIFT);
      } else mModifiers = aModifiers;
      try {
        for (Key mModifier : mModifiers) {
          myRobot.keyPress(mModifier.getKeyCode());
        }
        for (int i = 0; i < aCount; i++) {
          int mCode = aKey.getKeyCode();
          switch (aDirection) {
          case PRESS: pressOnce(aKey); break;
          case DOWN: myRobot.keyPress(mCode); break;
          case UP: myRobot.keyRelease(mCode); break;
          default: throw new AssertionError("Unrecognized direction: " + aDirection);
          }
        }
      } finally {
        for (Key mModifier : mModifiers) {
          myRobot.keyRelease(mModifier.getKeyCode());
        }
      }
    } finally {
      myRobot.setAutoDelay(mOldDelay);
    }
  }

  public void press(Key aKey) {
    int mShiftCode = Key.SHIFT.getKeyCode();
    if (aKey.requiresShift()) {
      try {
        myRobot.keyPress(mShiftCode);
        pressOnce(aKey);
      } finally {
        myRobot.keyRelease(mShiftCode);
      }
    } else pressOnce(aKey);
  }

  private void pressOnce(Key aKey) {
    int mCode = aKey.getKeyCode();
    try {
      myRobot.keyPress(mCode);
    } finally {
      myRobot.keyRelease(mCode);
    }
  }
}
