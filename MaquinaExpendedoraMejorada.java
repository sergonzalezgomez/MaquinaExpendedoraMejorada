public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    private boolean billeteRegalo;
    //El billete de regalo
    private int numBilletes;
    
    

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, 
            boolean billeteDeRegalo, int numDeBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        billeteRegalo = billeteDeRegalo;
        numBilletes = numDeBilletes;
    }
    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if(cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            if(numBilletes <= 0){
                  System.out.println("No hay billetes Disponibles!");
            }
            
        }
        else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }        
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
         if(balanceClienteActual >= precioBillete) {    
             if(numBilletes > 0){
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();
                numBilletes = numBilletes - 1 ;
            
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                if(billeteRegalo == true){
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de Regalo!:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + 0 + " euros.");
                System.out.println("##################");
                System.out.println();
                
                }
            }
            else{
                 System.out.println("No hay billetes Disponibles!");
            }
         }   
         else {
                System.out.println("Necesitas introducir " + (precioBillete - balanceClienteActual) + " euros mas!");         
         }
        
          
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero()
    {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;    
    } 

    public int vaciarDineroDeLaMaquina() {
        int sacarDineroDeLaMaquina;    
        if (balanceClienteActual == 0){
            sacarDineroDeLaMaquina = totalDineroAcumulado;
            totalDineroAcumulado = 0;
        }
        else {
            System.out.println("Operaci�n en curso , ERROR");
            sacarDineroDeLaMaquina =-1;
        }
        return sacarDineroDeLaMaquina;
     }
    
     
    
    }
