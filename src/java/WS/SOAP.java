/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Ulises
 */
@WebService(serviceName = "SOAP")
public class SOAP {

    /**
     * This is a sample web service operation
     */
     private final String USER= "mimo";
    private final String PASS = "123";
    @WebMethod(operationName = "Calcu")
    public String culcu(@WebParam(name = "num1") String num1,@WebParam(name="num2")String num2,
            @WebParam(name = "operacion") String operacion) {
           Double res= 0.0;
           switch(operacion){
               case "+":
                     res=Double.parseDouble(num1)+Double.parseDouble(num2);
                   break;
               case "-":
                     res=Double.parseDouble(num1)-Double.parseDouble(num2);
                   break;
               case "*":
                     res=Double.parseDouble(num1)*Double.parseDouble(num2);
                   break;
               case "/":
                     res=Double.parseDouble(num1)/Double.parseDouble(num2);
                   break;                   
           }
           
        return res.toString();
    }
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "user") String user, @WebParam(name = "contra") String contra) {
        if(user.equals(USER) && contra.equals(PASS)){
            return "true";
        }else{
         return "false"; 
        }
        
    }
}
