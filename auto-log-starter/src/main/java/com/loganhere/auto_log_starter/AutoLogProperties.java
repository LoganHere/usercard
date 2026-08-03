package com.loganhere.auto_log_starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "auto-log")
public class AutoLogProperties {

    private boolean enabled = true;

    private LogLevel defaultLevel = LogLevel.INFO;

    private int maxStringLength = 500;

    private String maskChar = "*";

    private boolean showFullClassName = false;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public LogLevel getDefaultLevel() {
        return defaultLevel;
    }

    public void setDefaultLevel(LogLevel defaultLevel) {
        this.defaultLevel = defaultLevel;
    }

    public int getMaxStringLength() {
        return maxStringLength;
    }

    public void setMaxStringLength(int maxStringLength) {
        this.maxStringLength = maxStringLength;
    }

    public String getMaskChar() {
        return maskChar;
    }

    public void setMaskChar(String maskChar) {
        this.maskChar = maskChar;
    }

    public boolean isShowFullClassName() {
        return showFullClassName;
    }

    public void setShowFullClassName(boolean showFullClassName) {
        this.showFullClassName = showFullClassName;
    }
}
