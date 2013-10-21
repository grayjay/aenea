package com.aenea.windowsServer.aeneaWindowsServer.commandHandlers;

import java.util.*;

import com.thetransactioncompany.jsonrpc2.*;
import com.thetransactioncompany.jsonrpc2.server.*;
import com.thetransactioncompany.jsonrpc2.util.NamedParamsRetriever;

abstract class AbstractHandler implements RequestHandler {  
  protected abstract String getMethodName();
  protected abstract Object process(Map<Parameter, Object> aArgs);
  protected abstract Collection<Parameter> getRequiredParams();
  protected abstract Collection<OptionalParameter> getOptionalParams();

  @Override
  public final String[] handledRequests() {
    return new String[] {getMethodName()};
  }

  @Override
  public final JSONRPC2Response process(JSONRPC2Request aRequest, MessageContext aContext) {
    Object mId = aRequest.getID();
    if (!aRequest.getMethod().equals(getMethodName())) {
      return new JSONRPC2Response(JSONRPC2Error.METHOD_NOT_FOUND, mId);
    }
    JSONRPC2ParamsType mParamsType = aRequest.getParamsType();
    if (mParamsType == JSONRPC2ParamsType.NO_PARAMS) {
      return new JSONRPC2Response(process(null), mId);
    } else if (mParamsType == JSONRPC2ParamsType.OBJECT) {
      Map<String, Object> mNamedParams = aRequest.getNamedParams();
      NamedParamsRetriever mRetriever = new NamedParamsRetriever(mNamedParams);
      Map<Parameter, Object> mArgs = new HashMap<>();
      try {
        for (Parameter mRequired : getRequiredParams()) {
          mArgs.put(mRequired, mRetriever.get(mRequired.getName(), mRequired.getType()));
        }
        for (OptionalParameter mOptional : getOptionalParams()) {
          mArgs.put(mOptional, mRetriever.getOpt(mOptional.getName(), (Class<Object>) mOptional.getType(), mOptional.getDefault()));
        }
      } catch (JSONRPC2Error e) {
        return new JSONRPC2Response(JSONRPC2Error.INVALID_PARAMS, mId);
      }
      return new JSONRPC2Response(process(mArgs), mId);
    } else {
      return new JSONRPC2Response(JSONRPC2Error.INVALID_PARAMS, mId);
    }
  }
}
