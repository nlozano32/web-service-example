package co.gov.uaecd.siic.vista;


import java.util.List;
import co.com.sogamoxi.administracion.entities.UsuarioVO;
import co.com.sogamoxi.administracion.facade.FacAdministracion;

import co.com.sogamoxi.auditoria.entities.AplException;

import co.gov.uaecd.siic.agendamiento.facade.FacAgendamiento;
import co.gov.uaecd.siic.agendamiento.obj.EstadoTramiteUAECD;


public class Facade {
    public List<EstadoTramiteUAECD> consultarEstadoTramiteUAECD(String fechaEntrada, String fechaSalida, String listaTramites, String correousuario, String pwd, String ipRemoto) throws Exception {
        FacAdministracion facade = new FacAdministracion();
        FacAgendamiento facET = new FacAgendamiento();
        if (ipRemoto == null && !ipRemoto.equals(""))
            throw new Exception("IP Remoto Inválido");
        else {
            facade.setIpRemoto(ipRemoto);
            facET.setIp(ipRemoto);
            UsuarioVO usuarioCon = facade.loadWS(correousuario, pwd);
            facET.setCodUsuarioCon(usuarioCon.getCodigo());
            if (usuarioCon.getOpcional() == null) {
                List ldatos = facET.consultarEstadoTramiteUAECD(fechaEntrada, fechaSalida, listaTramites);
                new AplException().ingresoWS(this.getClass().getPackage().getName(), "Uso del WS: WSEstadoTramiteUAECD", ipRemoto, usuarioCon.getCodigo());
                if (ldatos != null)
                    return ldatos;
                else
                    throw new Exception("No existen datos para la consulta de Estado Tramite con los parámetros recibidos...!");
            }
            else
                throw new Exception(usuarioCon.getOpcional());
        }

    }
    
    public String consultarEstadoTramiteUAECDPru(String fechaEntrada, String fechaSalida, String listaTramites, String correousuario, String pwd, String ipRemoto) throws Exception {
        FacAdministracion facade = new FacAdministracion();
        FacAgendamiento facET = new FacAgendamiento();
        if (ipRemoto == null && !ipRemoto.equals(""))
            throw new Exception("IP Remoto Inválido");
        else {
            facade.setIpRemoto(ipRemoto);
            facET.setIp(ipRemoto);
            UsuarioVO usuarioCon = facade.loadWS(correousuario, pwd);
            facET.setCodUsuarioCon(usuarioCon.getCodigo());
            if (usuarioCon.getOpcional() == null) {
                List ldatos = facET.consultarEstadoTramiteUAECD(fechaEntrada, fechaSalida, listaTramites);
                new AplException().ingresoWS(this.getClass().getPackage().getName(), "Uso del WS: WSEstadoTramiteUAECD", ipRemoto, usuarioCon.getCodigo());
                if (ldatos != null)
                    return "Cantidad de datos: " + ldatos.size();
                else
                    throw new Exception("No existen datos para la consulta de Estado Tramite con los parámetros recibidos...!");
            }
            else
                throw new Exception(usuarioCon.getOpcional());
        }

    }
}
