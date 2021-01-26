package com.ppt.web;

/** Class representing a url of the form https://... */
public class Url {
  private final Protocol protocol;
  private final String hostName;
  private final String fileName;

  public enum Protocol {
    HTTP,
    HTTPS,
    FTP,
    SMTP;

    @Override
    public String toString() {
      return name().toLowerCase();
    }
  }

  public Url(Protocol protocol, String hostName, String fileName) {
    this.protocol = protocol;
    this.hostName = hostName;
    this.fileName = fileName;
  }

  public String getFileName() {
    return fileName;
  }

  public String getHostName() {
    return hostName;
  }

  public Protocol getProtocol() {
    return protocol;
  }

  @Override
  public String toString() {
    return protocol + "://" + hostName + "/" + fileName;
  }
}
