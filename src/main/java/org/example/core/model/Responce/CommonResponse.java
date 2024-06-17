package org.example.core.model.Responce;

import java.util.Objects;

public class CommonResponse<T> {
    private T response;
    private String errorMessage;

    public CommonResponse(T response, String errorMessage) {
        this.response = response;
        this.errorMessage = errorMessage;
    }

    public CommonResponse(T response) {
        this.response = response;
        this.errorMessage = null;
    }

    public CommonResponse(String errorMessage) {
        this.errorMessage = errorMessage;
        this.response = null;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommonResponse<?> that)) return false;
        return Objects.equals(getResponse(), that.getResponse()) && Objects.equals(getErrorMessage(), that.getErrorMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResponse(), getErrorMessage());
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "response=" + response +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
