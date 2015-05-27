
/**
 * GestionAdministrateurServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package tn.rnu.isetsf.service.utilisateur;

    /**
     *  GestionAdministrateurServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class GestionAdministrateurServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public GestionAdministrateurServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public GestionAdministrateurServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for findAdministrateurByUserNamePassword method
            * override this method for handling normal response from findAdministrateurByUserNamePassword operation
            */
           public void receiveResultfindAdministrateurByUserNamePassword(
                    tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.FindAdministrateurByUserNamePasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from findAdministrateurByUserNamePassword operation
           */
            public void receiveErrorfindAdministrateurByUserNamePassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifierAdministrateur method
            * override this method for handling normal response from modifierAdministrateur operation
            */
           public void receiveResultmodifierAdministrateur(
                    tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.ModifierAdministrateurResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifierAdministrateur operation
           */
            public void receiveErrormodifierAdministrateur(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for findAdministrateurByUserName method
            * override this method for handling normal response from findAdministrateurByUserName operation
            */
           public void receiveResultfindAdministrateurByUserName(
                    tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.FindAdministrateurByUserNameResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from findAdministrateurByUserName operation
           */
            public void receiveErrorfindAdministrateurByUserName(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for creerAdministrateur method
            * override this method for handling normal response from creerAdministrateur operation
            */
           public void receiveResultcreerAdministrateur(
                    tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.CreerAdministrateurResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from creerAdministrateur operation
           */
            public void receiveErrorcreerAdministrateur(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAdministrateurByUserNamePassword method
            * override this method for handling normal response from getAdministrateurByUserNamePassword operation
            */
           public void receiveResultgetAdministrateurByUserNamePassword(
                    tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.GetAdministrateurByUserNamePasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAdministrateurByUserNamePassword operation
           */
            public void receiveErrorgetAdministrateurByUserNamePassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAdministrateurById method
            * override this method for handling normal response from getAdministrateurById operation
            */
           public void receiveResultgetAdministrateurById(
                    tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.GetAdministrateurByIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAdministrateurById operation
           */
            public void receiveErrorgetAdministrateurById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAdministrateurByUserName method
            * override this method for handling normal response from getAdministrateurByUserName operation
            */
           public void receiveResultgetAdministrateurByUserName(
                    tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.GetAdministrateurByUserNameResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAdministrateurByUserName operation
           */
            public void receiveErrorgetAdministrateurByUserName(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAdministrateursArray method
            * override this method for handling normal response from getAdministrateursArray operation
            */
           public void receiveResultgetAdministrateursArray(
                    tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.GetAdministrateursArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAdministrateursArray operation
           */
            public void receiveErrorgetAdministrateursArray(java.lang.Exception e) {
            }
                


    }
    