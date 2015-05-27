
/**
 * GestionUtilisateurServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package tn.rnu.isetsf.service.utilisateur;

    /**
     *  GestionUtilisateurServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class GestionUtilisateurServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public GestionUtilisateurServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public GestionUtilisateurServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getUtilisateursArray method
            * override this method for handling normal response from getUtilisateursArray operation
            */
           public void receiveResultgetUtilisateursArray(
                    tn.rnu.isetsf.service.utilisateur.GestionUtilisateurServiceStub.GetUtilisateursArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtilisateursArray operation
           */
            public void receiveErrorgetUtilisateursArray(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUtilisateurByUserNamePassword method
            * override this method for handling normal response from getUtilisateurByUserNamePassword operation
            */
           public void receiveResultgetUtilisateurByUserNamePassword(
                    tn.rnu.isetsf.service.utilisateur.GestionUtilisateurServiceStub.GetUtilisateurByUserNamePasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtilisateurByUserNamePassword operation
           */
            public void receiveErrorgetUtilisateurByUserNamePassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for findUtilisateurByUserNamePassword method
            * override this method for handling normal response from findUtilisateurByUserNamePassword operation
            */
           public void receiveResultfindUtilisateurByUserNamePassword(
                    tn.rnu.isetsf.service.utilisateur.GestionUtilisateurServiceStub.FindUtilisateurByUserNamePasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from findUtilisateurByUserNamePassword operation
           */
            public void receiveErrorfindUtilisateurByUserNamePassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifierUtilisateur method
            * override this method for handling normal response from modifierUtilisateur operation
            */
           public void receiveResultmodifierUtilisateur(
                    tn.rnu.isetsf.service.utilisateur.GestionUtilisateurServiceStub.ModifierUtilisateurResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifierUtilisateur operation
           */
            public void receiveErrormodifierUtilisateur(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUtilisateurById method
            * override this method for handling normal response from getUtilisateurById operation
            */
           public void receiveResultgetUtilisateurById(
                    tn.rnu.isetsf.service.utilisateur.GestionUtilisateurServiceStub.GetUtilisateurByIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtilisateurById operation
           */
            public void receiveErrorgetUtilisateurById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for findUtilisateurByUserName method
            * override this method for handling normal response from findUtilisateurByUserName operation
            */
           public void receiveResultfindUtilisateurByUserName(
                    tn.rnu.isetsf.service.utilisateur.GestionUtilisateurServiceStub.FindUtilisateurByUserNameResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from findUtilisateurByUserName operation
           */
            public void receiveErrorfindUtilisateurByUserName(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUtilisateurByUserName method
            * override this method for handling normal response from getUtilisateurByUserName operation
            */
           public void receiveResultgetUtilisateurByUserName(
                    tn.rnu.isetsf.service.utilisateur.GestionUtilisateurServiceStub.GetUtilisateurByUserNameResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtilisateurByUserName operation
           */
            public void receiveErrorgetUtilisateurByUserName(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for creerUtilisateur method
            * override this method for handling normal response from creerUtilisateur operation
            */
           public void receiveResultcreerUtilisateur(
                    tn.rnu.isetsf.service.utilisateur.GestionUtilisateurServiceStub.CreerUtilisateurResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from creerUtilisateur operation
           */
            public void receiveErrorcreerUtilisateur(java.lang.Exception e) {
            }
                


    }
    