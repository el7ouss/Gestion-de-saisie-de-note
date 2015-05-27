
/**
 * GestionEnseignantServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package tn.rnu.isetsf.service.utilisateur;

    /**
     *  GestionEnseignantServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class GestionEnseignantServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public GestionEnseignantServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public GestionEnseignantServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getEnseignantsArray method
            * override this method for handling normal response from getEnseignantsArray operation
            */
           public void receiveResultgetEnseignantsArray(
                    tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.GetEnseignantsArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEnseignantsArray operation
           */
            public void receiveErrorgetEnseignantsArray(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEnseignantByUserNamePassword method
            * override this method for handling normal response from getEnseignantByUserNamePassword operation
            */
           public void receiveResultgetEnseignantByUserNamePassword(
                    tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.GetEnseignantByUserNamePasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEnseignantByUserNamePassword operation
           */
            public void receiveErrorgetEnseignantByUserNamePassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEnseignantById method
            * override this method for handling normal response from getEnseignantById operation
            */
           public void receiveResultgetEnseignantById(
                    tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.GetEnseignantByIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEnseignantById operation
           */
            public void receiveErrorgetEnseignantById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for findEnseignantByUserNamePassword method
            * override this method for handling normal response from findEnseignantByUserNamePassword operation
            */
           public void receiveResultfindEnseignantByUserNamePassword(
                    tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.FindEnseignantByUserNamePasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from findEnseignantByUserNamePassword operation
           */
            public void receiveErrorfindEnseignantByUserNamePassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for findEnseignantByUserName method
            * override this method for handling normal response from findEnseignantByUserName operation
            */
           public void receiveResultfindEnseignantByUserName(
                    tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.FindEnseignantByUserNameResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from findEnseignantByUserName operation
           */
            public void receiveErrorfindEnseignantByUserName(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEnseignantByUserName method
            * override this method for handling normal response from getEnseignantByUserName operation
            */
           public void receiveResultgetEnseignantByUserName(
                    tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.GetEnseignantByUserNameResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEnseignantByUserName operation
           */
            public void receiveErrorgetEnseignantByUserName(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for creerEnseignant method
            * override this method for handling normal response from creerEnseignant operation
            */
           public void receiveResultcreerEnseignant(
                    tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.CreerEnseignantResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from creerEnseignant operation
           */
            public void receiveErrorcreerEnseignant(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCoursOfEnseignantArray method
            * override this method for handling normal response from getCoursOfEnseignantArray operation
            */
           public void receiveResultgetCoursOfEnseignantArray(
                    tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.GetCoursOfEnseignantArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCoursOfEnseignantArray operation
           */
            public void receiveErrorgetCoursOfEnseignantArray(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifierEnseignant method
            * override this method for handling normal response from modifierEnseignant operation
            */
           public void receiveResultmodifierEnseignant(
                    tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.ModifierEnseignantResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifierEnseignant operation
           */
            public void receiveErrormodifierEnseignant(java.lang.Exception e) {
            }
                


    }
    