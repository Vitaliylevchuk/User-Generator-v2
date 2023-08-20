package org.fbs.user_generato_v2.data;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Objects;

public class ConnectParameters {

    private final ArrayList<ConnectParameter> parameters = new ArrayList<>();

    public ArrayList<ConnectParameter> getParameters() {
        return parameters;
    }

    // Gets parameter name, and return parameter with that name. If parameter with that name does not exist - return null
    public @Nullable ConnectParameter getByName(String parameterName){
        for (ConnectParameter parameter : parameters){
            if (Objects.equals(parameter.getParameterName(), parameterName)){
                return parameter;
            }
        }
        return null;
    }

}
