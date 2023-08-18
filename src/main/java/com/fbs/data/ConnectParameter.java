package com.fbs.data;

import org.jetbrains.annotations.Nullable;

public class ConnectParameter {

    private String parameterName;
    private Object parameterValue0, parameterValue1;

    public ConnectParameter(String parameterName, Object parameterValue){
        this.parameterName = parameterName;
        parameterValue0 = parameterValue;
    }
    public ConnectParameter(String parameterName, Object parameterValue0, Object parameterValue1){
        this.parameterName = parameterName;
        this.parameterValue0 = parameterValue0;
        this.parameterValue1 = parameterValue1;
    }

    public String getParameterName(){
        return parameterName;
    }

    public @Nullable Object getParameterValue(int index){
        return switch (index) {
            case 0 -> parameterValue0;
            case 1 -> parameterValue1;
            default -> null;
        };
    }

    public void setParameterValue(int index, Object value){
        switch (index) {
            case 0 -> parameterValue0 = value;
            case 1 -> parameterValue1 = value;
        };
    }

    public void setParameterValue(Object value){
        parameterValue0 = value;
    }
    public void setParameterValues(Object value0, Object value1){
        parameterValue0 = value0;
        parameterValue1 = value1;
    }
}
