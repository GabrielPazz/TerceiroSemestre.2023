package Comum;

import java.rmi.Remote;

/**
 * Dicionario
 */
public interface Dicionario extends Remote {

    public String procuraPalavra(String palavraPortugues) throws java.rmi.RemoteException;
}