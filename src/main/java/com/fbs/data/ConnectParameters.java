package com.fbs.data;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Objects;

public class ConnectParameters {

    private final ArrayList<ConnectParameter> parameters = new ArrayList<>();

    public ArrayList<ConnectParameter> getParameters() {
        return parameters;
    }

    public @Nullable ConnectParameter getByName(String parameterName){
        for (ConnectParameter parameter : parameters){
            if (Objects.equals(parameter.getParameterName(), parameterName)){
                return parameter;
            }
        }
        return null;
    }

}
