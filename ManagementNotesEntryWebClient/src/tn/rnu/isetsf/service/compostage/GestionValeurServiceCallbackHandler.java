
/**
 * GestionValeurServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package tn.rnu.isetsf.service.compostage;

    /**
     *  GestionValeurServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class GestionValeurServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public GestionValeurServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public GestionValeurServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for modifierValeur method
            * override this method for handling normal response from modifierValeur operation
            */
           public void receiveResultmodifierValeur(
                    tn.rnu.isetsf.service.compostage.GestionValeurServiceStub.ModifierValeurResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifierValeur operation
           */
            public void receiveErrormodifierValeur(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for creerValeur method
            * override this method for handling normal response from creerValeur operation
            */
           public void receiveResultcreerValeur(
                    tn.rnu.isetsf.service.compostage.GestionValeurServiceStub.CreerValeurResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from creerValeur operation
           */
            public void receiveErrorcreerValeur(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getValeurById method
            * override this method for handling normal response from getValeurById operation
            */
           public void receiveResultgetValeurById(
                    tn.rnu.isetsf.service.compostage.GestionValeurServiceStub.GetValeurByIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getValeurById operation
           */
            public void receiveErrorgetValeurById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getValeursArray method
            * override this method for handling normal response from getValeursArray operation
            */
           public void receiveResultgetValeursArray(
                    tn.rnu.isetsf.service.compostage.GestionValeurServiceStub.GetValeursArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getValeursArray operation
           */
            public void receiveErrorgetValeursArray(java.lang.Exception e) {
            }
                


    }
    