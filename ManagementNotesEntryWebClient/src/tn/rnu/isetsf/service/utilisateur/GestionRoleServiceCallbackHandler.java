
/**
 * GestionRoleServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package tn.rnu.isetsf.service.utilisateur;

    /**
     *  GestionRoleServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class GestionRoleServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public GestionRoleServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public GestionRoleServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for creerRole method
            * override this method for handling normal response from creerRole operation
            */
           public void receiveResultcreerRole(
                    tn.rnu.isetsf.service.utilisateur.GestionRoleServiceStub.CreerRoleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from creerRole operation
           */
            public void receiveErrorcreerRole(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRoleById method
            * override this method for handling normal response from getRoleById operation
            */
           public void receiveResultgetRoleById(
                    tn.rnu.isetsf.service.utilisateur.GestionRoleServiceStub.GetRoleByIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRoleById operation
           */
            public void receiveErrorgetRoleById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUtilisateursOfRoleArray method
            * override this method for handling normal response from getUtilisateursOfRoleArray operation
            */
           public void receiveResultgetUtilisateursOfRoleArray(
                    tn.rnu.isetsf.service.utilisateur.GestionRoleServiceStub.GetUtilisateursOfRoleArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtilisateursOfRoleArray operation
           */
            public void receiveErrorgetUtilisateursOfRoleArray(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRolesArray method
            * override this method for handling normal response from getRolesArray operation
            */
           public void receiveResultgetRolesArray(
                    tn.rnu.isetsf.service.utilisateur.GestionRoleServiceStub.GetRolesArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRolesArray operation
           */
            public void receiveErrorgetRolesArray(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifierRole method
            * override this method for handling normal response from modifierRole operation
            */
           public void receiveResultmodifierRole(
                    tn.rnu.isetsf.service.utilisateur.GestionRoleServiceStub.ModifierRoleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifierRole operation
           */
            public void receiveErrormodifierRole(java.lang.Exception e) {
            }
                


    }
    