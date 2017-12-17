package br.com.blog.utils;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paulo
 */
public class Utils {
    
    /**
     * Criptografa a URL do navegador com varias info.
     * 
     * @param request
     * @return 
     */
    public static String urlEncryptor(HttpServletRequest request) {
        return "?action="+LocalDate.now()+"&"+LocalDateTime.now()
                +"&"+request.getLocalAddr()+"&"+request.getSession()
                +"&"+request.getProtocol()+"0.RXmKUXGO0UQ&"+request.getLocalName()
                +"&"+request.getRequestedSessionId()
                +"&locale="+request.getLocale().getCountry()
                +"&"+request.changeSessionId()
                +"&"+request.getSession().getCreationTime();
    }
    
    /**
     * Retorna data em String formato : dd/MM/yyyy
     *
     * @since 25/11/2017
     * @return
     */
    public static String retornaDataStringBR() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(Constants.DATA_FORMAT));
    }

    /**
     * Retorna hora em String formato : hh:mm:ss
     *
     * @since 25/11/2017
     * @return
     */
    public static String retornaHoraStringBR() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(Constants.HORA_FORMAT));
    }

    /**
     * Trata se a string é nulo
     *
     * @param v1 valor verificar
     * @param v2 valor substituir
     * @return v1 ou v2.
     */
    public static String trataNulo(String v1, String v2) {

        if (v1 == null) {
        } else {
            return v2;
        }

        if ("".equals(v1)) {
            return v2;
        }

        if (" ".equals(v1)) {
            return v2;
        } else {
            return v1;
        }
    }

    /**
     * Trata se o objeto é nulo
     *
     * @param obj o objeto a verificar
     * @return v1 ou v2.
     */
    public static Object trataNulo(Object obj) {
        if (obj == null) {
            return "{}";
        } else {
            return obj;
        }
    }
}
