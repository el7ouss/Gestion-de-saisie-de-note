
/**
 * GestionDepartementServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package tn.rnu.isetsf.service.parametres;

    /**
     *  GestionDepartementServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class GestionDepartementServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public GestionDepartementServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public GestionDepartementServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for creerDepartement method
            * override this method for handling normal response from creerDepartement operation
            */
           public void receiveResultcreerDepartement(
                    tn.rnu.isetsf.service.parametres.GestionDepartementServiceStub.CreerDepartementResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from creerDepartement operation
           */
            public void receiveErrorcreerDepartement(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getDepartementById method
            * override this method for handling normal response from getDepartementById operation
            */
           public void receiveResultgetDepartementById(
                    tn.rnu.isetsf.service.parametres.GestionDepartementServiceStub.GetDepartementByIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDepartementById operation
           */
            public void receiveErrorgetDepartementById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getFormationsOfDepartementArray method
            * override this method for handling normal response from getFormationsOfDepartementArray operation
            */
           public void receiveResultgetFormationsOfDepartementArray(
                    tn.rnu.isetsf.service.parametres.GestionDepartementServiceStub.GetFormationsOfDepartementArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getFormationsOfDepartementArray operation
           */
            public void receiveErrorgetFormationsOfDepartementArray(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifierDepartement method
            * override this method for handling normal response from modifierDepartement operation
            */
           public void receiveResultmodifierDepartement(
                    tn.rnu.isetsf.service.parametres.GestionDepartementServiceStub.ModifierDepartementResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifierDepartement operation
           */
            public void receiveErrormodifierDepartement(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getDepartementsArray method
            * override this method for handling normal response from getDepartementsArray operation
            */
           public void receiveResultgetDepartementsArray(
                    tn.rnu.isetsf.service.parametres.GestionDepartementServiceStub.GetDepartementsArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDepartementsArray operation
           */
            public void receiveErrorgetDepartementsArray(java.lang.Exception e) {
            }
                


    }
    