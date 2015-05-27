
/**
 * GestionEtudiantServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package tn.rnu.isetsf.service.utilisateur;

    /**
     *  GestionEtudiantServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class GestionEtudiantServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public GestionEtudiantServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public GestionEtudiantServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for findEtudiantByUserName method
            * override this method for handling normal response from findEtudiantByUserName operation
            */
           public void receiveResultfindEtudiantByUserName(
                    tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.FindEtudiantByUserNameResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from findEtudiantByUserName operation
           */
            public void receiveErrorfindEtudiantByUserName(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEtudiantByCin method
            * override this method for handling normal response from getEtudiantByCin operation
            */
           public void receiveResultgetEtudiantByCin(
                    tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.GetEtudiantByCinResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEtudiantByCin operation
           */
            public void receiveErrorgetEtudiantByCin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEtudiantsArray method
            * override this method for handling normal response from getEtudiantsArray operation
            */
           public void receiveResultgetEtudiantsArray(
                    tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.GetEtudiantsArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEtudiantsArray operation
           */
            public void receiveErrorgetEtudiantsArray(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for findEtudiantByUserNamePassword method
            * override this method for handling normal response from findEtudiantByUserNamePassword operation
            */
           public void receiveResultfindEtudiantByUserNamePassword(
                    tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.FindEtudiantByUserNamePasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from findEtudiantByUserNamePassword operation
           */
            public void receiveErrorfindEtudiantByUserNamePassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEtudiantByUserName method
            * override this method for handling normal response from getEtudiantByUserName operation
            */
           public void receiveResultgetEtudiantByUserName(
                    tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.GetEtudiantByUserNameResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEtudiantByUserName operation
           */
            public void receiveErrorgetEtudiantByUserName(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getValeursOfEtudiantArray method
            * override this method for handling normal response from getValeursOfEtudiantArray operation
            */
           public void receiveResultgetValeursOfEtudiantArray(
                    tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.GetValeursOfEtudiantArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getValeursOfEtudiantArray operation
           */
            public void receiveErrorgetValeursOfEtudiantArray(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEtudiantById method
            * override this method for handling normal response from getEtudiantById operation
            */
           public void receiveResultgetEtudiantById(
                    tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.GetEtudiantByIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEtudiantById operation
           */
            public void receiveErrorgetEtudiantById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEtudiantByNumInscrit method
            * override this method for handling normal response from getEtudiantByNumInscrit operation
            */
           public void receiveResultgetEtudiantByNumInscrit(
                    tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.GetEtudiantByNumInscritResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEtudiantByNumInscrit operation
           */
            public void receiveErrorgetEtudiantByNumInscrit(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for creerEtudiant method
            * override this method for handling normal response from creerEtudiant operation
            */
           public void receiveResultcreerEtudiant(
                    tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.CreerEtudiantResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from creerEtudiant operation
           */
            public void receiveErrorcreerEtudiant(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEtudiantByUserNamePassword method
            * override this method for handling normal response from getEtudiantByUserNamePassword operation
            */
           public void receiveResultgetEtudiantByUserNamePassword(
                    tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.GetEtudiantByUserNamePasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEtudiantByUserNamePassword operation
           */
            public void receiveErrorgetEtudiantByUserNamePassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifierEtudiant method
            * override this method for handling normal response from modifierEtudiant operation
            */
           public void receiveResultmodifierEtudiant(
                    tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.ModifierEtudiantResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifierEtudiant operation
           */
            public void receiveErrormodifierEtudiant(java.lang.Exception e) {
            }
                


    }
    