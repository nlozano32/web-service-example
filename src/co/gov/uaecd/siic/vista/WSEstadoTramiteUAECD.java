package co.gov.uaecd.siic.vista;

import co.gov.uaecd.siic.agendamiento.obj.EstadoTramiteUAECD;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.List;

public interface WSEstadoTramiteUAECD extends Remote {
    public String consultarEstadoTramiteUAECDPru(String fechaEntrada, String fechaSalida, String listaTramites, String correousuario, String pwd, String ipRemoto) throws Exception, RemoteException;

    public List<EstadoTramiteUAECD> consultarEstadoTramiteUAECD(String fechaEntrada, String fechaSalida, String listaTramites, String correousuario, String pwd, String ipRemoto) throws Exception, RemoteException;
}
