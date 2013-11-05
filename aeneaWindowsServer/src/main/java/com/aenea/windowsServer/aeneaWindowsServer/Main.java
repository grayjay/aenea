package com.aenea.windowsServer.aeneaWindowsServer;

import java.io.*;
import java.net.InetSocketAddress;

import javax.servlet.http.*;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.AbstractHandler;

import com.aenea.windowsServer.aeneaWindowsServer.commandHandlers.*;
import com.thetransactioncompany.jsonrpc2.*;
import com.thetransactioncompany.jsonrpc2.server.Dispatcher;


public class Main {
  public static void main(String[] aArgs) throws Exception {
    if (aArgs.length == 0) {
      System.out.println("Expecting the ip address to bind to");
    } else if (aArgs.length > 1) {
      System.out.println("Expecting only the ip address to bind to");
    } else {
      String mIpAddress = aArgs[0];
      System.out.println("Using ip address: " + mIpAddress);
      Server mServer = new Server(new InetSocketAddress(mIpAddress, 8240));
      mServer.setHandler(new AbstractHandler() {
        private Dispatcher myDispatcher;

        {
          myDispatcher = new Dispatcher();
          myDispatcher.register(new KeyPressHandler());
          myDispatcher.register(new WriteTextHandler());
          myDispatcher.register(new PauseHandler());
          myDispatcher.register(new GetContextHandler());
        }

        @Override
        public void handle(
            String aTarget,
            Request aBaseRequest,
            HttpServletRequest aRequest,
            HttpServletResponse aResponse) throws IOException {
          aResponse.setContentType("text/html;charset=utf-8");
          aResponse.setStatus(HttpServletResponse.SC_OK);
          aBaseRequest.setHandled(true);
          BufferedReader mReader = aRequest.getReader();
          StringBuilder mSB = new StringBuilder();
          String mLine = null;
          while ((mLine = mReader.readLine()) != null) {
            mSB.append(mLine);
          }
          JSONRPC2Request mJSON;
          try {
            mJSON = JSONRPC2Request.parse(mSB.toString(), true);

            System.out.println(mJSON.toJSONString());

            aResponse.getWriter().append(myDispatcher.process(mJSON, null).toJSONString());
          } catch (JSONRPC2ParseException e) {
            throw new RuntimeException(e);
          }
        }
      });
      mServer.start();
      mServer.join();
    }
  }
}
