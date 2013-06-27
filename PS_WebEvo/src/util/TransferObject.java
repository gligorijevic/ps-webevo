/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author Djordje Gligorijevic
 */
public class TransferObject implements Serializable{

    private int clientRequestOperation;
    private Object clientObject;
    private Object serverObject;
    private String serverMessage;

    public TransferObject() {
    }

    public TransferObject(int clientRequestOperation, Object clientObject, Object serverObject, String serverMessage) {
        this.clientRequestOperation = clientRequestOperation;
        this.clientObject = clientObject;
        this.serverObject = serverObject;
        this.serverMessage = serverMessage;
    }

    public TransferObject(int clientRequestOperation, Object clientObject) {
        this.clientRequestOperation = clientRequestOperation;
        this.clientObject = clientObject;
        this.serverObject = null;
        this.serverMessage = null;
    }

    /**
     * @return the clientRequestOperation
     */
    public int getClientRequestOperation() {
        return clientRequestOperation;
    }

    /**
     * @param clientRequestOperation the clientRequestOperation to set
     */
    public void setClientRequestOperation(int clientRequestOperation) {
        this.clientRequestOperation = clientRequestOperation;
    }

    /**
     * @return the clientObject
     */
    public Object getClientObject() {
        return clientObject;
    }

    /**
     * @param clientObject the clientObject to set
     */
    public void setClientObject(Object clientObject) {
        this.clientObject = clientObject;
    }

    /**
     * @return the serverObject
     */
    public Object getServerObject() {
        return serverObject;
    }

    /**
     * @param serverObject the serverObject to set
     */
    public void setServerObject(Object serverObject) {
        this.serverObject = serverObject;
    }

    /**
     * @return the serverMessage
     */
    public String getServerMessage() {
        return serverMessage;
    }

    /**
     * @param serverMessage the serverMessage to set
     */
    public void setServerMessage(String serverMessage) {
        this.serverMessage = serverMessage;
    }
}
